package tomcat_test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

public class test_sql_conect extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
        Connection db_con = null;
        PreparedStatement  db_st = null;
        ResultSet db_data = null;
        
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","root","");
        db_st = db_con.prepareStatement("select * from M_ID ");
        db_data = db_st.executeQuery();
        while(db_data.next()){
            System.out.print("ID："+db_data.getInt("ID")+"，");
            System.out.print("名前："+db_data.getString("NAME")+"，");
        }
        db_data.close();
        db_st.close();
        db_con.close();
        
	}catch(Exception e_con){
        System.out.println(e_con.getMessage()); 
	}
	}

	    
}

