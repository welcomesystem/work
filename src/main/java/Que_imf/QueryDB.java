package Que_imf;

import Datas.*;
import DBConnection.*;
import java.sql.*;
import java.util.*;

public class QueryDB {
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	public InfoData infoQuery(int id) throws SQLException {//ѧ��������Ϣ
		InfoData StuData=new InfoData();
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select STU_NA��NATIO��STU_BR��STU_GE��ID_NUM��POSTA��PLRES��CLA_NA��DOR��BUI"//����������,�������ڣ��Ա����֤�ţ�������ò����ס��ַ���༶�����������ƺţ�����
					+ "from student_inf,build_inf��dormitory_inf��college_inf"
					+ "where student_inf.CLA_ID=class_inf.CLA_ID and student_inf.DOR_ID=dormitory_inf.DOR_ID and dormitory_inf.BUI_ID=build_inf.BUI_ID"
					+ " and STU_ID=?");
			stmt.setInt(1,id);
		}
		catch(Exception e){
			System.out.println("ѧ��������Ϣsql�����ҳ�������");
		}
		try {
			rs=stmt.executeQuery();
			rs.next();
			StuData.setBui_na(Integer.parseInt(rs.getString("BUI")));//����
			StuData.setCla_na(rs.getString("CLA_NA"));//�༶
			StuData.setDor_na(Integer.parseInt(rs.getString("DOR")));//�������ƺ�
			StuData.setNatio(rs.getString("NATIO"));//����
			StuData.setPlres(rs.getString("PLRES"));//��סʡ��
			StuData.setPosta(Integer.parseInt(rs.getString("POSTA")));//������ò
			StuData.setStu_br(rs.getString("STU_BR"));//��������
			StuData.setStu_ge(Integer.parseInt(rs.getString("STU_GE")));//�Ա�
			StuData.setId_num(rs.getString("ID_NUM"));//���֤��
			StuData.setStu_na(rs.getString("STU_NA"));//����
			StuData.setStu_id(id);
		}
		catch(Exception e) {
			System.out.println("ѧ��������Ϣ���ݷ����������");
		}
		rs.close();
		stmt.close();
		DBConnection.closeConnection();
		return StuData;
	}
	public TeaData TeaDataInfoQuery(int id) throws SQLException {//��ְ����Ϣ,����ѧ��id��
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
			System.out.println("��ְ����Ϣsql��ѯ������");
		}
		try {
			rs.next();
			Teadata.setTea_em(rs.getString("TEA_EM"));//��ְ������
			Teadata.setTea_na(rs.getString("TEA_NA"));//��ְ������
			Teadata.setTea_ph(rs.getString("TEA_Ph"));//��ְ���绰
			Teadata.setTea_wo(rs.getString("TEA_WO"));//��ְ���칫��
		}
		catch(Exception e) {
			System.out.println("��ְ����Ϣ��ȡ������");
		}
		return Teadata;
	}
	public statusData statusQuery(int id)  throws SQLException {//������Ϣ
		statusData StuData=new statusData();
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select JUD_1,JUD_2,JUD_3 form and student_jud where STU_ID=?");
			stmt.setInt(1,id);
		}
		catch(Exception e){
			System.out.println("������Ϣ����sql����ѯ��������");
		}
		try {
			rs=stmt.executeQuery();
			rs.next();
			StuData.setSta_1(Integer.parseInt(rs.getString("JUD_1")));//���񴦱���
			StuData.setSta_2(Integer.parseInt(rs.getString("JUD_2")));//���ᱨ��
			StuData.setSta_3(Integer.parseInt(rs.getString("JUD_3")));//��챨��
			StuData.setStu_id(id);
		}
		catch(Exception e) {
			System.out.println("������Ϣ���ݷ����������");
		}
		rs.close();
		stmt.close();
		DBConnection.closeConnection();
		return StuData;
	}
	public costData costQuery(int id) throws SQLException {//�ɷ���Ϣ
		costData StuData=new costData();
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select COST_1,COST_2,COST_3,COST_4 from student_cost where STU_ID=?");
			stmt.setInt(1,id);
		}
		catch(Exception e){
			System.out.println("�ɷ���Ϣsql�����ҳ�������");
		}
		try{
			rs=stmt.executeQuery();
			rs.next();
			StuData.setCost_1(Integer.parseInt(rs.getString("COST_1")));//ѧ�ӷѼ��鱾��
			StuData.setCost_2(Integer.parseInt(rs.getString("COST_2")));//���˱��շ�
			StuData.setCost_3(Integer.parseInt(rs.getString("COST_3")));//ˮ������
			StuData.setCost_4(Integer.parseInt(rs.getString("COST_4")));//��������
			StuData.setStu_id(id);
		}
		catch(Exception e){
			System.out.println("�ɷѱ�����Ϣ���ݷ����������");
		}
		rs.close();
		stmt.close();
		DBConnection.closeConnection();
		return StuData;
	}
	public forumData forumQuery(int id) throws SQLException {//��̳��Ϣ
		forumData ForData=new forumData();
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select FOR_IM from forum where FOR_ID=?");
			stmt.setInt(1,id);
		}
		catch(Exception e){
			System.out.println("��̳������Ϣsql�����ҳ�������");
		}
		try {
			rs=stmt.executeQuery();
			rs.next();
			ForData.setFor_id(id);
			ForData.setFor_im(rs.getString("FOR_IM"));
		}
		catch(Exception e) {
			System.out.println("��̳������Ϣ�����������");
		}
		rs.close();
		stmt.close();
		DBConnection.closeConnection();
		return ForData;
	}
	public annData annQuery(int id) throws SQLException {//������Ϣ
		annData AnnData=new annData();
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select ANN_IM from announcement where ANN_ID=?");
			stmt.setInt(1,id);
		}
		catch(Exception e){
			System.out.println("������̳������Ϣsql�����ҳ�������");
		}
		try {
			rs=stmt.executeQuery();
			rs.next();
			AnnData.setAnn_id(id);
			AnnData.setAnn_im(rs.getString("ANN_IM"));
		}
		catch(Exception e) {
			System.out.println("����������Ϣ�����������");
		}
		rs.close();
		stmt.close();
		DBConnection.closeConnection();
		return AnnData;
	}
	public ArrayList<InfoData> allinfoQuery(String Classname) throws SQLException {//һ���༶����ѧ����Ϣ
		ArrayList<InfoData>allstuData =new ArrayList<InfoData>();
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select STU_NA��NATIO��STU_BR��STU_GE��ID_NUM��POSTA��PLRES��STU_ID��DOR��BUI"//����������,�������ڣ��Ա����֤�ţ�������ò����ס��ַ��ѧ�ţ��������ƺţ�����
					+ "from student_inf,build_inf��dormitory_inf��college_inf"
					+ "where student_inf.CLA_ID=class_inf.CLA_ID and student_inf.DOR_ID=dormitory_inf.DOR_ID and dormitory_inf.BUI_ID=build_inf.BUI_ID"
					+ " and CLA_NA=?");
			stmt.setString(1,Classname);
		}
		catch(Exception e){
			System.out.println("��ȡ�༶ѧ��������Ϣsql����������");
		}
		try{
			rs=stmt.executeQuery();
			while(rs.next())
			{
				InfoData StuData=new InfoData();
				StuData.setBui_na(Integer.parseInt(rs.getString("BUI")));//����
				StuData.setStu_id(Integer.parseInt(rs.getString("STU_ID")));//ѧ��
				StuData.setDor_na(Integer.parseInt(rs.getString("DOR")));//�������ƺ�
				StuData.setNatio(rs.getString("NATIO"));//����
				StuData.setPlres(rs.getString("PLRES"));//��סʡ��
				StuData.setPosta(Integer.parseInt(rs.getString("POSTA")));//������ò
				StuData.setStu_br(rs.getString("STU_BR"));//��������
				StuData.setStu_ge(Integer.parseInt(rs.getString("STU_GE")));//�Ա�
				StuData.setId_num(rs.getString("ID_NUM"));//���֤��
				StuData.setStu_na(rs.getString("STU_NA"));//����
				StuData.setCla_na(Classname);//�༶��
				allstuData.add(StuData);
			}
		}
		catch(Exception e){
			System.out.println("��ȡ�༶ѧ��������Ϣ�����������");
		}
		rs.close();
		stmt.close();
		DBConnection.closeConnection();
		return allstuData;
	}
	public ArrayList<statusData> allstatusQuery(String Classname) throws SQLException {//һ���༶ѧ��������Ϣ
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
			System.out.println("��ȡ�༶ѧ��������Ϣsql����������");
		}
		try{
			rs=stmt.executeQuery();
			while(rs.next())
			{
				statusData StuData=new statusData();
				StuData.setSta_1(Integer.parseInt(rs.getString("JUD_1")));//���񴦱���
				StuData.setSta_2(Integer.parseInt(rs.getString("JUD_2")));//���ᱨ��
				StuData.setSta_3(Integer.parseInt(rs.getString("JUD_3")));//��챨��
				StuData.setStu_id(Integer.parseInt(rs.getString("STU_ID")));//ѧ��
				StuData.setStu_name(rs.getString("STU_NA"));//����
				allstuData.add(StuData);
			}
		}
		catch(Exception e){
			System.out.println("��ȡ�༶ѧ��������Ϣ�����������");
		}
		rs.close();
		stmt.close();
		DBConnection.closeConnection();
		return allstuData;
	}
	public ArrayList<costData> allcostQuery(String Classname) throws SQLException {//һ���༶ѧ���ɷ���Ϣ
		ArrayList<costData> allstuData=new ArrayList<costData>();
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select COST_1,COST_2,COST_3,COST_4,STU_ID,STU_NA "
					+ "from student_cost,student_inf,class_inf "
					+ "where student_inf.STU_ID=student_cost.STU_ID and class_inf.CLA_ID=student_inf.CLA_ID"
					+ " and STU_ID=?");
		}
		catch(Exception e){
			System.out.println("��ȡ�༶ѧ���ɷ���Ϣsql����������");
		}
		try{
			rs=stmt.executeQuery();
			while(rs.next())
			{
				costData StuData=new costData();
				StuData.setCost_1(Integer.parseInt(rs.getString("COST_1")));//ѧ�ӷѼ��鱾��
				StuData.setCost_1(Integer.parseInt(rs.getString("COST_2")));//���˱��շ�
				StuData.setCost_1(Integer.parseInt(rs.getString("COST_3")));//ˮ������
				StuData.setCost_1(Integer.parseInt(rs.getString("COST_4")));//��������
				StuData.setStu_id(Integer.parseInt(rs.getString("STU_ID")));//ѧ��
				StuData.setStu_name(rs.getString("STU_NA"));//����
				allstuData.add(StuData);
			}
		} 
		catch(Exception e){
			System.out.println("��ȡ�༶ѧ���ɷ���Ϣ�����������");
		}
		rs.close();
		stmt.close();
		DBConnection.closeConnection();
		return allstuData;
	}
}