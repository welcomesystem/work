package Cen_imf;

import java.sql.*;

import DBConnection.DBConnection;
public class CensusDB {
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	public int infoCount(int Jud,String FindName) throws SQLException {//ͳ��������,JUD=1/2/3 : ѧԺ/ϵ/�༶
		int Nums=0;
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select count(STU_ID) "
					+ "from student_inf,class_inf,profession_inf,college_inf"
					+ "where student_inf.CLA_ID=class_inf.CLA_ID and class_inf.PRO_ID=profession_inf.PRO_ID and profession_inf.COL_ID=college_inf.COL_ID"
					+ " and ?=?");
			if(Jud==1)
				stmt.setString(1,"COL_NA");
			else if(Jud==2)
				stmt.setString(1,"PRO_NA");
			else
				stmt.setString(1,"CLA_NA");
			stmt.setString(2,FindName);
		}
		catch(Exception e){
			System.out.println("ͳ��������sql��ѯʧ��");
		}
		try {
			rs=stmt.executeQuery();
			rs.next();
			Nums=rs.getInt(1);
		}
		catch(Exception e){
			System.out.println("ͳ�����������ݻ�ȡʧ��");
		}
		return Nums;
	}
	public int statusCount(int Jud_1,int Jud_2,String FindName) throws SQLException {//ͳ�Ʒ�����Ϣ
		int Nums=0;
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select count(STU_ID) "
					+ "from student_inf,class_inf,profession_inf,college_inf,student_cost"
					+ "where student_inf.CLA_ID=class_inf.CLA_ID and class_inf.PRO_ID=profession_inf.PRO_ID and profession_inf.COL_ID=college_inf.COL_ID and student_cost.STU_ID=student_inf.STU_ID"
					+ " and ?=? and ?=0");
			if(Jud_1==1)
				stmt.setString(1,"COL_NA");
			else if(Jud_1==2)
				stmt.setString(1,"PRO_NA");
			else
				stmt.setString(1,"CLA_NA");
			stmt.setString(2,FindName);
			if(Jud_2==1)
				stmt.setString(3,"COST_1");
			else if(Jud_2==2)
				stmt.setString(3,"COST_2");
			else if(Jud_2==3)
				stmt.setString(3,"COST_3");
			else
				stmt.setString(3,"COST_4");
		}
		catch(Exception e){
			System.out.println("ͳ���ѽɷ�������Ϣsql��ѯʧ��");
		}
		try {
			rs=stmt.executeQuery();
			rs.next();
			Nums=rs.getInt(1);
		}
		catch(Exception e){
			System.out.println("ͳ���ѽɷ��������ݻ�ȡʧ��");
		}
		return Nums;
	}
	public int costCount(int Jud_1,int Jud_2,String FindName) throws SQLException {//ͳ�Ʊ�����Ϣ
		int Nums=0;
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select count(STU_ID) "
					+ "from student_inf,class_inf,profession_inf,college_inf,student_jud"
					+ "where student_inf.CLA_ID=class_inf.CLA_ID and class_inf.PRO_ID=profession_inf.PRO_ID and profession_inf.COL_ID=college_inf.COL_ID and student_jud.STU_ID=student_inf.STU_ID"
					+ " and ?=? and =1");//�ɹ�ǩ������Ϊ0
			if(Jud_1==1)
				stmt.setString(1,"COL_NA");
			else if(Jud_1==2)
				stmt.setString(1,"PRO_NA");
			else
				stmt.setString(1,"CLA_NA");
			stmt.setString(2,FindName);
			if(Jud_2==1)
				stmt.setString(3,"JUD_1");
			else if(Jud_2==2)
				stmt.setString(3,"JUD_2");
			else
				stmt.setString(3,"JUD_3");
		}
		catch(Exception e){
			System.out.println("ͳ����ǩ��������Ϣsql��ѯʧ��");
		}
		try {
			rs=stmt.executeQuery();
			rs.next();
			Nums=rs.getInt(1);
		}
		catch(Exception e){
			System.out.println("ͳ����ǩ���������ݻ�ȡʧ��");
		}
		return Nums;
	}
}
