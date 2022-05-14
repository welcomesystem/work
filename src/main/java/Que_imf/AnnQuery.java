package Que_imf;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import Datas.annData;

@WebServlet("/AnnQuery")
public class AnnQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AnnQuery() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//返回text
		int id=Integer.parseInt(request.getParameter(""));//传入公告编号
		PrintWriter out = response.getWriter();
		QueryDB Query =new QueryDB();
		try {
			annData AnnData=Query.annQuery(id);
			String jsonData="[{\"json名称\":\""+AnnData.getAnn_im()+"\"}]";//放入公告链接json名称
			out.print(jsonData);
			out.flush();
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
