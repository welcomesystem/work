package Que_imf;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import Datas.*;

@WebServlet("/CostCensus")
public class CostCensus extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CostCensus() {
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
			ArrayList<costData> cost=new ArrayList<costData>();
			cost=Query.allcostQuery(classname);
			String jsonData="[";
			for(int i=0;i<cost.size();i++)
			{
				costData co=cost.get(i);
				jsonData+="{";
				jsonData+="\"json数据\":"+co.getCost_1()+",";//学杂费及书本费
				jsonData+="\"json数据\":"+co.getCost_2()+",";//个人保险费
				jsonData+="\"json数据\":"+co.getCost_3()+",";//水卡费用
				jsonData+="\"json数据\":"+co.getCost_4()+",";//饭卡费用
				jsonData+="\"json数据\":"+co.getStu_id()+",";//学号
				jsonData+="\"json数据\":\""+co.getStu_name()+"\"";//姓名
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
