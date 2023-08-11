package com.dgh.pojo;

import com.dgh.pojo.ChiNhanh;
import com.dgh.pojo.HoaDonThanhToan;
import com.dgh.pojo.LoaiTiec;
import com.dgh.pojo.ThongTinChiTietDatTiec;
import com.dgh.pojo.ThongTinChiTietKhachHangDatTiec;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-11T20:25:53")
@StaticMetamodel(PhieuDatBan.class)
public class PhieuDatBan_ { 

    public static volatile SingularAttribute<PhieuDatBan, Float> tienConLai;
    public static volatile SingularAttribute<PhieuDatBan, ThongTinChiTietKhachHangDatTiec> chiTietKhachHangId;
    public static volatile SingularAttribute<PhieuDatBan, Float> tongTien;
    public static volatile SingularAttribute<PhieuDatBan, Boolean> isDelete;
    public static volatile SingularAttribute<PhieuDatBan, Integer> id;
    public static volatile SingularAttribute<PhieuDatBan, Float> tienCoc;
    public static volatile SingularAttribute<PhieuDatBan, Date> ngayXuatPhieu;
    public static volatile SetAttribute<PhieuDatBan, HoaDonThanhToan> hoaDonThanhToanSet;
    public static volatile SingularAttribute<PhieuDatBan, ThongTinChiTietDatTiec> chiTietDatTiecId;
    public static volatile SingularAttribute<PhieuDatBan, ChiNhanh> chiNhanhId;
    public static volatile SingularAttribute<PhieuDatBan, LoaiTiec> loaiTiecId;

}