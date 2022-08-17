package com.xf.mian;

import com.xf.obj.*;
import com.xf.utils.GameUtils;
import com.xf.utils.NumberUtils;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GameWin extends JFrame {
    static int w = 500;
    static int h = 800;
    //�ɻ��ȼ�
    public static int leve=1;

    //0��Ϸ��ʼ  1��Ϸ��  2��ͣ   3ͨ��ʧ��  4ͨ���ɹ�
    public static int state = 0;

    //����ͼƬ
    Bgobj bgobj1 = new Bgobj(GameUtils.bgImg, 0, -1866, 2);//-2066=-(2666-800)

    Bgobj makeobj=new Bgobj(GameUtils.makeImg,0,-31,0);
    Bgobj bgobj=bgobj1;
    //ͼƬ����
    Image offScreenImage = null;

    //������Ʒ
    lucky_itemObj lucky_item=new lucky_itemObj(GameUtils.lukyImg, 100, 20, 61, 49, 4, this);

    //�ҷ��ɻ�
    public Planeobj planeobj1 = new Planeobj(GameUtils.heroImg1, 150, 600, 80, 80, 0, this);//40,41���ڼ���,�ı����鲻��ı�ͼƬ��С
    public Planeobj planeobj2 = new Planeobj(GameUtils.heroImg2, 150, 600, 80, 80, 0, this);//40,41���ڼ���,�ı����鲻��ı�
    public Planeobj planeobj3 = new Planeobj(GameUtils.heroImg3, 150, 600, 80, 80, 0, this);//40,41���ڼ���,�ı����鲻��ı�

    public Planeobj planeobj=planeobj1;
    //bossͼƬ
//    public Bossobj bossobj=new Bossobj(GameUtils.bossImg,50,30,157,109,5,this);

    //�з��ɻ�
    //Enemyobj enemyobj=new Enemyobj(GameUtils.enemyImg,150,50,61,48,5,this);
    //���ƴ���
    int count = 0;

    //�ҷ��ӵ�
    //Fireobj fireobj=new Fireobj(GameUtils.fireImg,planeobj.getX(),planeobj.getY()-50,50,52,5,this);
    public static Image fireImg=GameUtils.fireImg1;


    //��Ϸ�÷�
    public static int score = 0;

    //�Եз��ɻ��ļ���
    int enemtCount = 0;

    //boss����
    public Bossobj bossobj;


    @Override
    public void paint(Graphics g)  {
        //��ʼ��ͼƬ
        if (offScreenImage == null) {
            offScreenImage = createImage(w, h);
        }
        //��ȡ��ǰ�Ļ�������
        Graphics gImage = offScreenImage.getGraphics();

        //ʹ�û����������һ�����и߶ȺͿ�ȵ�����
        gImage.drawRect(0, 0, w, h);

        // g����  ������Ϸ����
        if (state == 0) {
            //����ͼƬ
            gImage.drawImage(GameUtils.bgImg, 0, 0, w, h, null);
            gImage.drawImage(GameUtils.bossImg, 170, 100, 157, 109, null);
            gImage.drawImage(GameUtils.heroImg1, 220, 600, 50, 41, null);
            gImage.setColor(Color.PINK);
            gImage.setFont(new Font("΢���ź�", Font.BOLD, 30));
            gImage.drawString("�����Ϸ��ʼ", 160, 320);
        }
        if (state == 1) {
            //����Ϸ��ʼʱ����ӱ�ը
            GameUtils.gameList.addAll(GameUtils.explodeobjList);
            //fireobj.painSelf(gImage);
            for (GameObj gameObj : GameUtils.gameList) {
                gameObj.painSelf(gImage);
            }
            //����һ�λ���ǰɾ�����������Ԫ��
            GameUtils.gameList.removeAll(GameUtils.removeList);
        }
        //��ͣ�˵�
        if(state==2){
            gImage.drawImage(GameUtils.stopImage,200,450,50,52,null);
            gImage.setColor(Color.PINK);
            gImage.setFont(new Font("΢���ź�", Font.ITALIC, 25));
            gImage.drawString("1.������Ϸ", 170, 250);
            gImage.drawString("2.���¿�ʼ��Ϸ", 170, 320);
            gImage.drawString("3.�˳���Ϸ", 170, 390);
            //gImage.drawImage(GameUtils.pauseImg,175,280,null);
        }
        //�����˵�
        if (state == 3) {
            gImage.drawImage(GameUtils.bzImage, planeobj.getX(), planeobj.getY() - 20, null);
            gImage.setColor(Color.PINK);
            gImage.setFont(new Font("΢���ź�", Font.BOLD, 25));
            gImage.drawString("GAME OVER", 150, 320);

            gImage.drawString("3���˳�����  4������  ",100,550);

            gImage.drawString("�����Ŭ��", 170, 400);
        }
        //ͨ��
        if (state == 4) {
            gImage.drawImage(GameUtils.bzImage, bossobj.getX() + 60, bossobj.getY() + 30, null);
            gImage.setColor(Color.PINK);
            gImage.setFont(new Font("΢���ź�", Font.BOLD, 25));

            gImage.drawString("3���˳����� ",180,550);

            gImage.drawString("ͨ�سɹ�", 200, 400);

        }

        //�˳�
        if(state==5){
            System.exit(0);
        }

        GameUtils.drawword(gImage, score + "��", 20, 60, 30, Color.green);
        //��ͼƬһ���Ի��봰��
        g.drawImage(offScreenImage, 0, 0, null);
        count++;
    }

    //���������ӵ�
    public void createobj() {
        //Ӣ�۷ɻ��������ӵ�����������ÿ��50��һ��;
        if (score==50){

            GameUtils.gameList.remove(planeobj);
            planeobj=planeobj2;
            GameUtils.gameList.add(planeobj);
            repaint();
        }
        if (score==100){

            GameUtils.gameList.remove(planeobj);
            planeobj=planeobj3;
            GameUtils.gameList.add(planeobj);
            repaint();
        }
        if (score==50){
            //�����ɻ�ͼƬ
            fireImg=GameUtils.fireImg2;
            repaint();
        }
        if (score==100){
            //�����ɻ�ͼƬ
            fireImg=GameUtils.fireImg3;
            repaint();
        }

        //ÿ����20������һ���ӵ�
        if (count % 15 == 0) {
            //�����ӵ�������ӵ�������
                GameUtils.fireList.add(new Fireobj(fireImg,
                        planeobj.getX()+40, planeobj.getY() - 50, 45, 45, 8, this));


            //ÿ����һ���ӵ��ͰѸ��ӵ���ӵ���Ϸ���弯����ȥ
            GameUtils.gameList.add(GameUtils.fireList.get(GameUtils.fireList.size() - 1));
        }
        //������Ʒ
        if(count%300==0){

            GameUtils.lucky_itemObjList.add(new lucky_itemObj(GameUtils.lukyImg, lucky_item.getX() + 60, lucky_item.getY() + 100, 50, 52, 5, this));
            GameUtils.gameList.add(GameUtils.lucky_itemObjList.get(GameUtils.lucky_itemObjList.size() - 1));
        }


        if (bossobj != null && count % 30 == 0) {
            //�����ӵ�������ӵ�������
            GameUtils.bossfireList.add(new Bossfireobj(GameUtils.bossfireImg,
                    bossobj.getX() + 70, bossobj.getY() + 80, 25, 50, 8, this));

            //ÿ����һ���ӵ��ͰѸ��ӵ���ӵ���Ϸ���弯����ȥ
            GameUtils.gameList.add(GameUtils.bossfireList.get(GameUtils.bossfireList.size() - 1));
        }
        if (count % 50 == 0) {
            //�з��ɻ�
            Image enemyImg = new ImageIcon(GameUtils.class.
                    getResource("../image/ep" + NumberUtils.getNumberbyCoundition(15) + ".png")).getImage();
            int enemyw = enemyImg.getWidth(null);
            int enemyh = enemyImg.getHeight(null);
            GameUtils.enemyList.add(new Enemyobj(enemyImg, (int) ((Math.random()) * (w / 50) * 50), 0, enemyw-5, enemyh-5, 5, this));

            GameUtils.gameList.add(GameUtils.enemyList.get(GameUtils.enemyList.size() - 1));
            enemtCount++;
        }
        //����boos
        if (bossobj == null && enemtCount > 3) {
            bossobj = new Bossobj(GameUtils.bossImg, 90, 30, 135, 95, 5, this);
            GameUtils.gameList.add(bossobj);
        }
    }

    public void lunch() {
//        //��ӱ�������
//        URL url=this.getClass().getResource("");
//        AudioClip ac= Applet.newAudioClip(url);
//        ac.play();

        //���������ø߿�
        this.setSize(w, h);
        //�Ѵ����Ĵ�����ʾ����
        this.setVisible(true);
        //�ô��ھ���
        this.setLocationRelativeTo(null);
        //���ô��ڲ�������
        this.setResizable(false);
        //�����ڼ��ϱ���
        this.setTitle("");
        //���ͼ��
        Image image = new ImageIcon(this.getClass().getResource("../image/logo.jpg")).getImage();//
        this.setIconImage(image);
        //����رհ�ť��������
        this.setDefaultCloseOperation(GameWin.EXIT_ON_CLOSE);

        //�������ǵ���Ϸ����
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                System.out.println("�����˻��濪ʼ");
                if (state == 0 && e.getButton() == 1) {
                    //�ı���Ϸ״̬
                    state = 1;
                    //�ػ����
                    repaint();
                }

            }
        });


        GameUtils.gameList.add(bgobj);
        GameUtils.planeobjList.add(planeobj1);
        GameUtils.planeobjList.add(planeobj2);
        GameUtils.planeobjList.add(planeobj3);
        GameUtils.gameList.add(planeobj);

//       GameUtils.gameList.add(bossobj);

        //��ͣ��Ϸ
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //��ͣѡ��
                if(e.getKeyCode() == 32){//�ո���ͣ;
                    state = 2;
                    repaint();
                }
                if(e.getKeyCode() ==50){//2
                    state=0;
                    repaint();

                }
                if(e.getKeyCode() ==49){
                    state=1;
                    repaint();
                }
                if(e.getKeyCode() ==51){
                    state=5;
                    repaint();
                }

                if(e.getKeyCode()==52){
                    state=0;
                    //GameUtils.gameList.remove(planeobj);
                    repaint();
                }


            }
        });


        while (true) {
            if (state == 1) {
                createobj();
                repaint();
            }

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.lunch();
    }
}
