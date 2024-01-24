package ex_popular_group_story.zyoukyu.ex7;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// ex2ouyouクラスの定義
public class ex2ouyou {
    public static void main(String[] args) {
        // データベース接続情報
        String url="jdbc:postgresql://localhost:5432/student";
        String name="postgres";
        String password="postgres";

        // データベースへの接続を試みる
        try (Connection con = DriverManager.getConnection(url, name, password)) {
            con.setAutoCommit(false); // 自動コミットを無効にする
        
            // SQL文の定義
            String sql = """
                insert into colors(id,name)
                values(1,'blue'),
                (2,'red'),
                (3,'green'),
                (4,'yellow'),
                (5,'purple'),
                (6,'orange');

                insert into members(name,birth_day,gender,color_id)
                values('大野智','1980-11-26','男',1),
                ('櫻井翔','1982-1-25','男',2),
                ('相葉雅紀','1982-12-24','男',3),
                ('二宮和也','1983-6-17','男',4),
                ('松本潤','1983-8-30','男',5);
                """;
            // PreparedStatementの作成と実行
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                int update = pstmt.executeUpdate();
                con.commit(); // すべての変更をコミットする
                System.out.println(update + "件追加されました");
            } catch (SQLException e) {
                con.rollback(); // エラーが発生した場合はロールバックする
                throw e;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}