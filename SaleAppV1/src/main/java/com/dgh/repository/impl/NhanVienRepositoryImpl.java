/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.repository.impl;

import com.dgh.dto.NhanVienDTO;
import com.dgh.pojo.NhanVien;
import com.dgh.pojo.TaiKhoan;
import com.dgh.repository.NhanVienRepository;
import java.util.ArrayList;
import java.util.Date;
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
public class NhanVienRepositoryImpl implements NhanVienRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<NhanVienDTO> getNhanVien() {
        Session session = this.factory.getObject().getCurrentSession();
        Query q = session.createNativeQuery("Select nhan_vien.id, nhan_vien.ten_nhan_vien, nhan_vien.ngay_sinh, nhan_vien.so_dien_thoai, \n"
                + "nhan_vien.email, nhan_vien.gioi_tinh, nhan_vien.dia_chi, nhan_vien.ngay_vao_lam, chi_nhanh.ten_chi_nhanh, \n"
                + "chuc_vu.chuc_vu, tai_khoan.ten_dang_nhap, tai_khoan.mat_khau, tai_khoan.vai_tro\n"
                + "from nhan_vien \n"
                + "join chi_nhanh on nhan_vien.chi_nhanh_id = chi_nhanh.id\n"
                + "join chuc_vu on nhan_vien.chuc_vu_id = chuc_vu.id\n"
                + "join tai_khoan on nhan_vien.tai_khoan_id = tai_khoan.id");
        List<Object[]> rows = q.getResultList();
        List<NhanVienDTO> nhanVienList = new ArrayList<>();

        for (Object[] row : rows) {
            NhanVienDTO nhanVien = new NhanVienDTO();
            nhanVien.setId(((Integer) row[0]));
            nhanVien.setTenNhanVien((String) row[1]);
            nhanVien.setNgaySinh((Date) row[2]);
            nhanVien.setEmail((String) row[3]);
            nhanVien.setSoDienThoai((String) row[4]);
            nhanVien.setGioiTinh((Integer) row[5]);
            nhanVien.setDiaChi((String) row[6]);
            nhanVien.setNgayVaoLam((Date) row[7]);
            nhanVien.setChiNhanh((String) row[8]);
            nhanVien.setChucVu((String) row[9]);
            nhanVien.setTaiKhoan((String) row[10]);
            nhanVienList.add(nhanVien);

        }
        return nhanVienList;
    }

//    @Override
//    public NhanVien addOrUpdateNhanVien(NhanVien nv) {
//        Session s = this.factory.getObject().getCurrentSession();
//        try {
//            NhanVien n = timKiemNhanVienById(nv.getId());
//            if(n == null) {
//                s.save(nv);
//            } else {
//                s.update(nv);
//            }
//            
//            return nv;
//        } catch (HibernateException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }
//    
//    
//
//    @Override
//    public NhanVien timKiemNhanVienById(int id) {
//        Session s = this.factory.getObject().getCurrentSession();
//        Query q = s.createNativeQuery("Select * From nhan_vien where nhan_vien.id = ?");
//        
//        q.setParameter(1, id);
//        
//        return (NhanVien) q.getSingleResult();
//        
//    }

    @Override
    public boolean addNhanVien(NhanVien nv) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if(nv.getId() == null) {
                s.save(nv);
            } else
                s.update(nv);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
