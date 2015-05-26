var fs = require('fs');
var libxmljs = require('libxmljs');
var html2jade = require('html2jade');
var minify = require('html-minifier').minify;

fs.readFile(process.argv[2], 'utf8', function (err, data) {
    var xmlDoc = libxmljs.parseXml(data);
    xmlDoc.childNodes().forEach(function (node) {
        if (node.type() == 'text') return;

        var html = node.attr('value').value();
        //We need to minify html in order to remove spaces, new lines and other elements that could be interpreted by html2jade
        html = minify(html,
            {
                collapseWhitespace: true,
                conservativeCollapse: false
            }
        );

        html = html.replace(/>\s+</g, '><');  //Remove empty text nodes ie. <span></span>[space]<span></span>
        var end = html.substr(-5) == '$END$';
        if(end)
            html = html.replace('$END$','');

        html2jade.convertHtml(html,{bodyless: true}, function(err,jade) {
            if(end) {
                jade += '$END$';
            }
            node.attr('value').value(jade);
        });

        //Remove all context elements and add JADE option
        node.get('context').childNodes().forEach(function(node) {
            node.remove();
        });

        node.get('context').node('option').attr({name:'JADE', value: true});
    });

    fs.writeFile(process.argv[3],xmlDoc.toString());
});