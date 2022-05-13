package Add_imf;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.DBConnection;
import student.StudentInfo;


public class AddDB {
	private Connection con = null;

/*
	public ArrayList<annData> getAllAnns() { //��ȡ���й�����Ϣ
        ResultSet rs = null;
        Statement sql = null;
        ArrayList<annData> annList = new ArrayList<annData>();
        try {
        	con = DBConnection.getConnection();
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
        	con = DBConnection.getConnection();
            sql = con.createStatement();
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
	
	public ArrayList<teaData> getAllTeachers() {//��ȡ���н�ְ����Ϣ
        ResultSet rs = null;
        Statement sql = null;
        ArrayList<teaData> teacherList = new ArrayList<teaData>();
        try {
        	con = DBConnection.getConnection();
            sql = con.createStatement();
	    	rs = sql.executeQuery("SELECT * from teacher_inf");
	    	while(rs.next()){
	    		teaData teacher = new teaData();
	    		teacher.setTea_id(rs.getInt("TEA_ID"));//��ȡ��ְ����
	    		teacher.setTea_na(rs.getInt("TEA_NA"));//��ȡ��ְ������
	    		teacher.setTea_po(rs.getInt("TEA_PO"));//��ȡ��ְ��������ò
	    		teacher.setTea_ph(rs.getInt("TEA_PH"));//��ȡ��ְ���绰
	    		teacher.setTea_em(rs.getInt("TEA_EM"));//��ȡ��ְ������
	    		teacher.setTea_wo(rs.getInt("TEA_WO"));//��ȡ��ְ���칫��

	    		teacherList.add(teacher);	    		
	    	}  
			rs.close();
			sql.close();

        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("��ȡ���н�ְ����Ϣʧ�ܣ�");
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
        	con = DBConnection.getConnection();
            sql = con.createStatement();
	    	rs = sql.executeQuery("SELECT * from student_inf");
	    	while(rs.next()){
	    		infoData student = new infoData();
	    		student.setStu_id(rs.getInt("STU_ID"));//��ȡѧ��ѧ��
	    		student.setCla_id(rs.getInt("CLA_ID"));//��ȡѧ�����ڰ༶���
	    		student.setDor_id(rs.getInt("DOR_ID"));//��ȡѧ���������ƺ�
	    		student.setStu_na(rs.getString("STU_NA"));//��ȡѧ������
	    		student.setNatio(rs.getString("NATIO"));//��ȡѧ������
	    		student.setStu_br(rs.getString("STU_BR"));//��ȡѧ����������
	    		student.setStu_ge(rs.getInt("STU_GE"));//��ȡѧ���Ա�
	    		student.setId_num(rs.getInt("ID_NUM"));//��ȡѧ�����֤��
	    		student.setPosta(rs.getInt("POSTA"));//��ȡѧ��������ò
	    		student.setPlres(rs.getString("PLRES"));//��ȡѧ����סʡ��
	    		
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
*/	
	public int addAnn(annData ann) { //��ӹ���
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
	
	public int addForum(forumData forum) { //�����̳����
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
	
	public int addStu(infoData student) { //���ѧ��
    	PreparedStatement pStmt = null; 
    	int count=0;  //��¼�������ݵ�����
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("insert into student_inf (STU_ID, CLA_ID, DOR_ID, NATIO, STU_BR, STU_GE, ID_NUM, POSTA, PLRES) values (?,?,?,?,?,?,?,?,?,?)");

    		pStmt.setInt(1, student.getStu_id());//���ѧ��ѧ��
    		pStmt.setInt(2, student.getCla_id());//���ѧ�����ڰ༶���
    		pStmt.setInt(3, student.getDor_id());//���ѧ���������ƺ�
    		pStmt.setString(4, student.getStu_na());//���ѧ������
    		pStmt.setString(5, student.getNatio());//���ѧ������
    		pStmt.setString(6, student.getStu_br());//���ѧ����������
    		pStmt.setInt(7, student.getStu_ge());//���ѧ���Ա�
    		pStmt.setString(8, student.getId_num());//���ѧ�����֤��
    		pStmt.setInt(9, student.getPosta());//���ѧ��������ò
    		pStmt.setInt(10, student.getPlres());//���ѧ����סʡ��
    		
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
	
	public int addTea(teaData teacher) { //��ӽ�ְ��
    	PreparedStatement pStmt = null; 
    	int count=0;  //��¼�������ݵ�����
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("insert into teacher_inf (TEA_ID, TEA_NA, TEA_PO, TEA_PH, TEA_EM, TEA_WO) values (?,?,?,?,?)");
    	
    		pStmt.setInt(1, teacher.getTea_id());//��ӽ�ְ����
    		pStmt.setString(2, teacher.getTea_na());//��ӽ�ְ������
    		pStmt.setString(3, teacher.getTea_po());//��ӽ�ְ��������ò
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
