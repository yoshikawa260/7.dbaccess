package ex_popular_group_story.zyoukyu.ex7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ex3ouyou {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/student"; // データベースのURL
        String name = "postgres"; // ユーザー名
        String password = "postgres"; // パスワード

        // SQLクエリ
        String sql = """
                select m.id id,m.name 名前,m.birth_day 誕生日,m.gender 性別,m.color_id 色のID,c.id 色id,c.name 色の名前
                from members m
                join colors c
                on m.color_id=c.id;
                """;

        // try-with-resourcesを使用してリソースを自動的に閉じる
        try (Connection con = DriverManager.getConnection(url, name, password); // データベース接続
                PreparedStatement pstmt = con.prepareStatement(sql); // SQLクエリの準備
                ResultSet rs = pstmt.executeQuery()) { // SQLクエリの実行

            // 結果セットの処理
            while (rs.next()) {
                String memberName = rs.getString("名前"); // 名前の取得
                String birthDay = rs.getString("誕生日"); // 誕生日の取得
                String gender = rs.getString("性別"); // 性別の取得
                String colorName = rs.getString("色の名前"); // 色の名前の取得

                // 名前、誕生日、性別、色の名前を表示
                System.out.print(memberName);
                System.out.print(" " + birthDay);
                System.out.print(" " + gender);
                System.out.print(" " + colorName);
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace(); // エラーの詳細を表示
        }
    }
}