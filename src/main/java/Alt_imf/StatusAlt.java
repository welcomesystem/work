package Alt_imf;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import Datas.*;

@WebServlet("/StatusAlt")
public class StatusAlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StatusAlt() {
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
		statusData status = new statusData();
		AlterDB Alter = new AlterDB();
		status.setStu_id(Integer.parseInt(request.getParameter("")));//学号
		status.setSta_1(Integer.parseInt(request.getParameter("")));//教务处报到
		status.setSta_2(Integer.parseInt(request.getParameter("")));//宿舍报到
		status.setSta_3(Integer.parseInt(request.getParameter("")));//体检报到
		if(Alter.statusAlt(status)==0)//返回0表示成功,1表示失败
			out.print("0");
		else
			out.print("1");
		out.flush();
		out.close();
	}
}
