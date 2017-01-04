package org.anyspirit.learning.gdx.client

import com.dragome.commons.DragomeConfiguratorImplementor

@DragomeConfiguratorImplementor(priority = 20)
class DragomeConfiguration : com.badlogic.gdx.backends.dragome.DragomeConfiguration() {

    override fun projectClassPathFilter(projectPath: String): Boolean =
            ".*/core-[0-9.]+.jar".toRegex().matches(projectPath)

    override fun isRemoveUnusedCode(): Boolean = true
}
