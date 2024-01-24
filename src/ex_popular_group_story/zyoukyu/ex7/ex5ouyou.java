package ex_popular_group_story.zyoukyu.ex7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ex5ouyou {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/student"; // データベースのURL
        String name = "postgres"; // ユーザー名
        String password = "postgres"; // パスワード

        // SQLクエリ
        String sql = """
                delete from members
                where id in(1,2)
                """;

        // try-with-resourcesを使用してリソースを自動的に閉じる
        try (Connection con = DriverManager.getConnection(url, name, password); // データベース接続
                PreparedStatement pstmt = con.prepareStatement(sql)) { // SQLクエリの準備

            int update = pstmt.executeUpdate(); // SQLクエリの実行
            System.out.println(update + "件削除されました"); // 削除件数の表示

        } catch (Exception e) {
            e.printStackTrace(); // エラーの詳細を表示
        }
    }
}