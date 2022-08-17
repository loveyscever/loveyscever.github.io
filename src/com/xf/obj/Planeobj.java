package com.xf.obj;

import com.xf.mian.GameWin;
import com.xf.utils.GameUtils;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Planeobj extends GameObj {
    @Override
    public void painSelf(Graphics g) {
        super.painSelf(g);

        //鼠标事件，让飞机跟随鼠标移动
        this.gameWin.addMouseMotionListener(new MouseAdapter() {
            //鼠标的移动和拖放另外用鼠标监听器mouseMoved
            @Override
            public void mouseMoved(MouseEvent e) {
                x = e.getX() - w / 2-30;
                y = e.getY() - h / 2;
            }
        });
        //检测我方飞机与boss的碰撞

        //检测碰撞，如果坐标重合就返回true
        if (this.gameWin.bossobj != null && this.getRes().intersects(this.gameWin.bossobj.getRes())) {
//                System.out.println("撞上了");
            //如果碰到了就改变敌机和子弹的位置
            GameWin.state = 3;
        }
        for(lucky_itemObj lucky : GameUtils.lucky_itemObjList){
            //检测碰撞，如果坐标重合就返回true
            if(this.getRes().intersects(lucky.getRes())){

                lucky.setX(-100);
                lucky.setY(100);
                GameUtils.removeList.add(lucky);
                GameWin.score+=10;
            }
        }
    }

    public Rectangle getRes() {
        return super.getRes();
    }

    public Image getImage() {
        return image;
    }

    public Planeobj() {
        super();
    }

    public Planeobj(Image image, int x, int y, double speed) {
        super(image, x, y, speed);
    }

    public Planeobj(Image image, int x, int y, int w, int h, double speed, GameWin gameWin) {
        super(image, x, y, w, h, speed, gameWin);
    }
}
