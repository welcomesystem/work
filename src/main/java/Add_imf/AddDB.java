package Add_imf;

import java.sql.*;

import DBConnection.DBConnection;
import Datas.*;

public class AddDB {
	private Connection con = null;
	public int addAnn(annData ann) { //添加公告,返回成功，0失败
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
	
	public int addForum(forumData forum) { //添加论坛帖子,返回成功，0失败
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
	
	public int addStu(InfoData student) { //添加学生,返回成功，0失败
    	PreparedStatement pStmt = null;
    	PreparedStatement pStmt_1 = null;
    	ResultSet rs=null;
    	int count=0;  //记录更新数据的条数
        try {
        	pStmt_1 = con.prepareStatement("select CLA_ID from class_inf where CLA_NA=?");
        	pStmt_1.setString(1,student.getCla_na());
        	rs=pStmt_1.executeQuery();
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("insert into student_inf (STU_ID, CLA_ID, DOR_ID, NATIO, STU_BR, STU_GE, ID_NUM, POSTA, PLRES) values (?,?,?,?,?,?,?,?,?,?)");
    		pStmt.setInt(1, student.getStu_id());//添加学生学号
    		pStmt.setInt(2, rs.getInt("CLA_ID"));//添加学生所在班级编号
    		pStmt_1 = con.prepareStatement("select DOR_ID from dormitory_inf where DOR=?");
    		pStmt_1.setInt(1,student.getDor_na());
    		pStmt.setInt(3, rs.getInt("DOR_ID"));//添加学生宿舍门牌号
    		pStmt.setString(4, student.getStu_na());//添加学生姓名
    		pStmt.setString(5, student.getNatio());//添加学生民族
    		pStmt.setString(6, student.getStu_br());//添加学生出生日期
    		pStmt.setInt(7, student.getStu_ge());//添加学生性别
    		pStmt.setString(8, student.getId_num());//添加学生身份证号
    		pStmt.setInt(9, student.getPosta());//添加学生政治面貌
    		pStmt.setString(10, student.getPlres());//添加学生居住省份
    		
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
	
	public int addTea(TeaData teacher) { //添加教职工,返回成功，0失败
    	PreparedStatement pStmt = null; 
    	int count=0;  //记录更新数据的条数
        try {
        	con=DBConnection.getConnection();
    		pStmt = con.prepareStatement("insert into teacher_inf (TEA_ID, TEA_NA, TEA_PO, TEA_PH, TEA_EM, TEA_WO) values (?,?,?,?,?)");
    	
    		pStmt.setInt(1, teacher.getTea_id());//添加教职工号
    		pStmt.setString(2, teacher.getTea_na());//添加教职工姓名
    		//pStmt.setString(3, teacher.getTea_po());//添加教职工政治面貌
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
