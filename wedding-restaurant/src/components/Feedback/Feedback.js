import { useContext, useState } from "react";
import anhNenThucDon from "../../image/banner-thuc-don.jpg";
import anh1 from "../../image/line-hoang-long-restaurant.png";
import { authApi, endpoint } from "../../configs/Apis";
import { MyUserContext } from "../../App";
import { Link } from "react-router-dom";

const Feedback = () => {
    const [taiKhoan,] = useContext(MyUserContext);
    const [phanHoiKhachHang, setPhanHoiKhachHang] = useState(null);
    const [content, setContent] = useState();
    const guiPhanHoi = (evt) => {
        evt.preventDefault();
        if (content.trim() === '') {
            alert('Vui lòng nhập nội dung phản hồi trước khi gửi.');
            return;
        }
        const process = async () => {
            let { data } = await authApi().post(endpoint['phanHoiKhachHang'], {
                "phanHoi": content
            });

            setPhanHoiKhachHang(data);
            setContent("");
        }

        process();
    }
    
    console.log(phanHoiKhachHang)

    let url = `/login?next=/feedback`;
    return (
        <>
            <div className="container-xxl py-5 container-bg">
                <div className="containe">
                    <div className="row g-5 align-items-center">
                        <div className="col-lg-6">
                            <h1 className="mb-4 text-center "><span className="title-about text-uppercase">Phản hồi khách hàng</span></h1>
                            <p className="mb-4 text-center">Những đóng góp ý kiến của bạn sẽ là lời động viên tinh thần cho chúng tôi tốt hơn ngày hôm nay.</p>
                        </div>
                        <div className="col-lg-6">
                            <img src={anhNenThucDon} />
                        </div>
                    </div>
                </div>
            </div>
            <div id="about">
                <div className="container container-bg">
                    <div className="widthImg">
                        <img alt="" src={anh1} />
                    </div>
                    <div className="section-header">
                        <h2 className='title-about'>Phản hồi khách hàng</h2>
                        <div className='text-center'>
                            <p>Ý kiến của bạn</p>
                            <p>Thành quả của chúng ta</p>
                        </div>
                    </div>
                    <form>
                        <div className="row g-3">
                            <h4>Thông tin liên hệ</h4>
                            <div className="col">
                                <div className="control-group">
                                    <textarea className="form-control" rows={5} id="feedback" placeholder="Thông tin phản hồi"
                                        value={content} onChange={e => setContent(e.target.value)} />
                                </div>
                            </div>
                            {taiKhoan === null ? <p>Vui lòng <Link to={url}>đăng nhập</Link> để gửi phản hồi! </p> : <>
                                <div className="col-3">
                                    <button className="btn btn-primary w-100 py-3" onClick={guiPhanHoi}>Gửi</button>
                                </div>
                            </>}
                        </div>
                    </form>
                </div>
            </div>
        </>
    )
}

export default Feedback;