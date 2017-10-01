package com.intellij.plugin.bootstrap;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.diagnostic.Logger;
import org.jetbrains.annotations.NotNull;

/**
 * Main application component.
 */
public class BootstrapPluginApplicationComponent implements ApplicationComponent {
  private static final Logger LOG = Logger.getInstance(BootstrapPluginApplicationComponent.class.getName());

  /**
   * Plugin has been updated with the current run.
   */
  private boolean updated;

  /**
   * Plugin update notification has been shown.
   */
  private boolean updateNotificationShown;

  /**
   * Checks if plugin was updated in the current run.
   *
   * @return plugin was updated
   */
  public boolean isUpdated() {
    return updated;
  }

  public boolean isUpdateNotificationShown() {
    return updateNotificationShown;
  }

  public void setUpdateNotificationShown(boolean shown) {
    this.updateNotificationShown = shown;
  }

  /**
   * Get BootstrapPlugin Application Component
   *
   * @return BootstrapPlugin Application Component
   */
  public static BootstrapPluginApplicationComponent getInstance() {
    return ApplicationManager.getApplication().getComponent(BootstrapPluginApplicationComponent.class);
  }

  @NotNull
  @Override
  public String getComponentName() {
    return "Bootstrap plugin for IntelliJ";
  }

  @Override
  public void initComponent() {
    LOG.info("Bootstrap plugin initialized for IntelliJ");

    final BootstrapSettings settings = BootstrapSettings.getInstance();
    updated = !Version.PLUGIN_VERSION.equals(settings.getVersion());
    if (updated) {
      settings.setVersion(Version.PLUGIN_VERSION);
    }
  }

  @Override
  public void disposeComponent() {
    LOG.info("Bootstrap plugin disposed for IntelliJ");
  }

}
