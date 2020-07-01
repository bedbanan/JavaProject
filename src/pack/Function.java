package pack;
import java.awt.*;

import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;


public class Function extends JFrame implements ActionListener{
    String StuID, Stud_Name;
    String num;
    JTextField ID;
    JButton Select;
    JPanel Va, Vb;
    JTable ival;
    JScrollPane qval;
    DefaultTableModel rval;
    JLabel label;
    static Connection ct;  
    PreparedStatement ps;  
    ResultSet rs;
    
    //Connect connect = new Connect();
    //学生登录界面
    public void StudentShow() {
        Icon v1 = new ImageIcon("p3.png");
        Va=new JPanel();
        label=new JLabel();
        label.setIcon(v1);
        label.setText("学号");
        ID = new JTextField(15);
        
        Select=new JButton("查询");
        Select.addActionListener(this);
        //界面表格名添加
        String[] colnames = { "学号","姓名", "学院", "Java", "Python", "数据结构"};  
        rval = new DefaultTableModel(colnames, 3);  
        ival = new JTable(rval);  
        qval = new JScrollPane(ival);
        
        Va = new JPanel();
        Vb = new JPanel();
        
        Va.add(label);
        Va.add(ID);
        Va.add(Select);
        Vb.add(qval);
        //查询位置调整
        this.add(Va,BorderLayout.SOUTH);
        this.add(Vb);
        
        //界面属性设置
        this.setLocationRelativeTo(null); //居中
        this.setVisible(true);
        this.setSize(500,600);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("学生管理系统");
        
    }

    //学生登录判断
     public void Student(String StudentAccount, String  StudentPassWord,JTextField te1, JPasswordField te2, JFrame frame, Function hua)  
        {
         if(StudentAccount.equals(te1.getText())&&StudentPassWord.equals(te2.getText()))  
            {  
                 JOptionPane.showMessageDialog(this, "登录成功！");
                frame.setVisible(false);//窗口不可见
                hua.StudentShow();//调用一个画板对象中的函数 弹出一个界面
            }else if(te1.getText().isEmpty()&&te2.getText().isEmpty())  
            {  
                JOptionPane.showMessageDialog(this, "请输入账号或密码");
            }else if(te1.getText().isEmpty())  
            {  
                JOptionPane.showMessageDialog(this,"请输入用户名！");  
            }else if(te2.getText().isEmpty())  
            {  
                JOptionPane.showMessageDialog(this,"请输入密码！");
            }else  
            {  
                JOptionPane.showMessageDialog(this,"<html>账户或密码错误！！！<br>请重新输入</html>","错误",JOptionPane.ERROR_MESSAGE);
                //清空输入框  
                Clear(te1, te2);
            }  
 }
        //清空文本框和密码框 
        public void Clear(JTextField te1, JPasswordField te2) {
            te1.setText("");
            te2.setText("");
        }
        //清空密码
        public void aClear(JPasswordField te2)  
        {  
            te2.setText("");  
        }
        public void bClear(JTextField te3)  
        {  
            te3.setText("");  
        }

        
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
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
            }
        }
        
        public void actionPerformed(ActionEvent ch) {  
            if(ch.getActionCommand()=="查询")  
            {
                Connect.ConnectSQL();//连接数据库
                Connect.GetStudeInfor(ID.getText());//获取ID
                    
                ID.setText("");
                ival.setValueAt(Connect.sID, 0, 0);  
                ival.setValueAt(Connect.sname, 0, 1);
                ival.setValueAt(Connect.Dept, 0 , 2);
                ival.setValueAt(Connect.Java, 0, 3);  
                ival.setValueAt(Connect.Python, 0, 4);  
                ival.setValueAt(Connect.DataStructure, 0, 5);  
            }
              
        }     
}