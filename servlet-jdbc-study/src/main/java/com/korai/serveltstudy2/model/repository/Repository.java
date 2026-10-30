package com.korai.serveltstudy2.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Repository<T>  {
    List<T> findAll() throws SQLException;
    T findById(int id);

    default ResultSet select(Connection connection, String sql) {
        try (Connection conn = connection) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    return rs;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("sql서버 연결실패");
            e.printStackTrace();
        }
        return null;
    }


}
