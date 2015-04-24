package com.jimpai.ccaction3;

import org.cocos2d.actions.base.CCFollow;
import org.cocos2d.actions.instant.CCCallFunc;
import org.cocos2d.actions.instant.CCCallFuncN;
import org.cocos2d.actions.interval.CCMoveTo;
import org.cocos2d.actions.interval.CCRotateTo;
import org.cocos2d.actions.interval.CCScaleTo;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.actions.interval.CCSpawn;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

/**
 * Created by jimpai on 15/4/24.
 */
public class GameLayer extends CCLayer {
    CCSprite player;
    public GameLayer() {

        player = CCSprite.sprite("player.png");
        CGPoint initPoint = CGPoint.ccp(200, 200);
        player.setPosition(initPoint);
        this.addChild(player);

        CGPoint targetPoint = CGPoint.ccp(500, 500);
        CCMoveTo moveTo = CCMoveTo.action(5, targetPoint);

        CCRotateTo rotateTo = CCRotateTo.action(5, 180);

        CCScaleTo scaleTo = CCScaleTo.action(2, 2);

        CCSequence ccSequence = CCSequence.actions(moveTo, rotateTo, scaleTo);

        CCSpawn ccSpawn = CCSpawn.actions(moveTo, rotateTo, scaleTo);

        //player.runAction(ccSequence);
        player.runAction(ccSpawn);


        CCCallFuncN funcN = CCCallFuncN.action(this, "onActionFinished");

        player.runAction(funcN);

        CCFollow ccFollow = CCFollow.action(followedNode, rect);
        player.runAction(ccFollow);
    }

    public void onActionFinished(Object sender) {
        System.out.println("onActionFinished");
    }
}
