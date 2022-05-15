package Alt_imf;
import DBConnection.*;
import java.sql.*;
import java.text.NumberFormat.Style;

import Datas.*;
import DBConnection.*;
//修改报到信息
//修改费用信息
//修改密码
//修改学生基本信息

public class AlterDB {
		//修改报到信息
		//根据学生学号修改，从status获得信息
		//数据库修改包含：student_jud
		//返回是否修改成功，成功为0，失败为1
	Connection con=null;
	PreparedStatement pStmt=null; 
	ResultSet rs=null;
	int count;
	int statusAlt(statusData status) {
		try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("update student_jud set JUD_1=?,JUD_2=?,JUD_3=? where STU_ID=?");
    		
    		pStmt.setInt(1,status.getSta_1());		
    		pStmt.setInt(2,status.getSta_2());		
    		pStmt.setInt(3,status.getSta_3());	
    		pStmt.setInt(4,status.getStu_id());
    		//System.out.println(pStmt);
    		count=pStmt.executeUpdate();
			pStmt.close();

        } 
		catch (Exception e) {
           	e.printStackTrace();
            System.out.println("修改报到信息失败！");
        } 
		finally{
        	DBConnection.closeConnection();
		}		
		if(count==1) 
	 		return 0;//执行成功返回0		 	
	 	else 
			return 1;//不成功返回1
	}
	int costAlt(costData cost) {
		
		//修改费用信息
		//根据学生学号修改，cost从获得信息
		//数据库修改包含：student_cost
		//返回是否修改成功，成功为0，失败为1
		try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("update student_cost set COST_1=?,COST_2=?,COST_3=?,COST_4=? where STU_ID=?");
    		
    		pStmt.setInt(1,cost.getCost_1());		
    		pStmt.setInt(2,cost.getCost_2());		
    		pStmt.setInt(3,cost.getCost_3());
    		pStmt.setInt(4,cost.getCost_4());
    		pStmt.setInt(5,cost.getStu_id());	
    			
    		//System.out.println(pStmt);
    		count=pStmt.executeUpdate();
			pStmt.close();

        } 
		catch (Exception e) {
           	e.printStackTrace();
            System.out.println("修改费用信息失败！");
        } 
		finally{
        	DBConnection.closeConnection();
		}		
		if(count==1) 
	 		return 0;//执行成功返回0		 	
	 	else 
			return 1;//不成功返回1
		
	}
	int passwdAlt(accountData account) {
		//修改密码
		//从account中获得，根据权限判断角色
		//数据库修改:根据情况修改student或者teacher
		//返回是否修改成功，成功为0，失败为1
		try {
        	con=DBConnection.getConnection();
        	if(account.getAcc_access()==1)
        		pStmt = con.prepareStatement("update student set PAS_ST=? where STU_ID=?");
        	if(account.getAcc_access()>=2)
        		pStmt = con.prepareStatement("update teacher set PAS_TE=? where TEA_ID=?");
    		pStmt.setString(1,account.getAcc_passwd());
    		pStmt.setInt(2,account.getAcc_id());
    		count=pStmt.executeUpdate();
			pStmt.close();
        } 
		catch (Exception e) {
           	e.printStackTrace();
            System.out.println("修改密码失败！");
        } 
		finally{
        	DBConnection.closeConnection();
		}		
		if(count==1) 
	 		return 0;//执行成功返回0		 	
	 	else 
			return 1;//不成功返回1
	}
	int infoAlt(InfoData stu) {
		//修改学生基本信息
		//修改指定学号的学生，从stu获得信息
		//数据库修改包含：student_inf，student_jud，student_cost，student
		//返回是否修改成功，成功为0，失败为1
		PreparedStatement pStmt1=null;
		try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("update student_inf set "
    				+ "CLA_ID=?,DOR_ID=?,STU_NA=?,NATIO=?,STU_BR=?,STU_GE=?,ID_NUM=?,POSTA=?,PLRES=?"
    				+ "where STU_ID=?");
    		
    		pStmt1 = con.prepareStatement("select CLA_ID from class_inf where CLA_NA=?");//获取班级id
    		pStmt1.setString(1,stu.getStu_na());//班级名
    		rs=pStmt1.executeQuery();
    		pStmt.setInt(1,Integer.parseInt(rs.getString("CLA_ID")));
    		
    		pStmt1 = con.prepareStatement("select DOR_ID from dormitory_inf where DOR=?");//获取宿舍id
    		pStmt1.setString(1,stu.getCla_na());//宿舍名
    		rs=pStmt1.executeQuery();
    		pStmt.setInt(2,Integer.parseInt(rs.getString("DOR_ID")));
    		
    		pStmt.setString(3,stu.getStu_na());
    		pStmt.setString(4,stu.getNatio());
    		pStmt.setString(5,stu.getStu_br());
    		pStmt.setInt(6,stu.getStu_ge());
    		pStmt.setString(7,stu.getId_num());
    		pStmt.setInt(8,stu.getPosta());		
    		pStmt.setString(9,stu.getPlres());
    		pStmt.setInt(10,stu.getStu_id());
    		
    		count=pStmt.executeUpdate();
			pStmt.close();
			rs.close();
        } 
		catch (Exception e) {
           	e.printStackTrace();
            System.out.println("修改学生信息失败！");
        } 
		finally{
        	DBConnection.closeConnection();
		}	
		if(count==1) 
	 		return 0;//执行成功返回0		 	
	 	else 
			return 1;//不成功返回1
	}
}
