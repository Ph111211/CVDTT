package strategy;

import model.SinhVien;
import model.GiangVien;
import java.util.List;

public interface ChonGVStrategy {
    void chonGiangVien(SinhVien sv, List<GiangVien> dsGV);
}
