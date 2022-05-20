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
public class InfoCount extends HttpServlet {//ͳ��ѧ��������Ϣ
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
		response.setContentType("text/html;charset=UTF-8");//����text
		CensusDB Census=new CensusDB();
		int Jud=Integer.parseInt(request.getParameter(""));//�����ѯ����(ϵ��ѧԺ���༶)
		String FindName=request.getParameter("");//�����ѯ����
		PrintWriter out = response.getWriter();
		try {
			out.print(Census.infoCount(Jud, FindName));//���ز�ѯ����
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
