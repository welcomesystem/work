package DBConnection;

import java.sql.*;

public class DBConnection {
	static Connection con=null;
	public static Connection getConnection(){
		if(con==null){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
		    }
			catch(Exception e){ 
	    		e.printStackTrace();
	    		System.out.println("����MYSQL���ݿ�����ʧ�ܣ�");
		    }
		    try {
		    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_school?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8","root","root");
		    }
		    catch(Exception e){
	            e.printStackTrace();
	            System.out.println("��ȡ���ݿ�����ʧ�ܣ�");
		    }
		}
	    return con;
	}
    public static void closeConnection() {
     	if(con!=null)
			try {
				con.close();
				con=null;
			} 
     		catch (SQLException e) {
				e.printStackTrace();
				System.out.println("�ر�con����ʧ�ܣ�");
			}
    }
}
