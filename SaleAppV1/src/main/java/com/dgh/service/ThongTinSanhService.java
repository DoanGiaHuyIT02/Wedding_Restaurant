/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.service;

import com.dgh.pojo.ThongTinSanh;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface ThongTinSanhService {
    List<ThongTinSanh> getThongTinSanh(Map<String, String> params); 
    boolean addOrUpdateSanh(ThongTinSanh s);
    ThongTinSanh getSanhById(int id);
    boolean deleteSanh(int id);
    Long countThongTinSanh();
}
