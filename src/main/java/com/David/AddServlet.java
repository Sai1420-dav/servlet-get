package com.David;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class AddServlet extends HttpServlet{
public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
{
	int id = Integer.parseInt(req.getParameter("id"));
	String Name = req.getParameter("name");
	int age = Integer.parseInt(req.getParameter("age"));
	String driver = "com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/network";
    String user = "root";
    String pwd = "Amma@143";
	try {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,user,pwd);
		String qry = "insert into WebData1 values(?,?,?)";
		PreparedStatement st = con.prepareStatement(qry);
		st.setInt(1,id);
		st.setString(2, Name);
		st.setInt(3,age);		
		int i = st.executeUpdate();
		PrintWriter out = res.getWriter();
		if(i>0) {
		out.println("Data Is Inserted SuccessFully");
			}
		else{
			out.println("Data Is not Inserted");
		}
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
