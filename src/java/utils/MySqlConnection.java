/*
 * MySqlConnection.java
 *
 * Created on 12 Ноябрь 2007 г., 23:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils;

/**
 *
 * @author jeen
 */

import java.sql.Connection;
//import java.sql.Statement;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlConnection {
    
    private Properties prop;
    //private String dsUrl="jdbc:mysql://localhost/psychological?user="+user+"&password="+password+"&useUnicode=true&characterEncoding=utf8";
    //private String dsUrl="jdbc:mysql://192.168.0.3:3306/bulletin";
    private String dsUrl="jdbc:mysql://localhost:3306/bulletin";
    private String password;
    private String user;
    public Connection connection=null;
    
    /** Creates a new instance of MySqlConnection */
    public MySqlConnection() {
        init();
    }
    @Override
    protected void finalize(){
        if(this.connection!=null) close();
    }
    
    public int close(){
        int result=0;
        try{
            if(!this.connection.isClosed()) this.connection.close();
            /*if(this.connection.isClosed()) this.connection=null;*/
        }
        catch(SQLException ex){
            this.error=ex.getMessage();
            this.errorCode=-2;
            /*this.connection=null;*/
            result=this.errorCode;
        }finally{
            this.connection=null;
        }
        return result;
    }
    
    public int init(){
        int result=0;
        prop = new Properties();
        prop.setProperty("user",user);
        prop.setProperty("password",password);
        prop.setProperty("useUnicode","true");
        prop.setProperty("characterEncoding","UTF-8");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection=DriverManager.getConnection(dsUrl,prop);
            //this.connection=DriverManager.getConnection(dsUrl);
            this.errorCode=result;
        }
        catch(Exception ex){
            result=-1;
            System.err.println("Error init application. Can't load Mysql Driver");
            System.err.println(ex.getMessage());
            this.error="Error init application. Can't load Mysql Driver "+ex.getMessage();
            this.errorCode=result;
        }
        return result;
    }

    /**
     * Holds value of property error.
     */
    private String error="";

    /**
     * Getter for property error.
     * @return Value of property error.
     */
    public String getError() {
        return this.error;
    }

    /**
     * Holds value of property errorCode.
     */
    private int errorCode=0;

    /**
     * Getter for property errorCode.
     * @return Value of property errorCode.
     */
    public int getErrorCode() {
        return this.errorCode;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setUser(String user){
        this.user=user;
    }
}
