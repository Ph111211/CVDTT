/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlydetaiapp;

/**
 *
 * @author ADMIN
 */
// File: IDeTaiOperationStrategy.java

public interface IDeTaiOperationStrategy {
    /**
     * Thực thi hành động quản lý đề tài.
     * Các tham số sẽ được truyền trực tiếp thay vì qua DTO.
     * Một số tham số có thể là null tùy theo hành động.
     * @return String Kết quả/Thông báo của hành động
     */
    String execute(String id, String tenDeTai, String moTa, String yeuCau, int soLuongSV, DeTaiRepository repository);
}