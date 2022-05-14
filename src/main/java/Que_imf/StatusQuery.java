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

@WebServlet("/StatusQuery")
public class StatusQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StatusQuery() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//返回text
		PrintWriter out = response.getWriter();
		QueryDB Query =new QueryDB();
		int id=Integer.parseInt(request.getParameter(""));//传入学生学号
		try {
			statusData status=new statusData();
			status=Query.statusQuery(id);
			String jsonData="[{";
			jsonData+="\"json数据\":"+status.getSta_1()+",";//教务处报到
			jsonData+="\"json数据\":"+status.getSta_2()+",";//宿舍报到
			jsonData+="\"json数据\":"+status.getSta_3()+",";//体检报到
			jsonData+="\"json数据\":"+status.getStu_id()+",";//学号
			jsonData+="\"json数据\":\""+status.getStu_name()+"\"";//姓名
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
