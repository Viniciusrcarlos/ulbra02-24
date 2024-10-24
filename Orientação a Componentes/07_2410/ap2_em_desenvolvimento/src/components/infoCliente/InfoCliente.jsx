import Clock from '../../hooks/Clock'
import '../infoCliente/infoCliente.css'

function InfoCliente({nome, cep, cidade, bairro, rua, hora}) {
    return (
        <div className='infoCliente'>
            <h1>Seja bem vindo, {nome}</h1>

            <div className="localizacao">
                <div className="sec1">
                    <p>CEP: {cep}</p>
                    <p>BAIRRO: {bairro}</p>
                    <p className='hora'>HORARIO:<Clock/> </p>
                </div>
                <div className="sec2">
                    <p>CIDADE: {cidade}</p>
                    <p>RUA: {rua}</p>
                </div>
            </div>



            {/* <div className="localizacao">
                <ul>
                    <li>CEP: {cep}</li>
                    <li>Bairro: {bairro}</li>
                    <li>Horario: {hora}</li>
                </ul>
                <ul>
                    <li>Cidade: {cidade}</li>
                    <li>Rua: {rua}</li>
                </ul>
            </div> */}
        </div>
    )
}

export default InfoCliente