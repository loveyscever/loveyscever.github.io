package com.xf.jf;

import java.awt.*;
import java.util.HashMap;

import javax.swing.*;

public class LoginFrame extends JFrame{

    public static int w=250;
    public static int h=200;
    //HashMap对象，模拟数据库

    //这里是集合的泛型形式，指定存储的内容是字符串、字符串键值对类型

    //声明为静态类型，便于访问
    public static HashMap<String,String> map = new HashMap<String,String>();
//
//    //数据库初始化
//    static {
//        for (int i = 0; i < 10; i++) {
//            map.put("user"+i, "pwd"+i);
//        }
//    }
//
//    //初始化窗体
//
    public void initFrame(){
        this.setSize(250,200);
        this.setDefaultCloseOperation(3);
        this.setTitle("飞机大战");
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        Image image=new ImageIcon(this.getClass().getResource("ep14.png")).getImage();
        this.setIconImage(image);//界面图标

        JLabel username = new JLabel("用户名 " );
        JTextField name =new JTextField(15);

        JLabel pwd = new JLabel(" 密  码 ");
        JTextField password =new JTextField(15);

        JButton bt = new JButton("登录");
        JButton bt1 = new JButton("注册");

        this.add(username);
        this.add(name);
        this.add(pwd);
        this.add(password);
        this.add(bt);
        this.add(bt1);
        JLabel bgImg = new JLabel();
        bgImg.setIcon(new ImageIcon(getClass().getResource("bg2.jpg")));
        //设置背景图片位置
//        bgImg.setBounds(10,10,250,200);
//        //背景添加到面板
//        this.add(bgImg);
        this.setVisible(true);

        //登录按钮添加监听器，处理登录逻辑
//        ButtonListener bl= new ButtonListener(name,password);
//        bt.addActionListener(bl);
//        new LoginJF().setVisible(false);

        //注册按钮添加监听器，处理注册逻辑
        RegisterLisener register = new RegisterLisener();


    }

}
