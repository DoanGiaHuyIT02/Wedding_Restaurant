/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.controllers;

import com.dgh.pojo.DichVu;
import com.dgh.service.DichVuService;
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
public class DichVuController {
    @Autowired
    private DichVuService dichVuService;
    
    @GetMapping("/dichVu")
    public String list() {
        return "dichVu";
    }
    
    @GetMapping("/themDichVu")
    public String listAdd(Model model) {
        model.addAttribute("themDichVu", new DichVu());
        return "themDichVu";
    }
    
    @PostMapping("/themDichVu")
    public String add(@ModelAttribute(value = "themDichVu") DichVu dv) {
        if(this.dichVuService.addOrUpdateDichVu(dv) == true) {
            return "redirect:dichVu";
        }
        
        return "themDichVu";
    }
}
