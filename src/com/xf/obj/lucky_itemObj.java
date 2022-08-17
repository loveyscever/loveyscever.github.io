package com.xf.obj;

import com.xf.mian.GameWin;

import java.awt.*;

//幸运物品类
public class lucky_itemObj extends GameObj{

    @Override
    public Image getImage() {
        return super.getImage();
    }
    double v=(Math.random()+1)*speed;
    @Override
    public void painSelf(Graphics g) {
        super.painSelf(g);

        y+=speed;
        x+=v;
        if(x>300||x<10){
            v=-v;
        }


    }

    @Override
    public Rectangle getRes() {
        return super.getRes();
    }

    public lucky_itemObj(Image image, int x, int y, int w, int h, double speed, GameWin gameMw) {
        super(image, x, y, w, h, speed, gameMw);
    }

    public lucky_itemObj() {
    }

    public lucky_itemObj(Image image, int x, int y, double speed) {
        super(image, x, y, speed);
    }

    public lucky_itemObj(int x, int y) {
        super(x, y);
    }
}

