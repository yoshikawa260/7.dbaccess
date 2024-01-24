// データベースの作成
package ex_popular_group_story.zyoukyu.ex7;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ex1ouyou {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/student"; // データベースのURL
        String name = "postgres"; // ユーザー名
        String password = "postgres"; // パスワード

        // SQLクエリ
        String sql = """
                drop table  if exists colors cascade;
                create table colors(id integer primary key,name text);

                drop table if exists members cascade;
                create table members(id serial primary key,name text not null,birth_day date,gender varchar(1),color_id integer references colors(id));
                """;

        // try-with-resourcesを使用してリソースを自動的に閉じる
        try (Connection con = DriverManager.getConnection(url, name, password); // データベース接続
             PreparedStatement pstmt = con.prepareStatement(sql)) { // SQLクエリの準備

            con.setAutoCommit(false); // 自動コミットを無効にする
            pstmt.executeUpdate(); // SQLクエリの実行
            con.commit(); // すべての変更をコミットする

            System.out.println("テーブルが作成されました"); // メッセージの表示

        } catch (Exception e) {
            e.printStackTrace(); // エラーの詳細を表示
        }
    }
}