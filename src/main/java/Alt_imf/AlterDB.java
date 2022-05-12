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
	int count;
	int costAlt(statusData status) {
		try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("update student_jud set JUD_1=?,JUD_2=?,JUD_3=? where STU_ID=?");
    		
    		pStmt.setInt(1,status.getSta_1());		
    		pStmt.setInt(2,status.getSta_2());		
    		pStmt.setInt(3,status.getSta_3());		
    			
    		//System.out.println(pStmt);
    		count=pStmt.executeUpdate();
			pStmt.close();

        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("修改报到信息失败！");
        } finally{
        	DBConnection.closeConnection();
		}		
		if(count==1) 
	 		return 0;//执行成功返回0		 	
	 	else 
			return 1;//不成功返回1
	}
	int statusAlt(costData cost) {
		
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
    			
    		//System.out.println(pStmt);
    		count=pStmt.executeUpdate();
			pStmt.close();

        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("修改费用信息失败！");
        } finally{
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
        	if(account.getAcc_access()==0)
        		pStmt = con.prepareStatement("update student set PAS_ST=? where STU_ID=?");
        	if(account.getAcc_access()==1)
        		pStmt = con.prepareStatement("update teacher set PAS_TE=? where TEA_ID=?");
        	
    		pStmt.setString(1,account.getAcc_passwd());		
    		
    		count=pStmt.executeUpdate();
			pStmt.close();

        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("修改密码失败！");
        } finally{
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
		try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("update student_inf set CLA_ID=?,DOR_ID=?,STU_NA=?,NATIO=?,STU_BR=?,STU_GE=?,ID_NUM=?,POSTA=?,PLRES=? where STU_ID=?");
    			
    		pStmt.setString(1,stu.getStu_na());
    		pStmt.setString(2,stu.getCla_na());
    		pStmt.setInt(3,stu.getDor_na());
    		pStmt.setInt(4,stu.getBui_na());
    		pStmt.setString(5,stu.getNatio());
    		pStmt.setString(6,stu.getStu_br());
    		pStmt.setInt(7,stu.getStu_ge());		
    		pStmt.setString(8,stu.getId_num());
    		pStmt.setInt(9,stu.getPosta());		
    		pStmt.setString(10,stu.getPlres());

    		count=pStmt.executeUpdate();
			pStmt.close();

        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("修改学生信息失败！");
        } finally{
        	DBConnection.closeConnection();
		}		
		if(count==1) 
	 		return 0;//执行成功返回0		 	
	 	else 
			return 1;//不成功返回1
	}
}
