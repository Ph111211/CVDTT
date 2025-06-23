/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main_mediator;

/**
 *
 * @author ADMIN
 */

public class DichVuQuanLyDoAn {
    public String layDanhSachDoAnChoVPK() {
        return "1. SV001 - Do an A\n2. SV002 - Do an B\n3. SV003 - Do an C (Chua co diem)";
    }

    public DoAn timDoAnTheoMa(String maSV) {
        if ("SV001".equals(maSV)) {
            DoAn da = new DoAn("SV001", "Do an A");
            da.diem = 7.5;
            da.trangThai = "Hoan thanh"; // Tiếng Việt không dấu
            da.nhanXetGV = "Can xem lai chuong 2.";
            return da;
        }
        if ("SV003".equals(maSV)) {
            DoAn da = new DoAn("SV003", "Do an C");
            // Giá trị mặc định từ constructor của DoAn sẽ được giữ nguyên (ví dụ: "Chua hoan thanh")
            return da;
        }
        return null;
    }
}