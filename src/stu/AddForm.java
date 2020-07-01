package stu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class AddForm extends DialogForm implements ActionListener {
    StudentDate student=new StudentDate();  //创建数据库操作类对象
    public AddForm() {
    	this.setTitle("添加学生信息");
    	init();
    }
    private void init() {
    	but1.addActionListener(this);
    	but2.addActionListener(this);
    }
	public void actionPerformed(ActionEvent e) {
		String s1,s2,s3,s4,s5,s6,s7;
		if(e.getSource()==but1) {
			s1=txtnumber.getText().trim();    //将文本框txtnumber的值赋值给S1
		if(s1==null||s1.equals("")) {
			JOptionPane.showMessageDialog(this, "学号不能为空!");
			txtnumber.requestFocus();
		}
		else {
			
			try {
				ResultSet rs = student.query("select * from Student where Sno='"+s1+"'");
					if(rs.next()) {
				JOptionPane.showMessageDialog(this,"学号已经存在!");
				txtname.requestFocus();
			}
			else {
				s2=txtname.getText().trim();  
				s3=(String)txtsex.getSelectedItem();
				s4=txtage.getText().trim();
				s5=(String)txthome.getSelectedItem();
				s6=(String)txtdepartment.getSelectedItem();
				s7=(String)txtDno.getSelectedItem();
				int count=student.insert(s1, s2, s3, s4, s5, s6, s7); //的代用数据库操作类汇总的insert方法，添加记录
				if(count!=0) {
					JOptionPane.showMessageDialog(this, "添加成功");
					new MainFrom();  //创建新的主界面
					this.dispose();
					}
				else {
					JOptionPane.showMessageDialog(this,"添加失败");
				}
			}
			} catch (SQLException e2) {
				System.out.println(e2);
			}  //查询学号是否存在
              catch (NumberFormatException e1) {
            	  JOptionPane.showMessageDialog(this, "年龄必须是数字");
				txtage.requestFocus();
			}
		
		 }
	}
		if(e.getSource()==but2) {
			new MainFrom();
			this.dispose();
		}
		
	}
}
