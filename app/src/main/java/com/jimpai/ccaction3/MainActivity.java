package com.jimpai.ccaction3;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;


public class MainActivity extends Activity {

    private CCGLSurfaceView view = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = new CCGLSurfaceView(this);

        setContentView(view);

        CCDirector director = CCDirector.sharedDirector();
        director.attachInView(view);
        director.setDisplayFPS(true);
        director.setAnimationInterval(1/30);
        CCScene scene = CCScene.node();

        GameLayer gameLayer = new GameLayer();
        scene.addChild(gameLayer);

        director.runWithScene(scene);
    }

}
