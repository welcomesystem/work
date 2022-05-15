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
		response.setContentType("text/html;charset=UTF-8");//返回text
		PrintWriter out = response.getWriter();
		costData cost = new costData();
		AlterDB Alter = new AlterDB();
		cost.setStu_id(Integer.parseInt(request.getParameter("")));//学号
		cost.setCost_1(Integer.parseInt(request.getParameter("")));//学杂费及书本费
		cost.setCost_2(Integer.parseInt(request.getParameter("")));//个人保险费
		cost.setCost_3(Integer.parseInt(request.getParameter("")));//水卡费用
		cost.setCost_4(Integer.parseInt(request.getParameter("")));//饭卡费用
		if(Alter.costAlt(cost)==0)//返回0表示成功,1表示失败
			out.print("0");
		else
			out.print("1");
		out.flush();
		out.close();
	}

}
