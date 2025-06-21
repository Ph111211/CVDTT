package DanhGia;

public class Main {
    public static void main(String[] args) {
        DanhGiaKyNangBuilder builder = new DanhGiaKyNangBuilder();
        DoanhNghiep doanhNghiep = new DoanhNghiep(builder);

        doanhNghiep.danhGiaSinhVien();
        DanhGia danhGia = builder.getResult();

        SinhVien sv = new SinhVien();
        sv.xemDanhGia(danhGia);
    }
}