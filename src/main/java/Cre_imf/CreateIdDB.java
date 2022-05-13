package Cre_imf;

import java.sql.*;
import DBConnection.*;
public class CreateIdDB {
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	public int CreateTeaIdDB() throws SQLException{//id
		int Id=0;
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select ID_TEA from createid");
			rs=stmt.executeQuery();
		}
		catch(Exception e) {
			System.out.println("教职工id查询sql语句查询失败");
		}
		try {
			rs.next();
			Id=Integer.parseInt(rs.getString("ID_TEA"));
		}
		catch(Exception e) {
			System.out.println("教职工id提取失败");
		}
		try {
			stmt=con.prepareStatement("updata createid set ID_TEA=?");
			stmt.setInt(1, Id+1);
			stmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("教职工id修改sql语句修改失败");
		}
		return Id;
	}
	public int CreateForIdDB() throws SQLException{
		int Id=0;
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select ID_FOR from createid");
			rs=stmt.executeQuery();
		}
		catch(Exception e) {
			System.out.println("论坛id查询sql语句查询失败");
		}
		try {
			rs.next();
			Id=Integer.parseInt(rs.getString("ID_FOR"));
		}
		catch(Exception e) {
			System.out.println("论坛id提取失败");
		}
		try {
			stmt=con.prepareStatement("updata createid set ID_FOR=?");
			stmt.setInt(1, Id+1);
			stmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("论坛id修改sql语句修改失败");
		}
		return Id;
	}
	public int CreateAnnIdDB() throws SQLException{
		int Id=0;
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select ID_ANN from createid");
			rs=stmt.executeQuery();
		}
		catch(Exception e) {
			System.out.println("公告id查询sql语句查询失败");
		}
		try {
			rs.next();
			Id=Integer.parseInt(rs.getString("ID_ANN"));
		}
		catch(Exception e) {
			System.out.println("公告id提取失败");
		}
		try {
			stmt=con.prepareStatement("updata createid set ID_ANN=?");
			stmt.setInt(1, Id+1);
			stmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("公告id修改sql语句修改失败");
		}
		return Id;
	}
	public int CreateStuIdDB(String ClassName) throws SQLException{
		int Id=20200000;
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select ID_STU,CLA_ID,PRO_ID from class_inf where CLA_NA=?");
			stmt.setString(1,ClassName);
			rs=stmt.executeQuery();
		}
		catch(Exception e) {
			System.out.println("学生id查询sql语句查询失败");
		}
		try {
			rs.next();
			Id+=(Integer.parseInt(rs.getString("ID_STU"))+100*Integer.parseInt(rs.getString("CLA_ID"))+1000*Integer.parseInt(rs.getString("PRO_ID")));
		}
		catch(Exception e) {
			System.out.println("学生id查询数据读取失败");
		}
		return Id;
	}
}
