import java.util.List;
import java.util.Scanner;

public class ChienLuocTheoMongMuon implements ChonGVStrategy {
    @Override
    public void chonGiangVien(SinhVien sv, List<GiangVien> dsGiangVien) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sinh viên " + sv.getTen() + " mong muốn giảng viên tên gì? ");
        String tenGvMongMuon = scanner.nextLine();

        for (GiangVien gv : dsGiangVien) {
            if (gv.getTen().equalsIgnoreCase(tenGvMongMuon) && gv.conChoTrong()) {
                gv.huongDan(sv);
                sv.setGiangVien(gv);
                System.out.println("SV " + sv.getTen() + " được phân cho giảng viên mong muốn: " + gv.getTen());
                return;
            }
        }

        System.out.println("Giảng viên mong muốn không tồn tại hoặc đã đủ sinh viên.");
    }
}
