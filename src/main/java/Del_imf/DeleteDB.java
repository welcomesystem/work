package Del_imf;

import DBConnection.*;
import java.sql.*;
//StuDelɾ��ѧ��
//ForumDel��̳ɾ��
//AnnDel����ɾ��
public class DeleteDB {
	Connection con=null;
	PreparedStatement pStmt=null; 
 	PreparedStatement pst1=null;
 	PreparedStatement pst2=null;
 	int count;
 	
	int stuDel(int id){//ɾ��ѧ��
	/*ɾ��ָ��ѧ�ŵ�ѧ������InfoData�����Ϣ
	���ݿ��޸İ�����student_inf��student_jud��student_cost��student
	�����Ƿ�ɾ���ɹ����ɹ�Ϊ0��ʧ��Ϊ1*/
		 try {
	        	con=DBConnection.getConnection();
	        try {
	        	pStmt = con.prepareStatement("delete from student_inf where STU_ID=?");
	    		pst1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
	        	pst2 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=1");
	    		pStmt.setInt(1,id);	
	    		pst1.executeUpdate();
	    		count=pStmt.executeUpdate();//ִ�гɹ���count=1��ʧ����Ϊ0
	    		pst2.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ɾ��ѧ����Ϣsql������");
			}	
	    		pStmt.close();   
	    		pst1.close();
	    		pst2.close();
	        } catch (Exception e) {
	           	e.printStackTrace();
	            System.out.println("ɾ��ѧ����Ϣʧ�ܣ�");
	        } finally{
	        	DBConnection.closeConnection();
			}
		 	if(count==1) 
		 		return 0;//ִ�гɹ�����0		 	
		 	else 
				return 1;//���ɹ�����1
			
	}
	int forumDel(int id){//��̳ɾ��
	/*ɾ��ָ����̳id�����ݣ���forumData�����Ϣ
	���ݿ��޸İ�����forum
	�����Ƿ�ɾ���ɹ����ɹ�Ϊ0��ʧ��Ϊ1*/
		try {
        	con=DBConnection.getConnection();
        try {
        	pStmt = con.prepareStatement("delete from forum where FOR_ID=?");
    		pst1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
        	pst2 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=1");
    		pStmt.setInt(1,id);	
    		pst1.executeUpdate();
    		count=pStmt.executeUpdate();//ִ�гɹ���count=1��ʧ����Ϊ0
    		pst2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ɾ����̳����sql������");
		}	
    		pStmt.close();   
    		pst1.close();
    		pst2.close();
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("ɾ����̳����ʧ�ܣ�");
        } finally{
        	DBConnection.closeConnection();
		}
	 	if(count==1) 
	 		return 0;//ִ�гɹ�����0		 	
	 	else 
			return 1;//���ɹ�����1
	}
	int annDel(int id){//����ɾ��
	/*ɾ��ָ������id�����ݣ���annData�����Ϣ
	���ݿ��޸İ�����announcement
	�����Ƿ�ɾ���ɹ����ɹ�Ϊ0��ʧ��Ϊ1*/
		try {
        	con=DBConnection.getConnection();
        try {
        	pStmt = con.prepareStatement("delete from announcement where ANN_ID=?");
    		pst1 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
        	pst2 = con.prepareStatement("SET FOREIGN_KEY_CHECKS=1");
    		pStmt.setInt(1,id);	
    		pst1.executeUpdate();
    		count=pStmt.executeUpdate();//ִ�гɹ���count=1��ʧ����Ϊ0
    		pst2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ɾ������sql������");
		}	
    		pStmt.close();   
    		pst1.close();
    		pst2.close();
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("ɾ������ʧ�ܣ�");
        } finally{
        	DBConnection.closeConnection();
		}
	 	if(count==1) 
	 		return 0;//ִ�гɹ�����0		 	
	 	else 
			return 1;//���ɹ�����1
	}
}
