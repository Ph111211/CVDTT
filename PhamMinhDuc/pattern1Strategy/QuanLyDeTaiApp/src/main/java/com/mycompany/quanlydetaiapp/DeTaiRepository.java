/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlydetaiapp;

/**
 *
 * @author ADMIN
 */
// File: DeTaiRepository.java

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeTaiRepository {
    private List<DeTai> danhSachDeTai = new ArrayList<>();

    public void them(DeTai deTai) {
        danhSachDeTai.add(deTai);
        System.out.println("REPOSITORY: Da them de tai: " + deTai.getTenDeTai());
    }

    public Optional<DeTai> findById(String id) {
        for (DeTai dt : danhSachDeTai) {
            if (dt.getId().equals(id)) {
                return Optional.of(dt);
            }
        }
        return Optional.empty();
    }

    public Optional<DeTai> findByTen(String ten) {
        for (DeTai dt : danhSachDeTai) {
            if (dt.getTenDeTai().equalsIgnoreCase(ten)) {
                return Optional.of(dt);
            }
        }
        return Optional.empty();
    }

    public void capNhat(DeTai deTaiCapNhat) {
        for (int i = 0; i < danhSachDeTai.size(); i++) {
            if (danhSachDeTai.get(i).getId().equals(deTaiCapNhat.getId())) {
                danhSachDeTai.set(i, deTaiCapNhat);
                System.out.println("REPOSITORY: Da cap nhat de tai ID: " + deTaiCapNhat.getId());
                return;
            }
        }
        System.out.println("REPOSITORY Loi: Khong tim thay de tai ID " + deTaiCapNhat.getId() + " de cap nhat.");
    }

    public void xoa(String id) {
        boolean removed = danhSachDeTai.removeIf(dt -> dt.getId().equals(id));
        if (removed) {
            System.out.println("REPOSITORY: Da xoa de tai ID: " + id);
        } else {
            System.out.println("REPOSITORY Loi: Khong tim thay de tai ID " + id + " de xoa.");
        }
    }

    public List<DeTai> layTatCa() {
        return new ArrayList<>(danhSachDeTai);
    }

    public void hienThiTatCa() {
        System.out.println("\n--- DANH SACH DE TAI HIEN TAI (trong Repository) ---");
        if (danhSachDeTai.isEmpty()) {
            System.out.println("(Trong)");
        } else {
            for (DeTai dt : danhSachDeTai) {
                System.out.println(dt); // toString của DeTai đã được sửa
            }
        }
        System.out.println("----------------------------------------------------");
    }
}