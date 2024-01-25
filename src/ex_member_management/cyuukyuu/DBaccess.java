package ex_member_management.cyuukyuu;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBaccess {
    private static final String URL="jdbc:postgresql://localhost:5432/student";
    private static final String NAME ="postgres";
    private static final String PASSWORD="postgres";

    public static Connection createConnection(){
        try{
        Connection connection=DriverManager.getConnection(URL, NAME, PASSWORD);
        return connection;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("DBに接続できませんでした");
        }
    }
    public static void closeConnection(Connection connection){
        try{
            if(connection!=null){
                connection.close();
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("切断できませんでした");
        }
    }
}
