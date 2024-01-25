package asobi.DB2asobi;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBmaneger2 {
    private static final String URL="jdbc:postgresql://localhost:5432/student";
    private static final String NAME="postgres";
    private static final String PASSWORD="postgres";
    
public static Connection createConection(){
    try{
        Connection con=DriverManager.getConnection(URL, NAME, PASSWORD);
        return con;
    }catch(Exception e){
        e.printStackTrace();
        throw new RuntimeException("接続エラー");
    }
}

public static void disConect(Connection con){
    try{
        if(con!=null){
            con.close();
        }
    }catch(Exception e){
        e.printStackTrace();
        throw new RuntimeException("接続エラー");
    }
}
}
