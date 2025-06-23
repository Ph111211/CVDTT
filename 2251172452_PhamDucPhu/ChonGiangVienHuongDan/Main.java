// import model.*; // Removed because the model package cannot be resolved

 import strategy.ChonGVStrategy;
 import strategy.ChienLuocVongTron;
 import strategy.ChienLuocNgauNhien;
 import strategy.ChienLuocGVItNhat;
 import strategy.ChienLuocTheoMongMuoon;
 import util.DBUtil;
 import model.SinhVien;
 import model.GiangVien;3
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<GiangVien> dsGV = layDanhSachGiangVien();
        List<SinhVien> dsSV = layDanhSachSinhVien();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Chọn chiến lược và chọn giảng viên cho sinh viên");
            System.out.println("3. Hiển thị sinh viên đã được phân công giảng viên");

            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    for (SinhVien sv : dsSV)
                        System.out.println(sv);
                    break;
                case 2:
                    System.out.print("Nhập mã sinh viên: ");
                    String maSV = sc.nextLine();
                    SinhVien sv = timSinhVien(dsSV, maSV);
                    if (sv == null) {
                        System.out.println("Không tìm thấy sinh viên.");
                        break;
                    }
                    System.out.println("1. Vòng tròn");
                    System.out.println("2. Ngẫu nhiên");
                    System.out.println("3. Giảng viên ít được chọn nhất");
                    System.out.println("4. Chọn giảng viên theo mong muốn của  ");
                    
                    System.out.print("Chọn chiến lược: ");
                    int cs = sc.nextInt();

                    switch (cs) {
                        case 1: sv.setStrategy(new ChienLuocVongTron()); break;
                        case 2: sv.setStrategy(new ChienLuocNgauNhien()); break;
                        case 3: sv.setStrategy(new ChienLuocGVItNhat()); break;
                        case 4: sv.setStrategy(new ChienLuocTheoMongMuoon()); break;
                        default: System.out.println("Chiến lược không hợp lệ."); continue;
                    }
                    sv.thucHienChonGV(dsGV);
                    break;
                case 3:
                    hienThiSinhVienDaDuocPhanCong();
                    break;

                case 0:
                    return;
            }
        }
    }
    static void hienThiSinhVienDaDuocPhanCong() {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = """
                SELECT sv.maSV, sv.tenSV, gv.maGV, gv.tenGV
                FROM SinhVien sv
                JOIN SinhVien_GiangVien sg ON sv.maSV = sg.maSV
                JOIN GiangVien gv ON sg.maGV = gv.maGV
                ORDER BY sv.maSV
            """;

            ResultSet rs = conn.createStatement().executeQuery(sql);

            System.out.println("\nDanh sách sinh viên đã được phân công giảng viên:");
            while (rs.next()) {
                System.out.printf("SV: %s - %s | GV: %s - %s\n",
                        rs.getString("maSV"),
                        rs.getString("tenSV"),
                        rs.getString("maGV"),
                        rs.getString("tenGV"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    static List<SinhVien> layDanhSachSinhVien() {
        List<SinhVien> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection()) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM SinhVien");
            while (rs.next()) {
                list.add(new SinhVien(rs.getString("maSV"), rs.getString("tenSV")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    static SinhVien timSinhVien(List<SinhVien> list, String maSV) {
        for (SinhVien sv : list)
            if (sv.getMaSV().equals(maSV))
                return sv;
        return null;
    }
}
