package Que_imf;

import Datas.*;
import DBConnection.*;
import java.sql.*;

import org.apache.catalina.util.ResourceSet;
public class QueryDB {
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	public InfoData infoQuery(int id) throws SQLException {
		InfoData StuData=new InfoData();
		con=DBConnection.getConnection();
		try {
			stmt=con.prepareStatement("select from student_inf,, where STU_ID=?");
			stmt.setInt(1,id);
		}
		catch(Exception e){
			
		}
		try {
			rs=stmt.executeQuery();
			rs.next();
			StuData.setBui_na("");
			StuData.setCla_na();
			StuData.setDor_na();
			StuData.setNatio();
			StuData.setPlres();
			StuData.setPosta();
			StuData.setStu_br();
			StuData.setStu_ge();
			StuData.setStu_br();
			StuData.setStu_ge();
			StuData.setStu_na(rs.getString("STU_NA"));//ªÒ»°–’√˚
		}
		catch(Exception e) {
			
		}
		return StuData;
	}
}
