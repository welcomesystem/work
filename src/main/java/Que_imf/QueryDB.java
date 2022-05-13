package Que_imf;

import Datas.*;
import DBConnection.*;
import java.sql.*;
import java.util.*;

public class QueryDB {
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	public InfoData infoQuery(int id) throws SQLException {//学生基本信息
		InfoData StuData=new InfoData();
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select STU_NA，NATIO，STU_BR，STU_GE，ID_NUM，POSTA，PLRES，CLA_NA，DOR，BUI"//姓名，民族,出生日期，性别，身份证号，政治面貌，居住地址，班级名，宿舍门牌号，栋数
					+ "from student_inf,build_inf，dormitory_inf，college_inf"
					+ "where student_inf.CLA_ID=class_inf.CLA_ID and student_inf.DOR_ID=dormitory_inf.DOR_ID and dormitory_inf.BUI_ID=build_inf.BUI_ID"
					+ " and STU_ID=?");
			stmt.setInt(1,id);
		}
		catch(Exception e){
			System.out.println("学生基本信息sql语句查找出现问题");
		}
		try {
			rs=stmt.executeQuery();
			rs.next();
			StuData.setBui_na(Integer.parseInt(rs.getString("BUI")));//栋数
			StuData.setCla_na(rs.getString("CLA_NA"));//班级
			StuData.setDor_na(Integer.parseInt(rs.getString("DOR")));//宿舍门牌号
			StuData.setNatio(rs.getString("NATIO"));//民族
			StuData.setPlres(rs.getString("PLRES"));//居住省份
			StuData.setPosta(Integer.parseInt(rs.getString("POSTA")));//政治面貌
			StuData.setStu_br(rs.getString("STU_BR"));//出生日期
			StuData.setStu_ge(Integer.parseInt(rs.getString("STU_GE")));//性别
			StuData.setId_num(rs.getString("ID_NUM"));//身份证号
			StuData.setStu_na(rs.getString("STU_NA"));//姓名
			StuData.setStu_id(id);
		}
		catch(Exception e) {
			System.out.println("学生基本信息数据放入出现问题");
		}
		rs.close();
		stmt.close();
		DBConnection.closeConnection();
		return StuData;
	}
	public TeaData TeaDataInfoQuery(int id) throws SQLException {//教职工信息,传入学生id，
		TeaData Teadata=new TeaData();
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select TEA_NA,TEA_Ph,TEA_EM,TEA_WO"
					+ "from teacher_inf,class_inf,student_inf"
					+ "where student_inf.CLA_ID=class_inf.CLA_ID and class_inf.TEA_ID=teacher_inf.TEA_ID"
					+ " and STU_ID=?");
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
		}
		catch(Exception e){
			System.out.println("教职工信息sql查询语句错误");
		}
		try {
			rs.next();
			Teadata.setTea_em(rs.getString("TEA_EM"));//教职工邮箱
			Teadata.setTea_na(rs.getString("TEA_NA"));//教职工姓名
			Teadata.setTea_ph(rs.getString("TEA_Ph"));//教职工电话
			Teadata.setTea_wo(rs.getString("TEA_WO"));//教职工办公室
		}
		catch(Exception e) {
			System.out.println("教职工信息获取语句错误");
		}
		return Teadata;
	}
	public statusData statusQuery(int id)  throws SQLException {//报到信息
		statusData StuData=new statusData();
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select JUD_1,JUD_2,JUD_3 form and student_jud where STU_ID=?");
			stmt.setInt(1,id);
		}
		catch(Exception e){
			System.out.println("报到信息数据sql语句查询出现问题");
		}
		try {
			rs=stmt.executeQuery();
			rs.next();
			StuData.setSta_1(Integer.parseInt(rs.getString("JUD_1")));//教务处报到
			StuData.setSta_2(Integer.parseInt(rs.getString("JUD_2")));//宿舍报到
			StuData.setSta_3(Integer.parseInt(rs.getString("JUD_3")));//体检报到
			StuData.setStu_id(id);
		}
		catch(Exception e) {
			System.out.println("报到信息数据放入出现问题");
		}
		rs.close();
		stmt.close();
		DBConnection.closeConnection();
		return StuData;
	}
	public costData costQuery(int id) throws SQLException {//缴费信息
		costData StuData=new costData();
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select COST_1,COST_2,COST_3,COST_4 from student_cost where STU_ID=?");
			stmt.setInt(1,id);
		}
		catch(Exception e){
			System.out.println("缴费信息sql语句查找出现问题");
		}
		try{
			rs=stmt.executeQuery();
			rs.next();
			StuData.setCost_1(Integer.parseInt(rs.getString("COST_1")));//学杂费及书本费
			StuData.setCost_2(Integer.parseInt(rs.getString("COST_2")));//个人保险费
			StuData.setCost_3(Integer.parseInt(rs.getString("COST_3")));//水卡费用
			StuData.setCost_4(Integer.parseInt(rs.getString("COST_4")));//饭卡费用
			StuData.setStu_id(id);
		}
		catch(Exception e){
			System.out.println("缴费报到信息数据放入出现问题");
		}
		rs.close();
		stmt.close();
		DBConnection.closeConnection();
		return StuData;
	}
	public forumData forumQuery(int id) throws SQLException {//论坛信息
		forumData ForData=new forumData();
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select FOR_IM from forum where FOR_ID=?");
			stmt.setInt(1,id);
		}
		catch(Exception e){
			System.out.println("论坛数据信息sql语句查找出现问题");
		}
		try {
			rs=stmt.executeQuery();
			rs.next();
			ForData.setFor_id(id);
			ForData.setFor_im(rs.getString("FOR_IM"));
		}
		catch(Exception e) {
			System.out.println("论坛数据信息放入出现问题");
		}
		rs.close();
		stmt.close();
		DBConnection.closeConnection();
		return ForData;
	}
	public annData annQuery(int id) throws SQLException {//公告信息
		annData AnnData=new annData();
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select ANN_IM from announcement where ANN_ID=?");
			stmt.setInt(1,id);
		}
		catch(Exception e){
			System.out.println("公告论坛数据信息sql语句查找出现问题");
		}
		try {
			rs=stmt.executeQuery();
			rs.next();
			AnnData.setAnn_id(id);
			AnnData.setAnn_im(rs.getString("ANN_IM"));
		}
		catch(Exception e) {
			System.out.println("公告数据信息放入出现问题");
		}
		rs.close();
		stmt.close();
		DBConnection.closeConnection();
		return AnnData;
	}
	public ArrayList<InfoData> allinfoQuery(String Classname) throws SQLException {//一个班级基本学生信息
		ArrayList<InfoData>allstuData =new ArrayList<InfoData>();
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select STU_NA，NATIO，STU_BR，STU_GE，ID_NUM，POSTA，PLRES，STU_ID，DOR，BUI"//姓名，民族,出生日期，性别，身份证号，政治面貌，居住地址，学号，宿舍门牌号，栋数
					+ "from student_inf,build_inf，dormitory_inf，college_inf"
					+ "where student_inf.CLA_ID=class_inf.CLA_ID and student_inf.DOR_ID=dormitory_inf.DOR_ID and dormitory_inf.BUI_ID=build_inf.BUI_ID"
					+ " and CLA_NA=?");
			stmt.setString(1,Classname);
		}
		catch(Exception e){
			System.out.println("获取班级学生基本信息sql语句出现问题");
		}
		try{
			rs=stmt.executeQuery();
			while(rs.next())
			{
				InfoData StuData=new InfoData();
				StuData.setBui_na(Integer.parseInt(rs.getString("BUI")));//栋数
				StuData.setStu_id(Integer.parseInt(rs.getString("STU_ID")));//学号
				StuData.setDor_na(Integer.parseInt(rs.getString("DOR")));//宿舍门牌号
				StuData.setNatio(rs.getString("NATIO"));//民族
				StuData.setPlres(rs.getString("PLRES"));//居住省份
				StuData.setPosta(Integer.parseInt(rs.getString("POSTA")));//政治面貌
				StuData.setStu_br(rs.getString("STU_BR"));//出生日期
				StuData.setStu_ge(Integer.parseInt(rs.getString("STU_GE")));//性别
				StuData.setId_num(rs.getString("ID_NUM"));//身份证号
				StuData.setStu_na(rs.getString("STU_NA"));//姓名
				StuData.setCla_na(Classname);//班级名
				allstuData.add(StuData);
			}
		}
		catch(Exception e){
			System.out.println("获取班级学生基本信息放入出现问题");
		}
		rs.close();
		stmt.close();
		DBConnection.closeConnection();
		return allstuData;
	}
	public ArrayList<statusData> allstatusQuery(String Classname) throws SQLException {//一个班级学生报到信息
		ArrayList<statusData> allstuData=new ArrayList<statusData>();
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select JUD_1,JUD_2,JUD_3,STU_ID,STU_NA "
					+ "form student_jud,student_inf,class_inf"
					+ " where student_inf.STU_ID=student_jud.STU_ID and class_inf.CLA_ID=student_inf.CLA_ID"
					+ " and CLA_NA=?");
			stmt.setString(1,Classname);
		}
		catch(Exception e){
			System.out.println("获取班级学生报到信息sql语句出现问题");
		}
		try{
			rs=stmt.executeQuery();
			while(rs.next())
			{
				statusData StuData=new statusData();
				StuData.setSta_1(Integer.parseInt(rs.getString("JUD_1")));//教务处报到
				StuData.setSta_2(Integer.parseInt(rs.getString("JUD_2")));//宿舍报到
				StuData.setSta_3(Integer.parseInt(rs.getString("JUD_3")));//体检报到
				StuData.setStu_id(Integer.parseInt(rs.getString("STU_ID")));//学号
				StuData.setStu_name(rs.getString("STU_NA"));//姓名
				allstuData.add(StuData);
			}
		}
		catch(Exception e){
			System.out.println("获取班级学生报到信息放入出现问题");
		}
		rs.close();
		stmt.close();
		DBConnection.closeConnection();
		return allstuData;
	}
	public ArrayList<costData> allcostQuery(String Classname) throws SQLException {//一个班级学生缴费信息
		ArrayList<costData> allstuData=new ArrayList<costData>();
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select COST_1,COST_2,COST_3,COST_4,STU_ID,STU_NA "
					+ "from student_cost,student_inf,class_inf "
					+ "where student_inf.STU_ID=student_cost.STU_ID and class_inf.CLA_ID=student_inf.CLA_ID"
					+ " and STU_ID=?");
		}
		catch(Exception e){
			System.out.println("获取班级学生缴费信息sql语句出现问题");
		}
		try{
			rs=stmt.executeQuery();
			while(rs.next())
			{
				costData StuData=new costData();
				StuData.setCost_1(Integer.parseInt(rs.getString("COST_1")));//学杂费及书本费
				StuData.setCost_1(Integer.parseInt(rs.getString("COST_2")));//个人保险费
				StuData.setCost_1(Integer.parseInt(rs.getString("COST_3")));//水卡费用
				StuData.setCost_1(Integer.parseInt(rs.getString("COST_4")));//饭卡费用
				StuData.setStu_id(Integer.parseInt(rs.getString("STU_ID")));//学号
				StuData.setStu_name(rs.getString("STU_NA"));//姓名
				allstuData.add(StuData);
			}
		} 
		catch(Exception e){
			System.out.println("获取班级学生缴费信息放入出现问题");
		}
		rs.close();
		stmt.close();
		DBConnection.closeConnection();
		return allstuData;
	}
}