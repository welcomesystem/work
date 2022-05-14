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
		response.setContentType("text/html;charset=UTF-8");//����text
		PrintWriter out = response.getWriter();
		QueryDB Query =new QueryDB();
		int id=Integer.parseInt(request.getParameter(""));//����ѧ��ѧ��
		try {
			statusData status=new statusData();
			status=Query.statusQuery(id);
			String jsonData="[{";
			jsonData+="\"json����\":"+status.getSta_1()+",";//���񴦱���
			jsonData+="\"json����\":"+status.getSta_2()+",";//���ᱨ��
			jsonData+="\"json����\":"+status.getSta_3()+",";//��챨��
			jsonData+="\"json����\":"+status.getStu_id()+",";//ѧ��
			jsonData+="\"json����\":\""+status.getStu_name()+"\"";//����
			jsonData+="}]";
			out.print(jsonData);//����ǰ��json����
			out.flush();
			out.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
