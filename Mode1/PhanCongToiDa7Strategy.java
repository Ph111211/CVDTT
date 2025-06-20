import java.util.List;

public class PhanCongToiDa7Strategy implements PhanCongStrategy {
    @Override
    public void phanCong(List<GiangVien> giangViens, List<SinhVienDoAn> sinhViens) {
        for (SinhVienDoAn sv : sinhViens) {
            if (!sv.daDuocPhanCong()) {
                for (GiangVien gv : giangViens) {
                    if (gv.conChoTrong()) {
                        gv.huongDan(sv);
                        break;
                    }
                }
            }
        }
    }
}

