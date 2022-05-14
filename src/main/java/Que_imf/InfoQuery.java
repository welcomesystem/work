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
@WebServlet("/InfoQuery")
public class InfoQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public InfoQuery() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//返回text
		int id=Integer.parseInt(request.getParameter(""));//传入学生学号
		PrintWriter out = response.getWriter();
		QueryDB Query =new QueryDB();
		try {
			InfoData student=new InfoData();
			student=Query.infoQuery(id);//调用查询DB
			String jsonData="[{";
			jsonData+="\"json数据\":"+student.getBui_na()+",";//栋数
			jsonData+="\"json数据\":\""+student.getCla_na()+"\",";//班级名
			jsonData+="\"json数据\":\""+student.getDor_na()+"\",";//宿舍名
			jsonData+="\"json数据\":"+student.getId_num()+",";//身份证号
			jsonData+="\"json数据\":\""+student.getNatio()+"\",";//民族
			jsonData+="\"json数据\":\""+student.getPlres()+"\",";//居住省份
			jsonData+="\"json数据\":"+student.getPosta()+",";//政治面貌
			jsonData+="\"json数据\":\""+student.getStu_br()+"\",";//出生日期
			jsonData+="\"json数据\":"+student.getStu_ge()+",";//性别
			jsonData+="\"json数据\":"+student.getStu_id()+",";//学号
			jsonData+="\"json数据\":\""+student.getStu_na()+"\"";//姓名
			jsonData+="}]";
			out.print(jsonData);//返回前端json数据
			out.flush();
			out.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
}
