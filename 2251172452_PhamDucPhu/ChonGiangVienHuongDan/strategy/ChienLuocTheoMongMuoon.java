package strategy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.GiangVien;
import model.SinhVien;
import util.DBUtil;

public class ChienLuocTheoMongMuoon implements ChonGVStrategy {
	static List<GiangVien> layDanhSachGiangVien() {
        List<GiangVien> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection()) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM GiangVien");
            while (rs.next()) {
                list.add(new GiangVien(rs.getString("maGV"), rs.getString("tenGV")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	public void chonGiangVien(SinhVien sv, List<GiangVien> dsGV) {
		try (Connection conn = DBUtil.getConnection()){
			Scanner sc = new Scanner(System.in);
			for (GiangVien gv : dsGV) {
				System.out.print(gv.getMaGV() + " " + gv.getTenGV()+ "\n");
			}
			System.out.print("Nhập mã giảng viên mà bạn muốn phân công: ");
			String maGV = sc.nextLine();
			// lay so luong sinh vien da phan cong cua giang vien
	        String sql = "SELECT COUNT(*) FROM SinhVien_GiangVien WHERE maGV = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, maGV);
	        ResultSet rs = ps.executeQuery();
	        int count = 0;
	        if (rs.next()) {
	            count = rs.getInt(1);
	        }
	        if (count < 7) {
	        	String sql1 = "INSERT INTO SinhVien_GiangVien (maSV, maGV) VALUES (?, ?)";
	            PreparedStatement ps1 = conn.prepareStatement(sql1);
	            ps1.setString(1, sv.getMaSV());
	            ps1.setString(2, maGV);
	            ps1.executeUpdate();
	            System.out.print("Đã thêm giảng viên thành công!");
	        }
	        else {
	        	System.out.println("Giảng viên đã có đủ số lượng sinh viên lựa chọn");
	        }
	        
	        System.out.println("Bạn chọn: " + maGV);
	    	
		}catch (Exception e) {
            e.printStackTrace();
        }
		
	}

}
