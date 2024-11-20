import React, { useState } from "react";
import './addProducts.css';
import { useNavigate } from "react-router-dom";

function AddProducts() {
    const navigate = useNavigate();
    const [previewUrl, setPreviewUrl] = useState(""); // Estado para a URL da pré-visualização

    async function createProduct(product) {
        await fetch(`http://localhost:3001/products`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(product),
        });

        navigate(`/produto`);
    }

    function handleSubmit(event) {
        event.preventDefault();

        const formData = new FormData(event.target);
        const produto = {
            name: formData.get("name"),
            price: formData.get("price"),
            description: formData.get("description"),
            photo_url: formData.get("photo_url"),
        };

        createProduct(produto);
    }

    function handlePreview(event) {
        event.preventDefault(); // Evita o envio do formulário
        const formData = new FormData(event.target.form);
        const photoUrl = formData.get("photo_url");
        setPreviewUrl(photoUrl); // Atualiza a URL da pré-visualização
    }

    return (
        <form onSubmit={handleSubmit}>
            <input name="name" placeholder="Nome do Produto" required />
            <input name="price" type="number" step="0.01" placeholder="Preço" required />
            <input name="description" placeholder="Descrição" required />
            <div className="url-input-container">
                <input name="photo_url" type="url" placeholder="URL da Imagem" required />
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
    );
}

export default AddProducts;
