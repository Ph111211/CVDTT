import java.util.List;
public class PhanCongVongTronStrategy implements PhanCongStrategy {
    @Override
    public void phanCong(List<GiangVien> giangViens, List<SinhVienDoAn> sinhViens) {
        int index = 0;
        for (SinhVienDoAn sv : sinhViens) {
            int soGiangVien = giangViens.size();
            int dem = 0;
            while (dem < soGiangVien) {
                GiangVien gv = giangViens.get(index % soGiangVien);
                if (gv.conChoTrong()) {
                    gv.huongDan(sv);
                    index++;
                    break;
                }
                index++;
                dem++;
            }
        }
    }
}
