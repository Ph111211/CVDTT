package DanhGia;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;


public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/danhgia";
    private static final String USER = "root";
    private static final String PASSWORD = "1324";

    private Connection connection;

    public DatabaseManager() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void saveDanhGia(DanhGia danhGia, int sinhVienId) {
        String sql = "INSERT INTO danhgia (kyNang, thaiDo, noiDungKhac, sinh_vien_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, danhGia.kyNang);
            pstmt.setString(2, danhGia.thaiDo);
            pstmt.setString(3, danhGia.noiDungKhac);
            pstmt.setInt(4, sinhVienId);
            pstmt.executeUpdate();
            System.out.println("Đánh giá đã được lưu vào cơ sở dữ liệu.");
        } catch (SQLException e) {
            System.err.println("Lỗi SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public DanhGia getLatestDanhGiaById(int sinhVienId) {
        String sql = "SELECT * FROM danhgia WHERE sinh_vien_id = ? ORDER BY id DESC LIMIT 1";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, sinhVienId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    DanhGia danhGia = new DanhGia();
                    String kyNang = rs.getString("kyNang");
                    String thaiDo = rs.getString("thaiDo");
                    danhGia.noiDungKhac = rs.getString("noiDungKhac");
                    if (kyNang != null && !kyNang.trim().isEmpty()) {
                        danhGia.kyNang = kyNang;
                    }
                    if (thaiDo != null && !thaiDo.trim().isEmpty()) {
                        danhGia.thaiDo = thaiDo;
                    }
                    return danhGia;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Set<Integer> getAllSinhVienIds() {
        Set<Integer> sinhVienIds = new HashSet<>();
        String sql = "SELECT DISTINCT sinh_vien_id FROM danhgia WHERE sinh_vien_id IS NOT NULL";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                sinhVienIds.add(rs.getInt("sinh_vien_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sinhVienIds;
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}