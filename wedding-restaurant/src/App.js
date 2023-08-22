import { BrowserRouter, Route, Routes } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import React, { createContext, useReducer } from "react";
import Cookies from "universal-cookie";
import BaseLayout from "./layout/BaseLayout";
import Home from "./components/Home";
import Login from "./components/Login/Login";
import Register from "./components/Resgister/Register";
import MyUserReducer from "./reducers/MyUserReducer";
import Menu from "./components/Menu/Menu";
import Booking from "./components/Booking/Booking";

export const MyUserContext  = createContext();

const App = () => {
  const cookies = new Cookies();
  const user = cookies.get('userData');
  const [taiKhoan, dispatch] = useReducer(MyUserReducer, user || null);

  return (
    <MyUserContext.Provider value={[ taiKhoan,  dispatch ]}>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<BaseLayout><Home /></BaseLayout>} />
          <Route path="/menu" element={<BaseLayout><Menu /></BaseLayout>} />
          <Route path="/booking" element={<BaseLayout><Booking /></BaseLayout>} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
        </Routes>
      </BrowserRouter>
    </MyUserContext.Provider>
  )
}

export default App;