/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.service;

import com.dgh.pojo.ThucDon;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface ThucDonService {
    List<ThucDon> getThucDon();
    boolean addOrUpdateThucDon(ThucDon td);
    ThucDon getThucDonById(int id);
    boolean deleteThucDonById(int id);
}
