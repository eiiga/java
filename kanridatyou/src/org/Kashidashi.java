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

public class Kashidashi extends HttpServlet {
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
		
			KanriDataDto system = new KanriDataDto();
			ArrayList<KanriDataDto> system_info = KanriDataDAO.getInstance().system_select(system);
	        
	        
	        	User.setAttribute("system_info", system_info);
	            request.getRequestDispatcher("/insert.jsp").forward(request, response);
	        

			
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
	
