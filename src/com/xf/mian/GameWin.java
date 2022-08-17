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
    //飞机等级
    public static int leve=1;

    //0游戏开始  1游戏中  2暂停   3通关失败  4通过成功
    public static int state = 0;

    //背景图片
    Bgobj bgobj1 = new Bgobj(GameUtils.bgImg, 0, -1866, 2);//-2066=-(2666-800)

    Bgobj makeobj=new Bgobj(GameUtils.makeImg,0,-31,0);
    Bgobj bgobj=bgobj1;
    //图片对象
    Image offScreenImage = null;

    //幸运物品
    lucky_itemObj lucky_item=new lucky_itemObj(GameUtils.lukyImg, 100, 20, 61, 49, 4, this);

    //我方飞机
    public Planeobj planeobj1 = new Planeobj(GameUtils.heroImg1, 150, 600, 80, 80, 0, this);//40,41用于计算,改变数组不会改变图片大小
    public Planeobj planeobj2 = new Planeobj(GameUtils.heroImg2, 150, 600, 80, 80, 0, this);//40,41用于计算,改变数组不会改变
    public Planeobj planeobj3 = new Planeobj(GameUtils.heroImg3, 150, 600, 80, 80, 0, this);//40,41用于计算,改变数组不会改变

    public Planeobj planeobj=planeobj1;
    //boss图片
//    public Bossobj bossobj=new Bossobj(GameUtils.bossImg,50,30,157,109,5,this);

    //敌方飞机
    //Enemyobj enemyobj=new Enemyobj(GameUtils.enemyImg,150,50,61,48,5,this);
    //绘制次数
    int count = 0;

    //我方子弹
    //Fireobj fireobj=new Fireobj(GameUtils.fireImg,planeobj.getX(),planeobj.getY()-50,50,52,5,this);
    public static Image fireImg=GameUtils.fireImg1;


    //游戏得分
    public static int score = 0;

    //对敌方飞机的计数
    int enemtCount = 0;

    //boss对象
    public Bossobj bossobj;


    @Override
    public void paint(Graphics g)  {
        //初始化图片
        if (offScreenImage == null) {
            offScreenImage = createImage(w, h);
        }
        //获取当前的画布对象
        Graphics gImage = offScreenImage.getGraphics();

        //使用画布对象填充一个具有高度和宽度的区域
        gImage.drawRect(0, 0, w, h);

        // g画板  画入游戏背景
        if (state == 0) {
            //背景图片
            gImage.drawImage(GameUtils.bgImg, 0, 0, w, h, null);
            gImage.drawImage(GameUtils.bossImg, 170, 100, 157, 109, null);
            gImage.drawImage(GameUtils.heroImg1, 220, 600, 50, 41, null);
            gImage.setColor(Color.PINK);
            gImage.setFont(new Font("微软雅黑", Font.BOLD, 30));
            gImage.drawString("点击游戏开始", 160, 320);
        }
        if (state == 1) {
            //当游戏开始时，添加爆炸
            GameUtils.gameList.addAll(GameUtils.explodeobjList);
            //fireobj.painSelf(gImage);
            for (GameObj gameObj : GameUtils.gameList) {
                gameObj.painSelf(gImage);
            }
            //在下一次绘制前删除集合里面的元素
            GameUtils.gameList.removeAll(GameUtils.removeList);
        }
        //暂停菜单
        if(state==2){
            gImage.drawImage(GameUtils.stopImage,200,450,50,52,null);
            gImage.setColor(Color.PINK);
            gImage.setFont(new Font("微软雅黑", Font.ITALIC, 25));
            gImage.drawString("1.继续游戏", 170, 250);
            gImage.drawString("2.重新开始游戏", 170, 320);
            gImage.drawString("3.退出游戏", 170, 390);
            //gImage.drawImage(GameUtils.pauseImg,175,280,null);
        }
        //死亡菜单
        if (state == 3) {
            gImage.drawImage(GameUtils.bzImage, planeobj.getX(), planeobj.getY() - 20, null);
            gImage.setColor(Color.PINK);
            gImage.setFont(new Font("微软雅黑", Font.BOLD, 25));
            gImage.drawString("GAME OVER", 150, 320);

            gImage.drawString("3：退出程序  4：复活  ",100,550);

            gImage.drawString("请继续努力", 170, 400);
        }
        //通关
        if (state == 4) {
            gImage.drawImage(GameUtils.bzImage, bossobj.getX() + 60, bossobj.getY() + 30, null);
            gImage.setColor(Color.PINK);
            gImage.setFont(new Font("微软雅黑", Font.BOLD, 25));

            gImage.drawString("3：退出程序 ",180,550);

            gImage.drawString("通关成功", 200, 400);

        }

        //退出
        if(state==5){
            System.exit(0);
        }

        GameUtils.drawword(gImage, score + "分", 20, 60, 30, Color.green);
        //把图片一次性汇入窗口
        g.drawImage(offScreenImage, 0, 0, null);
        count++;
    }

    //批量生成子弹
    public void createobj() {
        //英雄飞机升级和子弹升级，分数每加50升一级;
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
            //二级飞机图片
            fireImg=GameUtils.fireImg2;
            repaint();
        }
        if (score==100){
            //三级飞机图片
            fireImg=GameUtils.fireImg3;
            repaint();
        }

        //每绘制20次生成一颗子弹
        if (count % 15 == 0) {
            //创建子弹对象，添加到集合中
                GameUtils.fireList.add(new Fireobj(fireImg,
                        planeobj.getX()+40, planeobj.getY() - 50, 45, 45, 8, this));


            //每生成一颗子弹就把该子弹添加到游戏物体集合中去
            GameUtils.gameList.add(GameUtils.fireList.get(GameUtils.fireList.size() - 1));
        }
        //幸运物品
        if(count%300==0){

            GameUtils.lucky_itemObjList.add(new lucky_itemObj(GameUtils.lukyImg, lucky_item.getX() + 60, lucky_item.getY() + 100, 50, 52, 5, this));
            GameUtils.gameList.add(GameUtils.lucky_itemObjList.get(GameUtils.lucky_itemObjList.size() - 1));
        }


        if (bossobj != null && count % 30 == 0) {
            //创建子弹对象，添加到集合中
            GameUtils.bossfireList.add(new Bossfireobj(GameUtils.bossfireImg,
                    bossobj.getX() + 70, bossobj.getY() + 80, 25, 50, 8, this));

            //每生成一颗子弹就把该子弹添加到游戏物体集合中去
            GameUtils.gameList.add(GameUtils.bossfireList.get(GameUtils.bossfireList.size() - 1));
        }
        if (count % 50 == 0) {
            //敌方飞机
            Image enemyImg = new ImageIcon(GameUtils.class.
                    getResource("../image/ep" + NumberUtils.getNumberbyCoundition(15) + ".png")).getImage();
            int enemyw = enemyImg.getWidth(null);
            int enemyh = enemyImg.getHeight(null);
            GameUtils.enemyList.add(new Enemyobj(enemyImg, (int) ((Math.random()) * (w / 50) * 50), 0, enemyw-5, enemyh-5, 5, this));

            GameUtils.gameList.add(GameUtils.enemyList.get(GameUtils.enemyList.size() - 1));
            enemtCount++;
        }
        //生成boos
        if (bossobj == null && enemtCount > 3) {
            bossobj = new Bossobj(GameUtils.bossImg, 90, 30, 135, 95, 5, this);
            GameUtils.gameList.add(bossobj);
        }
    }

    public void lunch() {
//        //添加背景音乐
//        URL url=this.getClass().getResource("");
//        AudioClip ac= Applet.newAudioClip(url);
//        ac.play();

        //给窗口设置高宽
        this.setSize(w, h);
        //把创建的窗口显示出来
        this.setVisible(true);
        //让窗口居中
        this.setLocationRelativeTo(null);
        //设置窗口不可拉伸
        this.setResizable(false);
        //给窗口加上标题
        this.setTitle("");
        //添加图标
        Image image = new ImageIcon(this.getClass().getResource("../image/logo.jpg")).getImage();//
        this.setIconImage(image);
        //点击关闭按钮结束程序
        this.setDefaultCloseOperation(GameWin.EXIT_ON_CLOSE);

        //监听我们的游戏画面
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                System.out.println("你点击了画面开始");
                if (state == 0 && e.getButton() == 1) {
                    //改变游戏状态
                    state = 1;
                    //重绘组件
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

        //暂停游戏
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //暂停选择
                if(e.getKeyCode() == 32){//空格暂停;
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
