/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.service.impl;

import com.dgh.pojo.ThucDon;
import com.dgh.repository.ThucDonRepository;
import com.dgh.service.ThucDonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class ThucDonServiceImpl implements ThucDonService{
    @Autowired
    private ThucDonRepository thucDonRepo;

    @Override
    public List<ThucDon> getThucDon() {
        return this.thucDonRepo.getThucDon();
    }

    @Override
    public boolean addOrUpdateThucDon(ThucDon td) {
        return this.thucDonRepo.addOrUpdateThucDon(td);
    }
    
}
