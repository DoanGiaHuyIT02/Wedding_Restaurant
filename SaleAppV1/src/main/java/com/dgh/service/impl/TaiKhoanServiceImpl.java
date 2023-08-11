/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.service.impl;

import com.dgh.pojo.TaiKhoan;
import com.dgh.repository.TaiKhoanRepository;
import com.dgh.service.TaiKhoanService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class TaiKhoanServiceImpl implements TaiKhoanService{
    @Autowired
    private TaiKhoanRepository taiKhoanRepo;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public boolean addTaiKhoan(TaiKhoan tk) {
        tk.setMatKhau(encoder.encode(tk.getMatKhau()));
        return this.taiKhoanRepo.addTaiKhoan(tk);
    }

    @Override
    public UserDetails loadUserByUsername(String tenDangNhap) throws UsernameNotFoundException {
        TaiKhoan u = this.taiKhoanRepo.getTaiKhoanByTenDangNhap(tenDangNhap);
        if (u == null) {
            throw new UsernameNotFoundException("Invalid");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getVaiTro()));
        return new org.springframework.security.core.userdetails.User(
                u.getTenDangNhap(), u.getMatKhau(), authorities);
    }

   
    
}
