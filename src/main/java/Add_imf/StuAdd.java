package Add_imf;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import Datas.*;
import Cre_imf.*;

public class StuAdd extends HttpServlet {//ʧ�����0���ɹ����1
	private static final long serialVersionUID = 1L;
    public StuAdd() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		InfoData StuData = new InfoData();
		AddDB PutData = new AddDB();
		CreateIdDB CreateId=new CreateIdDB();
		StuData.setBui_na(Integer.parseInt(request.getParameter("")));//��ǰ�˴��붰��
		StuData.setCla_na(request.getParameter(""));//��ǰ�˴���༶
		StuData.setDor_na(Integer.parseInt(request.getParameter("")));//��ǰ�˴����������ƺ�
		StuData.setNatio(request.getParameter(""));//��ǰ�˴�������
		StuData.setPlres(request.getParameter(""));//��ǰ�˴����סʡ��
		StuData.setPosta(Integer.parseInt(request.getParameter("")));//��ǰ�˴���������ò
		StuData.setStu_br(request.getParameter(""));//��ǰ�˴����������
		StuData.setStu_ge(Integer.parseInt(request.getParameter("")));//��ǰ�˴����Ա�
		StuData.setId_num(request.getParameter(""));//��ǰ�˴������֤��
		StuData.setStu_na(request.getParameter(""));//��ǰ�˴�������
		try {
			StuData.setStu_id(CreateId.CreateStuIdDB(request.getParameter("")));//��ǰ�˴���༶�����ѧ��id��
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		if(PutData.addStu(StuData)==0)
			out.print("0");
		else
			out.print("1");
	}

}
