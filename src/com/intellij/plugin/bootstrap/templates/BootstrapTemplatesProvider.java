package com.intellij.plugin.bootstrap.templates;

import com.intellij.codeInsight.template.impl.DefaultLiveTemplatesProvider;
import org.jetbrains.annotations.Nullable;

/**
 * @author Erik Pragt
 */
public class BootstrapTemplatesProvider implements DefaultLiveTemplatesProvider {
    @Override
    public String[] getDefaultLiveTemplateFiles() {
        return new String[]{
                "liveTemplates/Bootstrap3",
                "liveTemplates/Bootstrap4",
                "liveTemplates/Bootstrap3-jade",
                "liveTemplates/FontAwesome",
                "liveTemplates/FontAwesome-jade",
        };
    }

    @Nullable
    @Override
    public String[] getHiddenLiveTemplateFiles() {
        return null;
    }
}
