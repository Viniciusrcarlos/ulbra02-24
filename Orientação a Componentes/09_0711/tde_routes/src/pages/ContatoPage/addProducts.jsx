// eslint-disable-next-line no-unused-vars
import React, { useState } from "react";
import './addProducts.css';
import {useNavigate} from "react-router-dom";

function AddProducts() {
    const navigate = useNavigate();

    async function createProduct(product) {
        await fetch(`http://localhost:3001/products`, {
            method: "POST",
            body: JSON.stringify(product),
        })

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
        }

        createProduct(produto);
    }

  return (
    <>
        <form onSubmit={handleSubmit}>
            <input name="name" placeholder="name"/>
            <input name="price" placeholder="price"/>
            <input name="description" placeholder="description"/>
            <input name="photo_url" placeholder="photo_url"/>
            <button type={"submit"}> Cadastrar </button>
        </form>
    </>
  );
}

export default AddProducts
