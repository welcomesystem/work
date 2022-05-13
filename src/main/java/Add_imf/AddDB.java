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
	public ArrayList<annData> getAllAnns() { //获取所有公告信息
        ResultSet rs = null;
        Statement sql = null;
        ArrayList<annData> annList = new ArrayList<annData>();
        try {
        	con = DBConnection.getConnection();
            sql = conn.createStatement();
	    	rs = sql.executeQuery("SELECT * from announcement");
	    	while(rs.next()){
	    		annData ann = new annData();
	    		ann.setAnn_id(rs.getInt("ANN_ID")); //获取公告ID
	    		ann.setAnn_im(rs.getString("ANN_IM")); //获取公告链接
	    		
	    		annList.add(ann);	    		
	    	}  
			rs.close();
			sql.close();

        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("获取所有公告信息失败！");
        } finally{
        	DBConnection.closeConnection();//关闭连接
		}		
        return annList;
    }
	
	public ArrayList<forumData> getAllForums() { //获取所有帖子信息
        ResultSet rs = null;
        Statement sql = null;
        ArrayList<forumData> forumList = new ArrayList<forumData>();
        try {
        	con = DBConnection.getConnection();
            sql = con.createStatement();
	    	rs = sql.executeQuery("SELECT * from forum");
	    	while(rs.next()){
	    		forumData forum = new forumData();
	    		ann.setFor_id(rs.getInt("FOR_ID"));//获取帖子ID
	    		ann.setFor_im(rs.getString("FOR_IM"));//获取帖子链接
	    		
	    		forumList.add(forum);	    		
	    	}  
			rs.close();
			sql.close();

        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("获取所有帖子信息失败！");
        } finally{
        	DBConnection.closeConnection();//关闭连接
		}		
        return annList;
    }
	
	public ArrayList<teaData> getAllTeachers() {//获取所有教职工信息
        ResultSet rs = null;
        Statement sql = null;
        ArrayList<teaData> teacherList = new ArrayList<teaData>();
        try {
        	con = DBConnection.getConnection();
            sql = con.createStatement();
	    	rs = sql.executeQuery("SELECT * from teacher_inf");
	    	while(rs.next()){
	    		teaData teacher = new teaData();
	    		teacher.setTea_id(rs.getInt("TEA_ID"));//获取教职工号
	    		teacher.setTea_na(rs.getInt("TEA_NA"));//获取教职工姓名
	    		teacher.setTea_po(rs.getInt("TEA_PO"));//获取教职工政治面貌
	    		teacher.setTea_ph(rs.getInt("TEA_PH"));//获取教职工电话
	    		teacher.setTea_em(rs.getInt("TEA_EM"));//获取教职工邮箱
	    		teacher.setTea_wo(rs.getInt("TEA_WO"));//获取教职工办公室

	    		teacherList.add(teacher);	    		
	    	}  
			rs.close();
			sql.close();

        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("获取所有教职工信息失败！");
        } finally{
        	DBConnection.closeConnection();//关闭连接
		}		
        return studentList;
    }
	
	public ArrayList<infoData> getAllStudents() {//获取所有学生信息
        ResultSet rs = null;
        Statement sql = null;
        ArrayList<infoData> studentList = new ArrayList<infoData>();
        try {
        	con = DBConnection.getConnection();
            sql = con.createStatement();
	    	rs = sql.executeQuery("SELECT * from student_inf");
	    	while(rs.next()){
	    		infoData student = new infoData();
	    		student.setStu_id(rs.getInt("STU_ID"));//获取学生学号
	    		student.setCla_id(rs.getInt("CLA_ID"));//获取学生所在班级编号
	    		student.setDor_id(rs.getInt("DOR_ID"));//获取学生宿舍门牌号
	    		student.setStu_na(rs.getString("STU_NA"));//获取学生姓名
	    		student.setNatio(rs.getString("NATIO"));//获取学生民族
	    		student.setStu_br(rs.getString("STU_BR"));//获取学生出生日期
	    		student.setStu_ge(rs.getInt("STU_GE"));//获取学生性别
	    		student.setId_num(rs.getInt("ID_NUM"));//获取学生身份证号
	    		student.setPosta(rs.getInt("POSTA"));//获取学生政治面貌
	    		student.setPlres(rs.getString("PLRES"));//获取学生居住省份
	    		
	    		studentList.add(student);	    		
	    	}  
			rs.close();
			sql.close();

        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("获取所有学生信息失败！");
        } finally{
        	DBConnection.closeConnection();//关闭连接
		}		
        return studentList;
    }
*/	
	public int addAnn(annData ann) { //添加公告
    	PreparedStatement pStmt = null; 
    	int count=0;  //记录更新数据的条数
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("insert into announcement (ANN_ID, ANN_IM) values (?,?)");
    		pStmt.setInt(1, ann.getAnn_id());	//公告编号	
    		pStmt.setString(2, ann.getAnn_im()); //公告链接			
    		count = pStmt.executeUpdate();  
			pStmt.close();
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("添加公告失败！");
        } finally{
        	DBConnection.closeConnection();
		}		
        return count;
    }
	
	public int addForum(forumData forum) { //添加论坛帖子
    	PreparedStatement pStmt = null; 
    	int count=0;  //记录更新数据的条数
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("insert into announcement (FOR_ID, FOR_IM) values (?,?)");
    		pStmt.setInt(1, forum.getFor_id());	//帖子编号	
    		pStmt.setString(2, forum.getFor_im()); //帖子链接			
    		count = pStmt.executeUpdate();  
			pStmt.close();
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("添加帖子失败！");
        } finally{
        	DBConnection.closeConnection();
		}		
        return count;
    }
	
	public int addStu(infoData student) { //添加学生
    	PreparedStatement pStmt = null; 
    	int count=0;  //记录更新数据的条数
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("insert into student_inf (STU_ID, CLA_ID, DOR_ID, NATIO, STU_BR, STU_GE, ID_NUM, POSTA, PLRES) values (?,?,?,?,?,?,?,?,?,?)");

    		pStmt.setInt(1, student.getStu_id());//添加学生学号
    		pStmt.setInt(2, student.getCla_id());//添加学生所在班级编号
    		pStmt.setInt(3, student.getDor_id());//添加学生宿舍门牌号
    		pStmt.setString(4, student.getStu_na());//添加学生姓名
    		pStmt.setString(5, student.getNatio());//添加学生民族
    		pStmt.setString(6, student.getStu_br());//添加学生出生日期
    		pStmt.setInt(7, student.getStu_ge());//添加学生性别
    		pStmt.setString(8, student.getId_num());//添加学生身份证号
    		pStmt.setInt(9, student.getPosta());//添加学生政治面貌
    		pStmt.setInt(10, student.getPlres());//添加学生居住省份
    		
    		count = pStmt.executeUpdate();  //执行
			pStmt.close();
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("添加学生失败！");
        } finally{
        	DBConnection.closeConnection();//关闭连接
		}		
        return count;
    }
	
	public int addTea(teaData teacher) { //添加教职工
    	PreparedStatement pStmt = null; 
    	int count=0;  //记录更新数据的条数
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("insert into teacher_inf (TEA_ID, TEA_NA, TEA_PO, TEA_PH, TEA_EM, TEA_WO) values (?,?,?,?,?)");
    	
    		pStmt.setInt(1, teacher.getTea_id());//添加教职工号
    		pStmt.setString(2, teacher.getTea_na());//添加教职工姓名
    		pStmt.setString(3, teacher.getTea_po());//添加教职工政治面貌
    		pStmt.setString(4, teacher.getTea_ph());//添加教职工电话
    		pStmt.setString(5, teacher.getTea_em());//添加教职工邮箱
    		pStmt.setString(6, teacher.getTea_wo());//添加教职工办公室

    		
    		count = pStmt.executeUpdate();  //执行
			pStmt.close();
        } catch (Exception e) {
           	e.printStackTrace();
            System.out.println("添加教职工失败！");
        } finally{
        	DBConnection.closeConnection();//关闭连接
		}		
        return count;
    }
}
