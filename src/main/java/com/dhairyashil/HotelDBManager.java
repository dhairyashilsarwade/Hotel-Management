package com.dhairyashil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HotelDBManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/hoteldb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found.");
        }
    }

    public static void addRoom(Room room) {
        String sql = "INSERT INTO rooms (type, price) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, room.getType());
            stmt.setDouble(2, room.getPrice());
            stmt.executeUpdate();
            new Thread(new HotelLogger("Added room: " + room.getType())).start();
        } catch (SQLException e) {
            System.out.println("Error adding room: " + e.getMessage());
        }
    }

    public static List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM rooms";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Room room = new Room(rs.getInt("id"), rs.getString("type"), rs.getDouble("price"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching rooms: " + e.getMessage());
        }
        return rooms;
    }

    public static void deleteRoom(int id) {
        String sql = "DELETE FROM rooms WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                new Thread(new HotelLogger("Deleted room ID: " + id)).start();
            } else {
                System.out.println("Room ID not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting room: " + e.getMessage());
        }
    }
}