package Que_imf;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import Datas.*;
import java.util.*;

@WebServlet("/ForumCensus")
public class ForumCensus extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ForumCensus() {
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
		QueryDB Query =new QueryDB();
		try {
			ArrayList<forumData> fouData=Query.allforumQuery();
			String jsonData="[";
			for(int i=0;i<fouData.size();i++)
			{
				forumData forum=fouData.get(i);
				jsonData+="{";
				jsonData+="\"json数据\":"+forum.getFor_id()+",";//论坛编号
				jsonData+="\"json数据\":\""+forum.getFor_im()+"\"";//论坛链接
				jsonData+="},";
			}
			out.print(jsonData.substring(0, jsonData.length()-1));
			out.print("]");
			out.flush();
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
