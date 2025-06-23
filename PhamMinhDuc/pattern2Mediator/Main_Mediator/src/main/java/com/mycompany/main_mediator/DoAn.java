/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main_mediator;

/**
 *
 * @author ADMIN
 */

public class DoAn {
    String maSinhVien;
    String tenDoAn;
    double diem;
    String trangThai;
    String nhanXetGV;

    public DoAn(String maSinhVien, String tenDoAn) {
        this.maSinhVien = maSinhVien;
        this.tenDoAn = tenDoAn;
        this.trangThai = "Chua hoan thanh"; // Tiếng Việt không dấu
        this.diem = 0.0;
        this.nhanXetGV = null;
    }

    @Override
    public String toString() {
        return "DoAn{" +
               "maSV='" + maSinhVien + '\'' +
               ", ten='" + tenDoAn + '\'' +
               ", diem=" + diem +
               ", trangThai='" + trangThai + '\'' +
               ", nhanXet='" + (nhanXetGV == null ? "Chua co" : nhanXetGV) + '\'' + // Tiếng Việt không dấu
               '}';
    }
}