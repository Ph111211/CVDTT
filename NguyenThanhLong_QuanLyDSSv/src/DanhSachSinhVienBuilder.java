import java.util.*;

public class DanhSachSinhVienBuilder {
    private List<Map<String, String>> dsSinhVien;

    public DanhSachSinhVienBuilder setDsSinhVien(List<Map<String, String>> dsSinhVien) {
        this.dsSinhVien = dsSinhVien;
        return this;
    }

    public DanhSachSinhVien build() {
        return new DanhSachSinhVien(dsSinhVien);
    }
}
