/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main_mediator;

/**
 *
 * @author ADMIN
 */

public class GiaoDienCapNhatUI {
    private ICapNhatKetQuaMediator mediator;
    private DoAn doAnDangChon;

    public GiaoDienCapNhatUI(ICapNhatKetQuaMediator mediator) {
        this.mediator = mediator;
    }

    public void chonDoAnDeCapNhat(DoAn da) {
        this.doAnDangChon = da;
        System.out.println("GIAO DIEN: Da chon do an: " + da.tenDoAn + " cua SV " + da.maSinhVien);
        System.out.println("GIAO DIEN: Thong tin hien tai: " + da.toString());
    }

    public void nguoiDungNhanLuu(double diemMoi, String trangThaiMoi, String nhanXetMoi) {
        System.out.println("\n--- GIAO DIEN: VPK nhan nut Luu ---");
        if (doAnDangChon == null) {
            hienThiLoi("Vui long chon mot do an de cap nhat!");
            return;
        }
        CapNhatKetQuaInputData inputData = new CapNhatKetQuaInputData(doAnDangChon, diemMoi, trangThaiMoi, nhanXetMoi);
        mediator.guiThongDiep(this, "LUU_KET_QUA_REQUEST", inputData);
    }

    public void hienThiDanhSachDoAn(String danhSach) {
        System.out.println("GIAO DIEN: Hien thi danh sach do an:\n" + danhSach);
    }

    public void hienThiThongBaoThanhCong(String message) {
        System.out.println("GIAO DIEN (THANH CONG): " + message);
    }

    public void hienThiLoi(String message) {
        System.err.println("GIAO DIEN (LOI): " + message);
    }
}