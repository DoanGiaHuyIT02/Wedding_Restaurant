/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dgh.service;

import com.dgh.pojo.AnhSanh;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface AnhSanhService {
    List<AnhSanh> getAnhSanh();
    boolean addOrUploadAnhSanh(AnhSanh as);
    AnhSanh getAnhSanhById(int id);
}