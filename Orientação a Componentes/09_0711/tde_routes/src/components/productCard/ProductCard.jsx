import './ProductCard.css';
import {useNavigate} from "react-router-dom";

function ProductCard({name, price, description, urlImg, id, refreshProducts}) {
    const navigate = useNavigate()

    async function deleteProduct(productId) {
        await fetch(`http://localhost:3001/products/${productId}`,{
            method: 'DELETE'
        })
        refreshProducts();
        navigate(`/produto`);
    }

    return (
        <div className="card">
            <div className="card-buttons">
                <button className="edit-button">Editar</button>
                <button className="delete-button" onClick={() => {
                    deleteProduct(id);
                }}>Excluir</button>
            </div>
            <img src={urlImg} alt=""/>
            <h1>{name}</h1>
            <h2>R$ {price}</h2>
            <button className="detail-button" onClick={() => {
                navigate(`/produto/${id}`)
            }}>Detalhes</button>
        </div>
    )
}

export default ProductCard;