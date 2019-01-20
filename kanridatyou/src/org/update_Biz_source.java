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

/**
 * Servlet implementation class update_Biz_source
 */
@WebServlet("/update_Biz_source")
public class update_Biz_source extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF8");
		request.setCharacterEncoding("UTF-8");
	
		//	データを変数に代入
	int num = Integer.parseInt(request.getParameter("check"));
	String update_flg = request.getParameter("update");
	String return_flg = request.getParameter("return");
	
	KanriDataDto kanri = new KanriDataDto();
	ArrayList<KanriDataDto> kashidashi_info = KanriDataDAO.getInstance().t_top_select(kanri);

	request.setAttribute("resultData", kashidashi_info);
	request.setAttribute("num", num);
	
	HttpSession User = request.getSession();
	
	KanriDataDto system = new KanriDataDto();
	ArrayList<KanriDataDto> system_info = KanriDataDAO.getInstance().system_select(system);
    
    
    User.setAttribute("system_info", system_info);


	if(return_flg == null) {
		request.getRequestDispatcher("/update.jsp").forward(request, response);
	}
	else if(update_flg == null) {
		request.getRequestDispatcher("/henkyaku.jsp").forward(request, response);
	}
	
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
