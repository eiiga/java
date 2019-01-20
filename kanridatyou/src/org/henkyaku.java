package org;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class henkyaku
 */
@WebServlet("/henkyaku")
public class henkyaku extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF8");
		request.setCharacterEncoding("UTF-8");
	
		String system_name = request.getParameter("system_name");
		String kashidashi_date = request.getParameter("kashidashi_date");
		String henkyaku_yoteibi = request.getParameter("henkyaku_yoteibi");
		String henkyaku_date = request.getParameter("henkyaku_date");
		String ankenmei = request.getParameter("ankenmei");
		String user_name = request.getParameter("user_name");
		
//		KanriDataDtoにデータを格納
		KanriDataDto data = new KanriDataDto();
		data.setSystemName(system_name);
		data.setKashidashiDate(kashidashi_date);
		data.setHenkyakuyoteiDate(henkyaku_yoteibi);
		data.setHenkyakuDate(henkyaku_date);
		data.setAnkenName(ankenmei);
		data.setUserName(user_name);
		
		KanriDataDto sysID = KanriDataDAO.getInstance().select_system_no(data);
		
		data.setSystemID(sysID.getSystemID());
		
		KanriDataDAO.getInstance().henkyaku(data);
        
        request.getRequestDispatcher("/top.jsp").forward(request, response);

	
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
