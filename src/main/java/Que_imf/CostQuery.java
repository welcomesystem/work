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
@WebServlet("/CostQuery")
public class CostQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CostQuery() {
        super();
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
			costData cost=new costData();
			cost=Query.costQuery(id);
			String jsonData="[{";
			jsonData+="\"json数据\":"+cost.getCost_1()+",";//学杂费及书本费
			jsonData+="\"json数据\":"+cost.getCost_2()+",";//个人保险费
			jsonData+="\"json数据\":"+cost.getCost_3()+",";//水卡费用
			jsonData+="\"json数据\":"+cost.getCost_4()+",";//饭卡费用
			jsonData+="\"json数据\":"+cost.getStu_id()+",";//学号
			jsonData+="\"json数据\":\""+cost.getStu_name()+"\"";//姓名
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
