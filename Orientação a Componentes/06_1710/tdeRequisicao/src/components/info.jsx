import { useState } from "react";
import useFetch from "../hooks/useFetch";


function Info() {
    const [cep, setCep] = useState("95555000")
    const [data] = useFetch(`https://viacep.com.br/ws/${cep}/json/`)
    

    return (
        <div>
            <input type="text" value={cep} onChange={(event) => {setCep(event.target.value)}}/>
            <h2>Cep: {data.cep}</h2>
            <h2>Bairro: {data.bairro}</h2>
            <h2>Cidade: {data.localidade}</h2>
        </div>
    )
}

export default Info;