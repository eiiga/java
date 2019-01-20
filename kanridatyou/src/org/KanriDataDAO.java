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
        System.out.println("select completed");
        
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
    
    public ArrayList<KanriDataDto> system_select(KanriDataDto kanri) throws SQLException{
    Connection con = null;
    PreparedStatement st = null;
    try{
        con = DBManager.getConnection();
        st =  con.prepareStatement("select * from M_SYSTEM_NAME;");
        ResultSet rs = st.executeQuery();
        
        KanriDataDto kanridto = new KanriDataDto();
        ArrayList<KanriDataDto> system_info = new ArrayList<KanriDataDto>();
        
        while(rs.next()){
            kanridto.setSystemID(rs.getInt(1));
            kanridto.setSystemName(rs.getString(2));
            system_info.add(kanridto);
            kanridto = new KanriDataDto();
        }            
        System.out.println("select completed");
        
        return system_info;
        
    }catch(SQLException e){
        System.out.println(e.getMessage());
        throw new SQLException(e);
    }finally{
        if(con != null){
            con.close();
        }
    }
    }
    

    public void system_insert(KanriDataDto kd) throws SQLException{
     Connection con = null;
     PreparedStatement st = null;
     try{
         con = DBManager.getConnection();
         st =  con.prepareStatement("insert into T_KANRI(SYSTEM_NO, KASHIDASHI_DATE, HENKYAKU_YOTEI_DATE, HENKYAKU_DATE, USER_NAME, ANKEN_NAME, HENKYAKU_FLG)values(?, ?, ?, ?, ?, ?, ?);");
         st.setInt(1, kd.getSystemID());
         st.setString(2, kd.getKashidashiDate());
         st.setString(3, kd.getHenkyakuyoteiDate());
         st.setString(4, "");
         st.setString(5, kd.getUserName());
         st.setString(6, kd.getAnkenName());
         st.setInt(7, 0);
         st.executeUpdate();
         System.out.println("insert completed");
         
     }catch(SQLException e){
         System.out.println(e.getMessage());
         throw new SQLException(e);
     }finally{
         if(con != null){
             con.close();
         }
     }
    }
    
    public void update(KanriDataDto kd) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("UPDATE T_KANRI SET SYSTEM_NO = ?, HENKYAKU_YOTEI_DATE = ?, USER_NAME = ?, ANKEN_NAME = ? WHERE HENKYAKU_FLG = ? AND KASHIDASHI_DATE = ?;");
            st.setInt(1, kd.getSystemID());
            st.setString(2, kd.getHenkyakuyoteiDate());
            st.setString(3, kd.getUserName());
            st.setString(4, kd.getAnkenName());
            st.setInt(5, 0);
            st.setString(6, kd.getKashidashiDate());
            st.executeUpdate();
            System.out.println("update completed");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
       }
    
    public KanriDataDto select_system_no(KanriDataDto kanri) throws SQLException{
    Connection con = null;
    PreparedStatement st = null;
    try{
        con = DBManager.getConnection();
        st =  con.prepareStatement("select SYSTEM_NO from M_SYSTEM_NAME where SYSTEM_NAME = ?;");
        st.setString(1, kanri.getSystemName());
        ResultSet rs = st.executeQuery();
        
        KanriDataDto system_no = new KanriDataDto();
        
        while(rs.next()){
        	system_no.setSystemID(rs.getInt(1));
        }            
        System.out.println("select completed");
        
        return system_no;
        
    }catch(SQLException e){
        System.out.println(e.getMessage());
        throw new SQLException(e);
    }finally{
        if(con != null){
            con.close();
        }
        
    }
    }
    
    public void henkyaku(KanriDataDto kd) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("UPDATE T_KANRI SET HENKYAKU_DATE = ?, HENKYAKU_FLG = ? WHERE SYSTEM_NO = ? AND KASHIDASHI_DATE = ?;");
            st.setString(1, kd.getHenkyakuDate());
            st.setInt(2, 1);
            st.setInt(3, kd.getSystemID());
            st.setString(4, kd.getKashidashiDate());
            st.executeUpdate();
            System.out.println("update completed");
            
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
