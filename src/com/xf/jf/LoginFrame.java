package com.xf.jf;

import java.awt.*;
import java.util.HashMap;

import javax.swing.*;

public class LoginFrame extends JFrame{

    public static int w=250;
    public static int h=200;
    //HashMap����ģ�����ݿ�

    //�����Ǽ��ϵķ�����ʽ��ָ���洢���������ַ������ַ�����ֵ������

    //����Ϊ��̬���ͣ����ڷ���
    public static HashMap<String,String> map = new HashMap<String,String>();
//
//    //���ݿ��ʼ��
//    static {
//        for (int i = 0; i < 10; i++) {
//            map.put("user"+i, "pwd"+i);
//        }
//    }
//
//    //��ʼ������
//
    public void initFrame(){
        this.setSize(250,200);
        this.setDefaultCloseOperation(3);
        this.setTitle("�ɻ���ս");
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        Image image=new ImageIcon(this.getClass().getResource("ep14.png")).getImage();
        this.setIconImage(image);//����ͼ��

        JLabel username = new JLabel("�û��� " );
        JTextField name =new JTextField(15);

        JLabel pwd = new JLabel(" ��  �� ");
        JTextField password =new JTextField(15);

        JButton bt = new JButton("��¼");
        JButton bt1 = new JButton("ע��");

        this.add(username);
        this.add(name);
        this.add(pwd);
        this.add(password);
        this.add(bt);
        this.add(bt1);
        JLabel bgImg = new JLabel();
        bgImg.setIcon(new ImageIcon(getClass().getResource("bg2.jpg")));
        //���ñ���ͼƬλ��
//        bgImg.setBounds(10,10,250,200);
//        //������ӵ����
//        this.add(bgImg);
        this.setVisible(true);

        //��¼��ť��Ӽ������������¼�߼�
//        ButtonListener bl= new ButtonListener(name,password);
//        bt.addActionListener(bl);
//        new LoginJF().setVisible(false);

        //ע�ᰴť��Ӽ�����������ע���߼�
        RegisterLisener register = new RegisterLisener();


    }

}
