import './Booking.css';
import '../Menu/Menu.css';
import '../Menu/bootstrap.min.css';
import b from "../../image/line-hoang-long-restaurant.png"
import anhNenThucDon from "../../image/banner-thuc-don.jpg";
import { useEffect, useState } from 'react';
import Apis, { endpoint } from '../../configs/Apis';
import MySpinner from '../../layout/MySpinner';

const Booking = () => {

    const [loaiTiec, setLoaiTiec] = useState(null);
    const [dichVu, setDichVu] = useState(null);
    const [thongTinSanh, setThongTinSanh] = useState(null);
    const [thucDon, setThucDon] = useState(null);

    const loadLoaiTiec = async () => {
        let res = await Apis.get(endpoint['loaiTiec']);
        setLoaiTiec(res.data);
    }

    const loadDichVu = async () => {
        let res = await Apis.get(endpoint['dichVu']);
        setDichVu(res.data);
    }
    const loadThongTinSanh = async () => {
        let res = await Apis.get(endpoint['thongTinSanh']);
        setThongTinSanh(res.data);
    }
    const loadThucDon = async () => {
        let res = await Apis.get(endpoint['thucDon']);
        setThucDon(res.data);
    }
   

    useEffect(() => {
        loadLoaiTiec();
        loadDichVu();
        loadThongTinSanh();
        loadThucDon();
    }, [])


    if (loaiTiec === null || thongTinSanh === null || dichVu === null || thucDon === null)
        return <MySpinner />;



    return (
        <>
             <div className="container-xxl py-5 container-bg">
                <div className="containe">
                    <div className="row g-5 align-items-center">
                        <div className="col-lg-6">
                            <h1 className="mb-4 text-center "><span className="title-about text-uppercase">Đặt tiệc</span></h1>
                            <p className="mb-4 text-center">Mỗi một món ăn đều được các đầu bếp chế biến theo khẩu vị khác nhau từ món thuần Việt đến ẩm thực Á – Âu, đảm bảo làm hài lòng cả những thực khách khó tính nhất.</p>
                        </div>
                        <div className="col-lg-6">
                            <img src={anhNenThucDon} />
                        </div>
                    </div>
                </div>
            </div>

            <section>
                <div className="container container-bg">
                    <div className="row">
                        <div className="col-md-12">
                            <div className="mt-3">
                                <img src={b} />
                            </div>
                            <h1 className="text-center mt-5">Đặt tiệc</h1>
                            <form>
                                <div className="row g-3" style={{textAlign:'center'}}>
                                    <h4>Thông tin liên hệ</h4>
                                    <div className="col-md-6">
                                        <div className="form-floating">
                                            <input type="text" className="form-control" id="name" placeholder="Họ và tên" />
                                            <label htmlFor="name">Họ và tên</label>
                                        </div>
                                    </div>
                                    <div className="col-md-6">
                                        <div className="form-floating">
                                            <input type="text" className="form-control" id="email" placeholder="Số điện thoại" />
                                            <label htmlFor="email">Số điện thoại</label>
                                        </div>
                                    </div>
                                    <div className="col-md-6">
                                        <div className="form-floating date" id="date3" data-target-input="nearest">
                                            <input type="Date" className="form-control" id="checkin" placeholder="Ngày tổ chức" />
                                            <label htmlFor="checkin">Ngày tổ chức</label>
                                        </div>
                                    </div>
                                    <div className="col-md-6">
                                        <div className="form-floating">
                                            <input type="text" className="form-control" id="diaChi" placeholder="Địa chỉ" />
                                            <label htmlFor="diaChi">Địa chỉ</label>
                                        </div>
                                    </div>
                                    <h4>Thông tin sự kiện</h4>
                                    <div className="col-md-6">
                                        <div className="form-floating">
                                            <select className="form-select" id="select1">
                                                {loaiTiec.map(lt =>
                                                    <option value={lt.id} key={lt.id}>{lt.tenLoaiTiec}</option>
                                                )}
                                            </select>
                                            <label htmlFor="select1">Loại tiệc</label>
                                        </div>
                                    </div>
                                    <div className="col-md-6">
                                        <div className="form-floating">
                                            <select className="form-select" id="select2">
                                                {thucDon.map(td =>
                                                    <option value={td.id} key={td.id}>{td.maThucDon}</option>
                                                )}
                                            </select>
                                            <label htmlFor="select2">Thực đơn</label>
                                        </div>
                                    </div>
                                    <div className="col-md-6">
                                        <div className="form-floating">
                                            <select className="form-select" id="select2">
                                                <option value="1">Buổi sáng</option>
                                                <option value="2">Buổi chiều</option>
                                            </select>
                                            <label htmlFor="select2">Buổi tổ chức</label>
                                        </div>
                                    </div>
                                    <div className="col-12">
                                        <div className="form-floating">
                                            <select className="form-select" id="select3">
                                                {thongTinSanh.map(s =>
                                                    <option value={s.id} key={s.id}>{s.loaiSanh}</option>
                                                )}
                                            </select>
                                            <label htmlFor="select3">Loại sảnh</label>
                                        </div>
                                    </div>
                                    <div className="col-12">
                                        <div className="form-floating">
                                            <select className="form-select" id="select3">
                                                {dichVu.map(dv =>
                                                    <option value={dv.id} key={dv.id}>{dv.loaiDichVu}</option>
                                                )}
                                            </select>
                                            <label htmlFor="select3">Dịch vụ</label>
                                        </div>
                                    </div>
                                    <div className="col-3 mt-2 mb-2">
                                        <button className="btn btn-primary w-100 py-3" type="submit">Đặt tiệc</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </section>

        </>
    )
}

export default Booking;