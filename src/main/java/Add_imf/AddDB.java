package Add_imf;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.DBConnection;
import student.StudentInfo;

public class AddDB {
	private Connection conn = null;
	
	public ArrayList<annData> getAllAnns() { //获取所有公告信息
        ResultSet rs = null;
        Statement sql = null;
        ArrayList<annData> annList = new ArrayList<annData>();
        try {
        	conn = DBConnection.getConnection();
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
        	conn = DBConnection.getConnection();
            sql = conn.createStatement();
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
	
	public ArrayList<infoData> getAllStudents() {//获取所有学生信息
        ResultSet rs = null;
        Statement sql = null;
        ArrayList<infoData> studentList = new ArrayList<infoData>();
        try {
        	conn = DBConnection.getConnection();
            sql = conn.createStatement();
	    	rs = sql.executeQuery("SELECT * from student_inf");
	    	while(rs.next()){
	    		infoData student = new infoData();
	    		student.setStu_id(rs.getInt("STU_ID"));//获取学生学号
	    		student.setCla_id(rs.getInt("CLA_ID"));//获取学生所在班级编号
	    		student.setDor_id(rs.getInt("DOR_ID"));//获取学生宿舍门牌号
	    		student.setStu_na(rs.getInt("STU_NA"));//获取学生姓名
	    		student.setNatio(rs.getInt("NATIO"));//获取学生民族
	    		student.setStu_br(rs.getInt("STU_BR"));//获取学生出生日期
	    		student.setStu_ge(rs.getInt("STU_GE"));//获取学生性别
	    		student.setId_num(rs.getInt("ID_NUM"));//获取学生身份证号
	    		student.setPosta(rs.getInt("POSTA"));//获取学生政治面貌
	    		student.setPlres(rs.getInt("PLRES"));//获取学生居住省份
	    		
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
	
	public ArrayList<infoData> getAllStudents() {//获取所有学生信息
        ResultSet rs = null;
        Statement sql = null;
        ArrayList<infoData> studentList = new ArrayList<infoData>();
        try {
        	conn = DBConnection.getConnection();
            sql = conn.createStatement();
	    	rs = sql.executeQuery("SELECT * from student_inf");
	    	while(rs.next()){
	    		infoData student = new infoData();
	    		student.setStu_id(rs.getInt("STU_ID"));//获取教职工号
	    		student.setCla_id(rs.getInt("CLA_ID"));//获取学生所在班级编号
	    		student.setDor_id(rs.getInt("DOR_ID"));//获取学生宿舍门牌号
	    		student.setStu_na(rs.getInt("STU_NA"));//获取学生姓名
	    		student.setNatio(rs.getInt("NATIO"));//获取学生民族
	    		student.setStu_br(rs.getInt("STU_BR"));//获取学生出生日期
	    		student.setStu_ge(rs.getInt("STU_GE"));//获取学生性别
	    		student.setId_num(rs.getInt("ID_NUM"));//获取学生身份证号
	    		student.setPosta(rs.getInt("POSTA"));//获取学生政治面貌
	    		student.setPlres(rs.getInt("PLRES"));//获取学生居住省份
	    		
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
	
	public int addAnn(annData ann) { //添加公告
    	PreparedStatement pStmt = null; 
    	int count=0;  //记录更新数据的条数
        try {
        	conn=DBConnection.getConnection();
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
        	conn=DBConnection.getConnection();
    		pStmt = conn.prepareStatement("insert into announcement (FOR_ID, FOR_IM) values (?,?)");
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
	
	public int addStu(infoData info) { //添加学生
    	PreparedStatement pStmt = null; 
    	int count=0;  //记录更新数据的条数
        try {
        	conn=DBConnection.getConnection();
    		pStmt = conn.prepareStatement("insert into announcement (FOR_ID, FOR_IM) values (?,?)");
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
}
