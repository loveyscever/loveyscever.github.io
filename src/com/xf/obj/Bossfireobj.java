package com.xf.obj;

import com.xf.mian.GameWin;
import com.xf.utils.GameUtils;

import java.awt.*;

public class Bossfireobj extends GameObj{
    @Override
    public void painSelf(Graphics g) {
        super.painSelf(g);
        y+=speed;
        if (y>800){
            this.x=-400;
            this.y=400;
            GameUtils.removeList.add(this);
        }
        if (this.getRes().intersects(this.gameWin.planeobj.getRes())){
//                System.out.println("撞上了");
            GameWin.state=3;

        }
        for(Fireobj firobj : GameUtils.fireList){
            //检测碰撞，如果坐标重合就返回true
            if(this.getRes().intersects(firobj.getRes())){
                firobj.setX(-100);
                firobj.setY(100);
                this.setX(-200);
                this.setY(200);
                GameUtils.removeList.add(this);
                //GameUtils.removeList.add(firobj);
                //GameMW.score++;
            }
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

    public Bossfireobj(Image image, int x, int y, int w, int h, double speed, GameWin gameWin) {
        super(image, x, y, w, h, speed, gameWin);
    }

    public Bossfireobj() {
    }

    public Bossfireobj(Image image, int x, int y, double speed) {
        super(image, x, y, speed);
    }
}
