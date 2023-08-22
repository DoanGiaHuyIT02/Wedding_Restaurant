import { useContext, useEffect, useState } from "react";
import { Button, Container, Nav, NavDropdown, Navbar } from "react-bootstrap";
import MySpinner from "./MySpinner";
import Apis, { endpoint } from "../configs/Apis";
import { Link } from "react-router-dom";
import { MyUserContext } from "../App";

const Header = () => {
    const [taiKhoan, dispatch] = useContext(MyUserContext);
    const [loaiTiec, setLoaiTiec] = useState(null);

    const loadLoaiTiec = async () => {
        let res = await Apis.get(endpoint['loaiTiec']);
        setLoaiTiec(res.data);
    }

    useEffect(() => {
        loadLoaiTiec();
    }, [])

    if (loaiTiec === null)
        return <MySpinner />;

    const logout = () => {
        dispatch({
            "type": "logout"
        })
    }

    return (<>
        <Navbar expand="lg" className="bg-body-tertiary">
            <Container>
                <Navbar.Brand href="#home">GH Wedding Restaurant</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Nav.Link href="#home">Giới thiệu</Nav.Link>
                        <Link className="nav-link" to="/">Trang chủ</Link>
                        <Link className="nav-link" to="/menu">Thực đơn</Link>
                        <NavDropdown title="Dịch vụ" id="basic-nav-dropdown">

                            {loaiTiec.map(lt =>
                                <NavDropdown.Item href="#action/3.1" key={lt.id}>{lt.tenLoaiTiec}</NavDropdown.Item>
                            )}
                        </NavDropdown>
                        <Nav.Link href="#link">Sảnh tiệc</Nav.Link>
                        <Link className="nav-link" to="/booking">Đặt tiệc</Link>
                    </Nav>
                </Navbar.Collapse>
                <div className="">
                    {taiKhoan === null ? <Link to="/login" style={{ marginRight: '10px' }}>
                        <Button variant="success">Đăng nhập</Button>
                    </Link>
                        : <>
                            <div className="info-user d-flex align-items-center">
                                <img
                                    src={taiKhoan.avatar}
                                    className="rounded-circle small-avatar"
                                    alt="Avatar"
                                />
                                <Link className="nav-link text-danger mt-0" to="/">Chào {taiKhoan.tenDangNhap}!</Link>
                                <Button variant="secondary" onClick={logout} style={{ marginLeft: '10px' }} >Đăng xuất</Button>
                            </div>
                            
                        </>}

                    {!taiKhoan && <Link to="/register"><Button variant="success">Đăng ký</Button></Link>}
                </div>

            </Container>
        </Navbar>

    </>)
}

export default Header;