package Add_imf;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import Datas.*;
import Cre_imf.*;

@WebServlet("/TeaAdd")
public class TeaAdd extends HttpServlet {//ʧ�����0���ɹ����1
	private static final long serialVersionUID = 1L;
    public TeaAdd() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//����text
		TeaData Teadata=new TeaData();
		CreateIdDB CreateTeaId=new CreateIdDB();
		AddDB PutData = new AddDB();
		Teadata.setTea_em(request.getParameter("tea_em"));//ǰ�˴����ְ������
		Teadata.setTea_na(request.getParameter("tea_name"));//ǰ�˴����ְ������
		Teadata.setTea_ph(request.getParameter("tea_ph"));//ǰ�˴����ְ���绰
		Teadata.setTea_wo(request.getParameter("tea_wo"));//ǰ�˴����ְ���칫��
		Teadata.setTea_po(Integer.parseInt(request.getParameter("tea_po")));//ǰ�˴����ʦְλ)
		try {
			Teadata.setTea_id(CreateTeaId.CreateTeaIdDB());
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		if(PutData.addTea(Teadata)==0||PutData.addTeaAccount(Teadata)==0)//0��ʾ���ʧ��
			out.print("0");
		else
			out.print("1");
		out.flush();
		out.close();
	}
}
