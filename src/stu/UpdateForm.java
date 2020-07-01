package stu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class UpdateForm extends DialogForm implements ActionListener{
    StudentDate student=new StudentDate(); //创建数据库操作类对象，用于操作数据库的查询
    UpdateForm(String s1,String s2,String s3,int s4,String s5,String s6,String s7) {
		this.setTitle("修改学生信息");
		txtnumber.setText(s1);  //设置文本框TxtNumber的文本
		txtname.setText(s2);
		txtsex.setSelectedItem(s3);
		txtage.setText(""+s4);
		txthome.setSelectedItem(s5);
		txtDno.setSelectedItem(s6);
		txtdepartment.setSelectedItem(s7);
		init();
	}
    private void init() {
    	txtnumber.setEditable(false);  //txtnumber文本不可使用，被锁定
    	but1.addActionListener(this);
    	but2.addActionListener(this);
    }
	public void actionPerformed(ActionEvent e) {
		String s1,s2,s3,s4,s5,s6,s7;
		try {
			if(e.getSource()==but1) {
				s1=txtnumber.getText().trim();  //获取txtnumber的文本赋值给s1
				s2=txtname.getText().trim();
				s3=(String)txtsex.getSelectedItem();
				s4=txtage.getText().trim();
				s5=(String)txthome.getSelectedItem();
				s6=(String)txtDno.getSelectedItem();
				s7=(String)txtdepartment.getSelectedItem();
				int count=student.update(s1, s2, s3, s4, s5, s6, s7);
				//调用sql语句
				if(count!=0) {
					JOptionPane.showMessageDialog(this, "修改成功");
					new MainFrom();
					this.dispose();
				}
				else {
					JOptionPane.showMessageDialog(this, "修改失败");
				}
			}
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(this,"年龄必须是数字");
			txtage.requestFocus();
		}
		if(e.getSource()==but2) {
			new MainFrom();
			this.dispose();
		}
		
	}
}
