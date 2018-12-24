package org;

public class JumsHelper {
    //トップへのリンクを定数として設定
    private final String homeURL = "http://localhost:8080/kanridatyou/top.jsp";
    private final String LogoutURL = "http://localhost:8080/kanridatyou/login.jsp";
    
    public static JumsHelper getInstance(){
        return new JumsHelper();
    }
    //トップへのリンクを返却
    public String home(){
        return "<a href=\""+homeURL+"\">トップへ戻る</a>";
    } 
  //トップへのリンクを返却
    public String Logout(){
        return "<a href=\""+LogoutURL+"\">ログアウト</a>";
    } 
}
