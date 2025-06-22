/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlydetaiapp;

/**
 *
 * @author ADMIN
 */
// File: DeTaiManager.java
// File: DeTaiManager.java

public class DeTaiManager {
    private IDeTaiOperationStrategy currentOperation;
    private DeTaiRepository repository;

    public DeTaiManager(DeTaiRepository repository) {
        this.repository = repository;
    }

    public void setStrategy(IDeTaiOperationStrategy strategy) {
        this.currentOperation = strategy;
    }

    public String performAction(String id, String tenDeTai, String moTa, String yeuCau, int soLuongSV) {
        if (this.currentOperation == null) {
            return "Loi: Chua chon hanh dong (chien luoc)!";
        }
        if (this.repository == null) {
            return "Loi: Repository chua duoc khoi tao!";
        }
        System.out.println("DeTaiManager: Chuan bi thuc thi hanh dong...");
        String result = this.currentOperation.execute(id, tenDeTai, moTa, yeuCau, soLuongSV, this.repository);
        System.out.println("DeTaiManager: Hoan thanh hanh dong. Ket qua: " + result);
        return result;
    }

    public String performDeleteAction(String id) {
        if (this.currentOperation == null || !(this.currentOperation instanceof XoaDeTaiStrategy)) {
            this.setStrategy(new XoaDeTaiStrategy());
        }
        if (this.repository == null) {
            return "Loi: Repository chua duoc khoi tao!";
        }
        System.out.println("DeTaiManager: Chuan bi thuc thi hanh dong XOA...");
        String result = this.currentOperation.execute(id, null, null, null, 0, this.repository);
        System.out.println("DeTaiManager: Hoan thanh hanh dong XOA. Ket qua: " + result);
        return result;
    }
}