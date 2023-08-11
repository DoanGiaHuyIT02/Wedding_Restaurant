/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.repository.impl;

import com.dgh.pojo.LoaiTiec;
import com.dgh.repository.LoaiTiecRepository;
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
 * @author admin
 */
@Repository
@Transactional
public class LoaiTiecRepositoryImpl implements LoaiTiecRepository {

    @Autowired
    private LocalSessionFactoryBean factory;


    @Override
    public List<LoaiTiec> getLoaiTiec() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM LoaiTiec");

        return q.getResultList();
    }

    @Override
    public boolean addOrUpdateLoaiTiec(LoaiTiec l) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if(l.getId() == null) {
                s.save(l);
            } else {
                s.update(l);
            }
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public LoaiTiec getLoaiTiecById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(LoaiTiec.class, id);
    }

    @Override
    public boolean deleteLoaiTiec(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        LoaiTiec lt = this.getLoaiTiecById(id);
        try {
            s.delete(lt);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    

}
