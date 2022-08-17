package com.xf.obj;

import com.xf.mian.GameWin;
import com.xf.utils.GameUtils;

import java.awt.*;

public class Enemyobj extends GameObj{
    @Override
    public void painSelf(Graphics g) {
        super.painSelf(g);
        y+=speed;
        //�з��ɻ�Խ����ʧ
        if (y>800){
            this.x=-400;
            this.y=400;
            GameUtils.removeList.add(this);
        }
        //�����ײ intersects
        for (Fireobj fireobj: GameUtils.fireList){
            //�����ײ����������غϾͷ���true
            if (this.getRes().intersects(fireobj.getRes())){
                //������ը����
                Explodeobj explodeobj= new Explodeobj(x,y);
                //�ѱ�ը������ӵ����󼯺���
                GameUtils.explodeobjList.add(explodeobj);
                //��ը��ɺ󣬰ѱ�ը������ӵ�ɾ��������
                GameUtils.removeList.add(explodeobj);
//                System.out.println("ײ����");
                //��������˾͸ı�л����ӵ���λ��
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
