import React, { useState } from "react";

function ContatoPage() {
  // Array local para armazenar os dados dos formulários
  const [data, setData] = useState([]);
  
  // Estado para os valores dos campos do formulário
  const [formValues, setFormValues] = useState({
    nome: "",
    sobrenome: "",
    telefone: "",
    cidade: ""
  });

  // Função para atualizar os valores do formulário conforme o usuário digita
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormValues({ ...formValues, [name]: value });
  };

  // Função para enviar o formulário
  const handleSubmit = (e) => {
    e.preventDefault(); // Evita o reload da página
    
    // Adiciona os dados do formulário ao array local
    setData([...data, formValues]);
    
    // Limpa os campos do formulário após o envio
    setFormValues({
      nome: "",
      sobrenome: "",
      telefone: "",
      cidade: ""
    });
  };

  return (
    <div>
      <h2>Formulário de Contato</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Nome:</label>
          <input
            type="text"
            name="nome"
            value={formValues.nome}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label>Sobrenome:</label>
          <input
            type="text"
            name="sobrenome"
            value={formValues.sobrenome}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label>Telefone:</label>
          <input
            type="text"
            name="telefone"
            value={formValues.telefone}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label>Cidade:</label>
          <input
            type="text"
            name="cidade"
            value={formValues.cidade}
            onChange={handleInputChange}
          />
        </div>
        <button type="submit">Adicionar</button>
      </form>

      <h3>Lista de Contatos</h3>
      <ul>
        {data.map((item, index) => (
          <li key={index}>
            {item.nome} {item.sobrenome}, {item.telefone} - {item.cidade}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ContatoPage
