import java.util.ArrayList;
import java.util.List;

public class GiangVien {
    private String maGV;
    private String tenGV;
    private List<SinhVienDoAn> danhSachSinhVien = new ArrayList<>();

    public GiangVien(String maGV, String tenGV) {
        this.maGV = maGV;
        this.tenGV = tenGV;
    }

    public boolean conChoTrong() {
        return danhSachSinhVien.size() < 7;
    }

    public void huongDan(SinhVienDoAn sv) {
        if (conChoTrong() && !sv.daDuocPhanCong()) {
            danhSachSinhVien.add(sv);
            sv.setGiangVien(this);
        }
    }

    public String getTenGV() {
        return tenGV;
    }

    public int getSoLuongSinhVien() {
        return danhSachSinhVien.size();
    }
}
