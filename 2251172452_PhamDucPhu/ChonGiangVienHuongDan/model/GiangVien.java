package model;

public class GiangVien {
    private String maGV;
    private String tenGV;

    public GiangVien(String maGV, String tenGV) {
        this.maGV = maGV;
        this.tenGV = tenGV;
    }

    public String getMaGV() {
        return maGV;
    }

    public String getTenGV() {
        return tenGV;
    }

    @Override
    public String toString() {
        return maGV + " - " + tenGV;
    }
}
