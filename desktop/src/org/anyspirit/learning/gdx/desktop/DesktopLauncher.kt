package org.anyspirit.learning.gdx.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import org.anyspirit.learning.gdx.MyGdxGame

// DesktopLauncher object の static method では ClassCastException 発生
//   com.intellij.psi.impl.compiled.ClsFileImpl cannot be cast to org.jetbrains.kotlin.psi.KtFile
fun main(arg: Array<String>) {
    val config = LwjglApplicationConfiguration()
    LwjglApplication(MyGdxGame(), config)
}
