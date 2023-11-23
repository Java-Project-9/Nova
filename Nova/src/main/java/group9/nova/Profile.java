/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group9.nova;

/**
 *
 * @author omaro
 */
public class Profile {
   
    private String nickName;
    private Time timeLogin;
    private Time timeLogout;
    private String saveFile;
    
    //add timelogin and timelogout parameters
    //check for repeated nicknames
    public Profile ( String nickName, String saveFile, Time timeLogin, Time timeLogout){
        this.nickName = nickName;
        this. saveFile = saveFile;
        this.timeLogout = timeLogout;
        this.timeLogin  = timeLogin;
    }
    public String getNickName(){return nickName;}
    public void setNickName(String nickName){
        this.nickName = nickName;
    }
    
    /*
    supposed the getLogIn time to be int instead of Time variable
    public int getHourLogin(){return timeLogin.getHour();}
    or 
    public time getLoginTime(){return timeLogin;}
    
    public void setTimeLogin(time timeLogin){this.timeLogin = timeLogin;}
    
    and the same will be for logout
    */
    
    public String getSaveFile(){return saveFile;}
    public void setSaveFile (String saveFile){this.saveFile = saveFile;}
    
    public int timeCalc(){
    return timeLogin.getHour()-timeLogout.getHour();
    }
    
    public void updateSaveFile(String saveFile){
        //suppose to be update not to be replaced so how to add the data in the txt file not replacing
        this.saveFile = saveFile;
    }
    
}
