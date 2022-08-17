package com.xf.obj;

import com.xf.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

//爆炸效果图类
public class Explodeobj extends GameObj{

    //爆炸图片的数组
    public static Image[] pic=new Image[16];

    //绘制图片爆炸图片的次数
    int explodeCont=0;

    static {
        for (int i = 0; i < pic.length; i++) {
            //遍历数组拿到爆炸的所有图片
            pic[i]=new ImageIcon(GameUtils.class.getResource("../image/explode/e"+(i+1)+".gif")).getImage();

        }
    }

    public Explodeobj() {

    }

    public Explodeobj(int x,int y) {
        super(x,y);
    }

    @Override
    public void painSelf(Graphics g) {
        //一个爆炸对象最多绘制16次
        if (explodeCont<16){
            image=pic[explodeCont];
            super.painSelf(g);
            explodeCont++;
        }
    }

    @Override
    public Image getImage() {
        return super.getImage();
    }
}
