package strategy;

import model.*;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class ChienLuocVongTron implements ChonGVStrategy {
    private static int index = 0;

    public void chonGiangVien(SinhVien sv, List<GiangVien> dsGV) {
    	try (Connection conn = DBUtil.getConnection()) {
        GiangVien gv = dsGV.get(index % dsGV.size());
        System.out.println("Chọn theo vòng tròn: " + gv);
        index++;
        // lay so luong sinh vien da phan cong cua giang vien
        String sql = "SELECT COUNT(*) FROM SinhVien_GiangVien WHERE maGV = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, gv.getMaGV());
        ResultSet rs = ps.executeQuery();
        int count = 0;
        if (rs.next()) {
            count = rs.getInt(1);
        }
        if (count < 7) {
        	String sql1 = "INSERT INTO SinhVien_GiangVien (maSV, maGV) VALUES (?, ?)";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setString(1, sv.getMaSV());
            ps1.setString(2, gv.getMaGV());
            ps1.executeUpdate();
            System.out.print("Đã thêm giảng viên thành công!");
        }
        else {
        	System.out.println("Giảng viên đã có đủ số lượng sinh viên lựa chọn");
        }
        }
    	catch (Exception e) {
            e.printStackTrace();
        }
    	
    }
}
