import { BrowserRouter, Route, Routes } from "react-router-dom"
import Header from "../components/header/Header"
import ContatoPage from "../pages/ContatoPage/ContatoPage.jsx"
import ErrorPage from "../pages/ErrorPage"
import HomePage from "../pages/HomePage"
import SobrePage from "../pages/SobrePage"
import ProdutosPage from "../pages/ProdutosPage"

function CustomRoutes() {
    return (
        <>
            <BrowserRouter>
                <Header/>
                <Routes>
                <Route path='/' element={<HomePage />}/>
                <Route path='/contato' element={<ContatoPage />}/>
                <Route path='/sobre' element={<SobrePage />}/>
                <Route path='/produtos' element={<ProdutosPage/>}/>
                <Route path='*' element={<ErrorPage/>}/>
                </Routes>
            </BrowserRouter>
        </>
    )
}

export default CustomRoutes