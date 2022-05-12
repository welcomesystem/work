package Add_imf;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.DBConnection;
import student.StudentInfo;

public class AddDB {
	private Connection conn = null;
	
	public ArrayList<annData> getAllAnns() { //��ȡ���й�����Ϣ
        ResultSet rs = null;
        Statement sql = null;
        ArrayList<annData> annList = new ArrayList<annData>();
        try {
        	conn = DBConnection.getConnection();
            sql = conn.createStatement();
	    	rs = sql.executeQuery("SELECT * from announcement");
	    	while(rs.next()){
	    		annData ann = new annData();
	    		ann.setAnn_id(rs.getInt("ANN_ID")); //��ȡ����ID
	    		ann.setAnn_im(rs.getString("ANN_IM")); //��ȡ��������
	    		
	    		annList.add(ann);	    		
	    	}  
			rs.close();
			sql.close();

        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("��ȡ���й�����Ϣʧ�ܣ�");
        } finally{
        	DBConnection.closeConnection();//�ر�����
		}		
        return annList;
    }
	
	public ArrayList<forumData> getAllForums() { //��ȡ����������Ϣ
        ResultSet rs = null;
        Statement sql = null;
        ArrayList<forumData> forumList = new ArrayList<forumData>();
        try {
        	conn = DBConnection.getConnection();
            sql = conn.createStatement();
	    	rs = sql.executeQuery("SELECT * from forum");
	    	while(rs.next()){
	    		forumData forum = new forumData();
	    		ann.setFor_id(rs.getInt("FOR_ID"));//��ȡ����ID
	    		ann.setFor_im(rs.getString("FOR_IM"));//��ȡ��������
	    		
	    		forumList.add(forum);	    		
	    	}  
			rs.close();
			sql.close();

        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("��ȡ����������Ϣʧ�ܣ�");
        } finally{
        	DBConnection.closeConnection();//�ر�����
		}		
        return annList;
    }
	
	public ArrayList<infoData> getAllStudents() {//��ȡ����ѧ����Ϣ
        ResultSet rs = null;
        Statement sql = null;
        ArrayList<infoData> studentList = new ArrayList<infoData>();
        try {
        	conn = DBConnection.getConnection();
            sql = conn.createStatement();
	    	rs = sql.executeQuery("SELECT * from student_inf");
	    	while(rs.next()){
	    		infoData student = new infoData();
	    		student.setStu_id(rs.getInt("STU_ID"));//��ȡѧ��ѧ��
	    		student.setCla_id(rs.getInt("CLA_ID"));//��ȡѧ�����ڰ༶���
	    		student.setDor_id(rs.getInt("DOR_ID"));//��ȡѧ���������ƺ�
	    		student.setStu_na(rs.getInt("STU_NA"));//��ȡѧ������
	    		student.setNatio(rs.getInt("NATIO"));//��ȡѧ������
	    		student.setStu_br(rs.getInt("STU_BR"));//��ȡѧ����������
	    		student.setStu_ge(rs.getInt("STU_GE"));//��ȡѧ���Ա�
	    		student.setId_num(rs.getInt("ID_NUM"));//��ȡѧ�����֤��
	    		student.setPosta(rs.getInt("POSTA"));//��ȡѧ��������ò
	    		student.setPlres(rs.getInt("PLRES"));//��ȡѧ����סʡ��
	    		
	    		studentList.add(student);	    		
	    	}  
			rs.close();
			sql.close();

        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("��ȡ����ѧ����Ϣʧ�ܣ�");
        } finally{
        	DBConnection.closeConnection();//�ر�����
		}		
        return studentList;
    }
	
	public ArrayList<infoData> getAllStudents() {//��ȡ����ѧ����Ϣ
        ResultSet rs = null;
        Statement sql = null;
        ArrayList<infoData> studentList = new ArrayList<infoData>();
        try {
        	conn = DBConnection.getConnection();
            sql = conn.createStatement();
	    	rs = sql.executeQuery("SELECT * from student_inf");
	    	while(rs.next()){
	    		infoData student = new infoData();
	    		student.setStu_id(rs.getInt("STU_ID"));//��ȡ��ְ����
	    		student.setCla_id(rs.getInt("CLA_ID"));//��ȡѧ�����ڰ༶���
	    		student.setDor_id(rs.getInt("DOR_ID"));//��ȡѧ���������ƺ�
	    		student.setStu_na(rs.getInt("STU_NA"));//��ȡѧ������
	    		student.setNatio(rs.getInt("NATIO"));//��ȡѧ������
	    		student.setStu_br(rs.getInt("STU_BR"));//��ȡѧ����������
	    		student.setStu_ge(rs.getInt("STU_GE"));//��ȡѧ���Ա�
	    		student.setId_num(rs.getInt("ID_NUM"));//��ȡѧ�����֤��
	    		student.setPosta(rs.getInt("POSTA"));//��ȡѧ��������ò
	    		student.setPlres(rs.getInt("PLRES"));//��ȡѧ����סʡ��
	    		
	    		studentList.add(student);	    		
	    	}  
			rs.close();
			sql.close();

        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("��ȡ����ѧ����Ϣʧ�ܣ�");
        } finally{
        	DBConnection.closeConnection();//�ر�����
		}		
        return studentList;
    }
	
	public int addAnn(annData ann) { //��ӹ���
    	PreparedStatement pStmt = null; 
    	int count=0;  //��¼�������ݵ�����
        try {
        	conn=DBConnection.getConnection();
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
	
	public int addForum(forumData forum) { //�����̳����
    	PreparedStatement pStmt = null; 
    	int count=0;  //��¼�������ݵ�����
        try {
        	conn=DBConnection.getConnection();
    		pStmt = conn.prepareStatement("insert into announcement (FOR_ID, FOR_IM) values (?,?)");
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
	
	public int addStu(infoData info) { //���ѧ��
    	PreparedStatement pStmt = null; 
    	int count=0;  //��¼�������ݵ�����
        try {
        	conn=DBConnection.getConnection();
    		pStmt = conn.prepareStatement("insert into announcement (FOR_ID, FOR_IM) values (?,?)");
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
}
