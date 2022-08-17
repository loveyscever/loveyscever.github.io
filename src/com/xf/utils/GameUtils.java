package com.xf.utils;

import com.xf.mian.GameWin;
import com.xf.obj.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//������
public class GameUtils {
    //����ͼƬ
    public static Image bgImg =new ImageIcon(GameUtils.class.
            getResource("../image/space.jpg")).getImage();

    //������ͼƬ
    public static Image makeImg=new ImageIcon(GameUtils.class.
            getResource("../image/over.png")).getImage();
    //bossͼƬ
    public static Image bossImg =new ImageIcon(GameUtils.class.
            getResource("../image/boss1.png")).getImage();

    //Ӣ�ۻ�
    public static Image heroImg1 =new ImageIcon(GameUtils.class.
            getResource("../image/hero1.png")).getImage();
    public static Image heroImg2 =new ImageIcon(GameUtils.class.
            getResource("../image/hero2.png")).getImage();
    public static Image heroImg3 =new ImageIcon(GameUtils.class.
            getResource("../image/hero3.png")).getImage();


    //Ӣ�ۻ��ӵ�
    public static Image fireImg1 =new ImageIcon(GameUtils.class.
            getResource("../image/shell1.png")).getImage();
    public static Image fireImg2 =new ImageIcon(GameUtils.class.
            getResource("../image/shell2.png")).getImage();
    public static Image fireImg3 =new ImageIcon(GameUtils.class.
            getResource("../image/shell3.png")).getImage();


    //boss�ӵ�
    public static Image bossfireImg =new ImageIcon(GameUtils.class.
            getResource("../image/bosszd1.png")).getImage();
    public static Image fireImg=fireImg1;


    //�з��ɻ�
//    public static Image enemyImg =new ImageIcon(GameUtils.class.
//            getResource("../image/ep02.png")).getImage();
//
    //��ըͼƬ
    public static Image bzImage=new ImageIcon(GameUtils.class.
            getResource("../image/explode/e3.gif")).getImage();

    //��ͣͼƬ
    public static Image stopImage=new ImageIcon(GameUtils.class.
            getResource("../image/score.png")).getImage();

    //������ƷͼƬ
    public static Image lukyImg = new ImageIcon(GameUtils.class.getResource("../image/luck.png")).getImage();

    //������Ϸ����ļ���
    public static ArrayList<GameObj> gameList=new ArrayList<GameObj>();

    //�ҷ��ӵ��ļ���
    public static ArrayList<Fireobj> fireList=new ArrayList<Fireobj>();

    //�з��ɻ��ļ���
    public static ArrayList<Enemyobj>enemyList=new ArrayList<Enemyobj>();

    //ɾ����Ϸ����ļ���
    public static ArrayList<GameObj>removeList=new ArrayList<GameObj>();

    //boss�ӵ�����
    public static ArrayList<Bossfireobj>bossfireList=new ArrayList<Bossfireobj>();

    //��ը����
    public static ArrayList<Explodeobj>explodeobjList=new ArrayList<Explodeobj>();

    //�ҷ��ɻ�����
    public static ArrayList<Planeobj>planeobjList=new ArrayList<Planeobj>();

    //������Ʒ����
    public static ArrayList<lucky_itemObj> lucky_itemObjList=new ArrayList<lucky_itemObj>();

    //�����ַ��ķ���
    public static void drawword(Graphics g,String str,int x,int y,int size,Color color){
        g.setColor(color);
        g.setFont(new Font("΢���ź�",Font.BOLD,size));
        g.drawString(str,x,y);
    }

}
