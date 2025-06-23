/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main_mediator;

/**
 *
 * @author ADMIN
 */

public class DichVuKiemTraHopLe {
    public boolean kiemTra(CapNhatKetQuaInputData input) {
        System.out.println("DICH VU KIEM TRA: Bat dau kiem tra du lieu...");
        boolean diemOk = input.diemMoi >= 0 && input.diemMoi <= 10;
        boolean trangThaiOk = "Hoan thanh".equals(input.trangThaiMoi) || "Chua hoan thanh".equals(input.trangThaiMoi);

        if (!diemOk) System.err.println("DICH VU KIEM TRA: Loi - Diem khong hop le.");
        if (!trangThaiOk) System.err.println("DICH VU KIEM TRA: Loi - Trang thai khong hop le.");

        return diemOk && trangThaiOk;
    }
}