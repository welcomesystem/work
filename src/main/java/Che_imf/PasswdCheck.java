package Che_imf;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class PasswdCheck extends HttpServlet {//����˺ţ����룬������֤�����Ȩ��
	private static final long serialVersionUID = 1L;
    public PasswdCheck() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int Id=Integer.parseInt(request.getParameter(""));//��ȡǰ���û������id
		int PassWord=Integer.parseInt(request.getParameter(""));//���ǰ���û����������
		int Jud=0;
		JudgeDB Get_Jud=new JudgeDB();
		try {
			Jud=Get_Jud.JudgePwdDB(Id,PassWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.print(Jud);//����Ȩ�����ͣ�-1Ϊ��¼ʧ��
	}
}
