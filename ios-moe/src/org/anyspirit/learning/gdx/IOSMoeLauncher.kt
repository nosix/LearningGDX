package org.anyspirit.learning.gdx

import com.badlogic.gdx.backends.iosmoe.IOSApplication
import com.badlogic.gdx.backends.iosmoe.IOSApplicationConfiguration
import org.moe.natj.general.Pointer
import org.anyspirit.learning.gdx.MyGdxGame

import apple.uikit.c.UIKit

class IOSMoeLauncher protected constructor(peer: Pointer) : IOSApplication.Delegate(peer) {

    override fun createApplication(): IOSApplication {
        val config = IOSApplicationConfiguration()
        config.useAccelerometer = false
        return IOSApplication(MyGdxGame(), config)
    }

    companion object {

        @JvmStatic fun main(argv: Array<String>) {
            UIKit.UIApplicationMain(0, null, null, IOSMoeLauncher::class.java.name)
        }
    }
}
