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

public class StuAdd extends HttpServlet {//失败输出0，成功输出1
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
		StuData.setBui_na(Integer.parseInt(request.getParameter("")));//从前端传入栋数
		StuData.setCla_na(request.getParameter(""));//从前端传入班级
		StuData.setDor_na(Integer.parseInt(request.getParameter("")));//从前端传入宿舍门牌号
		StuData.setNatio(request.getParameter(""));//从前端传入民族
		StuData.setPlres(request.getParameter(""));//从前端传入居住省份
		StuData.setPosta(Integer.parseInt(request.getParameter("")));//从前端传入政治面貌
		StuData.setStu_br(request.getParameter(""));//从前端传入出生日期
		StuData.setStu_ge(Integer.parseInt(request.getParameter("")));//从前端传入性别
		StuData.setId_num(request.getParameter(""));//从前端传入身份证号
		StuData.setStu_na(request.getParameter(""));//从前端传入姓名
		try {
			StuData.setStu_id(CreateId.CreateStuIdDB(request.getParameter("")));//从前端传入班级名获得学生id号
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
