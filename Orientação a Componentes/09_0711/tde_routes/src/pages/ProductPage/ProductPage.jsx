import {useEffect, useState} from "react";
import ProductCard from "../../components/productCard/ProductCard.jsx";
import './ProductPage.css';
import {useNavigate} from "react-router-dom";

function ProductPage() {
    const navigate = useNavigate();
    const [products, setProducts] = useState([]);
    async function getAllProducts() {
        const response = await fetch(`http://localhost:3001/products`);
        const productsResponse = await response.json();
        setProducts(productsResponse);
    }

    useEffect(() =>{
        getAllProducts();
    }, [])

    return (
        <div className="product-container">
            <div className="add-product-card" onClick={() => navigate('/addProduto')}>
                <span className="add-icon">+</span>
                <p>Adicionar Produto</p>
            </div>

            {products.map(product => (
                <ProductCard
                    product={product}
                    refreshProducts={getAllProducts  }
                />
                // <ProductCard
                //     key={product.id}
                //     name={product.name}
                //     price={product.price}
                //     description={product.description}
                //     urlImg={product.photo_url}
                //     id={product.id}
                //     refreshProducts={getAllProducts}
                // />
            ))}
        </div>
    );
}

export default ProductPage;