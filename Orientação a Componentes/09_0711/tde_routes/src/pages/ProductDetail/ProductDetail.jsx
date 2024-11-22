import { useParams, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faArrowLeft, faArrowRight, faHome } from "@fortawesome/free-solid-svg-icons";
import './ProductDetail.css';

function ProductDetail() {
    const params = useParams();
    const navigate = useNavigate();
    const [product , setProduct] = useState({});
    const [produtos, setProdutos] = useState([]);
    const [index, setIndex] = useState(0);

    async function getAllProduct() {
        try {
            const response = await fetch(`http://localhost:3001/products`);
            const productResponse = await response.json();
            setProdutos(productResponse);

            const produtoFiltrado = productResponse.find(item => item.id === params.id)
            const actualIndex = productResponse.findIndex(item => item.id === params.id)

            setIndex(actualIndex)
            setProduct(produtoFiltrado)

        } catch (error) {
            console.error("Erro ao buscar produto:", error);
        }
    }

    async function next(id) {
        const indexActual = produtos.findIndex(item => item.id === id)
        const response = await fetch(`http://localhost:3001/products/${produtos[indexActual + 1].id}`);
        const productResponse = await response.json();
        setProduct(productResponse);
    }

    async function previus(id) {
        const indexActual = produtos.findIndex(item => item.id === id)
        const response = await fetch(`http://localhost:3001/products/${produtos[indexActual - 1].id}`);
        const productResponse = await response.json();
        setProduct(productResponse);
    }

    useEffect(() => {
        getAllProduct();
    }, [params.id]);

    return (
        <div className="product-detail-card">
            <div className="navigation-buttons">
                <button
                    className="menu-button"
                    onClick={() => navigate('/produto/')}
                >
                    <FontAwesomeIcon icon={faHome} className="icon" />
                </button>
                <button
                    className="back-button"
                    onClick={() => previus(product.id)}
                >
                    <FontAwesomeIcon icon={faArrowLeft}   className="icon"/>
                </button>
                <button
                    className="next-button"
                    onClick={() => next(product.id)}
                >
                    <FontAwesomeIcon icon={faArrowRight} className="icon" />
                </button>
            </div>
            <img src={product.photo_url} alt={product.name} className="product-image" />
            <div className="product-info">
                <h1 className="product-name">{product.name}</h1>
                <h2 className="product-price">{product.price}</h2>
                <p className="product-description">{product.description}</p>
            </div>
        </div>
    );
}

export default ProductDetail;
