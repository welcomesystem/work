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
		TeaData Teadata=new TeaData();
		CreateIdDB CreateTeaId=new CreateIdDB();
		AddDB PutData = new AddDB();
		Teadata.setTea_em(request.getParameter(""));//ǰ�˴����ְ������
		Teadata.setTea_na(request.getParameter(""));//ǰ�˴����ְ������
		Teadata.setTea_ph(request.getParameter(""));//ǰ�˴����ְ���绰
		Teadata.setTea_wo(request.getParameter(""));//ǰ�˴����ְ���칫��
		try {
			Teadata.setTea_id(CreateTeaId.CreateTeaIdDB());
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		if(PutData.addTea(Teadata)==0)
			out.print("0");
		else
			out.print("1");
	}
}
