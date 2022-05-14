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
import java.util.*;
@WebServlet("/InfoCensus")
public class InfoCensus extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public InfoCensus() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//����text
		String clasname=request.getParameter("");//����༶����
		PrintWriter out = response.getWriter();
		QueryDB Query =new QueryDB();
		try {
			ArrayList<InfoData> student =new ArrayList<InfoData>();
			student=Query.allinfoQuery(clasname);
			String jsonData="[";
			for(int i=0;i<student.size();i++)
			{
				InfoData stu=student.get(i);
				jsonData+="{";
				jsonData+="\"json����\":"+stu.getBui_na()+",";//����
				jsonData+="\"json����\":\""+stu.getCla_na()+"\",";//�༶��
				jsonData+="\"json����\":\""+stu.getDor_na()+"\",";//������
				jsonData+="\"json����\":"+stu.getId_num()+",";//���֤��
				jsonData+="\"json����\":\""+stu.getNatio()+"\",";//����
				jsonData+="\"json����\":\""+stu.getPlres()+"\",";//��סʡ��
				jsonData+="\"json����\":"+stu.getPosta()+",";//������ò
				jsonData+="\"json����\":\""+stu.getStu_br()+"\",";//��������
				jsonData+="\"json����\":"+stu.getStu_ge()+",";//�Ա�
				jsonData+="\"json����\":"+stu.getStu_id()+",";//ѧ��
				jsonData+="\"json����\":\""+stu.getStu_na()+"\"},";//����
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
