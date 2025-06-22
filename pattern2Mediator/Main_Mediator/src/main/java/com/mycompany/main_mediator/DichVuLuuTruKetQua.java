/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main_mediator;

/**
 *
 * @author ADMIN
 */

public class DichVuLuuTruKetQua {
    public boolean luu(DoAn doAnDaCapNhat) {
        System.out.println("DICH VU LUU TRU: Dang luu do an cua SV " + doAnDaCapNhat.maSinhVien);
        System.out.println("DICH VU LUU TRU: Luu thanh cong vao CSDL gia lap. Du lieu moi: " + doAnDaCapNhat.toString());
        return true;
    }
}