package DanhGia;

public class DoanhNghiep {
    private DanhGiaBuilder builder;

    public DoanhNghiep(DanhGiaBuilder builder) {
        this.builder = builder;
    }

    public void changeBuilder(DanhGiaBuilder builder) {
        this.builder = builder;
    }

    public void danhGiaSinhVien() {
        builder.reset();
        builder.buildKyNang();
        builder.buildThaiDo();
        builder.buildNoiDungKhac();
    }
}
