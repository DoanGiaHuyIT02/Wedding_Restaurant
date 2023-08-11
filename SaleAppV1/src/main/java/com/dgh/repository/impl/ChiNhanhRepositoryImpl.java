/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.repository.impl;

import com.dgh.pojo.ChiNhanh;
import com.dgh.repository.ChiNhanhRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class ChiNhanhRepositoryImpl implements ChiNhanhRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<ChiNhanh> getChiNhanh() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM ChiNhanh");

        return q.getResultList();
    }

    @Override
    public boolean addOrUpdateChiNhanh(ChiNhanh cn) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if(cn.getId() == null) {
                s.save(cn);
            } else {
                s.update(cn);
            }
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public ChiNhanh getChiNhanhById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(ChiNhanh.class, id);
    }

//    @Override
//    public ChiNhanh getChiNhanhNativeById(int id) {
//        Session s = this.factory.getObject().getCurrentSession();
//        Query q = s.createNativeQuery("Select * From chi_nhanh where chi_nhanh.id = ?");
//        
//        q.setParameter(0, id);
//        
//        return (ChiNhanh) q.getSingleResult();
//    }

   

}
