package intellij.plugin.bootstrap3;

/**
 * @author Erik Pragt
 */
import com.intellij.codeInsight.template.impl.DefaultLiveTemplatesProvider;
import org.jetbrains.annotations.Nullable;

public class BootstrapTemplatesProvider implements DefaultLiveTemplatesProvider {
    @Override
    public String[] getDefaultLiveTemplateFiles() {
        return new String[]{
                "resources/liveTemplates/bootstrap3",
                "liveTemplates/bootstrap3",
                "bootstrap3",
                "resources/liveTemplates/bootstrap3.xml",
                "liveTemplates/bootstrap3.xml",
                "bootstrap3.xml",
        };
    }

    @Nullable
    @Override
    public String[] getHiddenLiveTemplateFiles() {
        return null;
    }
}
