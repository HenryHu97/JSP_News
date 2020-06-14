package DataBase;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


    public class DBManager {
        private Connection con;
        private Statement sta;
        private ResultSet rs;
        /********************静态块可以提高效率***********/
        static {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        /**
         * 加载驱动程序
         */

        public Connection getConnection(){
**/****1433是你自己的SQLserver端口号(默认是1433)*********/
 **/**************DatabaseName是你要连接的数据库名称*********/
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=News";
            try {
/**第一个sa是你的SQLserver用户名,第二个是此用户名所对应的密码***/
                con = DriverManager.getConnection(url, "sa", "123456");
                sta = con.createStatement();
                System.out.println("链接成功");
            } catch (SQLException e) {
                System.out.println("连接失败");
                e.printStackTrace();
            }

            return con;
        }

    public DataBase(){
        try {
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("connecting...");
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
            if(!connection.isClosed())
                System.out.println("Succeeded connecting to the Database!");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void Clocec(){
        try {
            if (connection != null){
                connection.close();
            }
            else if (preparedStatement !=null){
                preparedStatement.close();
            }
            else if (resultSet != null){
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean login(String name,String psw) throws UnsupportedEncodingException {

        System.out.println("\n\n=======================HANDLING LOGIN\n\n");

        String select = "SELECT * FROM uname_psw WHERE uname = ? AND psw= ? ";
        System.out.println(select);
        boolean bool = false;
        try {
            preparedStatement = connection.prepareStatement(select);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,psw);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                bool = true;
                System.out.println("\n\nUSER EXISTS\n\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bool;
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL,USER,PASS);
    }

    public static ResultSet executeQuery(String SQL){
        try {
            Connection conn=getConnection();
            Statement stmt=conn.createStatement();
            return stmt.executeQuery(SQL);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static boolean executeUpdate(String SQL){
        try {
            Connection conn=getConnection();

            Statement stmt=conn.createStatement();
            int result=stmt.executeUpdate(SQL);
            if(result>0)
                return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
