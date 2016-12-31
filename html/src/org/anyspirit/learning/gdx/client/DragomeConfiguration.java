package org.anyspirit.learning.gdx.client;

import com.dragome.commons.DragomeConfiguratorImplementor;

@DragomeConfiguratorImplementor(priority = 20)
public class DragomeConfiguration extends com.badlogic.gdx.backends.dragome.DragomeConfiguration {

    @Override
    public boolean projectClassPathFilter(String projectPath) {
        boolean include = false;
        include |= projectPath.matches(".*/core-[0-9.]+.jar");
        return include;
    }

    @Override
    public boolean isRemoveUnusedCode() {
        return true;
    }
}
