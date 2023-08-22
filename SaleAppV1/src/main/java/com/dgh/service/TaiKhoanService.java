/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.service;

import com.dgh.pojo.TaiKhoan;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author DELL
 */
public interface TaiKhoanService extends UserDetailsService{
    boolean addTaiKhoan(TaiKhoan tk);
    TaiKhoan addUser(Map<String, String> params, MultipartFile avatar);
    boolean deleteTaiKhoanById(int id);
    TaiKhoan getTaiKhoanByTenDangNhap(String tenDangNhap);
    boolean authUser(String tenDangNhap, String matKhau);
}
