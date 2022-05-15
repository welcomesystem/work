package Alt_imf;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import Datas.*;

@WebServlet("/PasswdAlt")
public class PasswdAlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PasswdAlt() {
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
		accountData account = new accountData();
		AlterDB Alter = new AlterDB();
		account.setAcc_id(Integer.parseInt(request.getParameter("")));//账号
		account.setAcc_access(Integer.parseInt(request.getParameter("")));//权限
		account.setAcc_passwd(request.getParameter(""));//新密码
		if(Alter.passwdAlt(account)==0)//返回0表示成功,1表示失败
			out.print("0");
		else
			out.print("1");
		out.flush();
		out.close();
	}
}
