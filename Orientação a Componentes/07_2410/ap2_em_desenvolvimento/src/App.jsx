import Header from "./components/header/Header"
import InfoCliente from "./components/infoCliente/InfoCliente"
import useFetch from "../src/hooks/useFetch"
import FormsConvidado from "./components/formsConvidado/FormsConvidado"

function App() {

  const [data] = useFetch(`https://viacep.com.br/ws/90810240/json/`)

  return (
    <div>
      {/* <Header />
      <InfoCliente nome={"Vinicius"} cep={data.cep} cidade={data.localidade} bairro={data.bairro} rua={data.logradouro}/> */}
      <FormsConvidado/>
    </div>
  )
}

export default App