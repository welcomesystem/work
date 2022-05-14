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
		response.setContentType("text/html;charset=UTF-8");//����text
		PrintWriter out = response.getWriter();
		QueryDB Query =new QueryDB();
		String classname= request.getParameter("");//����༶
		try {
			ArrayList<statusData> status=new ArrayList<statusData>();
			status=Query.allstatusQuery(classname);
			String jsonData="[";
			for(int i=0;i<status.size();i++)
			{
				statusData sta=status.get(i);
				jsonData+="{";
				jsonData+="\"json����\":"+sta.getSta_1()+",";//���񴦱���
				jsonData+="\"json����\":"+sta.getSta_2()+",";//���ᱨ��
				jsonData+="\"json����\":"+sta.getSta_3()+",";//��챨��
				jsonData+="\"json����\":"+sta.getStu_id()+",";//ѧ��
				jsonData+="\"json����\":\""+sta.getStu_name()+"\"";//����
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
