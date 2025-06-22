/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlydetaiapp;

/**
 *
 * @author ADMIN
 */
// File: XoaDeTaiStrategy.java

// File: XoaDeTaiStrategy.java

import java.util.Optional;

public class XoaDeTaiStrategy implements IDeTaiOperationStrategy {
    @Override
    public String execute(String id, String tenDeTai, String moTa, String yeuCau, int soLuongSV, DeTaiRepository repository) {
        System.out.println("--- CHIEN LUOC: XOA DE TAI  ---");

        if (id == null || id.trim().isEmpty()) {
            return "Loi: ID de tai khong duoc de trong khi xoa!";
        }

        Optional<DeTai> optDeTai = repository.findById(id);
        if (!optDeTai.isPresent()) {
            return "Loi: Khong tim thay de tai voi ID '" + id + "' de xoa.";
        }

        // boolean dieuKienKhongChoXoa = false;
        // if (repository.kiemTraSinhVienDaChon(id)) { // Giả lập
        //     return "Loi: De tai ID '" + id + "' da co sinh vien dang ky, khong the xoa.";
        // }

        repository.xoa(id);
        return "Xoa de tai ID '" + id + "' thanh cong.";
    }
}