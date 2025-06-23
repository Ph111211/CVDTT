package Teacher;

import Student.Student;

public class Teacher {
    private String maGV;
    private String name;
    private String ngaySinh;
    private String gioiTinh;
    private String maKhoa;
    private String sdt;
    private String email;

    public Teacher(String maGV, String name, String ngaySinh, String gioiTinh, String maKhoa, String sdt, String email) {
        this.maGV = maGV;
        this.name = name;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.maKhoa = maKhoa;
        this.sdt = sdt;
        this.email = email;
    }

    public Teacher() {

    }

    public String getMaGV() {
        return maGV;
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

    public String getMaKhoa() {
        return maKhoa;
    }

    public String getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }

    public String toCSV() {
        return String.join(",", maGV, name, ngaySinh, gioiTinh, maKhoa, sdt, email);
    }

    public static Teacher fromCSV(String line) {
        String[] parts = line.split(",", -1);
        if (parts.length != 7) return null;
        return new Teacher(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
    }

}
