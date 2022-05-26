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

@WebServlet("/StuAdd")
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
		response.setContentType("text/html;charset=UTF-8");//����text
		InfoData StuData = new InfoData();
		AddDB PutData = new AddDB();
		CreateIdDB CreateId=new CreateIdDB();
		StuData.setBui_na(Integer.parseInt(request.getParameter("stu_build")));//��ǰ�˴��붰��
		StuData.setCla_na(request.getParameter("stu_class"));//��ǰ�˴���༶
		StuData.setDor_na(Integer.parseInt(request.getParameter("stu_dormitory")));//��ǰ�˴����������ƺ�
		StuData.setNatio(request.getParameter("national"));//��ǰ�˴�������
		StuData.setPlres(request.getParameter("province")+"ʡ"+request.getParameter("city")+"��");//��ǰ�˴����סʡ��
		StuData.setPosta(Integer.parseInt(request.getParameter("posta")));//��ǰ�˴���������ò
		StuData.setStu_br(request.getParameter("year")+"��"+request.getParameter("month")+"��"+request.getParameter("day")+"��");//��ǰ�˴����������
		StuData.setStu_ge(Integer.parseInt(request.getParameter("sex")));//��ǰ�˴����Ա�
		StuData.setId_num(request.getParameter("stu_id_num"));//��ǰ�˴������֤��
		StuData.setStu_na(request.getParameter("stu_name"));//��ǰ�˴�������
		try {
			StuData.setStu_id(CreateId.CreateStuIdDB(request.getParameter("stu_class")));//��ǰ�˴���༶�����ѧ��id��
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		if(PutData.addStu(StuData)==0||PutData.addStuAccount(StuData)==0)//0��ʾʧ��
			out.print("0");
		else
			out.print("1");
		out.flush();
		out.close();
	}

}
