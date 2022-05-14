package Del_imf;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/StuDel")
public class StuDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StuDel() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//返回text
		int id=Integer.parseInt(request.getParameter(""));//传入公告编号
		DeleteDB Del =new DeleteDB();
		PrintWriter out = response.getWriter();
		out.print(Del.stuDel(id));//返回前端，成功0，失败1
		out.flush();
		out.close();
	}
}
