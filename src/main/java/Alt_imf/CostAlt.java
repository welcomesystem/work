package Alt_imf;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import Datas.*;

@WebServlet("/CostAlt")
public class CostAlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CostAlt() {
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
		costData cost = new costData();
		AlterDB Alter = new AlterDB();
		cost.setStu_id(Integer.parseInt(request.getParameter("")));//ѧ��
		cost.setCost_1(Integer.parseInt(request.getParameter("")));//ѧ�ӷѼ��鱾��
		cost.setCost_2(Integer.parseInt(request.getParameter("")));//���˱��շ�
		cost.setCost_3(Integer.parseInt(request.getParameter("")));//ˮ������
		cost.setCost_4(Integer.parseInt(request.getParameter("")));//��������
		if(Alter.costAlt(cost)==0)//����0��ʾ�ɹ�,1��ʾʧ��
			out.print("0");
		else
			out.print("1");
		out.flush();
		out.close();
	}

}
