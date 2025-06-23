/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlydetaiapp;

/**
 *
 * @author ADMIN
 */
// File: SuaDeTaiStrategy.java

// File: SuaDeTaiStrategy.java

import java.util.Optional;

public class SuaDeTaiStrategy implements IDeTaiOperationStrategy {
    @Override
    public String execute(String id, String tenDeTaiMoi, String moTaMoi, String yeuCauMoi, int soLuongSVMoi, DeTaiRepository repository) {
        System.out.println("--- CHIEN LUOC: SUA DE TAI ---");

        if (id == null || id.trim().isEmpty()) {
            return "Loi: ID de tai khong duoc de trong khi sua!";
        }

        Optional<DeTai> optDeTaiCanSua = repository.findById(id);
        if (!optDeTaiCanSua.isPresent()) {
            return "Loi: Khong tim thay de tai voi ID '" + id + "' de sua.";
        }
        DeTai deTaiCanSua = optDeTaiCanSua.get();

        if (tenDeTaiMoi == null || tenDeTaiMoi.trim().isEmpty()) {
            return "Loi: Ten de tai moi khong duoc de trong!";
        }
        // ... (them cac validate khac cho tenDeTaiMoi, moTaMoi, yeuCauMoi, soLuongSVMoi neu can) ...

        if (!deTaiCanSua.getTenDeTai().equalsIgnoreCase(tenDeTaiMoi) &&
            repository.findByTen(tenDeTaiMoi).filter(existing -> !existing.getId().equals(id)).isPresent()) {
            return "Loi: Ten de tai moi '" + tenDeTaiMoi + "' da ton tai cho mot de tai khac!";
        }

        deTaiCanSua.setTenDeTai(tenDeTaiMoi);
        deTaiCanSua.setMoTa(moTaMoi);
        deTaiCanSua.setYeuCau(yeuCauMoi);
        deTaiCanSua.setSoLuongSinhVienToiDa(soLuongSVMoi);

        repository.capNhat(deTaiCanSua);
        return "Sua de tai ID '" + id + "' thanh cong.";
    }
}