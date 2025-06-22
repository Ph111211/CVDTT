/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main_mediator;

/**
 *
 * @author ADMIN
 */

public class CapNhatKetQuaDieuPhoi implements ICapNhatKetQuaMediator {
    private GiaoDienCapNhatUI giaoDien;
    private DichVuKiemTraHopLe dichVuKiemTra;
    private DichVuLuuTruKetQua dichVuLuuTru;
    private DichVuQuanLyDoAn dichVuQuanLyDoAn;

    public CapNhatKetQuaDieuPhoi() {}

    public void setGiaoDien(GiaoDienCapNhatUI giaoDien) {
        this.giaoDien = giaoDien;
    }

    public void setDichVuKiemTra(DichVuKiemTraHopLe dichVuKiemTra) {
        this.dichVuKiemTra = dichVuKiemTra;
    }

    public void setDichVuLuuTru(DichVuLuuTruKetQua dichVuLuuTru) {
        this.dichVuLuuTru = dichVuLuuTru;
    }

    public void setDichVuQuanLyDoAn(DichVuQuanLyDoAn dichVuQuanLyDoAn) {
        this.dichVuQuanLyDoAn = dichVuQuanLyDoAn;
    }

    @Override
    public void guiThongDiep(Object nguoiGui, String suKien, Object duLieu) {
        System.out.println("MEDIATOR: Nhan su kien '" + suKien + "' tu " + (nguoiGui != null ? nguoiGui.getClass().getSimpleName() : "He thong"));

        switch (suKien) {
            case "KHOI_TAO_MAN_HINH_CAP_NHAT":
                String danhSach = dichVuQuanLyDoAn.layDanhSachDoAnChoVPK();
                giaoDien.hienThiDanhSachDoAn(danhSach);
                break;

            case "CHON_DO_AN_TU_DANH_SACH":
                String maSVChon = (String) duLieu;
                DoAn daChon = dichVuQuanLyDoAn.timDoAnTheoMa(maSVChon);
                if (daChon != null) {
                    giaoDien.chonDoAnDeCapNhat(daChon);
                    if (daChon.diem == 0.0 && "Chua hoan thanh".equals(daChon.trangThai) && daChon.nhanXetGV == null) {
                        giaoDien.hienThiLoi("Thong bao: Sinh vien nay chua co ket qua tu giang vien. VPK co the nhap thu cong.");
                    }
                } else {
                    giaoDien.hienThiLoi("Khong tim thay do an cho sinh vien " + maSVChon);
                }
                break;

            case "LUU_KET_QUA_REQUEST":
                if (nguoiGui instanceof GiaoDienCapNhatUI) {
                    CapNhatKetQuaInputData input = (CapNhatKetQuaInputData) duLieu;
                    boolean hopLe = dichVuKiemTra.kiemTra(input);

                    if (hopLe) {
                        input.doAnCanCapNhat.diem = input.diemMoi;
                        input.doAnCanCapNhat.trangThai = input.trangThaiMoi; // Đảm bảo gán giá trị không dấu nếu cần
                        input.doAnCanCapNhat.nhanXetGV = input.nhanXetMoi;

                        boolean luuThanhCong = dichVuLuuTru.luu(input.doAnCanCapNhat);

                        if (luuThanhCong) {
                            giaoDien.hienThiThongBaoThanhCong("Ket qua do an da duoc cap nhat thanh cong!");
                        } else {
                            giaoDien.hienThiLoi("Loi he thong khi luu du lieu. Vui long thu lai sau.");
                        }
                    } else {
                        giaoDien.hienThiLoi("Du lieu nhap khong hop le. Vui long kiem tra va nhap lai.");
                    }
                }
                break;
            default:
                System.out.println("MEDIATOR: Su kien khong xac dinh: " + suKien);
        }
    }
}