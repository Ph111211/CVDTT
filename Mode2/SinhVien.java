import java.util.List;

public class SinhVien {
    private String ten;
    private GiangVien giangVien;
    private ChonGVStrategy strategy;

    public SinhVien(String ten, ChonGVStrategy strategy) {
        this.ten = ten;
        this.strategy = strategy;
    }

    public String getTen() {
        return ten;
    }

    public void setGiangVien(GiangVien gv) {
        this.giangVien = gv;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void thucHienChonGiangVien(List<GiangVien> dsGiangVien) {
        strategy.chonGiangVien(this, dsGiangVien);
    }
}
