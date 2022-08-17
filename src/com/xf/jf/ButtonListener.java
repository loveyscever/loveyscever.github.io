//package com.xf.jf;
//
//import com.xf.mian.GameWin;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JOptionPane;
//import javax.swing.JTextField;
//
//public class ButtonListener implements ActionListener{
//    LoginJF that;
//
//    public JTextField name;
//    public JTextField password;
//
//    //获取传过来的输入框对象
//
//    public ButtonListener(JTextField name, JTextField password) {
//        this.name=name;
//        this.password=password;
//    }
//
//    //处理登录逻辑
//
//    public void actionPerformed(ActionEvent e) {
//
//
//        //获取输入框的用户名和密码信息
//        String username =name.getText();
//        String pwd =password.getText();
//
//        //检测用户名和密码输入是否为空
//        if(username.equals("")){
//            JOptionPane.showMessageDialog(null, "请输入用户名！");
//        }
//
//        else if( pwd.equals("")){
//            JOptionPane.showMessageDialog(null, "请输入用户密码！");
//        }
//
//        //不为空是查找数据库
//        else{
//            if(CheckLogin(username,pwd)){
//                JOptionPane.showMessageDialog(null, "登录成功！");
//               // that.setVisible(false);
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        GameWin gamewin=new GameWin();
//                        gamewin.lunch();
//                    }
//                }).start();
//
//            }else{
//                JOptionPane.showMessageDialog(null, "登录失败！");
//            }
//        }
//
//
//    }
//
//    public boolean CheckLogin(String name,String pawd){
//        //数据库中是否包含该用户名
//        if(LoginFrame.map.containsKey(name)){
//
//            String key =name;
//
//            //检验密码是否正确
//            if(LoginFrame.map.get(key).equals(pawd)){
//                return true;
//            }else{
//                JOptionPane.showMessageDialog(null, "密码错误！");
//                return false;
//            }
//        }
//
//        return false;
//    }
//
//}
