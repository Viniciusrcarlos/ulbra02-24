import Header from "../components/header/Header.jsx";
import {Outlet} from "react-router-dom";

function ProductLayout () {
    return (
        <>
            <Header />
            <Outlet />
        </>
    )
}

export default ProductLayout