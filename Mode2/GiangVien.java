import java.util.ArrayList;
import java.util.List;

public class GiangVien {
    private String ten;
    private List<SinhVien> danhSach = new ArrayList<>();

    public GiangVien(String ten) {
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }

    public void huongDan(SinhVien sv) {
        if (conChoTrong()) {
            danhSach.add(sv);
        }
    }

    public boolean conChoTrong() {
        return danhSach.size() < 7;
    }

    public int getSoLuong() {
        return danhSach.size();
    }
}
