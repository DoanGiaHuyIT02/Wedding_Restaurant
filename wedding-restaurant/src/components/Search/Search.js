import anh1 from "../../image/line-hoang-long-restaurant.png";
import anh2 from "../../image/line-hoang-long-restaurant-D.png";
import Apis, { endpoint } from "../../configs/Apis";
import { useEffect, useState } from "react";
import MySpinner from "../../layout/MySpinner";

const Search = () => {
    const [thongTinSanh, setThongTinSanh] = useState(null);


    const loadThongTinSanh = async () => {
        let res = await Apis.get(endpoint['thongTinSanh']);
        setThongTinSanh(res.data);
    }



    useEffect(() => {
        loadThongTinSanh();
    }, [])


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
                            <button className="nav-link" style={{ fontSize: '25px' }}>Tra cứu sảnh</button>

                        </li>
                        <li className="nav-item">
                            <button className="nav-link" style={{ fontSize: '25px' }}>Tra cứu thực đơn</button>
                        </li>
                    </ul>
                    <div style={{display:'flex'}}>
                        <div className="col-3" style={{ paddingLeft: '50px' }}>
                            <div className="form-floating">
                                <select className="form-select" id="select3">
                                    <option value="DIAMOND" selected>DIAMOND</option>
                                    <option value="GOLD">GOLD</option>
                                    <option value="SILVER">SILVER</option>
                                    <option value="RUBY">RUBY</option>
                                    <option value="SAPPHIRE">SAPPHIRE</option>
                                    <option value="GRAND DIAMOND">GRAND DIAMOND</option>
                                    <option value="GRAND RUBY">GRAND RUBY</option>
                                </select>
                                <label htmlFor="select3">Loại sảnh</label>
                            </div>
                        </div>

                        <div className="col-3" style={{ paddingLeft: '50px' }}>
                            <div className="form-floating">
                                <input type="number" className="form-control" id="price" placeholder="Giá sảnh (1.000.000)" />
                                <label htmlFor="price">Giá sảnh</label>
                            </div>
                        </div>
                    </div>
                </div>

                <div className="widthImg">
                    <img alt="" src={anh2} />
                </div>
            </div>
        </>
    )
}

export default Search;