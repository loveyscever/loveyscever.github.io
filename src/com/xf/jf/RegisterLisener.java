package com.xf.jf;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class RegisterLisener extends JFrame implements ActionListener {

    public JTextField name;

    public JTextField password;
    RegisterLisener that;
    String a;

    //ע�ᰴť�����߼�  

    public void actionPerformed(ActionEvent e) {
        //����ע��ҳ��  
        RegisterLisener register = new RegisterLisener();
        register.showF();
        //register.showFrame();

    }

    public void showF() {
        RegisterLisener register = new RegisterLisener();
        register.setTitle("��ӭע��");
        register.setSize(680, 447);
        register.setLocationRelativeTo(null);
        register.setResizable(false);
        register.setVisible(true);
        Image image = new ImageIcon(register.getClass().getResource("ep14.png")).getImage();
        register.setIconImage(image);//����ͼ��
    }

    public RegisterLisener() {

        that = this;
        JPanel jp = new JPanel();
        jp.setBounds(0, 0, 680, 447);
        jp.setLayout(null);
        this.getContentPane().add(jp);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel nameLable = new JLabel("�û�����");
        nameLable.setBounds(170, 140, 220, 20);
        nameLable.setFont(new Font("΢���ź�", Font.BOLD, 15));
        nameLable.setForeground(Color.YELLOW);
        jp.add(nameLable);
        JTextField namejf = new JTextField();
        namejf.setBounds(230, 140, 220, 25);
        jp.add(namejf);

        JLabel pwdLable = new JLabel("���룺");
        pwdLable.setBounds(170, 190, 220, 25);
        pwdLable.setFont(new Font("΢���ź�", Font.BOLD, 15));
        pwdLable.setForeground(Color.YELLOW);
        jp.add(pwdLable);
        JPasswordField jpwfield = new JPasswordField();
        jpwfield.setBounds(230, 190, 220, 25);
        jp.add(jpwfield);
        JLabel yzLable = new JLabel("��֤�룺");
        yzLable.setBounds(170, 240, 110, 25);
        yzLable.setFont(new Font("΢���ź�", Font.BOLD, 15));
        yzLable.setForeground(Color.YELLOW);
        jp.add(yzLable);
        JTextField yzjf = new JTextField();
        yzjf.setBounds(230, 240, 90, 25);
        jp.add(yzjf);

        JButton yz=new JButton("��ȡ��֤��");
        yz.setBounds(350, 240, 110, 25);
        yz.setFont(new Font("΢���ź�", Font.BOLD, 15));
        yz.setForeground(Color.BLACK);
        jp.add(yz);

//        JLabel yzLable = new JLabel("��֤�룺");
//        yzLable.setBounds(170, 200, 110, 25);
//        yzLable.setFont(new Font("΢���ź�", Font.BOLD, 15));
//        yzLable.setForeground(Color.YELLOW);
//        jp.add(yzLable);
//        JTextField yzjf = new JTextField();
//        yzjf.setBounds(230, 200, 90, 25);
//        jp.add(yzjf);


        //��ע��ҳ���ע�ᰴť��Ӽ�����
        JButton bt1 = new JButton("ע��");
        bt1.setBounds(345, 285, 70, 30);
        bt1.setFont(new Font("΢���ź�", Font.BOLD, 15));
        jp.add(bt1);

        JButton bt2 = new JButton("ȡ��");
        bt2.setBounds(245, 285, 70, 30);
        bt2.setFont(new Font("΢���ź�", Font.BOLD, 15));
        jp.add(bt2);

        yz.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int random=(int) (Math.random()*9000+1000);
                String str=random+"";
                System.out.println("��֤��Ϊ��"+random);
                a=random+"";
            }
        });
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String zhucename = namejf.getText();
                String zhucepwd = jpwfield.getText();
                //����û�����

                if (zhucename.equals("")) {
                    JOptionPane.showMessageDialog(null, "�������û�����");
                } else if (LoginFrame.map.containsKey(zhucename)) {
                    System.out.println(11);
                    JOptionPane.showMessageDialog(null, "���˺��Ѿ����ڣ�");
                } else if (zhucepwd.equals("")) {
                    JOptionPane.showMessageDialog(null, "�������û����룡");
                }
                else if(!yzjf.getText().equals(a)){
                    JOptionPane.showMessageDialog(null, "��֤����");
                }
                else {
                    //����µļ�ֵ��
                    LoginFrame.map.put(zhucename, zhucepwd);
                    JOptionPane.showMessageDialog(null, "ע��ɹ���");
                    //ע��ҳ������
                    //register.setVisible(false);
                    that.setVisible(false);

                }
            }

        });

        bt2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                that.setVisible(false);
            }
        });

        JLabel bgImg = new JLabel();
        bgImg.setIcon(new ImageIcon(getClass().getResource("RC-3.jpg")));
        //���ñ���ͼƬλ��
        bgImg.setBounds(0, 0, 680, 447);
        //������ӵ����
        jp.add(bgImg);
    }
}
