/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.repository;

import com.dgh.pojo.ThucDon;
import java.util.List;


/**
 *
 * @author DELL
 */
public interface ThucDonRepository {
    List<ThucDon> getThucDon();
    boolean addOrUpdateThucDon(ThucDon td);
}
