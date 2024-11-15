import './ProductCard.css';

function ProductCard({name, price, description, urlImg}) {
    return (
        <div className="card">
            <div className="card-buttons">
                <button className="edit-button">Editar</button>
                <button className="delete-button">Excluir</button>
            </div>
            <img src={urlImg} alt=""/>
            <h1>{name}</h1>
            <h2>R$ {price}</h2>
            <p>{description}</p>
        </div>
    )
}

export default ProductCard;