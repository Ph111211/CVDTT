/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlydetaiapp;

/**
 *
 * @author ADMIN
 */

public class ThemDeTaiStrategy implements IDeTaiOperationStrategy {
    @Override
    public String execute(String id, String tenDeTai, String moTa, String yeuCau, int soLuongSV, DeTaiRepository repository) {
        System.out.println("--- CHIEN LUOC: THEM DE TAI  ---");

        if (tenDeTai == null || tenDeTai.trim().isEmpty()) {
            return "Loi: Ten de tai khong duoc de trong!";
        }
        if (tenDeTai.length() > 255) {
            return "Loi: Ten de tai qua dai (toi da 255 ky tu)!";
        }
        if (soLuongSV < 1 || soLuongSV > 100) {
            return "Loi: So luong sinh vien phai tu 1 den 100!";
        }
        if ((moTa == null || moTa.trim().isEmpty()) && (yeuCau == null || yeuCau.trim().isEmpty())) {
            return "Loi: Vui long nhap mo ta hoac yeu cau!";
        }
        if (repository.findByTen(tenDeTai).isPresent()) {
            return "Loi: Ten de tai '" + tenDeTai + "' da ton tai!";
        }

        DeTai newDeTai = new DeTai.Builder(tenDeTai)
                .moTa(moTa)
                .yeuCau(yeuCau)
                .soLuongSinhVienToiDa(soLuongSV)
                .build();
        repository.them(newDeTai);
        return "Them de tai '" + tenDeTai + "' thanh cong.";
    }
}