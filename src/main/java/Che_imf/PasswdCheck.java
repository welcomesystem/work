package Che_imf;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class PasswdCheck extends HttpServlet {//获得账号，密码，返回验证情况，权限
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
		int Id=Integer.parseInt(request.getParameter(""));//获取前端用户输入的id
		int PassWord=Integer.parseInt(request.getParameter(""));//获得前端用户输入的密码
		int Jud=0;
		JudgeDB Get_Jud=new JudgeDB();
		try {
			Jud=Get_Jud.JudgePwdDB(Id,PassWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.print(Jud);//返回权限类型，-1为登录失败
	}
}
