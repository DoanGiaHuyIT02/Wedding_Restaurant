/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.service.impl;

import com.dgh.dto.NhanVienDTO;
import com.dgh.pojo.NhanVien;
import com.dgh.repository.NhanVienRepository;
import com.dgh.service.NhanVienService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class NhanVienServiceImpl implements NhanVienService{

    @Autowired
    private NhanVienRepository nhanVienRepo;
    
    @Override
    public List<NhanVienDTO> getNhanVien() {
        return this.nhanVienRepo.getNhanVien();
    }

//    @Override
//    public NhanVien addOrUpdateNhanVien(NhanVien nv) {
//        return this.nhanVienRepo.addOrUpdateNhanVien(nv);
//    }

    @Override
    public boolean addNhanVien(NhanVien nv) {
        return this.nhanVienRepo.addNhanVien(nv);
    }


    
}
