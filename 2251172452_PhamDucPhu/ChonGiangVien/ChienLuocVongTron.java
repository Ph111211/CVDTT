import java.util.List;
public class ChienLuocVongTron implements ChonGVStrategy {
    private static int viTriHienTai = 0;

    @Override
    public void chonGiangVien(SinhVien sv, List<GiangVien> dsGiangVien) {
        int soLuong = dsGiangVien.size();
        int daThu = 0;

        while (daThu < soLuong) {
            GiangVien gv = dsGiangVien.get(viTriHienTai);
            viTriHienTai = (viTriHienTai + 1) % soLuong;

            if (gv.conChoTrong()) {
                gv.huongDan(sv);
                sv.setGiangVien(gv);
                System.out.println("SV " + sv.getTen() + " được phân theo vòng tròn cho: " + gv.getTen());
                return;
            }

            daThu++;
        }

        System.out.println("Không còn giảng viên phù hợp cho SV " + sv.getTen());
    }
}
