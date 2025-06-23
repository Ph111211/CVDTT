/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main_mediator;

/**
 *
 * @author ADMIN
 */
// package com.mycompany.mediatordemo;

// Dữ liệu đầu vào cho việc cập nhật
public class CapNhatKetQuaInputData {
    DoAn doAnCanCapNhat;
    double diemMoi;
    String trangThaiMoi;
    String nhanXetMoi;

    public CapNhatKetQuaInputData(DoAn doAn, double diem, String trangThai, String nhanXet) {
        this.doAnCanCapNhat = doAn;
        this.diemMoi = diem;
        this.trangThaiMoi = trangThai;
        this.nhanXetMoi = nhanXet;
    }
}