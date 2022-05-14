package Que_imf;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

import Datas.statusData;
@WebServlet("/StatusCensus")
public class StatusCensus extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StatusCensus() {
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
		String classname= request.getParameter("");//传入班级
		try {
			ArrayList<statusData> status=new ArrayList<statusData>();
			status=Query.allstatusQuery(classname);
			String jsonData="[";
			for(int i=0;i<status.size();i++)
			{
				statusData sta=status.get(i);
				jsonData+="{";
				jsonData+="\"json数据\":"+sta.getSta_1()+",";//教务处报到
				jsonData+="\"json数据\":"+sta.getSta_2()+",";//宿舍报到
				jsonData+="\"json数据\":"+sta.getSta_3()+",";//体检报到
				jsonData+="\"json数据\":"+sta.getStu_id()+",";//学号
				jsonData+="\"json数据\":\""+sta.getStu_name()+"\"";//姓名
				jsonData+="},";
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
