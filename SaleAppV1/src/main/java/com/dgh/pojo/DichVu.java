/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "dich_vu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DichVu.findAll", query = "SELECT d FROM DichVu d"),
    @NamedQuery(name = "DichVu.findById", query = "SELECT d FROM DichVu d WHERE d.id = :id"),
    @NamedQuery(name = "DichVu.findByLoaiDichVu", query = "SELECT d FROM DichVu d WHERE d.loaiDichVu = :loaiDichVu"),
    @NamedQuery(name = "DichVu.findByGiaDichVu", query = "SELECT d FROM DichVu d WHERE d.giaDichVu = :giaDichVu"),
    @NamedQuery(name = "DichVu.findByIsDelete", query = "SELECT d FROM DichVu d WHERE d.isDelete = :isDelete")})
public class DichVu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "loai_dich_vu")
    private String loaiDichVu;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "gia_dich_vu")
    private Float giaDichVu;
    @Column(name = "isDelete")
    private Boolean isDelete;
    @OneToMany(mappedBy = "dichVuId")
    private Set<ThongTinChiTietDatTiec> thongTinChiTietDatTiecSet;

    public DichVu() {
    }

    public DichVu(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoaiDichVu() {
        return loaiDichVu;
    }

    public void setLoaiDichVu(String loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
    }

    public Float getGiaDichVu() {
        return giaDichVu;
    }

    public void setGiaDichVu(Float giaDichVu) {
        this.giaDichVu = giaDichVu;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    @XmlTransient
    public Set<ThongTinChiTietDatTiec> getThongTinChiTietDatTiecSet() {
        return thongTinChiTietDatTiecSet;
    }

    public void setThongTinChiTietDatTiecSet(Set<ThongTinChiTietDatTiec> thongTinChiTietDatTiecSet) {
        this.thongTinChiTietDatTiecSet = thongTinChiTietDatTiecSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DichVu)) {
            return false;
        }
        DichVu other = (DichVu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dgh.pojo.DichVu[ id=" + id + " ]";
    }
    
}
