import java.util.Comparator;
import java.util.List;
public class PhanCongItNhatStrategy implements PhanCongStrategy {
    @Override
    public void phanCong(List<GiangVien> giangViens, List<SinhVienDoAn> sinhViens) {
        for (SinhVienDoAn sv : sinhViens) {
            GiangVien gv = giangViens.stream()
                .filter(GiangVien::conChoTrong)
                .min(Comparator.comparingInt(GiangVien::getSoLuongSinhVien))
                .orElse(null);
            if (gv != null) {
                gv.huongDan(sv);
            }
        }
    }
}
