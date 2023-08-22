/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.repository.impl;

import com.dgh.pojo.TaiKhoan;
import com.dgh.repository.TaiKhoanRepository;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class TaiKhoanRepositoryImpl implements TaiKhoanRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private BCryptPasswordEncoder endcoder;

    @Override
    public boolean addTaiKhoan(TaiKhoan tk) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(tk);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public TaiKhoan timKiemTaiKhoanById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(TaiKhoan.class, id);
    }

    @Override
    public TaiKhoan getTaiKhoanByTenDangNhap(String tenDangNhap) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From TaiKhoan Where tenDangNhap=:un");
        q.setParameter("un", tenDangNhap);

        return (TaiKhoan) q.getSingleResult();
    }

    @Override
    public boolean deleteTaiKhoanById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        TaiKhoan tk = this.timKiemTaiKhoanById(id);
        try {
            s.delete(tk);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean authUser(String tenDangNhap, String matKhau) {
        TaiKhoan u = this.getTaiKhoanByTenDangNhap(tenDangNhap);

        return this.endcoder.matches(matKhau, u.getMatKhau());
    }

    @Override
    public TaiKhoan addUser(TaiKhoan tk) {
        Session s = this.factory.getObject().getCurrentSession();
       s.save(tk);
       return tk;
    }

}
