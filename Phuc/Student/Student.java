package Student;

public class Student {
    private String maSV;
    private String name;
    private String ngaySinh;
    private String gioiTinh;
    private String lop;
    private String sdt;
    private String email;
    private String diaChi;

    public Student(String maSV, String name, String ngaySinh, String gioiTinh, String lop, String sdt, String email, String diaChi) {
        this.maSV = maSV;
        this.name = name;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.lop = lop;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
    }

    public Student() {

    }

    public String getMaSV() {
        return maSV;
    }

    public String getName() {
        return name;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getLop() {
        return lop;
    }

    public String getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }

    public String getDiaChi() {
        return diaChi;
    }
    public String toCSV() {
        return String.join(",", maSV, name, ngaySinh, gioiTinh, lop, sdt, email, diaChi);
    }

    public static Student fromCSV(String line) {
        String[] parts = line.split(",", -1);
        if (parts.length != 8) return null;
        return new Student(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]);
    }
}
