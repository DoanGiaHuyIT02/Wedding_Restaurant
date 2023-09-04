import { useEffect, useState } from "react";
import './Bill.css';
import Apis, { endpoint } from "../../configs/Apis";
import { format } from "date-fns";
import { Link } from "react-router-dom";

const Bill = () => {
    const [thanhToan, setThanhToan] = useState(null);

    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');


    const fetchThanhToanHoaDon = async (id) => {
        Apis.get(`${endpoint.thanhToan}?id=${id}`)
            .then(res => {
                setThanhToan(res.data);
                console.log("--- fetchThanhToanHoaDon", res.data);
                console.log("tenLoaitiec", res.data.loaiTiec.tenLoaiTiec);
            })
            .catch(error => {
                console.error(error);
            });
    };

    useEffect(() => {
        fetchThanhToanHoaDon(id);
    }, [id]);

    console.log(thanhToan);

    if (!thanhToan) {
        return <h1>Test</h1>
    }

    let urlThanhToanOnline = `/payMomo?id=${id}`;
    return (
        <>
            <section>
                <div className="row">
                    <h1 className="text-center mt-3">Thanh toán đặt tiệc</h1>
                    <div className="col-md-6 container" style={{}}>
                        <h3>Thông tin khách hàng</h3>
                        <ul>
                            <li className="bill_info">
                                Họ và tên khách hàng:
                                <p>{thanhToan.tenKhachHang}</p>
                            </li>
                            <li className="bill_info">
                                Số điện thoại:
                                <p>{thanhToan.soDienThoai}</p>
                            </li>
                            <li className="bill_info">
                                Địa chỉ:
                                <p>{thanhToan.diaChi}</p>
                            </li>
                        </ul>
                    </div>
                    <div className="col-md-6" style={{}}>
                        <h3>Thông tin đặt tiệc</h3>
                        <ul>
                            <li className="bill_info" >
                                Loại tiệc:
                                <p> {thanhToan.loaiTiec.tenLoaiTiec}</p>
                            </li>
                            <li className="bill_info" >
                                Loại sảnh: <p>{thanhToan.tenSanh.tenSanh}</p>
                            </li>
                            <li className="bill_info" >
                                Dịch vụ:
                                <p>{thanhToan.loaiDichVu.loaiDichVu}</p>
                            </li>
                            <li className="bill_info">
                                Thực đơn:
                                <p>{thanhToan.maThucDon.maThucDon}</p>
                            </li>
                            <li className="bill_info" >
                                Số lượng bàn: <p>{thanhToan.soLuongBan}</p>
                            </li>
                            <li className="bill_info">
                                Ngày tổ chức: <p> {format(thanhToan.ngayToChuc, 'dd/MM/yyyy')}</p>
                            </li>
                            <li className="bill_info" >
                                Buổi tổ chức: <p> {thanhToan.ca === "SA" ? "Buổi sáng" : thanhToan.ca === "CH" ? "Buổi chiều" : "Buổi tối"}</p>
                            </li>
                        </ul>
                        <hr />
                        <div>
                            <div className="bill_price">
                                <p>{thanhToan.tenSanh.tenSanh}:</p>
                                <p>{thanhToan.tongTienSanh.toLocaleString('vi-VN')} VND</p>
                            </div>
                            <div className="bill_price">
                                <p>{thanhToan.maThucDon.maThucDon}:</p>
                                <p>{thanhToan.maThucDon.giaGoi.toLocaleString('vi-VN')} VND</p>
                            </div>
                            <div className="bill_price">
                                <p>{thanhToan.maThucDon.maThucDon} = </p>
                                <p>{thanhToan.soLuongBan} * {thanhToan.maThucDon.giaGoi.toLocaleString('vi-VN')} VND</p>
                                <p>{thanhToan.tongTienThucDon.toLocaleString('vi-VN')} VND</p>
                            </div>
                            <div className="bill_price">
                                <p>{thanhToan.loaiDichVu.loaiDichVu}:</p>
                                <p>{thanhToan.loaiDichVu.giaDichVu.toLocaleString('vi-VN')} VND</p>
                            </div>
                            <div className="bill_price">
                                <h3><strong>Tổng tiền:</strong></h3>
                                <h3><strong>{thanhToan.tongTienHoaDon.toLocaleString('vi-VN')} VND</strong></h3>
                            </div>
                        </div>
                        <div className="mt-3 mb-3" style={{ width: '250px' }}>
                            <Link type="button" to={urlThanhToanOnline} className="btn btn-primary w-100 py-3 text-white">
                            Thanh toán
                            </Link>
                        </div>
                    </div>

                </div>

            </section>
        </>
    )
}

export default Bill;