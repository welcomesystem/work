package Add_imf;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import Cre_imf.CreateIdDB;
import Datas.*;

@WebServlet("/ForumAdd")
public class ForumAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ForumAdd() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//返回text
		forumData forum=new forumData();
		AddDB PutData = new AddDB();
		CreateIdDB CreateId=new CreateIdDB();
		forum.setFor_im(request.getParameter(""));//前端传入论坛链接
		try {
			forum.setFor_id(CreateId.CreateForIdDB());//生成论坛id
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		if(PutData.addForum(forum)==0)
			out.print("0");
		else
			out.print("1");
		out.flush();
		out.close();
	}
}
