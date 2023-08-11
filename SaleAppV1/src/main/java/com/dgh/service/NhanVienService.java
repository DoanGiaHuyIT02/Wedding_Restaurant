/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.service;

import com.dgh.dto.NhanVienDTO;
import com.dgh.pojo.NhanVien;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface NhanVienService {
    List<NhanVienDTO> getNhanVien();
    boolean addNhanVien(NhanVien nv);
//    NhanVien addOrUpdateNhanVien(NhanVien nv);
}
