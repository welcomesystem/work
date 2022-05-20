package Cen_imf;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/InfoCount")
public class InfoCount extends HttpServlet {//统计学生基本信息
	private static final long serialVersionUID = 1L;
    public InfoCount() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//返回text
		CensusDB Census=new CensusDB();
		int Jud=Integer.parseInt(request.getParameter(""));//传入查询对象(系，学院，班级)
		String FindName=request.getParameter("");//传入查询对象
		PrintWriter out = response.getWriter();
		try {
			out.print(Census.infoCount(Jud, FindName));//返回查询人数
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
