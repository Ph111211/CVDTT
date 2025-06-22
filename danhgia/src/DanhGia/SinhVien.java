package DanhGia;

public class SinhVien {
    private DatabaseManager dbManager = new DatabaseManager();

    public DanhGia xemDanhGia(int idSinhVien) {
        return dbManager.getLatestDanhGiaById(idSinhVien);
    }

    public void shutdown() {
        dbManager.close();
    }
}
