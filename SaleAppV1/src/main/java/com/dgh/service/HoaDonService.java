/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.service;

import com.dgh.dto.HoaDonDTO;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface HoaDonService {
    HoaDonDTO getHoaDonDtoById(int id);
    boolean ThanhToanHoaHon (Map<String, String> params);
}
