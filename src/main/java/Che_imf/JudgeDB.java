package Che_imf;

import java.sql.*;
import DBConnection.*;

public class JudgeDB {
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	public int JudgePwdDB(int id,int password)  throws SQLException {//正确返回权限等级，错误返回-1
		int Jud=-1;
		String RemQuery=null;
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select ? form ? where ?=?");//根据id来判断身份返回判断
			if(id==100000)//管理员账号为100000
			{
				Jud=0;
				RemQuery="PAS_AD";
				stmt.setString(1,"PAS_AD");
				stmt.setString(2,"admin_");
				stmt.setString(3,"ADMINS");
				stmt.setInt(4,id);
			}
			else if(id/1000000==0)//教职工账号为6位，除100000为0
			{
				RemQuery="PAS_TE";
				stmt.setString(1,"PAS_TE,TEA_ROOT");
				stmt.setString(2,"teacher");
				stmt.setString(3,"TEA_ID");
				stmt.setInt(4,id);
			}
			else//学生账号
			{
				Jud=1;
				RemQuery="PAS_ST";
				stmt.setString(1,"PAS_ST");
				stmt.setString(2,"student");
				stmt.setString(3,"STU_ID");
				stmt.setInt(4,id);
			}
		}
		catch(Exception e){
			System.out.println("密码SQL查询失败");
		}
		try {
			rs=stmt.executeQuery();
			rs.next();	
			if(Jud==-1)
				Jud=Integer.parseInt(rs.getString("TEA_ROOT"));
			if(password!=Integer.parseInt(rs.getString(RemQuery)))
				Jud=-1;
		}
		catch(Exception e){
			System.out.println("密码验证获取失败");
		}
		return Jud;
	}
}
