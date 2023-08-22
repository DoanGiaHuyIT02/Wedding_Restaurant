import { Link } from 'react-router-dom';
import '../Login/Login.css';

const Register = () => {
    return (

        <div className='bodyLogin'>
            <div className="form">
                <form>
                    <h2>Đăng ký</h2>
                    <div className="form_userName control">
                        <input id="name" type="text" placeholder="Họ và tên" />
                        <small></small>
                        <span></span>
                    </div>
                    <div className="form_userName control">
                        <input id="soDienThoai" type="text" placeholder="Số điện thoại" />
                        <small></small>
                        <span></span>
                    </div>
                    <div className="form_userName control">
                        <input id="email" type="email" placeholder="Email" />
                        <small></small>
                        <span></span>
                    </div>
                    <div className="form_userName control">
                        <input id="tenDangNhap" type="text" placeholder="Tên đăng nhập" />
                        <small></small>
                        <span></span>
                    </div>
                    <div className="form_Password control">
                        <input type="password" name="matKhau" id="password" placeholder="Mật khẩu" />
                        <small></small>
                        <span></span>
                    </div>
                    <div className="form_Password control">
                        <input type="password" name="matKhau" id="confirmPassword" placeholder="Nhập lại mật khẩu" />
                        <small></small>
                        <span></span>
                    </div>

                    <input id="file" type="file" placeholder="Avatar" />

                    <div className="container_login">
                        <button className="LogIn" type="submit">Đăng ký</button>
                        <p>Not a member? <Link to="/login">Đăng nhập</Link></p>
                    </div>
                </form>
            </div>
        </div>

    )
}

export default Register;