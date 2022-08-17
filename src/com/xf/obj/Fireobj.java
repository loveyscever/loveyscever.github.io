package com.xf.obj;

import com.xf.mian.GameWin;
import com.xf.utils.GameUtils;

import java.awt.*;
//我方子弹类
public class Fireobj extends GameObj{
    @Override
    public void painSelf(Graphics g) {
        super.painSelf(g);
        y-=speed;
        if (y<0){
            this.x=-300;
            this.y=300;
            GameUtils.removeList.add(this);
        }
    }

    @Override
    public Rectangle getRes() {
        return super.getRes();
    }

    @Override
    public Image getImage() {
        return super.getImage();
    }

    public Fireobj(Image image, int x, int y, int w, int h, double speed, GameWin gameWin) {
        super(image, x, y, w, h, speed, gameWin);
    }

    public Fireobj() {
    }

    public Fireobj(Image image, int x, int y, double speed) {
        super(image, x, y, speed);
    }
}
