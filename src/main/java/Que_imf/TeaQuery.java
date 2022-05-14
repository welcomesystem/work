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
		response.setContentType("text/html;charset=UTF-8");//����text
		int id=Integer.parseInt(request.getParameter(""));//����ѧ��ѧ��
		PrintWriter out = response.getWriter();
		QueryDB Query =new QueryDB();
		try {
			TeaData teacher =new TeaData();
			teacher=Query.TeaDataInfoQuery(id);
			String jsonData="[{";
			jsonData+="\"json����\":\""+teacher.getTea_em()+"\",";//����
			jsonData+="\"json����\":\""+teacher.getTea_na()+"\",";//����
			jsonData+="\"json����\":\""+teacher.getTea_ph()+"\",";//�绰
			jsonData+="\"json����\":\""+teacher.getTea_wo()+"\",";//������ַ
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
