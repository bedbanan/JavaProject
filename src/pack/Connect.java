package pack;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import java.awt.Cursor;
public class Connect {
    static String sID, sname, Dept, Java, Python, DataStructure;
    static Connection Co;  
    static PreparedStatement nValue;  
    static ResultSet ResultInfor; 
    static Statement ST;
    //数据库连接函数
    public static void ConnectSQL() {
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=master;";//master是自己储存数据的数据库名
        try {
            // 连接数据库
            Co = DriverManager.getConnection(url, "sa", "123456");//sa是SQL账号，后面是密码
            // 建立Statement对象
            ST = Co.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"<html>数据库连接错误！！！<br>请联系管理员修复。</html>","错误",JOptionPane.ERROR_MESSAGE);
        }
    }
    
     public static void GetStudeInfor(String Str) {  
            try {
                // 给?赋值,防止SQL注入， 
                 String sql = "select * from Infor where Stud_ID = ?";
                 nValue = Co.prepareStatement(sql);  
                 nValue.setString(1, Str); 
                 ResultInfor = nValue.executeQuery();  
                 if(ResultInfor.next())     
                 {  
                    //获取学生信息
                    sID = ResultInfor.getString("Stud_ID");  
                    sname = ResultInfor.getString("Stud_Name");
                    Dept = ResultInfor.getString("Stud_Dept");
                    Java = ResultInfor.getString("JavaGrade");  
                    Python = ResultInfor.getString("PythonGrade");  
                    DataStructure = ResultInfor.getString("DataStructureGrade");
                    JOptionPane.showMessageDialog(null, "查询成功！");
                 }else  
                 {  
                     JOptionPane.showMessageDialog(null, "没有此学生！"); 
                 }  
          
             } catch (Exception e1) {  
                // TODO Auto-generated catch block  
                e1.printStackTrace();  
             }  
        } 
}