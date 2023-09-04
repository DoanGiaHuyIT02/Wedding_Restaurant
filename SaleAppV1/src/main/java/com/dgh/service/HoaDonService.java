/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.service;

import com.dgh.dto.HoaDonDTO;
import com.dgh.dto.HoaDonDaThanhToanOnlineDTO;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface HoaDonService {
    HoaDonDTO getHoaDonDtoById(int id);
    HoaDonDaThanhToanOnlineDTO getHoaDonDaThanhToanByPhieuDatBanId(int id);
    boolean ThanhToanHoaHon (Map<String, String> params);
}
