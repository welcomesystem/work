package Che_imf;

import java.sql.*;
import DBConnection.*;

public class JudgeDB {
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	public int JudgePwdDB(int id,int password)  throws SQLException {//��ȷ����Ȩ�޵ȼ������󷵻�-1
		int Jud=-1;
		String RemQuery=null;
		con=DBConnection.getConnection();
		try {
			if(id==100000)//����Ա�˺�Ϊ100000
			{
				Jud=0;
				RemQuery="PAS_AD";
				stmt=con.prepareStatement("select PAS_AD from admin_ where ADMINS=?");//����id���ж���ݷ����ж�
				stmt.setInt(1,id);
			}
			else if(id/1000000==0)//��ְ���˺�Ϊ6λ����100000Ϊ0
			{
				RemQuery="PAS_TE";
				stmt=con.prepareStatement("select PAS_TE,TEA_ROOT from teacher where TEA_ID=?");//����id���ж���ݷ����ж�
				stmt.setInt(1,id);
			}
			else//ѧ���˺�
			{
				Jud=1;
				RemQuery="PAS_ST";
				stmt=con.prepareStatement("select PAS_ST from student where STU_ID=?");//����id���ж���ݷ����ж�
				stmt.setInt(1,id);
			}
		}
		catch(Exception e){
			System.out.println("����SQL��ѯʧ��");
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
			System.out.println("������֤��ȡʧ��");
		}
		return Jud;
	}
}
