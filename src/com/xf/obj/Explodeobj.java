package com.xf.obj;

import com.xf.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

//��ըЧ��ͼ��
public class Explodeobj extends GameObj{

    //��ըͼƬ������
    public static Image[] pic=new Image[16];

    //����ͼƬ��ըͼƬ�Ĵ���
    int explodeCont=0;

    static {
        for (int i = 0; i < pic.length; i++) {
            //���������õ���ը������ͼƬ
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
        //һ����ը����������16��
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
