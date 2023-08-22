import './Booking.css';
import '../Menu/Menu.css';
import '../Menu/bootstrap.min.css';
import a from "../../image/heading-banner.jpg"
import b from "../../image/line-hoang-long-restaurant.png"
import { useEffect, useState } from 'react';
import Apis, { endpoint } from '../../configs/Apis';
import MySpinner from '../../layout/MySpinner';

const Booking = () => {

    const backgroundImageStyle = {
        backgroundImage: `url(${a})`,
        backgroundRepeat: 'no-repeat',
        backgroundSize: 'cover'
    };

    const [loaiTiec, setLoaiTiec] = useState(null);
    const [dichVu, setDichVu] = useState(null);
    const [thongTinSanh, setThongTinSanh] = useState(null);

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

    useEffect(() => {
        loadLoaiTiec();
    }, [])

    useEffect(() => {
        loadDichVu();
    }, [])

    useEffect(() => {
        loadThongTinSanh();
    }, [])

    if (loaiTiec === null)
        return <MySpinner />;



    return (
        <>
            <div style={backgroundImageStyle} >
                <div className="container-fluid page-header-inner py-5">
                    <div className="container text-center pb-5">
                        <h1 className="display-3 mb-3 text-white animated slideInDown ">Đặt tiệc</h1>
                    </div>
                </div>
            </div>

            <section>
                <div className="container">
                    <div className="row">
                        <div className="col-md-12">
                            <div className="mt-3">
                                <img src={b} />
                            </div>
                            <h1 className="text-center mt-5">Đặt tiệc</h1>
                            <form>
                                <div className="row g-3">
                                    <h4>Thông tin liên hệ</h4>
                                    <div className="col-md-6">
                                        <div className="form-floating">
                                            <input type="text" className="form-control" id="name" placeholder="Họ và tên" />
                                            <label for="name">Họ và tên</label>
                                        </div>
                                    </div>
                                    <div className="col-md-6">
                                        <div className="form-floating">
                                            <input type="text" className="form-control" id="email" placeholder="Số điện thoại" />
                                            <label for="email">Số điện thoại</label>
                                        </div>
                                    </div>
                                    <div className="col-md-6">
                                        <div className="form-floating date" id="date3" data-target-input="nearest">
                                            <input type="Date" className="form-control" id="checkin" placeholder="Ngày tổ chức" />
                                            <label for="checkin">Ngày tổ chức</label>
                                        </div>
                                    </div>
                                    <div className="col-md-6">
                                        <div className="form-floating">
                                            <input type="text" className="form-control" id="diaChi" placeholder="Địa chỉ" />
                                            <label for="diaChi">Địa chỉ</label>
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
                                            <label for="select1">Loại tiệc</label>
                                        </div>
                                    </div>
                                    <div className="col-md-6">
                                        <div className="form-floating">
                                            <select className="form-select" id="select2">
                                                <option value="1">Child 1</option>
                                                <option value="2">Child 2</option>
                                                <option value="3">Child 3</option>
                                            </select>
                                            <label for="select2">Thực đơn</label>
                                        </div>
                                    </div>
                                    <div className="col-md-6">
                                        <div className="form-floating">
                                            <select className="form-select" id="select2">
                                                <option value="1">Buổi sáng</option>
                                                <option value="2">Buổi chiều</option>
                                            </select>
                                            <label for="select2">Buổi tổ chức</label>
                                        </div>
                                    </div>
                                    <div className="col-12">
                                        <div className="form-floating">
                                            <select className="form-select" id="select3">
                                                {thongTinSanh.map(s =>
                                                    <option value={s.id} key={s.id}>{s.tenSanh}</option>
                                                )}
                                            </select>
                                            <label for="select3">Loại sảnh</label>
                                        </div>
                                    </div>
                                    <div className="col-12">
                                        <div className="form-floating">
                                            <select className="form-select" id="select3">
                                            {dichVu.map(dv =>
                                                    <option value={dv.id} key={dv.id}>{dv.loaiDichVu}</option>
                                                )}
                                            </select>
                                            <label for="select3">Dịch vụ</label>
                                        </div>
                                    </div>
                                    <div className="col-12">
                                        <button className="btn btn-primary w-100 py-3" type="submit">Book Now</button>
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