package model;

import strategy.ChonGVStrategy;
import java.util.List;
import java.util.ArrayList;

public class SinhVien {
    private String maSV;
    private String tenSV;
    private ChonGVStrategy strategy;

    public SinhVien(String maSV, String tenSV) {
        this.maSV = maSV;
        this.tenSV = tenSV;
    }

    public void setStrategy(ChonGVStrategy strategy) {
        this.strategy = strategy;
    }

    public void thucHienChonGV(List<GiangVien> dsGV) {
        if (strategy != null) {
            strategy.chonGiangVien(this, dsGV);
        } else {
            System.out.println("Chưa chọn chiến lược.");
        }
    }

    public String getMaSV() { return maSV; }

    @Override
    public String toString() {
        return maSV + " - " + tenSV;
    }
}
