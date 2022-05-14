package Que_imf;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import Datas.*;

@WebServlet("/ForumQuery")
public class ForumQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ForumQuery() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//返回text
		int id=Integer.parseInt(request.getParameter(""));//传入论坛编号
		PrintWriter out = response.getWriter();
		QueryDB Query =new QueryDB();
		try {
			forumData fouData=Query.forumQuery(id);
			String jsonData="[{\"json名称\":\""+fouData.getFor_im()+"\"}]";//放入论坛链接json名称
			out.print(jsonData);
			out.flush();
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
