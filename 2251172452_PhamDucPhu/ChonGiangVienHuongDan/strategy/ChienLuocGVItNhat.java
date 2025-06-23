package strategy;

import model.*;
import util.DBUtil;

import java.sql.*;
import java.util.*;

public class ChienLuocGVItNhat implements ChonGVStrategy {
    public void chonGiangVien(SinhVien sv, List<GiangVien> dsGV) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT maGV, COUNT(*) AS soLan FROM SinhVien_GiangVien GROUP BY maGV";
            ResultSet rs = conn.createStatement().executeQuery(sql);

            Map<String, Integer> map = new HashMap<>();
            while (rs.next()) {
                map.put(rs.getString("maGV"), rs.getInt("soLan"));
            }

            GiangVien minGV = dsGV.get(0);
            int min = map.getOrDefault(minGV.getMaGV(), 0);

            for (GiangVien gv : dsGV) {
                int count = map.getOrDefault(gv.getMaGV(), 0);
                if (count < min  && count < 7) {
                    min = count;
              
                    minGV = gv;
                    String sql1 = "INSERT INTO SinhVien_GiangVien (maSV, maGV) VALUES (?, ?)";
                    PreparedStatement ps = conn.prepareStatement(sql1);
                    ps.setString(1, sv.getMaSV());
                    ps.setString(2, gv.getMaGV());
                    ps.executeUpdate();
                    System.out.print("Đã thêm giảng viên thành công!");
    	        }
    	        else {
    	        	System.out.println("Giảng viên đã có đủ số lượng sinh viên lựa chọn");
    	        }
            }
            

            System.out.println("Chọn giảng viên ít được chọn nhất: " + minGV + " " + "Số sinh viên đã chọn "+ min++);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	private void and(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
