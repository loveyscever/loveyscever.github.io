package com.xf.jf;

import com.xf.mian.GameWin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginJF extends JFrame {
    //HashMap存放用户名和密码
    public static HashMap<String,String> map = new HashMap<>();


    //数据库初始化
    static {
        for (int i = 0; i < 10; i++) {
            map.put("user"+i, "pwd"+i);
        }
    }
    static int w=680,h=447;//全局参数
    LoginJF that;
    public static void main(String[] args) {
        LoginJF loginJF = new LoginJF();
        loginJF.Logins();

    }

    public void Logins(){
        this.setSize(w,h);//设置宽高
        this.setVisible(true);//显示窗口
        this.setLocationRelativeTo(null);//窗口居中
        this.setResizable(false);//设置窗口不可拉伸
        this.setTitle("飞机大战登录窗口");
        Image image=new ImageIcon(this.getClass().getResource("../image/ep14.png")).getImage();
        this.setIconImage(image);//界面图标
    }

    public LoginJF(){
        that=this;
        //面板
        JPanel jpanel=new JPanel();
        //设置面板位置及大小
        jpanel.setBounds(0,0,w,h);
        //布局方式
        jpanel.setLayout(null);
        //添加背景颜色
        //jpanel.setBackground(Color.PINK);
        //把面板添加进窗体
        this.getContentPane().add(jpanel);
        //点击关闭按钮结束运行
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

        //用户名
        JLabel nameJLabel = new JLabel("用户名：");
        //位置
        nameJLabel.setBounds(200,80,100,20);
        //设置字体样式
        nameJLabel.setFont(new Font("微软雅黑",Font.BOLD,15));
        //字体颜色
        nameJLabel.setForeground(Color.WHITE);
        //加入到面板
        jpanel.add(nameJLabel);

        //用户名输入框
        JTextField nameJT = new JTextField();
        nameJT.setBounds(280,80,150,26);
        jpanel.add(nameJT);

        //密码
        JLabel pwdJLabel = new JLabel("   密码：");
        //位置
        pwdJLabel.setBounds(200,150,100,20);
        //设置字体样式
        pwdJLabel.setFont(new Font("微软雅黑",Font.BOLD,15));
        //字体颜色
        pwdJLabel.setForeground(Color.WHITE);
        //加入到面板
        jpanel.add(pwdJLabel);

        //密码框
        JPasswordField pwdJP=new JPasswordField();
        pwdJP.setBounds(280,150,150,26);
        jpanel.add(pwdJP);




        //登录按钮
        JButton lgoinjb=new JButton("登录");
        lgoinjb.setBounds(240,220,100,30);
        lgoinjb.setFont(new Font("微软雅黑", Font.BOLD,20));
        jpanel.add(lgoinjb);

//         JTextField name=new JTextField();
//         JTextField password=new JTextField();
        lgoinjb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username =nameJT.getText();
                String pwd =pwdJP.getText();

                //检测用户名和密码输入是否为空
                if(username.equals("")){
                    JOptionPane.showMessageDialog(null, "请输入用户名！");
                }
                else if( pwd.equals("")){
                    JOptionPane.showMessageDialog(null, "请输入用户密码！");
                }

                //不为空是查找数据库
                else{
                    if(CheckLogin(username,pwd)){
                        JOptionPane.showMessageDialog(null, "登录成功！");
                         that.setVisible(false);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                GameWin gamewin=new GameWin();
                                gamewin.lunch();
                            }
                        }).start();

                    }else{
                        JOptionPane.showMessageDialog(null, "用户名不存在,请先注册！");
                    }
                }
            }
            public boolean CheckLogin(String name,String pawd){
                //数据库中是否包含该用户名
                if(LoginFrame.map.containsKey(name)){

                    String key =name;

                    //检验密码是否正确
                    if(LoginFrame.map.get(key).equals(pawd)){
                        return true;
                    }else{
                        JOptionPane.showMessageDialog(null, "密码错误！");
                        return false;
                    }
                }

                return false;
            }

        });


        //注册按钮
        JButton zc=new JButton("注册");
        zc.setBounds(350,220,100,30);
        zc.setFont(new Font("微软雅黑", Font.BOLD,20));
        jpanel.add(zc);
        //事件监视器来判断是否点击了按钮

//        ButtonListener bl= new ButtonListener(nameJT,pwdJP);
//        lgoinjb.addActionListener(bl);
//        that.setVisible(false);

        //注册按钮添加监听器，处理注册逻辑
        RegisterLisener register = new RegisterLisener();
        zc.addActionListener(register);
        //JLabel背景图片
        JLabel bgImg = new JLabel();
        bgImg.setIcon(new ImageIcon(getClass().getResource("R-C2.png")));
        //设置背景图片位置
        bgImg.setBounds(0,0,w,h);
        //背景添加到面板
        jpanel.add(bgImg);
    }
}
