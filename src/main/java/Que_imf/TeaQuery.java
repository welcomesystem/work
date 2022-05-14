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

@WebServlet("/TeaQuery")
public class TeaQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TeaQuery() {
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
			TeaData teacher =new TeaData();
			teacher=Query.TeaDataInfoQuery(id);
			String jsonData="[{";
			jsonData+="\"json数据\":\""+teacher.getTea_em()+"\",";//邮箱
			jsonData+="\"json数据\":\""+teacher.getTea_na()+"\",";//姓名
			jsonData+="\"json数据\":\""+teacher.getTea_ph()+"\",";//电话
			jsonData+="\"json数据\":\""+teacher.getTea_wo()+"\",";//工作地址
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
