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
		response.setContentType("text/html;charset=UTF-8");//����text
		PrintWriter out = response.getWriter();
		QueryDB Query =new QueryDB();
		int id=Integer.parseInt(request.getParameter(""));//����ѧ��ѧ��
		try {
			costData cost=new costData();
			cost=Query.costQuery(id);
			String jsonData="[{";
			jsonData+="\"json����\":"+cost.getCost_1()+",";//ѧ�ӷѼ��鱾��
			jsonData+="\"json����\":"+cost.getCost_2()+",";//���˱��շ�
			jsonData+="\"json����\":"+cost.getCost_3()+",";//ˮ������
			jsonData+="\"json����\":"+cost.getCost_4()+",";//��������
			jsonData+="\"json����\":"+cost.getStu_id()+",";//ѧ��
			jsonData+="\"json����\":\""+cost.getStu_name()+"\"";//����
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
