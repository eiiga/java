package org;

public class KanriDataDto {
	private int systemID;
	private String systemName;
    private String kashidashiDate;
    private String henkyakuyoteiDate;
    private String henkyakuDate;
    private String userName;
    private String ankenName;
    private int henkyakuFlg;
    
    
    public int getSystemID(){
    	return systemID;
    }
    public void setSystemID(int systemID){
        this.systemID = systemID;
    }
    
    
    public String getSystemName(){
        return systemName;
    }
    public void setSystemName(String systemName){
        this.systemName = systemName;
    }
    
        
    public String getKashidashiDate(){
    	return kashidashiDate;
    }
    public void setKashidashiDate(String kashidashiDate){
        this.kashidashiDate = kashidashiDate;
    }
    

    public String getHenkyakuyoteiDate(){
    	return henkyakuyoteiDate;
    }
    public void setHenkyakuyoteiDate(String henkyakuyoteiDate){
        this.henkyakuyoteiDate = henkyakuyoteiDate;
    }
    
    
    public String getHenkyakuDate(){
    	return henkyakuDate;
    }
    public void setHenkyakuDate(String henkyakuDate){
        this.henkyakuDate = henkyakuDate;
    }
    
    
    public String getUserName(){
    	return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    
    public String getAnkenName(){
    	return ankenName;
    }
    public void setAnkenName(String ankenName){
        this.ankenName = ankenName;
    }
    
    
    public int getHenkyakuFlg(){
    	return henkyakuFlg;
    }
    public void setHenkyakuFlg(int henkyakuFlg){
        this.henkyakuFlg = henkyakuFlg;
    }    
    
    
}
