package ru.sstu.hotel.loyalty.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CardRepository {
    public void saveBalance(Connection conn, String cardId, int newBalance) throws SQLException {
        String sql = "UPDATE loyalty_cards SET balance = ? WHERE card_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, newBalance);
            stmt.setString(2, cardId);
            stmt.executeUpdate();
        }
    }
}
