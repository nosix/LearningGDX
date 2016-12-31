package org.anyspirit.learning.gdx.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.dragome.DragomeApplication;
import com.badlogic.gdx.backends.dragome.DragomeApplicationConfiguration;
import com.badlogic.gdx.backends.dragome.DragomeWindow;
import com.badlogic.gdx.backends.dragome.preloader.AssetDownloader;
import com.badlogic.gdx.backends.dragome.preloader.AssetType;
import com.dragome.web.annotations.PageAlias;

import org.anyspirit.learning.gdx.MyGdxGame;

@PageAlias(alias= "MyGdxGame")
public class HtmlLauncher extends DragomeApplication {

        @Override
        public ApplicationListener createApplicationListener()
        {
                getPreloader().loadAsset("badlogic.jpg", AssetType.Image, null, new AssetDownloader.AssetLoaderListener<>());
                return new MyGdxGame();
        }

        @Override
        public DragomeApplicationConfiguration getConfig()
        {
                return null;
        }

        @Override
        protected void onResize()
        {
                int clientWidth= DragomeWindow.getInnerWidth();
                int clientHeight= DragomeWindow.getInnerHeight();
                getCanvas().setWidth(clientWidth);
                getCanvas().setHeight(clientHeight);
                getCanvas().setCoordinateSpaceWidth(clientWidth);
                getCanvas().setCoordinateSpaceHeight(clientHeight);
                super.onResize();
        }
}
