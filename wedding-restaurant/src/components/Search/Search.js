import anh1 from "../../image/line-hoang-long-restaurant.png";
import anh2 from "../../image/line-hoang-long-restaurant-D.png";
import Apis, { endpoint } from "../../configs/Apis";
import { useEffect, useState } from "react";
import MySpinner from "../../layout/MySpinner";
import { Table } from "react-bootstrap";

const Search = () => {
    const [thongTinSanh, setThongTinSanh] = useState(null);
    const [thucDon, setThucDon] = useState(null);
    const [selectedHallType, setSelectedHallType] = useState('all');
    const [isSearchSanhVisible, setIsSearchSanhVisible] = useState(false);
    const [isSearchThucDonVisible, setIsSearchThucDonVisible] = useState(false);
    const [maxPrice, setMaxPrice] = useState('');


    const loadThongTinSanh = async () => {
        let res = await Apis.get(endpoint['thongTinSanh']);

        let filteredData = res.data;

        if (selectedHallType !== 'all') {
            filteredData = filteredData.filter(item => item.loaiSanh === selectedHallType);
        }

        if (maxPrice !== '') {
            filteredData = filteredData.filter(item => item.donGiaToiThieu <= parseInt(maxPrice));

        }
        setThongTinSanh(filteredData);
    }

    const loadThucDon = async () => {
        let res = await Apis.get(endpoint['thucDon']);

        let filteredData = res.data;
        if (maxPrice !== '') {
            filteredData = filteredData.filter(item => item.giaGoi <= parseInt(maxPrice));

        }

        setThucDon(filteredData);
    }



    useEffect(() => {
        loadThongTinSanh();
    }, [selectedHallType, maxPrice])

    useEffect(() => {
        loadThucDon();
    }, [maxPrice])

    const handleToggleSearchSanh = () => {
        setIsSearchSanhVisible(!isSearchSanhVisible);
        setIsSearchThucDonVisible(false);
    };

    const handleToggleSearchThucDon = () => {
        setIsSearchThucDonVisible(!isSearchThucDonVisible);
        setIsSearchSanhVisible(false);
    };


    if (thongTinSanh === null)
        return <MySpinner />;

    return (
        <>
            <div id="about">
                <div className="container container-bg">
                    <div className="widthImg">
                        <img alt="" src={anh1} />
                    </div>
                    <div className="section-header">
                        <h2 className='title-about'>Tra cứu thông tin</h2>
                        <div className='text-center'>
                            <p>Những gì bạn tìm kiếm</p>
                            <p>"<strong className='title-about'>Nhà hàng GH</strong>: sẽ đáp ứng cho bạn!"</p>
                        </div>
                    </div>
                </div>

                <div className="container_lobby">
                    <ul className="nav nav-pills mb-3 justify-content-center justify-content-lg-start lobby_titles">
                        <li className="nav-item">
                            <button className="nav-link" style={{ fontSize: '25px' }} onClick={handleToggleSearchSanh}>Tra cứu sảnh</button>

                        </li>
                        <li className="nav-item">
                            <button className="nav-link" style={{ fontSize: '25px' }} onClick={handleToggleSearchThucDon}>Tra cứu thực đơn</button>
                        </li>
                    </ul>
                    {isSearchSanhVisible && (
                        <div style={{ display: 'flex' }}>

                            <div className="col-3" style={{ paddingLeft: '50px' }}>
                                <div className="form-floating">
                                    <select className="form-select" id="select3" value={selectedHallType}
                                        onChange={(e) => setSelectedHallType(e.target.value)}>
                                        <option value="all" selected>All</option>
                                        <option value="DIAMOND">DIAMOND</option>
                                        <option value="GOLD">GOLD</option>
                                        <option value="SILVER">SILVER</option>
                                        <option value="RUBY">RUBY</option>
                                        <option value="SAPPIRE">SAPPIRE</option>
                                        <option value="GRAND DIAMOND">GRAND DIAMOND</option>
                                        <option value="GRAND RUBY">GRAND RUBY</option>
                                    </select>
                                    <label htmlFor="select3">Loại sảnh</label>
                                </div>
                            </div>


                            <div className="col-3" style={{ paddingLeft: '20px' }}>
                                <input
                                    type="number"
                                    className=""
                                    style={{ padding: '15px' }}
                                    id="maxPrice"
                                    placeholder="Giá sảnh"
                                    value={maxPrice}
                                    onChange={(e) => setMaxPrice(e.target.value)}
                                />
                            </div>

                        </div>
                    )}
                    {isSearchThucDonVisible && (
                        <div style={{ display: 'flex' }}>



                            <div className="col-3" style={{ paddingLeft: '20px' }}>
                                <input
                                    type="number"
                                    className=""
                                    style={{ padding: '15px' }}
                                    id="maxPrice"
                                    placeholder="Giá thực đơn"
                                    value={maxPrice}
                                    onChange={(e) => setMaxPrice(e.target.value)}
                                />
                            </div>

                        </div>
                    )}
                </div>
                {isSearchSanhVisible && (
                    <div id="amenities" className="container-bg" style={{ padding: '0' }}>
                        <div className="container">
                            <div className="table-responsive mt-5">
                                <Table responsive="sm">
                                    <thead>
                                        <tr>
                                            <th>Loại sảnh</th>
                                            <th>
                                                Tên sảnh
                                            </th>
                                            <th>
                                                Số lượng bàn tối đa
                                            </th>
                                            <th>Đơn giá</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        {thongTinSanh.map(t => <>
                                            <tr key={t.id}>
                                                <td >{t.loaiSanh}</td>
                                                <td>{t.tenSanh}</td>
                                                <td>{t.soLuongBan}</td>
                                                <td>{t.donGiaToiThieu.toLocaleString('vi-VN')} VND</td>
                                            </tr>
                                        </>
                                        )}

                                    </tbody>
                                </Table>
                            </div>
                        </div>
                    </div>
                )}

                {isSearchThucDonVisible && (
                    <div id="amenities" className="container-bg" style={{ padding: '0' }}>
                        <div className="container">
                            <div className="table-responsive mt-5">
                                <Table responsive="sm">
                                    <thead>
                                        <tr>
                                            <th>Mã thực đơn</th>
                                            <th>
                                                Món khai vị
                                            </th>
                                            <th>Món chính 1</th>
                                            <th>Món chính 2</th>
                                            <th>Món chính 3</th>
                                            <th>Món chính 4</th>
                                            <th>Đơn giá</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        {thucDon.map((t, index) => <>
                                            <tr key={t.id}>
                                                <td >{t.maThucDon}</td>
                                                <td>{t.monKhaiVi}</td>
                                                <td>{t.monChinh1}</td>
                                                <td>{t.monChinh2}</td>
                                                <td>{t.monChinh3}</td>
                                                <td>{t.monChinh4}</td>
                                                <td>{t.giaGoi.toLocaleString('vi-VN')} VND</td>
                                            </tr>
                                        </>
                                        )}

                                    </tbody>
                                </Table>
                            </div>
                        </div>
                    </div>
                )}

                <div className="widthImg">
                    <img alt="" src={anh2} />
                </div>
            </div>
        </>
    )
}

export default Search;