package stu;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.JTableHeader;
/**
 * MainFrom作为主界面，需要具备增删改查的功能
 */
public class MainFrom extends JFrame implements ActionListener{
    JLabel labScore1=new JLabel("请输入学号:");
    JLabel labScore2=new JLabel("请输入姓名:");
    JTextField textScore1 =new JTextField(10);
    JTextField textScore2=new JTextField(10);
    JButton but1=new JButton("查询");
    JButton but2=new JButton("模糊查询");
    JButton but3=new JButton("添加");
    JButton but4=new JButton("修改");
    JButton but5=new JButton("删除");
    JPanel pan1=new JPanel();
    JPanel pan2=new JPanel();
    JPanel pan3=new JPanel();
    JTable jTable=new JTable();
    JScrollPane jsp=new JScrollPane(jTable); //滚动条
    TableForm tf;   //表格表单
    String sql;
     MainFrom() {
    	this.setTitle("学生管理系统");
    	this.setBounds(500,500,700,400);
    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	init();
    	this.setVisible(true);
    }
    public void init()  {
    	pan1.add(labScore1); pan1.add(textScore1);pan1.add(but1);
    	pan1.add(labScore2); pan1.add(textScore2);pan1.add(but2);
    	this.add(pan1,"North");
    	pan2.setLayout(new BorderLayout());//BorderLayout是一个边界布局 setLayout格式布局
    	tf=new TableForm(); //表格实例化
    	jTable.setModel(tf);  //将tf设置成jTbable的Model,将此表的数据模型设置为 newModel，并向其注册以获取来自新数据模型的侦听器通知
    	pan2.add(jsp,"Center");
    	this.add(pan2,"Center");
    	but1.addActionListener(this);
    	but2.addActionListener(this);
    	pan3.add(but3);pan3.add(but4);pan3.add(but5);
    	this.add(pan3,"South");
    	but3.addActionListener(this);
    	but4.addActionListener(this);
    	but5.addActionListener(this);
    }
	public void actionPerformed(ActionEvent e) {
		String s;
		if(e.getSource()==but1) {     //当点击第一个查询按钮时
			s=textScore1.getText().trim();
			if(s.equals("")) {  //空白建立新表
				tf=new TableForm();
				jTable.setModel(tf);
			}else {
				sql="select * from Student where Sno='"+s+"'";
				tf=new TableForm(sql);
				jTable.setModel(tf);
			}
		}
		if(e.getSource()==but2) {   //当点击第二个模糊查询时
			s=textScore2.getText().trim();
			if(s.equals("")) {
				tf=new TableForm();
				jTable.setModel(tf);
			}else {
				sql="select * from Student where Sname like'%"+s+"%'";
				tf=new TableForm(sql);
				jTable.setModel(tf);
			}
		}
		if(e.getSource()==but3) {  //当点击第三个按钮添加按钮时
			new AddForm();
			this.dispose();
		}
		if(e.getSource()==but4) {  //当点击第四个更新按钮时
			int i=jTable.getSelectedRow();
            if(i==-1) {
            	JOptionPane.showMessageDialog(this,"没有选中修改的记录");
            }else {
            	//获取备选的表格记录的各个字段的值
            	String t1=(String)jTable.getValueAt(i, 0);  //获取被选的表格记录缩影为0的字段的值
            	String t2=(String)jTable.getValueAt(i, 1);
            	String t3=(String)jTable.getValueAt(i, 2);
            	int t4=(Integer)jTable.getValueAt(i, 3);
            	String t5=(String)jTable.getValueAt(i, 4);
            	String t6=(String)jTable.getValueAt(i, 5);
            	String t7=(String)jTable.getValueAt(i, 6);
            	new UpdateForm(t1,t2,t3,t4,t5,t6,t7);
            	this.dispose();
            }
		}
		if(e.getSource()==but5) { //当点击第五个删除按钮时
			int i=jTable.getSelectedRow();
			if(i==-1) {
				JOptionPane.showMessageDialog(this,"没有选中删除的记录");
			}else {
				int n=JOptionPane.showConfirmDialog(this,"确定要删除么？","是否要删除",JOptionPane.YES_NO_OPTION);
			    if(n==JOptionPane.YES_OPTION) {
			    	String t1=(String)jTable.getValueAt(i,0);
			    	new DeletForm(t1);
			    	this.dispose();
			    }
			}
		}
		 
	}
    public static void main(String args[]) {
    	new MainFrom();
    }
}
