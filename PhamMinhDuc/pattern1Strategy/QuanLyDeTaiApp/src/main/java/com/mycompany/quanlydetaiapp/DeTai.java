/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlydetaiapp;

/**
 *
 * @author ADMIN
 */
// File: DeTai.java
// File: DeTai.java

import java.util.Objects;
import java.util.UUID;

public class DeTai {
    private String id;
    private String tenDeTai;
    private String moTa;
    private String yeuCau;
    private int soLuongSinhVienToiDa;
    private boolean daDuyet;

    // Constructor dùng cho Builder
    private DeTai(Builder builder) {
        this.id = builder.id;
        this.tenDeTai = builder.tenDeTai;
        this.moTa = builder.moTa;
        this.yeuCau = builder.yeuCau;
        this.soLuongSinhVienToiDa = builder.soLuongSinhVienToiDa;
        this.daDuyet = builder.daDuyet;
    }

    // Getters
    public String getId() { return id; }
    public String getTenDeTai() { return tenDeTai; }
    public String getMoTa() { return moTa; }
    public String getYeuCau() { return yeuCau; }
    public int getSoLuongSinhVienToiDa() { return soLuongSinhVienToiDa; }
    public boolean isDaDuyet() { return daDuyet; }

    // Setters
    public void setTenDeTai(String tenDeTai) { this.tenDeTai = tenDeTai; }
    public void setMoTa(String moTa) { this.moTa = moTa; }
    public void setYeuCau(String yeuCau) { this.yeuCau = yeuCau; }
    public void setSoLuongSinhVienToiDa(int soLuongSinhVienToiDa) { this.soLuongSinhVienToiDa = soLuongSinhVienToiDa; }
    public void setDaDuyet(boolean daDuyet) { this.daDuyet = daDuyet; }


    @Override
    public String toString() {
        return "DeTai{" +
               "id='" + id + '\'' +
               ", tenDeTai='" + tenDeTai + '\'' +
               ", moTa='" + moTa + '\'' +
               ", yeuCau='" + yeuCau + '\'' +
               ", soLuongSV=" + soLuongSinhVienToiDa +
               ", daDuyet=" + daDuyet +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeTai deTai = (DeTai) o;
        return Objects.equals(id, deTai.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Builder Pattern
    public static class Builder {
        private String id;
        private String tenDeTai;
        private String moTa = "";
        private String yeuCau = "";
        private int soLuongSinhVienToiDa = 1;
        private boolean daDuyet = false;

        public Builder(String tenDeTai) {
            this.id = UUID.randomUUID().toString();
            this.tenDeTai = tenDeTai;
        }

        public Builder(String id, String tenDeTai) {
            this.id = id;
            this.tenDeTai = tenDeTai;
        }

        public Builder moTa(String moTa) {
            this.moTa = moTa;
            return this;
        }

        public Builder yeuCau(String yeuCau) {
            this.yeuCau = yeuCau;
            return this;
        }

        public Builder soLuongSinhVienToiDa(int soLuong) {
            if (soLuong > 0) {
                this.soLuongSinhVienToiDa = soLuong;
            }
            return this;
        }

        public Builder daDuyet(boolean daDuyet) {
            this.daDuyet = daDuyet;
            return this;
        }

        public DeTai build() {
            if (tenDeTai == null || tenDeTai.trim().isEmpty()) {
                throw new IllegalArgumentException("Ten de tai khong duoc de trong"); 
            }
            return new DeTai(this);
        }
    }
}