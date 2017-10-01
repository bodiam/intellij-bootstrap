package com.intellij.plugin.bootstrap;

import com.intellij.openapi.components.*;
import org.jetbrains.annotations.Nullable;

/**
 * Persistent global settings object for the Bootstrap plugin.
 */
@State(
        name = "BootstrapSettings",
        storages = @Storage(id = "other", file = StoragePathMacros.APP_CONFIG + "/bootstrap.xml")
)
public class BootstrapSettings implements PersistentStateComponent<BootstrapPluginState> {

    /**
     * Get the instance of this service.
     *
     * @return the unique {@link BootstrapSettings} instance.
     */
    public static BootstrapSettings getInstance() {
        return ServiceManager.getService(BootstrapSettings.class);
    }

    private BootstrapPluginState myState = new BootstrapPluginState();

    @Nullable
    @Override
    public BootstrapPluginState getState() {
        return myState;
    }

    @Override
    public void loadState(BootstrapPluginState element) {
        myState = element;
    }

    public String getVersion() {
        return myState.getPluginVersion();
    }

    public void setVersion(String version) {
        myState.setPluginVersion(version);
    }
}
