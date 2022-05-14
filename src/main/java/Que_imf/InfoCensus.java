package Que_imf;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import Datas.*;
import java.util.*;
@WebServlet("/InfoCensus")
public class InfoCensus extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public InfoCensus() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//返回text
		String clasname=request.getParameter("");//传入班级名称
		PrintWriter out = response.getWriter();
		QueryDB Query =new QueryDB();
		try {
			ArrayList<InfoData> student =new ArrayList<InfoData>();
			student=Query.allinfoQuery(clasname);
			String jsonData="[";
			for(int i=0;i<student.size();i++)
			{
				InfoData stu=student.get(i);
				jsonData+="{";
				jsonData+="\"json数据\":"+stu.getBui_na()+",";//栋数
				jsonData+="\"json数据\":\""+stu.getCla_na()+"\",";//班级名
				jsonData+="\"json数据\":\""+stu.getDor_na()+"\",";//宿舍名
				jsonData+="\"json数据\":"+stu.getId_num()+",";//身份证号
				jsonData+="\"json数据\":\""+stu.getNatio()+"\",";//民族
				jsonData+="\"json数据\":\""+stu.getPlres()+"\",";//居住省份
				jsonData+="\"json数据\":"+stu.getPosta()+",";//政治面貌
				jsonData+="\"json数据\":\""+stu.getStu_br()+"\",";//出生日期
				jsonData+="\"json数据\":"+stu.getStu_ge()+",";//性别
				jsonData+="\"json数据\":"+stu.getStu_id()+",";//学号
				jsonData+="\"json数据\":\""+stu.getStu_na()+"\"},";//姓名
			}
			out.print(jsonData.substring(0, jsonData.length()-1));
			out.print("]");
			out.flush();
			out.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
}
