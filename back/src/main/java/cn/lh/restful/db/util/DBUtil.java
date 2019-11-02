package cn.lh.restful.db.util;


//java文件
import java.nio.file.*;
import java.sql.*;
import java.io.*;
import java.util.*;

public class DBUtil {
    private static Connection connection = null;
    /**
    *创建书表数据库信息
    */
    public static void createTable() {
        Connection conn = getConnection();
        try {
            Statement stat = conn.createStatement();
            if (!isBookSchemaExists(conn)) {
                System.out.println("创建数据开始");
                System.out.println("创建书签信息");
                stat.execute(DBSqlConst.CREATE_BOOK_SQL);
                System.out.println("创建数据库结束");
            }
        }catch (Exception ex){
            System.out.println("创建数据库失败");
            ex.printStackTrace();
        }finally {
            closeConnection();
        }
    }

    private static boolean isBookSchemaExists(Connection con) throws SQLException{
        DatabaseMetaData meta = con.getMetaData();
        ResultSet res = meta.getSchemas(null, null);
        HashSet<String> set=new HashSet<String>();
        while (res.next()) {
            set.add(res.getString("TABLE_SCHEM"));
        }
        System.out.println("All the schemas associated to current connection are :");
        System.out.println(set);
        return set.contains("BOOK");
    }

    /*
    *Gets a connection from the properties specified in the file database.properties.
    *@return the database connection
    */
    private static Connection getConnection(){
        if(connection == null){
            try {
                Properties props = new Properties();
                InputStream in = Files.newInputStream(Paths.get("./conf/database.properties"));
                props.load(in);
                String drivers = props.getProperty("jdbc.drivers");
                if (drivers != null) {
                    Class.forName(drivers).newInstance();
                    String url = props.getProperty("jdbc.url");
                    String username = props.getProperty("jdbc.username");
                    String password = props.getProperty("jdbc.password");
                    connection = DriverManager.getConnection(url, username, password);
                }
            }catch (Exception ex){
                System.out.println("get connection failed.");
                ex.printStackTrace();
            }
        }
        return connection;
    }

    /*
     *Gets a connection from the properties specified in the file database.properties.
     *@return the database connection
     */
    private static void closeConnection(){
        if(connection == null){
            try {
                Properties props = new Properties();
                InputStream in = Files.newInputStream(Paths.get("./conf/database.properties"));
                props.load(in);
                String drivers = props.getProperty("jdbc.drivers");
                if (drivers != null) {
                    Class.forName(drivers).newInstance();
                    String url = props.getProperty("jdbc.url.shutdown");
                    String username = props.getProperty("jdbc.username");
                    String password = props.getProperty("jdbc.password");
                    connection = DriverManager.getConnection(url, username, password);
                }
            }catch (Exception ex){
                System.out.println("close connection failed.");
                ex.printStackTrace();
            }
        }
    }
}