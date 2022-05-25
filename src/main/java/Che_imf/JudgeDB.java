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
			if(id==100000)//管理员账号为100000
			{
				Jud=0;
				RemQuery="PAS_AD";
				stmt=con.prepareStatement("select PAS_AD from admin_ where ADMINS=?");//根据id来判断身份返回判断
				stmt.setInt(1,id);
			}
			else if(id/1000000==0)//教职工账号为6位，除100000为0
			{
				RemQuery="PAS_TE";
				stmt=con.prepareStatement("select PAS_TE,TEA_ROOT from teacher where TEA_ID=?");//根据id来判断身份返回判断
				stmt.setInt(1,id);
			}
			else//学生账号
			{
				Jud=1;
				RemQuery="PAS_ST";
				stmt=con.prepareStatement("select PAS_ST from student where STU_ID=?");//根据id来判断身份返回判断
				stmt.setInt(1,id);
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
