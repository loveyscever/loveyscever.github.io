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

    //注册按钮处理逻辑  

    public void actionPerformed(ActionEvent e) {
        //创建注册页面  
        RegisterLisener register = new RegisterLisener();
        register.showF();
        //register.showFrame();

    }

    public void showF() {
        RegisterLisener register = new RegisterLisener();
        register.setTitle("欢迎注册");
        register.setSize(680, 447);
        register.setLocationRelativeTo(null);
        register.setResizable(false);
        register.setVisible(true);
        Image image = new ImageIcon(register.getClass().getResource("ep14.png")).getImage();
        register.setIconImage(image);//界面图标
    }

    public RegisterLisener() {

        that = this;
        JPanel jp = new JPanel();
        jp.setBounds(0, 0, 680, 447);
        jp.setLayout(null);
        this.getContentPane().add(jp);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel nameLable = new JLabel("用户名：");
        nameLable.setBounds(170, 140, 220, 20);
        nameLable.setFont(new Font("微软雅黑", Font.BOLD, 15));
        nameLable.setForeground(Color.YELLOW);
        jp.add(nameLable);
        JTextField namejf = new JTextField();
        namejf.setBounds(230, 140, 220, 25);
        jp.add(namejf);

        JLabel pwdLable = new JLabel("密码：");
        pwdLable.setBounds(170, 190, 220, 25);
        pwdLable.setFont(new Font("微软雅黑", Font.BOLD, 15));
        pwdLable.setForeground(Color.YELLOW);
        jp.add(pwdLable);
        JPasswordField jpwfield = new JPasswordField();
        jpwfield.setBounds(230, 190, 220, 25);
        jp.add(jpwfield);
        JLabel yzLable = new JLabel("验证码：");
        yzLable.setBounds(170, 240, 110, 25);
        yzLable.setFont(new Font("微软雅黑", Font.BOLD, 15));
        yzLable.setForeground(Color.YELLOW);
        jp.add(yzLable);
        JTextField yzjf = new JTextField();
        yzjf.setBounds(230, 240, 90, 25);
        jp.add(yzjf);

        JButton yz=new JButton("获取验证码");
        yz.setBounds(350, 240, 110, 25);
        yz.setFont(new Font("微软雅黑", Font.BOLD, 15));
        yz.setForeground(Color.BLACK);
        jp.add(yz);

//        JLabel yzLable = new JLabel("验证码：");
//        yzLable.setBounds(170, 200, 110, 25);
//        yzLable.setFont(new Font("微软雅黑", Font.BOLD, 15));
//        yzLable.setForeground(Color.YELLOW);
//        jp.add(yzLable);
//        JTextField yzjf = new JTextField();
//        yzjf.setBounds(230, 200, 90, 25);
//        jp.add(yzjf);


        //该注册页面的注册按钮添加监听器
        JButton bt1 = new JButton("注册");
        bt1.setBounds(345, 285, 70, 30);
        bt1.setFont(new Font("微软雅黑", Font.BOLD, 15));
        jp.add(bt1);

        JButton bt2 = new JButton("取消");
        bt2.setBounds(245, 285, 70, 30);
        bt2.setFont(new Font("微软雅黑", Font.BOLD, 15));
        jp.add(bt2);

        yz.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int random=(int) (Math.random()*9000+1000);
                String str=random+"";
                System.out.println("验证码为："+random);
                a=random+"";
            }
        });
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String zhucename = namejf.getText();
                String zhucepwd = jpwfield.getText();
                //检测用户输入

                if (zhucename.equals("")) {
                    JOptionPane.showMessageDialog(null, "请输入用户名！");
                } else if (LoginFrame.map.containsKey(zhucename)) {
                    System.out.println(11);
                    JOptionPane.showMessageDialog(null, "该账号已经存在！");
                } else if (zhucepwd.equals("")) {
                    JOptionPane.showMessageDialog(null, "请输入用户密码！");
                }
                else if(!yzjf.getText().equals(a)){
                    JOptionPane.showMessageDialog(null, "验证错误！");
                }
                else {
                    //添加新的键值对
                    LoginFrame.map.put(zhucename, zhucepwd);
                    JOptionPane.showMessageDialog(null, "注册成功！");
                    //注册页面隐藏
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
        //设置背景图片位置
        bgImg.setBounds(0, 0, 680, 447);
        //背景添加到面板
        jp.add(bgImg);
    }
}
