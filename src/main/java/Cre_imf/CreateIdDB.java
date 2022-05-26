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
			stmt=con.prepareStatement("update createid set ID_TEA=? where ID_Mark=1");
			Id++;
			stmt.setInt(1, Id);
			stmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("��ְ��id�޸�sql����޸�ʧ��");
		}
		return Id-1;
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
			stmt=con.prepareStatement("update createid set ID_FOR=? where ID_Mark=1");
			Id++;
			stmt.setInt(1,Id);
			stmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("��̳id�޸�sql����޸�ʧ��");
		}
		return Id-1;
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
			stmt=con.prepareStatement("update createid set ID_ANN=? where ID_Mark=1");
			Id++;
			stmt.setInt(1, Id);
			stmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("����id�޸�sql����޸�ʧ��");
		}
		return Id-1;
	}
	public int CreateStuIdDB(String ClassName) throws SQLException{
		int Id=200000000;//ǰ��λ����ѧʱ�� ����λ�༶��� �����λ���ݰ༶�������������
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select ID_STU,CLA_ID from class_inf where CLA_NA=? ");
			stmt.setString(1,ClassName);
			rs=stmt.executeQuery();
		}
		catch(Exception e) {
			System.out.println("ѧ��id��ѯsql����ѯʧ��");
		}
		try {
			rs.next();
			Id+=(100*Integer.parseInt(rs.getString("CLA_ID"))+Integer.parseInt(rs.getString("ID_STU")));
		}
		catch(Exception e) {
			System.out.println("ѧ��id��ѯ���ݶ�ȡʧ��");
		}
		try {
			stmt=con.prepareStatement("update class_inf set ID_STU=? where CLA_NA=?");
			stmt.setInt(1,Integer.parseInt(rs.getString("ID_STU"))+1);
			stmt.setString(2,ClassName);
			stmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("�༶id�޸ı���ʧ��");
		}
		return Id;
	}
}
