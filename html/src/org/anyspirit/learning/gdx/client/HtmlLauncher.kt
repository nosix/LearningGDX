package org.anyspirit.learning.gdx.client

import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.backends.dragome.DragomeApplication
import com.badlogic.gdx.backends.dragome.DragomeApplicationConfiguration
import com.badlogic.gdx.backends.dragome.DragomeWindow
import com.badlogic.gdx.backends.dragome.preloader.AssetDownloader
import com.badlogic.gdx.backends.dragome.preloader.AssetType
import com.dragome.web.annotations.PageAlias

import org.anyspirit.learning.gdx.MyGdxGame

@PageAlias(alias = "MyGdxGame")
class HtmlLauncher : DragomeApplication() {

    override fun createApplicationListener(): ApplicationListener {
        preloader.loadAsset("badlogic.jpg", AssetType.Image, null, AssetDownloader.AssetLoaderListener<Any>())
        return MyGdxGame()
    }

    override fun getConfig(): DragomeApplicationConfiguration? = null

    override fun onResize() {
        val clientWidth = DragomeWindow.getInnerWidth()
        val clientHeight = DragomeWindow.getInnerHeight()
        canvas.width = clientWidth
        canvas.height = clientHeight
        canvas.setCoordinateSpaceWidth(clientWidth)
        canvas.setCoordinateSpaceHeight(clientHeight)
        super.onResize()
    }
}
