/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.service.impl;

import com.dgh.pojo.ChiNhanh;
import com.dgh.repository.ChiNhanhRepository;
import com.dgh.service.ChiNhanhService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class ChiNhanhServiceImpl implements ChiNhanhService {

    @Autowired
    private ChiNhanhRepository chiNhanhRepo;

    @Override
    public List<ChiNhanh> getChiNhanh() {
        return this.chiNhanhRepo.getChiNhanh();
    }

    @Override
    public boolean addOrUpdateChiNhanh(ChiNhanh cn) {
        return this.chiNhanhRepo.addOrUpdateChiNhanh(cn);
    }

    @Override
    public ChiNhanh getChiNhanhById(int id) {
        return this.chiNhanhRepo.getChiNhanhById(id);
    }

//    @Override
//    public ChiNhanh getChiNhanhNativeById(int id) {
//        return this.chiNhanhRepo.getChiNhanhNativeById(id);
//    }

}
