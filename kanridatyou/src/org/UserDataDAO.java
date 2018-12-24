package org;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDataDAO {
	
	public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
	

    public UserDataDto login(UserDataDto ud) throws SQLException{
    Connection con = null;
    PreparedStatement st = null;
    try{
        con = DBManager.getConnection();
        st =  con.prepareStatement("select * from M_USER where USER_ID = ? and PASSWORD = ?");
        st.setString(1, ud.getUserID());
        st.setString(2, ud.getPassword());
        ResultSet rs = st.executeQuery();
        
        UserDataDto uddto = new UserDataDto();
        
        while(rs.next()){
            uddto.setUserID(rs.getString(1));
            uddto.setPassword(rs.getString(2));
            uddto.setUserName(rs.getString(3));
        }            
        System.out.println("insert completed");
        
        return uddto;
        
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
