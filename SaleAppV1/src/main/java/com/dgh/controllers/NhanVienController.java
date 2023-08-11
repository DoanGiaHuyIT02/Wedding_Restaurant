/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.controllers;

import com.dgh.pojo.NhanVien;
import com.dgh.service.ChiNhanhService;
import com.dgh.service.ChucVuService;
import com.dgh.service.NhanVienService;
import com.dgh.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author DELL
 */
@Controller
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping("/nhanVien")
    public String list() {
        return "nhanVien";
    }

    @GetMapping("/themNhanVien")
    public String listAdd(Model model) {
        model.addAttribute("themNhanVien", new NhanVien());
        return "themNhanVien";
    }
    
    @PostMapping("/themNhanVien")
    public String themNhanVien(@ModelAttribute(value = "themNhanVien") NhanVien nv) {
        
        if(this.taiKhoanService.addTaiKhoan(nv.getTaiKhoanId()) == true) {
            if(this.nhanVienService.addNhanVien(nv) == true) {
                return "redirect:nhanVien";
            }
        }
        return "themNhanVien";
    }


}
