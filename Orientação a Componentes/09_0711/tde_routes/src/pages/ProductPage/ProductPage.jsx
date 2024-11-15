import {useEffect, useState} from "react";
import ProductCard from "../../components/productCard/ProductCard.jsx";
import './ProductPage.css';

function ProductPage() {
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
            <div className="add-product-card" onClick={() => console.log('Adicionar produto')}>
                <span className="add-icon">+</span>
                <p>Adicionar Produto</p>
            </div>

            {products.map(product => (
                <ProductCard
                    key={product.id}
                    name={product.name}
                    price={product.price}
                    description={product.description}
                    urlImg={product.photo_url}
                />
            ))}
        </div>
    );
}

export default ProductPage;