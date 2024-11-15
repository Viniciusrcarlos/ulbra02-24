// eslint-disable-next-line no-unused-vars
import React, { useState } from "react";
import './ContatoPage.css';

function ContatoPage() {
  // const [pessoa, setPessoa] = useState(data);


  // const [formValues, setFormValues] = useState({
  //   nome: "",
  //   sobrenome: "",
  //   telefone: "",
  //   cidade: ""
  // });


  // const handleInputChange = (e) => {
  //   const { name, value } = e.target;
  //   setFormValues({ ...formValues, [name]: value });
  // };


  // const handleSubmit = (e) => {
  //   e.preventDefault();

  //   data.push(formValues);
  //   setPessoa([...data]);

  //   setFormValues({
  //     nome: "",
  //     sobrenome: "",
  //     telefone: "",
  //     cidade: ""
  //   });
  // };

  return (
    <>
      <h1>Contato</h1>
    </>
    // <div className="ContatoPage">
    //   <h1>Formulário de Contato</h1>
    //   <form className="forms" onSubmit={handleSubmit}>
    //     <div className="formsRow">
    //       <input
    //           placeholder="Nome"
    //         type="text"
    //         name="nome"
    //         value={formValues.nome}
    //         onChange={handleInputChange}
    //       />
    //     </div>
    //     <div className="formsRow">
    //       <input
    //           placeholder="Sobrenome"
    //         type="text"
    //         name="sobrenome"
    //         value={formValues.sobrenome}
    //         onChange={handleInputChange}
    //       />
    //     </div>
    //     <div className="formsRow">
    //       <input
    //           placeholder="Telefone"
    //         type="text"
    //         name="telefone"
    //         value={formValues.telefone}
    //         onChange={handleInputChange}
    //       />
    //     </div>
    //     <div className="formsRow">
    //       <input
    //           placeholder="Cidade"
    //         type="text"
    //         name="cidade"
    //         value={formValues.cidade}
    //         onChange={handleInputChange}
    //       />
    //     </div>
    //     <button className="buttonSubmit" type="submit">Adicionar</button>
    //   </form>

    //   <h3>Lista de Contatos</h3>
    //   <ul>
    //     {pessoa.map((item, index) => (
    //       <li key={index}>
    //         {item.nome} {item.sobrenome}, {item.telefone} , {item.cidade}
    //       </li>
    //     ))}
    //   </ul>
    // </div>
  );
}

export default ContatoPage
