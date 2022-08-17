package com.xf.utils;

import com.xf.mian.GameWin;
import com.xf.obj.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//工具类
public class GameUtils {
    //背景图片
    public static Image bgImg =new ImageIcon(GameUtils.class.
            getResource("../image/space.jpg")).getImage();

    //制作人图片
    public static Image makeImg=new ImageIcon(GameUtils.class.
            getResource("../image/over.png")).getImage();
    //boss图片
    public static Image bossImg =new ImageIcon(GameUtils.class.
            getResource("../image/boss1.png")).getImage();

    //英雄机
    public static Image heroImg1 =new ImageIcon(GameUtils.class.
            getResource("../image/hero1.png")).getImage();
    public static Image heroImg2 =new ImageIcon(GameUtils.class.
            getResource("../image/hero2.png")).getImage();
    public static Image heroImg3 =new ImageIcon(GameUtils.class.
            getResource("../image/hero3.png")).getImage();


    //英雄机子弹
    public static Image fireImg1 =new ImageIcon(GameUtils.class.
            getResource("../image/shell1.png")).getImage();
    public static Image fireImg2 =new ImageIcon(GameUtils.class.
            getResource("../image/shell2.png")).getImage();
    public static Image fireImg3 =new ImageIcon(GameUtils.class.
            getResource("../image/shell3.png")).getImage();


    //boss子弹
    public static Image bossfireImg =new ImageIcon(GameUtils.class.
            getResource("../image/bosszd1.png")).getImage();
    public static Image fireImg=fireImg1;


    //敌方飞机
//    public static Image enemyImg =new ImageIcon(GameUtils.class.
//            getResource("../image/ep02.png")).getImage();
//
    //爆炸图片
    public static Image bzImage=new ImageIcon(GameUtils.class.
            getResource("../image/explode/e3.gif")).getImage();

    //暂停图片
    public static Image stopImage=new ImageIcon(GameUtils.class.
            getResource("../image/score.png")).getImage();

    //幸运物品图片
    public static Image lukyImg = new ImageIcon(GameUtils.class.getResource("../image/luck.png")).getImage();

    //所有游戏物体的集合
    public static ArrayList<GameObj> gameList=new ArrayList<GameObj>();

    //我方子弹的集合
    public static ArrayList<Fireobj> fireList=new ArrayList<Fireobj>();

    //敌方飞机的集合
    public static ArrayList<Enemyobj>enemyList=new ArrayList<Enemyobj>();

    //删除游戏物体的集合
    public static ArrayList<GameObj>removeList=new ArrayList<GameObj>();

    //boss子弹集合
    public static ArrayList<Bossfireobj>bossfireList=new ArrayList<Bossfireobj>();

    //爆炸集合
    public static ArrayList<Explodeobj>explodeobjList=new ArrayList<Explodeobj>();

    //我方飞机集合
    public static ArrayList<Planeobj>planeobjList=new ArrayList<Planeobj>();

    //幸运物品集合
    public static ArrayList<lucky_itemObj> lucky_itemObjList=new ArrayList<lucky_itemObj>();

    //绘制字符的方法
    public static void drawword(Graphics g,String str,int x,int y,int size,Color color){
        g.setColor(color);
        g.setFont(new Font("微软雅黑",Font.BOLD,size));
        g.drawString(str,x,y);
    }

}
