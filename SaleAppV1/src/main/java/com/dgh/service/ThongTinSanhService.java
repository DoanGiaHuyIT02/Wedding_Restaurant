/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.service;

import com.dgh.pojo.ThongTinSanh;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface ThongTinSanhService {
    List<ThongTinSanh> getThongTinSanh(); 
    boolean addOrUpdateSanh(ThongTinSanh s);
    ThongTinSanh getSanhById(int id);
    boolean deleteSanh(int id);
}
