import { BrowserRouter, Route, Routes } from "react-router-dom"
import AddProducts from "../pages/AddProductPage/addProducts.jsx"
import ErrorPage from "../pages/ErrorPage"
import HomePage from "../pages/HomePage"
import SobrePage from "../pages/SobrePage"
import ProductPage from "../pages/ProductPage/ProductPage.jsx"
import MainLayout from "../layout/MainLayout.jsx";
import ProductLayout from "../layout/ProductLayout.jsx";
import ProductDetail from "../pages/ProductDetail/ProductDetail.jsx";

function CustomRoutes() {
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route path='/' element={<MainLayout />}>
                        <Route index path='/' element={<HomePage />}/>
                        <Route path='/addProduto' element={<AddProducts />}/>
                        <Route path='/sobre' element={<SobrePage />}/>
                        <Route path='*' element={<ErrorPage/>}/>
                    </Route>

                    <Route path='/produto' element={<ProductLayout/>}>
                        <Route index path='/produto' element={<ProductPage />} />
                        <Route path='/produto/:id' element={<ProductDetail />} />
                        <Route path='*' element={<ErrorPage/>}/>
                    </Route>
                </Routes>
            </BrowserRouter>
        </>
    )
}

export default CustomRoutes