import { useParams, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faArrowLeft, faArrowRight, faHome } from "@fortawesome/free-solid-svg-icons";
import './ProductDetail.css';

function ProductDetail() {
    const params = useParams();
    const navigate = useNavigate();
    const [product, setProduct] = useState({});
    const [totalProducts, setTotalProducts] = useState(0); // Novo estado para total de produtos

    async function getProduct() {
        try {
            const response = await fetch(`http://localhost:3001/products/${params.id}`);
            const productResponse = await response.json();
            setProduct(productResponse);
        } catch (error) {
            console.error("Erro ao buscar produto:", error);
        }
    }

    async function getTotalProducts() {
        try {
            const response = await fetch(`http://localhost:3001/products`);
            const productsResponse = await response.json();
            setTotalProducts(productsResponse.length);
        } catch (error) {
            console.error("Erro ao buscar produtos:", error);
        }
    }

    useEffect(() => {
        getProduct();
        getTotalProducts();
    }, [params.id]);

    const isFirstProduct = Number(params.id) === 1;
    const isLastProduct = Number(params.id) === totalProducts;

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
                    onClick={() => navigate(`/produto/${params.id <= 1 ? params.id : params.id - 1}`)}
                    disabled={isFirstProduct} // Desabilita o botão "Voltar" no primeiro item
                >
                    <FontAwesomeIcon icon={faArrowLeft} className="icon"/>
                </button>
                <button
                    className="next-button"
                    onClick={() => navigate(`/produto/${Number(params.id) + 1}`)}
                    disabled={isLastProduct}
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
