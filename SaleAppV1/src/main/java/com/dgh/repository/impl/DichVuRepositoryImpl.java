/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.repository.impl;

import com.dgh.pojo.DichVu;
import com.dgh.repository.DichVuRepository;
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
public class DichVuRepositoryImpl implements DichVuRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<DichVu> getDichVu() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM DichVu Where isDelete = 0");

        return q.getResultList();
    }

    @Override
    public boolean addOrUpdateDichVu(DichVu dv) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if(dv.getId() == null) {
                
                s.save(dv);
            } else 
                s.update(dv);
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public DichVu getDichVuById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(DichVu.class, id);
    }

    @Override
    public boolean deleteDichVu(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        DichVu dv = this.getDichVuById(id);
        dv.setIsDelete(Boolean.TRUE);
        try {
            s.update(dv);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
