import java.util.List;

public class ChienLuocGvItNhat implements ChonGVStrategy {
    @Override
    public void chonGiangVien(SinhVien sv, List<GiangVien> dsGiangVien) {
        GiangVien totNhat = null;
        int min = Integer.MAX_VALUE;

        for (GiangVien gv : dsGiangVien) {
            if (gv.conChoTrong() && gv.getSoLuong() < min) {
                min = gv.getSoLuong();
                totNhat = gv;
            }
        }

        if (totNhat != null) {
            totNhat.huongDan(sv);
            sv.setGiangVien(totNhat);
            System.out.println("SV " + sv.getTen() + " chon GV: " + totNhat.getTen());
        } else {
            System.out.println("Khong co giang vien nao phu hop " + sv.getTen());
        }
    }
}
