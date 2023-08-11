/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.repository;

import com.dgh.dto.NhanVienDTO;
import com.dgh.pojo.NhanVien;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface NhanVienRepository {
    List<NhanVienDTO> getNhanVien();
    boolean addNhanVien(NhanVien nv);
  
}
