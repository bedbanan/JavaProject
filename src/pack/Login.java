package pack;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class Login {
    String StudentAccount="123456";  
    String StudentPassWord="123456";
    JLabel L, L1, L2, L3, L4, BK;
    JTextField te1, te3;
    JPasswordField te2;
    JRadioButton value1, value2;
    JButton B1, B2;
    ButtonGroup bg;
    JPanel jp1,jp2,jp3,jp4;
    //设置图标
    Icon v1 = new ImageIcon("p3.png");
    Icon v2 = new ImageIcon("p4.png");
    Icon v3 = new ImageIcon("p5.png");
    Icon v4 = new ImageIcon("p6.png");
    private VerCode VerCode = new VerCode();//引用验证码函数
    
    public static void main(String[] args) {
        Login frame=new Login();
        frame.show();
    }
        JFrame frame=new JFrame();//frame界面
    public void show() {    
        setBackgroudImage();
        
         Toolkit tk = Toolkit.getDefaultToolkit();//默认加载方式
         Image image = new ImageIcon(getClass().getResource("p6.png")).getImage();//设置光标图片
         Cursor cursor = tk.createCustomCursor(image, new Point(10, 10), "biubiubiu");//光标image属性，指定光标中心，光标文字描述
         frame.setCursor(cursor);
        
        L1=new JLabel("<html>账号:</html>");
        L1.setIcon(v1);
        te1=new JTextField(80);
        //设置密码窗口，使用'*'隐藏密码
        L2=new JLabel("<html>密码:</html>");
        L2.setIcon(v2);
        te2=new JPasswordField(80);//
        te2.setEchoChar('*');
        L4 = new JLabel("验证码:");
        L4.setIcon(v3);
        te3=new JTextField(80);
        
        //设置登录身份选择按钮
        jp2 = new JPanel();
        L3 = new JLabel("身份:");
        L3.setIcon(v4);
        value2=new JRadioButton("学生");
        SetBt(value2);
        
        //设置位置和大小
        L1.setBounds(60, 90, 60, 40);
        L2.setBounds(60, 140, 60, 40);
        L3.setBounds(60, 240, 60, 40);
        L4.setBounds(60, 190, 60, 40);
        
        jp2.setBounds(80, 240, 60, 40);
        te1.setBounds(130, 90, 150, 30);
        te2.setBounds(130, 140, 150, 30);
        te3.setBounds(130, 190, 150, 30);
        VerCode.setBounds(290, 190, 100, 40);
        value2.setBounds(120, 240, 60, 40);
        
        //设置'登录'及'重置'按钮
        B1=new JButton("登录");
        B1.setBounds(120, 280, 80, 40);
        SetBt(B1);
        ButtonListener li1=new ButtonListener(te1,te2);             
        
        B2=new JButton("注册");
        B2.setBounds(250, 280, 80, 40);
        SetBt(B2);
        ButtonListener li2=new ButtonListener(te1,te2);
        
        //设置监听  
        B1.addActionListener(li1);  
        B2.addActionListener(li2);  

        //组键添加到窗口
        frame.setLayout(null);
        //frame.add(L);
        
        frame.add(L1);
        frame.add(te1);
        
        frame.add(L2);
        frame.add(te2);
        
        frame.add(L3);
        frame.add(value2);
        
        frame.add(L4);
        frame.add(te3);
        frame.add(VerCode);
        
        frame.add(B1);
        frame.add(B2);
        frame.setVisible(true);//窗体设置为可见
        
        frame.setTitle("学生管理系统");
        frame.setSize(700,403);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    private void SetBt(JButton b12) {
        b12.setBackground(new Color(102, 0, 204));//设置色值
        b12.setFont(new Font("宋体", Font.BOLD, 24));//设置字体，样式。字号
        b12.setOpaque(false);//设置控件透明
        b12.setBorder(BorderFactory.createEmptyBorder());
        
    }
    private void SetBt(JRadioButton b12) {
        b12.setBackground(new Color(102, 0, 204));
        b12.setFont(new Font("Dialog", Font.BOLD, 15));  
        b12.setOpaque(false);//设置控件透明
        b12.setBorder(BorderFactory.createEmptyBorder());
        
    }
    
    public boolean isValidCodeRight() {//判断验证码是否有效
        if(te3 == null) {
            return false;
        }else if(VerCode == null) {
            return true;
        }else if(VerCode.getCode() .equals(te3.getText())) {
            return true;
        }else 
            return false;
    }

    private void setBackgroudImage() {
        // TODO Auto-generated method stub
         ((JPanel) frame.getContentPane()).setOpaque(false);  
            ImageIcon img = new ImageIcon("3.gif"); // 添加图片  
            BK = new JLabel(img);  
            frame.getLayeredPane().add(BK, new Integer(Integer.MIN_VALUE));  
            BK.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());  
    }

    //创建类实现接口
    public  class ButtonListener implements java.awt.event.ActionListener{    //实现ActionListener 接口 implement
        JTextField te1=new JTextField();               //传参
        JPasswordField te2=new JPasswordField();
        Function hua=new Function();                       //一个画板对象
        ButtonListener(JTextField te1,JPasswordField te2) {//重载 窗体上的账号框，密码框传到监听上来
            this.te1=te1;    
            this.te2=te2;
        }
        public ButtonListener(JTextField ID) {
            // TODO Auto-generated constructor stub
        }
        @Override
        public void actionPerformed(ActionEvent ch) {
            // TODO Auto-generated method stub
             if(ch.getActionCommand()=="登录")
                { 
                 if(te3.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "请输入验证码!");
                    }else {
                        if(!isValidCodeRight()) {
                            JOptionPane.showMessageDialog(null, "验证码错误,请重新输入!","错误",JOptionPane.ERROR_MESSAGE);
                            hua.bClear(te3);
                        }
                        else if(value2.isSelected()) 
                        {  
                        hua.Student(StudentAccount, StudentPassWord, te1, te2, frame, hua);//学生
                        }
                          
                        else if(ch.getActionCommand()=="重置")  
                        {  
                            hua.Clear(te1, te2);  
                        }
                    }
                      
                }
            
        }
        
    }
}