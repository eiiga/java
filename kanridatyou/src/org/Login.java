package org;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.UserDataDto;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @throws SQLException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF8");
		response.setContentType("text/html; charset=UTF8");
		
		HttpSession User = request.getSession();
		
//		データを変数に代入
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("LoginID");
		String pass = request.getParameter("password");
		
//		UserDataDtoにデータを格納
		UserDataDto data = new UserDataDto();
		data.setUserID(user_id);
		data.setPassword(pass);
		
		UserDataDto dto = UserDataDAO.getInstance().login(data);
		KanriDataDto kanri = new KanriDataDto();
		ArrayList<KanriDataDto> kashidashi_info = KanriDataDAO.getInstance().t_top_select(kanri);
        
        if(dto.getUserID() == null){
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }else{
        	User.setAttribute("userinfo", dto);
        	User.setAttribute("kashidashi_info", kashidashi_info);
            request.getRequestDispatcher("/top.jsp").forward(request, response);
        } 
		
	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	@Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
	
}
