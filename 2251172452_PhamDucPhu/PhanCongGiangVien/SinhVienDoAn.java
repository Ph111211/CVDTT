public class SinhVienDoAn {
    private String maSV;
    private String tenSV;
    private String deTai;
    private GiangVien giangVienPhanCong = null;

    public SinhVienDoAn(String maSV, String tenSV, String deTai) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.deTai = deTai;
    }

    public boolean daDuocPhanCong() {
        return giangVienPhanCong != null;
    }

    public void setGiangVien(GiangVien gv) {
        this.giangVienPhanCong = gv;
    }

    public String getThongTin() {
        return tenSV + " - " + deTai + 
               (giangVienPhanCong != null ? " (GV: " + giangVienPhanCong.getTenGV() + ")" : " (Chưa phân công)");
    }
}
