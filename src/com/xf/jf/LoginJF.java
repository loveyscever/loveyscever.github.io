package com.xf.jf;

import com.xf.mian.GameWin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginJF extends JFrame {
    //HashMap����û���������
    public static HashMap<String,String> map = new HashMap<>();


    //���ݿ��ʼ��
    static {
        for (int i = 0; i < 10; i++) {
            map.put("user"+i, "pwd"+i);
        }
    }
    static int w=680,h=447;//ȫ�ֲ���
    LoginJF that;
    public static void main(String[] args) {
        LoginJF loginJF = new LoginJF();
        loginJF.Logins();

    }

    public void Logins(){
        this.setSize(w,h);//���ÿ��
        this.setVisible(true);//��ʾ����
        this.setLocationRelativeTo(null);//���ھ���
        this.setResizable(false);//���ô��ڲ�������
        this.setTitle("�ɻ���ս��¼����");
        Image image=new ImageIcon(this.getClass().getResource("../image/ep14.png")).getImage();
        this.setIconImage(image);//����ͼ��
    }

    public LoginJF(){
        that=this;
        //���
        JPanel jpanel=new JPanel();
        //�������λ�ü���С
        jpanel.setBounds(0,0,w,h);
        //���ַ�ʽ
        jpanel.setLayout(null);
        //��ӱ�����ɫ
        //jpanel.setBackground(Color.PINK);
        //�������ӽ�����
        this.getContentPane().add(jpanel);
        //����رհ�ť��������
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

        //�û���
        JLabel nameJLabel = new JLabel("�û�����");
        //λ��
        nameJLabel.setBounds(200,80,100,20);
        //����������ʽ
        nameJLabel.setFont(new Font("΢���ź�",Font.BOLD,15));
        //������ɫ
        nameJLabel.setForeground(Color.WHITE);
        //���뵽���
        jpanel.add(nameJLabel);

        //�û��������
        JTextField nameJT = new JTextField();
        nameJT.setBounds(280,80,150,26);
        jpanel.add(nameJT);

        //����
        JLabel pwdJLabel = new JLabel("   ���룺");
        //λ��
        pwdJLabel.setBounds(200,150,100,20);
        //����������ʽ
        pwdJLabel.setFont(new Font("΢���ź�",Font.BOLD,15));
        //������ɫ
        pwdJLabel.setForeground(Color.WHITE);
        //���뵽���
        jpanel.add(pwdJLabel);

        //�����
        JPasswordField pwdJP=new JPasswordField();
        pwdJP.setBounds(280,150,150,26);
        jpanel.add(pwdJP);




        //��¼��ť
        JButton lgoinjb=new JButton("��¼");
        lgoinjb.setBounds(240,220,100,30);
        lgoinjb.setFont(new Font("΢���ź�", Font.BOLD,20));
        jpanel.add(lgoinjb);

//         JTextField name=new JTextField();
//         JTextField password=new JTextField();
        lgoinjb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username =nameJT.getText();
                String pwd =pwdJP.getText();

                //����û��������������Ƿ�Ϊ��
                if(username.equals("")){
                    JOptionPane.showMessageDialog(null, "�������û�����");
                }
                else if( pwd.equals("")){
                    JOptionPane.showMessageDialog(null, "�������û����룡");
                }

                //��Ϊ���ǲ������ݿ�
                else{
                    if(CheckLogin(username,pwd)){
                        JOptionPane.showMessageDialog(null, "��¼�ɹ���");
                         that.setVisible(false);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                GameWin gamewin=new GameWin();
                                gamewin.lunch();
                            }
                        }).start();

                    }else{
                        JOptionPane.showMessageDialog(null, "�û���������,����ע�ᣡ");
                    }
                }
            }
            public boolean CheckLogin(String name,String pawd){
                //���ݿ����Ƿ�������û���
                if(LoginFrame.map.containsKey(name)){

                    String key =name;

                    //���������Ƿ���ȷ
                    if(LoginFrame.map.get(key).equals(pawd)){
                        return true;
                    }else{
                        JOptionPane.showMessageDialog(null, "�������");
                        return false;
                    }
                }

                return false;
            }

        });


        //ע�ᰴť
        JButton zc=new JButton("ע��");
        zc.setBounds(350,220,100,30);
        zc.setFont(new Font("΢���ź�", Font.BOLD,20));
        jpanel.add(zc);
        //�¼����������ж��Ƿ����˰�ť

//        ButtonListener bl= new ButtonListener(nameJT,pwdJP);
//        lgoinjb.addActionListener(bl);
//        that.setVisible(false);

        //ע�ᰴť��Ӽ�����������ע���߼�
        RegisterLisener register = new RegisterLisener();
        zc.addActionListener(register);
        //JLabel����ͼƬ
        JLabel bgImg = new JLabel();
        bgImg.setIcon(new ImageIcon(getClass().getResource("R-C2.png")));
        //���ñ���ͼƬλ��
        bgImg.setBounds(0,0,w,h);
        //������ӵ����
        jpanel.add(bgImg);
    }
}
