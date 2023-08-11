/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.controllers;

import com.dgh.service.ChiNhanhService;
import com.dgh.service.ChucVuService;
import com.dgh.service.DichVuService;
import com.dgh.service.LoaiTiecService;
import com.dgh.service.NhanVienService;
import com.dgh.service.ThucDonService;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")
public class IndexController {
    @Autowired
    private LoaiTiecService loaiTiecService;
    @Autowired
    private ChiNhanhService chiNhanhService;
    @Autowired
    private DichVuService dichVuService;
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private ThucDonService thucDonService;
    @Autowired
    private ChucVuService chucVuService;
    
    @ModelAttribute
    public void commonAttri(Model model) {
        model.addAttribute("loaiTiecs", this.loaiTiecService.getLoaiTiec());
        model.addAttribute("chiNhanh", this.chiNhanhService.getChiNhanh());
        model.addAttribute("dichVu", this.dichVuService.getDichVu());
        model.addAttribute("nhanVien", this.nhanVienService.getNhanVien());
        model.addAttribute("thucDon", this.thucDonService.getThucDon());
        model.addAttribute("chucVu", this.chucVuService.getChucVu());
    }
    
    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        return "index";
    }
}
