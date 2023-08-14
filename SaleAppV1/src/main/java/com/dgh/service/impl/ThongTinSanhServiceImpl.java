/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.service.impl;

import com.dgh.pojo.ThongTinSanh;
import com.dgh.repository.ThongTinSanhRepository;
import com.dgh.service.ThongTinSanhService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class ThongTinSanhServiceImpl implements ThongTinSanhService{

    @Autowired
    private ThongTinSanhRepository thongTinSanhRepo;
    @Override
    public List<ThongTinSanh> getThongTinSanh() {
        return this.thongTinSanhRepo.getThongTinSanh();
    }

    @Override
    public boolean addOrUpdateSanh(ThongTinSanh s) {
        return this.thongTinSanhRepo.addOrUpdateSanh(s);
    }

    @Override
    public ThongTinSanh getSanhById(int id) {
        return this.thongTinSanhRepo.getSanhById(id);
    }

    @Override
    public boolean deleteSanh(int id) {
        return this.thongTinSanhRepo.deleteSanh(id);
    }
    
}
