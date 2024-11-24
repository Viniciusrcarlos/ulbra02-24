import './EditProduct.css'
import React, {useState} from "react";
import {useLocation, useNavigate } from "react-router-dom";

function EditProduct () {
    const navigate = useNavigate();
    const location = useLocation();
    const product = location.state;
    const [previewUrl, setPreviewUrl] = useState("");

    async function editProduct (product) {
        await fetch(`http://localhost:3001/products/${product.id}`, {
            method: 'PUT',
            body: JSON.stringify(product),
        })
        navigate(`/produto`);

        console.log("id:" + product.id);
    }

    function handlePreview(event) {
        event.preventDefault();
        const formData = new FormData(event.target.form);
        const photoUrl = formData.get("photo_url");
        setPreviewUrl(photoUrl);
    }

    async function handleSubmit(event) {
        event.preventDefault();

        const formData = new FormData(event.target);
        const produto = {
            id: product.id,
            name: formData.get("name"),
            price: formData.get("price"),
            description: formData.get("description"),
            photo_url: formData.get("photo_url"),
        };


        await editProduct(produto)
    }

    return (
        <>
            <form onSubmit={handleSubmit}>
                <input name="name" placeholder="Nome do Produto" required defaultValue={product.name} />
                <input name="price" type="number" step="0.01" placeholder="Preço" required defaultValue={product.price} />
                <input name="description" placeholder="Descrição" required defaultValue={product.description} />
                <div className="url-input-container">
                    <input name="photo_url" type="url" placeholder="URL da Imagem" required defaultValue={product.photo_url} />
                    <button type="button" onClick={handlePreview}>Pré-visualizar</button>
                </div>
                <button type="submit">Cadastrar</button>

                {previewUrl && (
                    <div className="image-preview">
                        <h3>Pré-visualização da Imagem:</h3>
                        <img src={previewUrl} alt="Pré-visualização" />
                    </div>
                )}
            </form>
        </>
    )
}

export default EditProduct;