/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.repository;

import com.dgh.pojo.TaiKhoan;

/**
 *
 * @author DELL
 */
public interface TaiKhoanRepository {
    TaiKhoan getTaiKhoanByTenDangNhap(String tenDangNhap);
    boolean addTaiKhoan(TaiKhoan tk);
    TaiKhoan addUser(TaiKhoan tk);
    TaiKhoan timKiemTaiKhoanById(int id);
    boolean deleteTaiKhoanById(int id);
    boolean authUser(String tenDangNhap, String matKhau);
}
