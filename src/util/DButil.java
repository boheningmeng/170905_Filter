package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by LENOVO on 2017/9/5.
 */
public class DButil {
    static  String ip = "127.0.0.1";
    static int port = 3306 ;
    static String database = "blog";
    static String encoding = "UTF-8";
    static String loginName = "root" ;
    static String password = "root";

    static {
        try  {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException{
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s",ip,port,database,encoding);
        return DriverManager.getConnection(url,loginName,password);
    }
}
