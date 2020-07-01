package stu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
	    public static final  String dirverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL数据库引擎
		public static final  String url="jdbc:sqlserver://localhost:1433;databaseName=Student";//数据库名
		public static final  String name="sa";       //服务器名
		public static final  String pwd="123456";    //密码
		//固定前三步操作和属性的定义
		public static void main(String args[])throws Exception {
		    Class.forName(dirverName);  //第一步加载数据库驱动程序，此时不需要实例化，因为会由容器自己负责管理
		    Connection conn=DriverManager.getConnection(url,name,pwd); //第二步，根据连接协议，用户新，密码连接数据库
		    Statement sta=conn.createStatement();  //第三步
		    String sql="select * from Student";
		    ResultSet rs=sta.executeQuery(sql); //实现数据查询
		    while(rs.next()) {     //循环取出返回的每一行数据
		    	int Sno=rs.getInt("Sno");
		    	String Sname=rs.getString("Sname");
		    	String Ssex=rs.getString("Ssex");
		     	int Sage=rs.getInt("Sage");
	            String Snative=rs.getString("Snative");
	            String Dno=rs.getString("Dno");
	            String Sdepartment=rs.getString("Sdepartment");
		    	System.out.println(Sno+","+Sname+","+Ssex+","+Sage+","+Snative+","+Dno+","+Sdepartment);
		    }
		    rs.close();
		    sta.close();
		    conn.close();
  }
}
