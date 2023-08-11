/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.controllers;

import com.dgh.pojo.LoaiTiec;
import com.dgh.service.LoaiTiecService;
import com.github.mustachejava.Binding;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author DELL
 */
@Controller
public class LoaiTiecController {

    @Autowired
    private LoaiTiecService loaiTiecService;

    @GetMapping("/loaiTiec")
    public String list() {
        return "loaiTiec";
    }

    @GetMapping("/themLoaiTiec")
    public String listAdd(Model model) {
        model.addAttribute("themLoaiTiec", new LoaiTiec());
        return "themLoaiTiec";
    }

    @GetMapping("/themLoaiTiec/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("themLoaiTiec", this.loaiTiecService.getLoaiTiecById(id));
        return "themLoaiTiec";
    }

    @PostMapping("/themLoaiTiec")
    public String add(@ModelAttribute(value = "themLoaiTiec") @Valid LoaiTiec l,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (this.loaiTiecService.addOrUpdateLoaiTiec(l) == true) {
                return "redirect:loaiTiec";
            }
        }
        return "themLoaiTiec";
    }

}
