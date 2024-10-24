import '../infoCliente/infoCliente.css'
import React from 'react'
import {ButtonCustom} from "../buttons/ButtonCustom.jsx";
import {Card, ListGroup} from "react-bootstrap";


export const InfoCliente = () => {
    const [dropState, setDropState] = React.useState(false)
    const [json, setJson] = React.useState({
        nome: '',
        cep: '',
        bairro: '',
        cidade: '',
        rua: ''
    })

    React.useEffect(() => {
        getJson()

    }, [])

    const getJson = async () => {

        const response = await fetch('https://viacep.com.br/ws/95555000/json/')
        const data = await response.json()
        console.log(data)
        setJson(data)
    }

    const handleClick = () => {
        console.log('click')
        setDropState(!dropState)
        if (dropState) {
            getJson()
        }
    }

    const style = {
        card: {
            backgroundColor: 'white',
            borderRadius: '10px',
            padding: '10px',
            boxShadow: '0 0 10px rgba(0, 0, 0, 0.1)',
            width: '300px',
            alignSelf: 'start',
        }
    }

    return (
        <div className='infoCliente' >
            <h1>Seja bem vindo, {json.nome ? json.nome : "..."}</h1>
            <ButtonCustom onClick={handleClick} text='Ver localização'/>
            {dropState &&
                <div className="localizacao" style={style.card}>
                    <Card style={style.card}>
                        <Card.Body>

                            <Card.Text>
                                <ListGroup>
                                    <ListGroup.Item>CEP: {json.cep}</ListGroup.Item>
                                    <ListGroup.Item>Bairro: {json.bairro ? json.bairro : "..."}</ListGroup.Item>
                                    <ListGroup.Item>Cidade: {json.localidade}</ListGroup.Item>
                                    <ListGroup.Item>Rua: {json.rua ? json.rua : "..."}</ListGroup.Item>
                                </ListGroup>
                            </Card.Text>
                        </Card.Body>
                    </Card>
                </div>
            }
        </div>
    )
}

