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

public class TeaAdd extends HttpServlet {//失败输出0，成功输出1
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
		Teadata.setTea_em(request.getParameter(""));//前端传入教职工邮箱
		Teadata.setTea_na(request.getParameter(""));//前端传入教职工姓名
		Teadata.setTea_ph(request.getParameter(""));//前端传入教职工电话
		Teadata.setTea_wo(request.getParameter(""));//前端传入教职工办公室
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
