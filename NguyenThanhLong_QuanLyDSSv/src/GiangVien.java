public class GiangVien {
    private String maGV;

    public GiangVien(String maGV) {
        this.maGV = maGV;
    }

    public DanhSachSinhVien quanLyDanhSach(DanhSachDirector director) {
        return director.construct();
    }
}
