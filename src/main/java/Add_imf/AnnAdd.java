package Add_imf;

import jakarta.servlet.ServletException; 
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import Cre_imf.CreateIdDB;
import Datas.*;

public class AnnAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AnnAdd() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		annData ann=new annData();
		AddDB PutData = new AddDB();
		CreateIdDB CreateId=new CreateIdDB();
		ann.setAnn_im(request.getParameter(""));//前端传入公告链接
		try {
			ann.setAnn_id(CreateId.CreateAnnIdDB());//生成论坛id
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		if(PutData.addAnn(ann)==0)
			out.print("0");
		else
			out.print("1");
	}
}
