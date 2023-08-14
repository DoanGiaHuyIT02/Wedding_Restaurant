/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.repository.impl;

import com.dgh.pojo.ThongTinSanh;
import com.dgh.repository.ThongTinSanhRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateError;
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
public class ThongTinSanhRepositoryImpl implements ThongTinSanhRepository{
    
     @Autowired
    private LocalSessionFactoryBean factory;
     
    @Override
    public List<ThongTinSanh> getThongTinSanh() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM ThongTinSanh Where isDelete = 0");

        return q.getResultList();
    }

    @Override
    public boolean addOrUpdateSanh(ThongTinSanh s) {
         Session session = this.factory.getObject().getCurrentSession();
         try {
            if(s.getId() == null) {
                session.save(s);
            } else {
                session.update(s);
            }
            
            return true;
        } catch (HibernateError ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public ThongTinSanh getSanhById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(ThongTinSanh.class, id);
    }

    @Override
    public boolean deleteSanh(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        ThongTinSanh t = this.getSanhById(id);
        t.setIsDelete(true);
        try {
            s.update(t);
            return true;
        } catch (HibernateError ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
