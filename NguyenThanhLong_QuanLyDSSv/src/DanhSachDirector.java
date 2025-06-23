import java.util.*;

public class DanhSachDirector {
    private DanhSachSinhVienBuilder builder;

    public void setBuilder(DanhSachSinhVienBuilder builder) {
        this.builder = builder;
    }

    public DanhSachSinhVien construct() {
        List<Map<String, String>> danhSach = new ArrayList<>();

        Map<String, String> sv1 = new HashMap<>();
        sv1.put("maSV", "SV01");
        sv1.put("tenSV", "Nguyễn Văn A");
        sv1.put("trangThai", "Chưa phân công");

        Map<String, String> sv2 = new HashMap<>();
        sv2.put("maSV", "SV02");
        sv2.put("tenSV", "Trần Thị B");
        sv2.put("trangThai", "Chưa phân công");

        danhSach.add(sv1);
        danhSach.add(sv2);

        return builder.setDsSinhVien(danhSach).build();
    }
}
