package com.xf.obj;

import com.xf.mian.GameWin;
import com.xf.utils.GameUtils;

import java.awt.*;

public class Enemyobj extends GameObj{
    @Override
    public void painSelf(Graphics g) {
        super.painSelf(g);
        y+=speed;
        //敌方飞机越界消失
        if (y>800){
            this.x=-400;
            this.y=400;
            GameUtils.removeList.add(this);
        }
        //检测碰撞 intersects
        for (Fireobj fireobj: GameUtils.fireList){
            //检测碰撞，如果坐标重合就返回true
            if (this.getRes().intersects(fireobj.getRes())){
                //创建爆炸对象
                Explodeobj explodeobj= new Explodeobj(x,y);
                //把爆炸对象添加到对象集合中
                GameUtils.explodeobjList.add(explodeobj);
                //爆炸完成后，把爆炸对象添加到删除集合中
                GameUtils.removeList.add(explodeobj);
//                System.out.println("撞上了");
                //如果碰到了就改变敌机和子弹的位置
                fireobj.setX(-100);
                fireobj.setY(100);
                this.setX(-500);
                this.setY(100);
                GameUtils.removeList.add(this);
                GameUtils.removeList.add(fireobj);
                GameWin.score+=5;
            }
        }
        //
        if (this.getRes().intersects(this.gameWin.planeobj.getRes())){
            gameWin.state=3;
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

    public Enemyobj(Image image, int x, int y, int w, int h, double speed, GameWin gameWin) {
        super(image, x, y, w, h, speed, gameWin);
    }

    public Enemyobj() {
    }

    public Enemyobj(Image image, int x, int y, double speed) {
        super(image, x, y, speed);
    }
}
