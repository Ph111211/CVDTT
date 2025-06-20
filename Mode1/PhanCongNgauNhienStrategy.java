import java.util.Collections;
import java.util.List;

public class PhanCongNgauNhienStrategy implements PhanCongStrategy {
    @Override
    public void phanCong(List<GiangVien> giangViens, List<SinhVienDoAn> sinhViens) {
        Collections.shuffle(sinhViens);
        for (SinhVienDoAn sv : sinhViens) {
            Collections.shuffle(giangViens);
            for (GiangVien gv : giangViens) {
                if (gv.conChoTrong()) {
                    gv.huongDan(sv);
                    break;
                }
            }
        }
    }
}
