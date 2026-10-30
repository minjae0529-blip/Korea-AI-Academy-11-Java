package com.korai.serveltstudy2.model.repository;

import com.korai.serveltstudy2.database.DatabaseProvider;
import com.korai.serveltstudy2.entity.Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuRepository implements Repository<Menu> {
    private static MenuRepository instance;
    private DatabaseProvider databaseProvider;

    // 1. 매개변수 제거 (또는 DatabaseProvider를 받아서 this.databaseProvider = databaseProvider; 로 작성)
    private MenuRepository() {
        this.databaseProvider = DatabaseProvider.getInstance();
    }

    // 2. return instance; 를 if문 밖으로 이동
    public static MenuRepository getInstance() {
        if (instance == null) {
            instance = new MenuRepository();
        }
        return instance;
    }

    @Override
    public List<Menu> findAll() {
        List<Menu> menus = new ArrayList<>();

        String sql = """
                select
                    *
                from
                    menus
                """;

        try{
            ResultSet rs =select(databaseProvider.getConnection(), sql);
            while(rs.next()){
                menus.add(new Menu(
                        rs.getInt("menu_id"),
                        rs.getInt("restaurant_id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        rs.getBoolean("is_signature"),
                        rs.getBoolean("is_sold_out")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        // 3. prepareStatement(sql) 에 쿼리 전달
        try (Connection conn = databaseProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Menu menu = new Menu(
                        rs.getInt("menu_id"),
                        rs.getInt("restaurant_id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        rs.getBoolean("is_signature"),
                        rs.getBoolean("is_sold_out")
                );
                menus.add(menu);
            }
        } catch (SQLException e) {
            System.out.println("sql서버 연결실패");
            e.printStackTrace();
        }
        return menus;
    }

    // 4. 반환 타입을 List<Menu> -> Menu 로 변경
    @Override
    public Menu findById(int id) {
        return null;
    }

}