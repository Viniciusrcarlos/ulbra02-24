import Header from "./components/header/Header"
import InfoCliente from "./components/infoCliente/InfoCliente"
import useFetch from "../src/hooks/useFetch"

function App() {

  const [data] = useFetch(`https://viacep.com.br/ws/90810-240/json/`)

  return (
    <div>
      <Header />
      <div style={{display: "flex", flexDirection: "column"}}>
        <InfoCliente nome={"Vinicius"} cep={data.cep} cidade={data.localidade} bairro={data.bairro} rua={data.logradouro}/>
      </div>
    </div>
  )
}

export default App
