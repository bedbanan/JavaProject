package stu;
//数据库类不带主方法，在此类中将建立数据库连接，关闭连接，关闭语句和关闭结果等四种方法，由于都只是用于内部测试没所以设置成私有的
//其他数据库操作设置为公有


import java.sql.*;


public class StudentDate {
	public static final  String dirverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL数据库引擎
	public static final  String url="jdbc:sqlserver://localhost:1433;databaseName=Student";//数据库名
	public static final  String name="sa";       //服务器名
	public static final  String pwd="123456";    //密码 
	private Connection conn=null;  //声明连接对象
	private Statement stmt=null;   //声明语句对象
	private PreparedStatement prpstmt=null;  //声明预编译对象
	ResultSet rs=null;   //声明结果集对象
	String str;
	int count=0;
	private void creatConn() {    //定义连接数据库的方法
		try {
			Class.forName(dirverName);  //第一步加载数据库驱动程序，此时不需要实例化，因为会由容器自己负责管理
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		try {
		    conn=DriverManager.getConnection(url,name,pwd); 
		    //第二步，根据连接协议，用户新，密码连接数据库
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void closeConn(){          //定义关闭对象的方法
		try {
			if(conn!=null) {      //关闭连接对象
			conn.close();  
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	private void closeRs(){          //定义关闭对象的方法
		try {
			if(rs!=null)          //关闭结果集对象
			rs.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	private void closePrpstmt() {  //定义关闭对象
		try {
			if(conn!=null) {        //关闭连接对象
			conn.close();
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public ResultSet query(String sql){    //定义数据库查询记录的方法
		try {
			creatConn(); //建立连接
		    prpstmt=conn.prepareStatement(sql);  //创建预编译语句对象
		    rs=prpstmt.executeQuery();  //执行sql查询语句，返回插叙那结果 
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}
	public int insert(String s1,String s2,String s3,String s4,String s5,String s6,String s7) {
		try {
			creatConn();   //建立数据库连接
		    str="insret into Student(Sno,Sname,Ssex,Sage,Snative,Dno,Sdepartment) values (?,?,?,?,?,?,?)";    //插入语句
		    prpstmt=conn.prepareStatement(str);  //创建预编译语句对象
		    prpstmt.setString(1, s1);       //设置第一个？值
		    prpstmt.setString(2, s2);
		    prpstmt.setString(3,s3);
		    prpstmt.setInt(4, Integer.parseInt(s4));
		    prpstmt.setString(5,s5);
		    prpstmt.setString(6,s6);
		    prpstmt.setString(7,s7);
	     	count=prpstmt.executeUpdate();   //执行sql语句返回一个整型
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closePrpstmt();
		closeConn(); 
		return count;
		
	}
	public int update(String s1,String s2,String s3,String s4,String s5,String s6,String s7){
		try {
		creatConn();   //创建连接
		str="update Student set Sno=?,Sname=?,Ssex=?,Sage=?,Snative=?,Dno=?,Sdepartment=? where Sno=?";  //更新语句
		prpstmt=conn.prepareStatement(str);  //创建预编译语句对象
		prpstmt.setString(1, s2);       //设置第一个？值
		prpstmt.setString(2, s3);
		prpstmt.setString(3,s4);
		prpstmt.setInt(4, Integer.parseInt(s5));
		prpstmt.setString(5,s6);
		prpstmt.setString(6,s7);
		prpstmt.setString(7,s1);
		count=prpstmt.executeUpdate();  //执行sql语句返回一个整型
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closePrpstmt();
		closeConn();
		return count;
	}
	public int delete(String s) {    //定义数据库删除记录的方法
		try {
		creatConn(); 
		str="delete from Student where Sno=?";
		prpstmt=conn.prepareStatement(str);  //创建预编译语句对象
		prpstmt.setString(1, s);
		count=prpstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closePrpstmt();
		closeConn();
		return count;
	}
}
