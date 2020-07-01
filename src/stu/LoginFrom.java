package stu;
import pack.VerCode;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.JTableHeader;
/**
 * 登录窗口
 * @author hasee
 *
 */
class LoginFrom extends JFrame implements ActionListener {
    JLabel labName=new JLabel("姓名");
    JLabel labpwd=new JLabel("密码");
    JTextField txtname=new JTextField(20);
    JPasswordField txtpwd=new JPasswordField(20);
    JButton but=new JButton("确定");
    JButton but1=new JButton("取消");
    JPanel pan=new JPanel();
    JPanel pan1=new JPanel();
    JPanel pan2=new JPanel();
    JPanel pan3=new JPanel();
    JPanel pan4=new JPanel();
    JPanel pan5=new JPanel();
    JPanel pan6=new JPanel();
    StudentDate studnet=new StudentDate(); //创建数据库操作对象，实现对象的增删改查
    private VerCode verCode=new VerCode();//引用验证码
    JLabel lver=new JLabel("验证码");
    JTextField ver=new JTextField(20);
    public LoginFrom() {
		this.setTitle("用户登录");
		this.setBounds(500,500,350,300);
		verCode.setBounds(290, 190, 100, 40);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		init();
		this.setVisible(true);
	}
    public void init() {
    	pan.setBorder(BorderFactory.createTitledBorder("登录"));//创建一个框框
    	pan.setLayout(new GridLayout(4,1));
    	labName.setFont(new Font("Dialog",Font.BOLD,20));
    	labpwd.setFont(new Font("Dialog",Font.BOLD,20));
    	lver.setFont(new Font("Dialog",Font.BOLD,20));
    	but.setFont(new Font("Dialog",Font.BOLD,20));
    	but1.setFont(new Font("Dialog",Font.BOLD,20));
    	pan1.add(labName); pan1.add(txtname);
    	pan2.add(labpwd); pan2.add(txtpwd);
    	pan5.add(lver); pan5.add(ver);pan6.add(verCode);
    	pan.add(pan1); pan.add(pan2);pan.add(pan5);pan.add(pan6);
    	pan3.add(but); pan3.add(but1);
    	pan4.add(pan);
    	this.add(pan4,"Center"); this.add(pan3,"South");
    	txtname.addActionListener(this);
    	txtpwd.addActionListener(this);
    	but.addActionListener(this);
    	but1.addActionListener(this);
    	txtname.requestFocus();  //txtname获取输入焦点，定位光标
    	
    }
	public boolean isValidCodeRight() {//判断验证码是否有效
		if(ver == null) {
			return false;
		}else if(verCode == null) {
			return true;
		}else if(verCode.getCode() .equals(ver.getText())) {
			return true;
		}else 
			return false;
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==but1) {    //事件源是but1
			System.exit(0);
			
		}else if(e.getSource()==but) {
			String str="select * from amdin where Name='"+txtname.getText()+"' and Password='" + new String(txtpwd.getPassword())+"'";
			try {
		             ResultSet rs=studnet.query(str); //调用数据库的查询方法
		            
				if((rs.next())&&(isValidCodeRight())) {
					JOptionPane.showMessageDialog(this, "验证通过!","信息",
							JOptionPane.INFORMATION_MESSAGE);  //弹出对话框
					new MainFrom();   //进入主界面
					this.dispose();   //关闭该界面
				}else{
					JOptionPane.showMessageDialog(null, "验证码或密码账号错误,请重新输入!","错误",JOptionPane.ERROR_MESSAGE);
					txtname.requestFocus();  //txtname获取输入焦点，定位光标
					txtname.setText(null);  //清空
					txtpwd.setText(null);  //清空 赵守信 
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
	}
     public static void main(String args[]) {
    	 new LoginFrom();
     }
}
