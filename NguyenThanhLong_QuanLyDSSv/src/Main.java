public class Main {
    public static void main(String[] args) {
        GiangVien gv = new GiangVien("GV01");

        DanhSachSinhVienBuilder builder = new DanhSachSinhVienBuilder();
        DanhSachDirector director = new DanhSachDirector();
        director.setBuilder(builder);

        DanhSachSinhVien ds = gv.quanLyDanhSach(director);

        ds.phanCongDeTai("Đồ án tốt nghiệp");
        System.out.println("== Sau khi phân công đề tài ==");
        ds.hienThi();

        ds.thayDoiTrangThai("Đã hoàn thành");
        System.out.println("\n== Sau khi cập nhật trạng thái ==");
        ds.hienThi();
    }
}
