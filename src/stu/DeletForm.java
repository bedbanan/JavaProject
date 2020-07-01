package stu;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class DeletForm extends JDialog {
     StudentDate student=new StudentDate();
     public DeletForm(String s) {
    	 try {
			int count=student.delete(s);  //调用数据库的删除方法
			if(count!=0) {
				JOptionPane.showMessageDialog(this, "删除成功");
				new MainFrom();
			}
			else {
				JOptionPane.showMessageDialog(this,"删除失败!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
     }
}
