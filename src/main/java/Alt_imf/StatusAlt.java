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
		response.setContentType("text/html;charset=UTF-8");//����text
		PrintWriter out = response.getWriter();
		statusData status = new statusData();
		AlterDB Alter = new AlterDB();
		status.setStu_id(Integer.parseInt(request.getParameter("")));//ѧ��
		status.setSta_1(Integer.parseInt(request.getParameter("")));//���񴦱���
		status.setSta_2(Integer.parseInt(request.getParameter("")));//���ᱨ��
		status.setSta_3(Integer.parseInt(request.getParameter("")));//��챨��
		if(Alter.statusAlt(status)==0)//����0��ʾ�ɹ�,1��ʾʧ��
			out.print("0");
		else
			out.print("1");
		out.flush();
		out.close();
	}
}
