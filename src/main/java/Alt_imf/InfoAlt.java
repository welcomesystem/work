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
		response.setContentType("text/html;charset=UTF-8");//返回text
		PrintWriter out = response.getWriter();
		InfoData StuData = new InfoData();
		AlterDB Alter = new AlterDB();
		StuData.setCla_na(request.getParameter(""));//从前端传入班级
		StuData.setDor_na(Integer.parseInt(request.getParameter("")));//从前端传入宿舍门牌号
		StuData.setNatio(request.getParameter(""));//从前端传入民族
		StuData.setPlres(request.getParameter(""));//从前端传入居住省份
		StuData.setPosta(Integer.parseInt(request.getParameter("")));//从前端传入政治面貌
		StuData.setStu_br(request.getParameter(""));//从前端传入出生日期
		StuData.setStu_ge(Integer.parseInt(request.getParameter("")));//从前端传入性别
		StuData.setId_num(request.getParameter(""));//从前端传入身份证号
		StuData.setStu_na(request.getParameter(""));//从前端传入姓名
		StuData.setStu_id(Integer.parseInt(request.getParameter("")));//从前端传入id
		if(Alter.infoAlt(StuData)==0)//返回0表示成功,1表示失败
			out.print("0");
		else
			out.print("1");
		out.flush();
		out.close();
	}
}
