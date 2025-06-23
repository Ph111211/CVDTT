import java.util.*;

public class DanhSachSinhVien {
    private List<Map<String, String>> dsSinhVien;

    public DanhSachSinhVien(List<Map<String, String>> dsSinhVien) {
        this.dsSinhVien = dsSinhVien;
    }

    public void phanCongDeTai(String deTai) {
        for (Map<String, String> sv : dsSinhVien) {
            sv.put("trangThai", "Đã phân công: " + deTai);
        }
    }

    public void thayDoiTrangThai(String trangThaiMoi) {
        for (Map<String, String> sv : dsSinhVien) {
            sv.put("trangThai", trangThaiMoi);
        }
    }

    public void hienThi() {
        for (Map<String, String> sv : dsSinhVien) {
            System.out.println("Mã SV: " + sv.get("maSV") +
                    ", Tên SV: " + sv.get("tenSV") +
                    ", Trạng thái: " + sv.get("trangThai"));
        }
    }
}
