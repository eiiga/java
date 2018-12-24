package org;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KanriDataDAO {

	public static KanriDataDAO getInstance(){
        return new KanriDataDAO();
    }
	

    public ArrayList<KanriDataDto> t_top_select(KanriDataDto kanri) throws SQLException{
    Connection con = null;
    PreparedStatement st = null;
    try{
        con = DBManager.getConnection();
        st =  con.prepareStatement("select A.SYSTEM_NAME, B.KASHIDASHI_DATE, B.HENKYAKU_YOTEI_DATE, B.USER_NAME, B.ANKEN_NAME from M_SYSTEM_NAME as A inner join T_KANRI as B on A.SYSTEM_NO = B.SYSTEM_NO Where B.HENKYAKU_FLG = ?;");
        st.setInt(1, kanri.getHenkyakuFlg());
        ResultSet rs = st.executeQuery();
        
        KanriDataDto kanridto = new KanriDataDto();
        ArrayList<KanriDataDto> kashidashi_info = new ArrayList<KanriDataDto>();
        
        while(rs.next()){
            kanridto.setSystemName(rs.getString(1));
            kanridto.setKashidashiDate(rs.getString(2));
            kanridto.setHenkyakuyoteiDate(rs.getString(3));
            kanridto.setUserName(rs.getString(4));
            kanridto.setAnkenName(rs.getString(5));
            kashidashi_info.add(kanridto);
            kanridto = new KanriDataDto();
        }            
        System.out.println("insert completed");
        
        return kashidashi_info;
        
    }catch(SQLException e){
        System.out.println(e.getMessage());
        throw new SQLException(e);
    }finally{
        if(con != null){
            con.close();
        }
    }
    
    }
}
