package com.intellij.plugin.bootstrap;

import com.intellij.CommonBundle;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.PropertyKey;

import java.util.ResourceBundle;

/**
 * {@link java.util.ResourceBundle}/localization utils for the bootstrap plugin.
 */
public class BootstrapBundle {
    /**
     * The {@link java.util.ResourceBundle} path.
     */
    @NonNls
    private static final String BUNDLE_NAME = "messages.bootstrapBundle";

    /**
     * The {@link java.util.ResourceBundle} instance.
     */
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private BootstrapBundle() {
    }

    public static String message(@PropertyKey(resourceBundle = BUNDLE_NAME) String key, Object... params) {
        return CommonBundle.message(BUNDLE, key, params);
    }

    public static String messageOrDefault(@PropertyKey(resourceBundle = BUNDLE_NAME) String key, String defaultValue, Object... params) {
        return CommonBundle.messageOrDefault(BUNDLE, key, defaultValue, params);
    }
}
