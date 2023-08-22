import { Link, Navigate } from 'react-router-dom';
import './Login.css';
import { useContext, useState } from 'react';
import Apis, { authApi, endpoint } from '../../configs/Apis';
import { MyUserContext } from '../../App';

const Login = () => {
    const [taiKhoan, dispatch] = useContext(MyUserContext);
    const [tenDangNhap, setTenDangNhap] = useState();
    const [matKhau, setMatKhau] = useState();


    const login = (evt) => {
        evt.preventDefault();

        const process = async () => {
            let res = await Apis.post(endpoint['login'], {
                "tenDangNhap": tenDangNhap,
                "matKhau": matKhau
            });
            const accessToken = await res.data;
            document.cookie = `accessToken=${accessToken}; Path=/;`;

            let user = await authApi().get(endpoint['currentUser']);

            const userData = await user.data;
            document.cookie = `userData=${userData}; Path=/;`;

            console.log(userData);
            dispatch({
                "type": "login",
                "payload": userData
            });

            console.info(user.data);
        }

        process();
    }

    if (taiKhoan !== null)
        return <Navigate to="/" />

    return (
        <div className='bodyLogin'>
            <div className="form">
                <form onSubmit={login}>
                    <h2>Đăng nhập</h2>
                    <div className="form_userName control">
                        <input id="tenDangNhap" value={tenDangNhap} onChange={e => setTenDangNhap(e.target.value)} type="text" placeholder="Tên đăng nhập" />
                        <small></small>
                        <span></span>
                    </div>
                    <div className="form_Password control">
                        <input type="password" value={matKhau} onChange={e => setMatKhau(e.target.value)} name="matKhau" id="matKhau" placeholder="Mật khẩu" />
                        <small></small>
                        <span></span>
                    </div>
                    <div className="container_login">
                        <button className="LogIn" type="submit">Đăng nhập</button>
                        <p>Not a member? <Link to="/register">Đăng ký</Link></p>
                    </div>
                </form>
            </div>
        </div>
    )
}

export default Login;