package Del_imf;

import DBConnection.*;
import java.sql.*;
//StuDel删除学生
//ForumDel论坛删除
//AnnDel公告删除
public class DeleteDB {
	Connection con=null;
	PreparedStatement pStmt=null; 
 	PreparedStatement pst1=null;
 	PreparedStatement pst2=null;
 	int count;
 	
	int stuDel(int id){//删除学生
	/*删除指定学号的学生，从InfoData获得信息
	数据库修改包含：student_inf，student_jud，student_cost，student
	返回是否删除成功，成功为0，失败为1*/
		 try {
	        	con=DBConnection.getConnection();
	        try {
	        	pStmt = con.prepareStatement("delete from student_inf where STU_ID=?");
	    		pst1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
	        	pst2 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=1");
	    		pStmt.setInt(1,id);	
	    		pst1.executeUpdate();
	    		count=pStmt.executeUpdate();//执行成功，count=1，失败则为0
	    		pst2.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("删除学生信息sql语句出错！");
			}	
	    		pStmt.close();   
	    		pst1.close();
	    		pst2.close();
	        } catch (Exception e) {
	           	e.printStackTrace();
	            System.out.println("删除学生信息失败！");
	        } finally{
	        	DBConnection.closeConnection();
			}
		 	if(count==1) 
		 		return 0;//执行成功返回0		 	
		 	else 
				return 1;//不成功返回1
			
	}
	int forumDel(int id){//论坛删除
	/*删除指定论坛id的内容，从forumData获得信息
	数据库修改包含：forum
	返回是否删除成功，成功为0，失败为1*/
		try {
        	con=DBConnection.getConnection();
        try {
        	pStmt = con.prepareStatement("delete from forum where FOR_ID=?");
    		pst1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
        	pst2 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=1");
    		pStmt.setInt(1,id);	
    		pst1.executeUpdate();
    		count=pStmt.executeUpdate();//执行成功，count=1，失败则为0
    		pst2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("删除论坛内容sql语句出错！");
		}	
    		pStmt.close();   
    		pst1.close();
    		pst2.close();
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("删除论坛内容失败！");
        } finally{
        	DBConnection.closeConnection();
		}
	 	if(count==1) 
	 		return 0;//执行成功返回0		 	
	 	else 
			return 1;//不成功返回1
	}
	int annDel(int id){//公告删除
	/*删除指定公告id的内容，从annData获得信息
	数据库修改包含：announcement
	返回是否删除成功，成功为0，失败为1*/
		try {
        	con=DBConnection.getConnection();
        try {
        	pStmt = con.prepareStatement("delete from announcement where ANN_ID=?");
    		pst1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
        	pst2 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=1");
    		pStmt.setInt(1,id);	
    		pst1.executeUpdate();
    		count=pStmt.executeUpdate();//执行成功，count=1，失败则为0
    		pst2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("删除公告sql语句出错！");
		}	
    		pStmt.close();   
    		pst1.close();
    		pst2.close();
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("删除公告失败！");
        } finally{
        	DBConnection.closeConnection();
		}
	 	if(count==1) 
	 		return 0;//执行成功返回0		 	
	 	else 
			return 1;//不成功返回1
	}
}
