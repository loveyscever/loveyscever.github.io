package com.xf.obj;

import com.xf.mian.GameWin;
import com.xf.utils.GameUtils;

import java.awt.*;

public class Bossobj extends GameObj{

    //boss血量
    int life=20;
    @Override
    public void painSelf(Graphics g) {
        super.painSelf(g);
        if(x>=90&&x<=450&&y==30)
        {
            x+=speed;
            if (x==450){
                y+=2*speed;
            }
        }else if (x<=450&&x>=370&&y>30){
            x-=speed;
            y+=2*speed;
            if (x==370){
                x-=speed;
            }
        }else if(x>=170&&x<=370&&y==200){
            x-=speed;
            if (x==170){
                y-=2*speed;
            }
        }else if(x<=170&&x>=90&&y>=30){
            x-=speed;
            y-=2*speed;
            if (y==30){
                x+=speed;
            }
        }


        for (Fireobj fireobj: GameUtils.fireList){
            if (this.getRes().intersects(fireobj.getRes())){
                life--;
                //碰撞之后改变子弹位置
                fireobj.setX(-200);
                fireobj.setY(200);
                //添加到要删除的集合
                GameUtils.removeList.add(fireobj);

            }
        }
        if (life<=0){
            GameWin.state=4;
        }
        //血条 白色底板
//        g.setColor(Color.white);
//        g.fillRect(100,50,100,15);
//
//        g.setColor(Color.red);
//        g.fillRect(100,50,life*10,15);
        if(life>=10&&life<20)
        {
            g.setColor(Color.red);
            g.fillRect(100, 40, 200, 10);
            g.setColor(Color.GREEN);
            g.fillRect(100, 40, (life -10)* 20, 10);
        }
        if(life>0&&life<10)
        {
            g.setColor(Color.white);
            g.fillRect(100, 40, 200, 10);
            g.setColor(Color.red);
            g.fillRect(100, 40, life * 20, 10);
        }

    }

    @Override
    public Image getImage() {
        return super.getImage();
    }

    @Override
    public Rectangle getRes() {
        return super.getRes();
    }

    public Bossobj(Image image, int x, int y, int w, int h, double speed, GameWin gameWin) {
        super(image, x, y, w, h, speed, gameWin);
    }

    public Bossobj() {
    }

    public Bossobj(Image image, int x, int y, double speed) {
        super(image, x, y, speed);
    }
}
