import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<GiangVien> giangViens = Arrays.asList(
            new GiangVien("Thay A"),
            new GiangVien("Co B"),
            new GiangVien("Thay C")
        );

        List<SinhVien> sinhViens = Arrays.asList(
    new SinhVien("SV1", new ChienLuocNgauNhien()),
    new SinhVien("SV2", new ChienLuocGvItNhat()),
    new SinhVien("SV3", new ChienLuocVongTron()),
    new SinhVien("SV4", new ChienLuocTheoMongMuon())
);

        for (SinhVien sv : sinhViens) {
            sv.thucHienChonGiangVien(giangViens);
        }

        System.out.println("--- Ket qua phan cong ---");
        for (GiangVien gv : giangViens) {
            System.out.println(gv.getTen() + ": " + gv.getSoLuong() + " sinh vien");
        }
    }
}
