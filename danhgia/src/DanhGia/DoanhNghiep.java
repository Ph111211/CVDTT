package DanhGia;

public class DoanhNghiep {
    private DanhGiaBuilder builder;
    private DatabaseManager dbManager = new DatabaseManager();

    public DoanhNghiep(DanhGiaBuilder builder) {
        this.builder = builder;
    }

    public void danhGiaSinhVien(int sinhVienId) {
        builder.reset();
        builder.buildKyNang();
        builder.buildThaiDo();
        builder.buildNoiDungKhac();
        DanhGia danhGia = builder.getResult();
        dbManager.saveDanhGia(danhGia,sinhVienId);
    }

    public void shutdown() {
        dbManager.close();
    }
}