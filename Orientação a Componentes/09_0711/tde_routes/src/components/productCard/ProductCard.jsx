import './ProductCard.css';
import {useNavigate} from "react-router-dom";

function ProductCard({product, refreshProducts}) {
    const navigate = useNavigate()

    async function deleteProduct(productId) {
        await fetch(`http://localhost:3001/products/${productId}`,{
            method: 'DELETE'
        })
        refreshProducts();
        navigate(`/produto`);
    }

    function handleChange(event) {
        navigate('/produto/editar')
    }

    return (
        <div className="card">
            <div className="card-buttons">
                <button className="edit-button" onClick={() => {
                    handleChange(event);
                }}>Editar</button>
                <button className="delete-button" onClick={() => {
                    deleteProduct(product.id);
                }}>Excluir</button>
            </div>
            <img src={product.photo_url} alt=""/>
            <h1>{product.name}</h1>
            <h2>R$ {product.price}</h2>
            <button className="detail-button" onClick={() => {
                navigate(`/produto/${product.id}`)
            }}>Detalhes</button>
        </div>
    )
}

export default ProductCard;