/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.service.impl;

import com.dgh.pojo.DichVu;
import com.dgh.repository.DichVuRepository;
import com.dgh.service.DichVuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class DichVuServiceImpl implements DichVuService{
    @Autowired
    private DichVuRepository dichVuRepo;

    @Override
    public List<DichVu> getDichVu() {
        return this.dichVuRepo.getDichVu();
    }

    @Override
    public boolean addOrUpdateDichVu(DichVu dv) {
        return this.dichVuRepo.addOrUpdateDichVu(dv);
    }
    
}
