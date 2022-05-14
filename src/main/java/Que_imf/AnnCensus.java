package Que_imf;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import Datas.*;

@WebServlet("/AnnCensus")
public class AnnCensus extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AnnCensus() {
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
			ArrayList<annData> AnnData=Query.allannQuery();
			String jsonData="[";
			for(int i=0;i<AnnData.size();i++)
			{
				annData Ann=AnnData.get(i);
				jsonData+="{";
				jsonData+="\"json数据\":"+Ann.getAnn_id()+",";//公告编号
				jsonData+="\"json数据\":\""+Ann.getAnn_im()+"\"";//公告链接
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
