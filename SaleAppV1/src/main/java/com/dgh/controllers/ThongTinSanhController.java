/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.controllers;

import com.dgh.pojo.ThongTinSanh;
import com.dgh.service.ThongTinSanhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author DELL
 */
@Controller
public class ThongTinSanhController {

    @Autowired
    private ThongTinSanhService ThongTinSanhService;

    @GetMapping("/thongTinSanh")
    public String list() {
        return "thongTinSanh";
    }

    @GetMapping("/themSanh")
    public String listAdd(Model model) {
        model.addAttribute("themSanh", new ThongTinSanh());
        return "themSanh";
    }
    
    @GetMapping("/themSanh/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("themSanh", this.ThongTinSanhService.getSanhById(id));
        return "themSanh";
    }

    @PostMapping("/themSanh")
    public String add(@ModelAttribute(value = "themSanh") ThongTinSanh s) {
        if (this.ThongTinSanhService.addOrUpdateSanh(s) == true) {
            return "redirect:thongTinSanh";
        }
        return "themSanh";
    }
}
