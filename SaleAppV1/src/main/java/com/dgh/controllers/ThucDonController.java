/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.controllers;

import com.dgh.pojo.ThucDon;
import com.dgh.service.ThucDonService;
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
public class ThucDonController {
    @Autowired
    private ThucDonService thucDonService;
    
    @GetMapping("/thucDon")
    public String list() {
        return "thucDon";
    }
    
    @GetMapping("/themThucDon")
    public String listAdd(Model model) {
        model.addAttribute("themThucDon", new ThucDon());
        return "themThucDon";
    }
    
    @PostMapping("/themThucDon")
    public String add(@ModelAttribute(value = "themThucDon") ThucDon td) {
        if(this.thucDonService.addOrUpdateThucDon(td) == true) {
            return "redirect:thucDon";
        }
        
        return "themThucDon";
    }
}
