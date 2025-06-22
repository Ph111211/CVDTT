/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main_mediator;

/**
 *
 * @author ADMIN
 */

public class Main_Mediator {
    public static void main(String[] args) {
        DichVuKiemTraHopLe dvKiemTra = new DichVuKiemTraHopLe();
        DichVuLuuTruKetQua dvLuuTru = new DichVuLuuTruKetQua();
        DichVuQuanLyDoAn dvQuanLyDoAn = new DichVuQuanLyDoAn();
        CapNhatKetQuaDieuPhoi mediator = new CapNhatKetQuaDieuPhoi();
        GiaoDienCapNhatUI ui = new GiaoDienCapNhatUI(mediator);

        mediator.setGiaoDien(ui);
        mediator.setDichVuKiemTra(dvKiemTra);
        mediator.setDichVuLuuTru(dvLuuTru);
        mediator.setDichVuQuanLyDoAn(dvQuanLyDoAn);

        System.out.println("=== KICH BAN CAP NHAT KET QUA DO AN (DUNG MEDIATOR) ===");

        mediator.guiThongDiep(null, "KHOI_TAO_MAN_HINH_CAP_NHAT", null);

        System.out.println("\n--- VPK chon SV001 de cap nhat ---");
        mediator.guiThongDiep(ui, "CHON_DO_AN_TU_DANH_SACH", "SV001");
        // Khi nhập trạng thái, đảm bảo nhập không dấu để khớp với logic kiểm tra
        ui.nguoiDungNhanLuu(8.5, "Hoan thanh", "Lam tot, can cai thien phan X.");

        System.out.println("\n--- VPK nhap diem khong hop le cho SV001 ---");
        ui.nguoiDungNhanLuu(11.0, "Hoan thanh", "Diem sai roi.");

        System.out.println("\n--- VPK chon SV003 (chua co diem) ---");
        mediator.guiThongDiep(ui, "CHON_DO_AN_TU_DANH_SACH", "SV003");
        ui.nguoiDungNhanLuu(7.0, "Hoan thanh", "GVCC cham bo sung.");
    }
}