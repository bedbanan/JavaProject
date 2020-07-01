package stu;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.*;
class TableForm extends AbstractTableModel{    //AbstractTableModel一种表结构类 继承它
    Vector<Object> v1,v2;   //定义vector向量对象 这里表示行和列
    StudentDate student=new StudentDate();  //创建数据库操作类，方便下面的查询操作
	public int getRowCount() {  //获取表格的行数
		return v2.size();
	}
	public int getColumnCount() {    //获取表格的列
		return v1.size();
	}
	public Object getValueAt(int row,int col ) {	
		return ((Vector<?>)v2.get(row)).get(col);
	}  
	public String getColumName(int e) {  //设置表格列名
		return (String)v1.get(e);
	}
	public TableForm()  {    //无参构造
		select("select * from Student");
	}
	public TableForm(String s)  {
		select(s);
	}
	public void select(String sql) {    //定义一个查询数据库的方法，并显示查询结果
        v1=new Vector<Object>();   //创建v1列的向量对象
        v1.add("Sno");
		v1.add("Sname");v1.add("Ssex");
		v1.add("Sage");v1.add("Snative");
		v1.add("Dno");v1.add("Sdepartment");
		v2=new Vector<Object>();   //创建v2行的对象*/
		try {
	    ResultSet rs=student.query(sql);  //查询语句
	    while(rs.next()) {
	    	Vector<Object> hang=new Vector<Object>(); //创建hang向量对象
	    	hang.add(rs.getString(1)); //将结果集中当前记录的第一列的值添加到hang中
	    	hang.add(rs.getString(2));
	    	hang.add(rs.getString(3));
	    	hang.add(rs.getInt(4));
	    	hang.add(rs.getString(5));
	    	hang.add(rs.getString(6));
	    	hang.add(rs.getString(7));
	    	v2.add(hang);  //将hang向量加入行中
	    } 
	   }catch (Exception e) {
			e.printStackTrace();
		}
	}
}
