package DanhGia;

public class SinhVien {
    private int id;
    private DatabaseManager dbManager = new DatabaseManager();

    public void xemDanhGia() {
        DanhGia danhGia = dbManager.getLatestDanhGiaById(id);
        if (danhGia != null) {
            System.out.println("\nSinh viên ID " + id + " nhận được đánh giá:\n" + danhGia);
        } else {
            System.out.println("Không có đánh giá nào cho sinh viên ID " + id + " trong cơ sở dữ liệu.");
        }
    }

    public void shutdown() {
        dbManager.close();
    }
}
