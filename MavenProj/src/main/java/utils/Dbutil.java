package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dbutil {
    Connection con=null;

    public static Connection getCon() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //2.获取连接
        Connection con= DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE"
                ,"SYSTEM"
                ,"123456"
        );
        return con;
    }
    //可变参数
    public static void close(AutoCloseable... closeables){
        for (AutoCloseable closeable : closeables) {
            if (closeable!=null){
                try {
                    closeable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

