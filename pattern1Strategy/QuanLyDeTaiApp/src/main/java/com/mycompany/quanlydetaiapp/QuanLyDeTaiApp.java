/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quanlydetaiapp;

/**
 *
 * @author ADMIN
 */
public class QuanLyDeTaiApp {
    public static void main(String[] args) {
        DeTaiRepository repository = new DeTaiRepository();
        DeTaiManager manager = new DeTaiManager(repository);
        String ketQua;

        System.out.println("\n=== THAO TAC THEM DE TAI ===");
        manager.setStrategy(new ThemDeTaiStrategy());
        ketQua = manager.performAction(
                null,
                "Web GIS Quan ly Tai nguyen Nuoc",
                "Xay dung ban do GIS truc tuyen.",
                "ArcGIS API, JavaScript, Geoserver",
                2
        );
        System.out.println("Client nhan: " + ketQua);
        if (ketQua.contains("thanh cong")) repository.hienThiTatCa();

        ketQua = manager.performAction(null, "", "Mo ta", "Yeu cau", 1);
        System.out.println("Client nhan: " + ketQua);


        System.out.println("\n=== THAO TAC SUA DE TAI  ===");
        manager.setStrategy(new SuaDeTaiStrategy());
        DeTai dtTam = new DeTai.Builder("De tai tam de sua").build();
        repository.them(dtTam);
        String idCanSua = dtTam.getId();

        ketQua = manager.performAction(
                idCanSua,
                "Web GIS Quan ly Tai nguyen Nuoc Ngam (Da sua)",
                "Cap nhat: Tap trung vao nuoc ngam.",
                "Python, Geopandas, Folium",
                3
        );
        System.out.println("Client nhan: " + ketQua);
        if (ketQua.contains("thanh cong")) repository.hienThiTatCa();


        System.out.println("\n=== THAO TAC XOA DE TAI  ===");
        String idCanXoa = idCanSua;
        ketQua = manager.performDeleteAction(idCanXoa);
        System.out.println("Client nhan: " + ketQua);
        if (ketQua.contains("thanh cong")) repository.hienThiTatCa();
    }
}