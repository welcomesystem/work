package Alt_imf;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import Datas.*;

@WebServlet("/InfoAlt")
public class InfoAlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public InfoAlt() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");//����text
		PrintWriter out = response.getWriter();
		InfoData StuData = new InfoData();
		AlterDB Alter = new AlterDB();
		StuData.setCla_na(request.getParameter(""));//��ǰ�˴���༶
		StuData.setDor_na(Integer.parseInt(request.getParameter("")));//��ǰ�˴����������ƺ�
		StuData.setNatio(request.getParameter(""));//��ǰ�˴�������
		StuData.setPlres(request.getParameter(""));//��ǰ�˴����סʡ��
		StuData.setPosta(Integer.parseInt(request.getParameter("")));//��ǰ�˴���������ò
		StuData.setStu_br(request.getParameter(""));//��ǰ�˴����������
		StuData.setStu_ge(Integer.parseInt(request.getParameter("")));//��ǰ�˴����Ա�
		StuData.setId_num(request.getParameter(""));//��ǰ�˴������֤��
		StuData.setStu_na(request.getParameter(""));//��ǰ�˴�������
		StuData.setStu_id(Integer.parseInt(request.getParameter("")));//��ǰ�˴���id
		if(Alter.infoAlt(StuData)==0)//����0��ʾ�ɹ�,1��ʾʧ��
			out.print("0");
		else
			out.print("1");
		out.flush();
		out.close();
	}
}
