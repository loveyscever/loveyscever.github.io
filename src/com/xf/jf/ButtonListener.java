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
//    //��ȡ����������������
//
//    public ButtonListener(JTextField name, JTextField password) {
//        this.name=name;
//        this.password=password;
//    }
//
//    //�����¼�߼�
//
//    public void actionPerformed(ActionEvent e) {
//
//
//        //��ȡ�������û�����������Ϣ
//        String username =name.getText();
//        String pwd =password.getText();
//
//        //����û��������������Ƿ�Ϊ��
//        if(username.equals("")){
//            JOptionPane.showMessageDialog(null, "�������û�����");
//        }
//
//        else if( pwd.equals("")){
//            JOptionPane.showMessageDialog(null, "�������û����룡");
//        }
//
//        //��Ϊ���ǲ������ݿ�
//        else{
//            if(CheckLogin(username,pwd)){
//                JOptionPane.showMessageDialog(null, "��¼�ɹ���");
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
//                JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ�");
//            }
//        }
//
//
//    }
//
//    public boolean CheckLogin(String name,String pawd){
//        //���ݿ����Ƿ�������û���
//        if(LoginFrame.map.containsKey(name)){
//
//            String key =name;
//
//            //���������Ƿ���ȷ
//            if(LoginFrame.map.get(key).equals(pawd)){
//                return true;
//            }else{
//                JOptionPane.showMessageDialog(null, "�������");
//                return false;
//            }
//        }
//
//        return false;
//    }
//
//}
