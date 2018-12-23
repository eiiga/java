package tomcat_test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tomcat_test.datadto;

public class test_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF8");
		response.setContentType("text/html; charset=UTF8");
		
//		データを変数に代入
		String name = request.getParameter("name");
		
//		datadtoにデータを格納
		datadto data = new datadto();
		data.SetWord(name);
		request.setAttribute("Data", data);
					
//		result_test.jspにデータを送る
		RequestDispatcher rd = request.getRequestDispatcher("result_test.jsp");
        	rd.forward(request, response);

	}
}