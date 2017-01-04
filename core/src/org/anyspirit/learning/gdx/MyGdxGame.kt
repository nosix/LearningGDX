package org.anyspirit.learning.gdx

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.viewport.ScreenViewport

class MyGdxGame : ApplicationAdapter() {

    companion object {
        private val TAG = MyGdxGame::class.java.name
    }

    private val stage by lazy {
        Stage(ScreenViewport())
        /*
        Stage(ScreenViewport().apply {
            unitsPerPixel = 2f
        })
        */
        //Stage(ScalingViewport(Scaling.none, 640f, 480f))
        //Stage(ScalingViewport(Scaling.fit, 640f, 480f))
        //Stage(FitViewport(640f, 480f))
        //Stage(ScalingViewport(Scaling.fill, 640f, 480f))
        //Stage(FillViewport(640f, 480f))
        //Stage(ScalingViewport(Scaling.stretch, 640f, 480f))
        //Stage(StretchViewport(640f, 480f))
        //Stage(ExtendViewport(640f, 480f))
        //Stage(ExtendViewport(640f, 480f, 800f, 480f))
        //Stage(ExtendViewport(640f, 480f, 800f, 640f))
    }

    private val image by lazy {
        Image(Texture("badlogic.jpg")).apply {
            //setScaling(Scaling.none)
            //setScaling(Scaling.fit)
            //setScaling(Scaling.fill)
            //setScaling(Scaling.stretch)
            //setAlign(Align.center)
        }
    }

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG
        Gdx.app.debug(TAG, "create")
        Gdx.graphics.isContinuousRendering = false
        Gdx.input.inputProcessor = stage
        stage.setDebugAll(true)
        stage.addActor(image)
    }

    override fun pause() {
        Gdx.app.debug(TAG, "pause")
    }

    override fun resume() {
        Gdx.app.debug(TAG, "resume")
    }

    override fun resize(width: Int, height: Int) {
        Gdx.app.debug(TAG, "resize $width $height")
        stage.viewport.update(width, height, true)
    }

    override fun render() {
        Gdx.app.debug(TAG, "render")
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        stage.act(Gdx.graphics.deltaTime)
        stage.draw()
    }

    override fun dispose() {
        Gdx.app.debug(TAG, "dispose")
        stage.dispose()
    }
}
