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
			System.out.println("��ְ��id��ѯsql����ѯʧ��");
		}
		try {
			rs.next();
			Id=Integer.parseInt(rs.getString("ID_TEA"));
		}
		catch(Exception e) {
			System.out.println("��ְ��id��ȡʧ��");
		}
		try {
			stmt=con.prepareStatement("updata createid set ID_TEA=?");
			stmt.setInt(1, Id+1);
			stmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("��ְ��id�޸�sql����޸�ʧ��");
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
			System.out.println("��̳id��ѯsql����ѯʧ��");
		}
		try {
			rs.next();
			Id=Integer.parseInt(rs.getString("ID_FOR"));
		}
		catch(Exception e) {
			System.out.println("��̳id��ȡʧ��");
		}
		try {
			stmt=con.prepareStatement("updata createid set ID_FOR=?");
			stmt.setInt(1, Id+1);
			stmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("��̳id�޸�sql����޸�ʧ��");
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
			System.out.println("����id��ѯsql����ѯʧ��");
		}
		try {
			rs.next();
			Id=Integer.parseInt(rs.getString("ID_ANN"));
		}
		catch(Exception e) {
			System.out.println("����id��ȡʧ��");
		}
		try {
			stmt=con.prepareStatement("updata createid set ID_ANN=?");
			stmt.setInt(1, Id+1);
			stmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("����id�޸�sql����޸�ʧ��");
		}
		return Id;
	}
}
