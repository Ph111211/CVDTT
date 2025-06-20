import java.util.*;

public class ChienLuocNgauNhien implements ChonGVStrategy {
    @Override
    public void chonGiangVien(SinhVien sv, List<GiangVien> dsGiangVien) {
        List<GiangVien> coTheChon = new ArrayList<>();
        for (GiangVien gv : dsGiangVien) {
            if (gv.conChoTrong()) {
                coTheChon.add(gv);
            }
        }

        if (coTheChon.isEmpty()) {
            System.out.println("Không còn giảng viên phù hợp cho SV " + sv.getTen());
            return;
        }

        Random rand = new Random();
        GiangVien chon = coTheChon.get(rand.nextInt(coTheChon.size()));
        chon.huongDan(sv);
        sv.setGiangVien(chon);
        System.out.println("SV " + sv.getTen() + " được phân công ngẫu nhiên cho: " + chon.getTen());
    }
}
