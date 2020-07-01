package stu;
/**
 * 对话框类，为增添2个界面提供组件功能
 * 只为后续的操作界面提供界面
 * @author hasee
 *
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class DialogForm extends JDialog{
     JLabel labNumber=new JLabel("学号:");
     JLabel labName=new JLabel("名字:");
     JLabel labSage=new JLabel("年龄:");
     JLabel labSsex=new JLabel("性别:");
     JLabel labHome=new JLabel("籍贯:");
     JLabel labDepartment=new JLabel("专业:");
     JLabel labDno=new JLabel("院系:");
     JTextField txtnumber=new JTextField(15);
     JTextField txtname=new JTextField(15);
     String s[]= {"男","女"};
     JComboBox txtsex=new JComboBox(s);
     JTextField txtage=new JTextField(15);
     String s1[]={"广东","湖南","湖北","江苏","江西"};
     JComboBox txthome=new JComboBox(s1);
     String s2[]= {"信息系","工业系","外语系","新闻系","艺术系"};
     JComboBox txtdepartment=new JComboBox(s2);
     String s3[]= {"计算机科学与技术","工业自动化","新闻","服装设计","日语"};
     JComboBox txtDno=new JComboBox(s3);
     JButton but1=new JButton("确定");
     JButton but2=new JButton("取消");
     JPanel pan1=new JPanel();JPanel pan2=new JPanel();JPanel pan3=new JPanel();
     JPanel pan4=new JPanel();JPanel pan5=new JPanel();JPanel pan6=new JPanel();
     JPanel pan7=new JPanel();JPanel pan8=new JPanel();
     public DialogForm() {
    	 this.setBounds(500,500,300,350);
         init();
    	 this.setVisible(true);
    	 this.setLayout(new GridLayout(8,1));
     }
     private void init() {
    	 pan1.add(labNumber);pan1.add(txtnumber);
    	 pan2.add(labName); pan2.add(txtname);
    	 pan3.add(labSsex); pan3.add(txtsex);
    	 pan4.add(labSage); pan4.add(txtage);
    	 pan5.add(labHome); pan5.add(txthome);
    	 pan6.add(labDno); pan6.add(txtDno);
    	 pan7.add(labDepartment); pan7.add(txtdepartment);
    	 pan8.add(but1); pan8.add(but2);
    	 pan1.setLayout(new FlowLayout(FlowLayout.LEFT));//左对齐
    	 pan2.setLayout(new FlowLayout(FlowLayout.LEFT));
    	 pan3.setLayout(new FlowLayout(FlowLayout.LEFT));
         pan4.setLayout(new FlowLayout(FlowLayout.LEFT));
         pan5.setLayout(new FlowLayout(FlowLayout.LEFT));
         pan6.setLayout(new FlowLayout(FlowLayout.LEFT));
         pan7.setLayout(new FlowLayout(FlowLayout.LEFT));
         this.add(pan1);this.add(pan2);this.add(pan3);this.add(pan4);
         this.add(pan5);this.add(pan6);this.add(pan7);this.add(pan8);
     }
}
