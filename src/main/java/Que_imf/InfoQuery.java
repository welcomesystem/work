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
		response.setContentType("text/html;charset=UTF-8");//����text
		int id=Integer.parseInt(request.getParameter(""));//����ѧ��ѧ��
		PrintWriter out = response.getWriter();
		QueryDB Query =new QueryDB();
		try {
			InfoData student=new InfoData();
			student=Query.infoQuery(id);//���ò�ѯDB
			String jsonData="[{";
			jsonData+="\"json����\":"+student.getBui_na()+",";//����
			jsonData+="\"json����\":\""+student.getCla_na()+"\",";//�༶��
			jsonData+="\"json����\":\""+student.getDor_na()+"\",";//������
			jsonData+="\"json����\":"+student.getId_num()+",";//���֤��
			jsonData+="\"json����\":\""+student.getNatio()+"\",";//����
			jsonData+="\"json����\":\""+student.getPlres()+"\",";//��סʡ��
			jsonData+="\"json����\":"+student.getPosta()+",";//������ò
			jsonData+="\"json����\":\""+student.getStu_br()+"\",";//��������
			jsonData+="\"json����\":"+student.getStu_ge()+",";//�Ա�
			jsonData+="\"json����\":"+student.getStu_id()+",";//ѧ��
			jsonData+="\"json����\":\""+student.getStu_na()+"\"";//����
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
