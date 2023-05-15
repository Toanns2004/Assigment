package com.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection()throws Exception{
        Connection conn = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=java","sa","12345678");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
