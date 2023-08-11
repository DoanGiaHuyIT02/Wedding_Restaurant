/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.service;

import com.dgh.pojo.LoaiTiec;
import java.util.List;

/**
 *
 * @author admin
 */
public interface LoaiTiecService {
    List<LoaiTiec> getLoaiTiec();
    boolean addOrUpdateLoaiTiec(LoaiTiec l);
    LoaiTiec getLoaiTiecById(int id);
    boolean deleteLoaiTiec(int id);
}
