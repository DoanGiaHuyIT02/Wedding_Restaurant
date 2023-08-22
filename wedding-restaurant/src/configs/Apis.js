import axios from "axios";
import Cookies from "universal-cookie";

const SERVER = "http://localhost:8080";

export const endpoint = {
    "loaiTiec": `/api/loaiTiec/`,
    "dichVu": `/api/dichVu/`,
    "thongTinSanh": `/api/thongTinSanh/`,
    "login": `/api/login/`,
    "currentUser": `/api/current-user/`
}

const cookies = new Cookies();
const token = cookies.get('accessToken');

export const authApi = () => {
    return axios.create({
        baseURL: SERVER,
        headers: {
            "Authorization":  token
        }
    })
}
export default axios.create({
    baseURL: SERVER,
    
})