package Add_imf;

import java.sql.*;

import DBConnection.DBConnection;
import Datas.*;

public class AddDB {
	private Connection con = null;
	public int addAnn(annData ann) { //��ӹ���,���سɹ���0ʧ��
    	PreparedStatement pStmt = null; 
    	int count=0;  //��¼�������ݵ�����
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("insert into announcement (ANN_ID, ANN_IM) values (?,?)");
    		pStmt.setInt(1, ann.getAnn_id());	//������	
    		pStmt.setString(2, ann.getAnn_im()); //��������			
    		count = pStmt.executeUpdate();  
			pStmt.close();
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("��ӹ���ʧ�ܣ�");
        } finally{
        	DBConnection.closeConnection();
		}		
        return count;
    }
	
	public int addForum(forumData forum) { //�����̳����,���سɹ���0ʧ��
    	PreparedStatement pStmt = null; 
    	int count=0;  //��¼�������ݵ�����
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("insert into announcement (FOR_ID, FOR_IM) values (?,?)");
    		pStmt.setInt(1, forum.getFor_id());	//���ӱ��	
    		pStmt.setString(2, forum.getFor_im()); //��������			
    		count = pStmt.executeUpdate();  
			pStmt.close();
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("�������ʧ�ܣ�");
        } finally{
        	DBConnection.closeConnection();
		}		
        return count;
    }
	
	public int addStu(InfoData student) { //���ѧ��,���سɹ���0ʧ��
    	PreparedStatement pStmt = null;
    	PreparedStatement pStmt_1 = null;
    	ResultSet rs=null;
    	int count=0;  //��¼�������ݵ�����
        try {
        	pStmt_1 = con.prepareStatement("select CLA_ID from class_inf where CLA_NA=?");
        	pStmt_1.setString(1,student.getCla_na());
        	rs=pStmt_1.executeQuery();
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("insert into student_inf (STU_ID, CLA_ID, DOR_ID, NATIO, STU_BR, STU_GE, ID_NUM, POSTA, PLRES) values (?,?,?,?,?,?,?,?,?,?)");
    		pStmt.setInt(1, student.getStu_id());//���ѧ��ѧ��
    		pStmt.setInt(2, rs.getInt("CLA_ID"));//���ѧ�����ڰ༶���
    		pStmt_1 = con.prepareStatement("select DOR_ID from dormitory_inf where DOR=?");
    		pStmt_1.setInt(1,student.getDor_na());
    		pStmt.setInt(3, rs.getInt("DOR_ID"));//���ѧ���������ƺ�
    		pStmt.setString(4, student.getStu_na());//���ѧ������
    		pStmt.setString(5, student.getNatio());//���ѧ������
    		pStmt.setString(6, student.getStu_br());//���ѧ����������
    		pStmt.setInt(7, student.getStu_ge());//���ѧ���Ա�
    		pStmt.setString(8, student.getId_num());//���ѧ�����֤��
    		pStmt.setInt(9, student.getPosta());//���ѧ��������ò
    		pStmt.setString(10, student.getPlres());//���ѧ����סʡ��
    		
    		count = pStmt.executeUpdate();  //ִ��
			pStmt.close();
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("���ѧ��ʧ�ܣ�");
        } finally{
        	DBConnection.closeConnection();//�ر�����
		}		
        return count;
    }
	
	public int addTea(TeaData teacher) { //��ӽ�ְ��,���سɹ���0ʧ��
    	PreparedStatement pStmt = null; 
    	int count=0;  //��¼�������ݵ�����
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("insert into teacher_inf (TEA_ID, TEA_NA, TEA_PO, TEA_PH, TEA_EM, TEA_WO) values (?,?,?,?,?)");
    	
    		pStmt.setInt(1, teacher.getTea_id());//��ӽ�ְ����
    		pStmt.setString(2, teacher.getTea_na());//��ӽ�ְ������
    		//pStmt.setString(3, teacher.getTea_po());//��ӽ�ְ��������ò
    		pStmt.setString(4, teacher.getTea_ph());//��ӽ�ְ���绰
    		pStmt.setString(5, teacher.getTea_em());//��ӽ�ְ������
    		pStmt.setString(6, teacher.getTea_wo());//��ӽ�ְ���칫��

    		
    		count = pStmt.executeUpdate();  //ִ��
			pStmt.close();
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("��ӽ�ְ��ʧ�ܣ�");
        } finally{
        	DBConnection.closeConnection();//�ر�����
		}		
        return count;
    }
}
