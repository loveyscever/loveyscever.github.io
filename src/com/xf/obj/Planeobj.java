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

        //����¼����÷ɻ���������ƶ�
        this.gameWin.addMouseMotionListener(new MouseAdapter() {
            //�����ƶ����Ϸ���������������mouseMoved
            @Override
            public void mouseMoved(MouseEvent e) {
                x = e.getX() - w / 2-30;
                y = e.getY() - h / 2;
            }
        });
        //����ҷ��ɻ���boss����ײ

        //�����ײ����������غϾͷ���true
        if (this.gameWin.bossobj != null && this.getRes().intersects(this.gameWin.bossobj.getRes())) {
//                System.out.println("ײ����");
            //��������˾͸ı�л����ӵ���λ��
            GameWin.state = 3;
        }
        for(lucky_itemObj lucky : GameUtils.lucky_itemObjList){
            //�����ײ����������غϾͷ���true
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
