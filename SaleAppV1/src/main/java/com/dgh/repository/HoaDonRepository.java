/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.repository;

import com.dgh.dto.HoaDonDTO;
import com.dgh.pojo.HoaDonThanhToan;

/**
 *
 * @author DELL
 */
public interface HoaDonRepository {
    HoaDonDTO getHoaDonDtoByPhieuDatBanId(int id);
    HoaDonThanhToan addThanhToanHoaDon(HoaDonThanhToan hd);
}
