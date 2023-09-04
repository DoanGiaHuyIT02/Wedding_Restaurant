/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.service.impl;

import com.dgh.dto.HoaDonDTO;
import com.dgh.dto.HoaDonDaThanhToanOnlineDTO;
import com.dgh.pojo.HoaDonThanhToan;
import com.dgh.pojo.PhieuDatBan;
import com.dgh.repository.HoaDonRepository;
import com.dgh.repository.PhieuDatBanRepository;
import com.dgh.service.HoaDonService;
import java.util.Date;
import java.util.Map;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepo;
    @Autowired
    private PhieuDatBanRepository phieuDatBanRepo;

    @Override
    public HoaDonDTO getHoaDonDtoById(int id) {
        return this.hoaDonRepo.getHoaDonDtoByPhieuDatBanId(id);
    }
    
    @Override
    public HoaDonDaThanhToanOnlineDTO getHoaDonDaThanhToanByPhieuDatBanId(int id) {
        return this.hoaDonRepo.getHoaDonDaThanhToanByPhieuDatBanId(id);
    }

    @Override
    public boolean ThanhToanHoaHon(Map<String, String> params) {
        String maThanhToan = params.get("maThanhToan");
        if (!maThanhToan.equals("HUY123")) {
            return false;
        }

        HoaDonDTO hoaDonDto = this.hoaDonRepo.getHoaDonDtoByPhieuDatBanId(Integer.parseInt(params.get("id")));

        PhieuDatBan pdt = this.phieuDatBanRepo.getPhieuDatBanById(Integer.parseInt(params.get("id")));
        if (pdt == null) {
//            throw new NotFoundException("Phiếu đặt bàn không hợp lệ");
        }

        double floatValue = (double) hoaDonDto.getTongTienHoaDon();
        pdt.setTongTien(floatValue);
        pdt.setNgayDatCoc(new Date());
        pdt.setTienCoc(0.0);

        boolean isUpdateSuccess = this.phieuDatBanRepo.updatePayPhieuDatBan(pdt);
        if (isUpdateSuccess) {
            HoaDonThanhToan hdtt = new HoaDonThanhToan();
            hdtt.setMaThanhToan(params.get("maThanhToan"));
            hdtt.setNgayThanhToan(new Date());
            hdtt.setPhieuDatBanId(pdt);
            hdtt.setIsActive(Boolean.TRUE);
            
            HoaDonThanhToan hd = this.hoaDonRepo.addThanhToanHoaDon(hdtt);
        }

        return true;
    }

    

}
