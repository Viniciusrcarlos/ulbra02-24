import { Card } from "react-bootstrap";

export const CustomCard = ({ userInfo }) => {
    const style = {
        padding: '20px',
        backgroundColor: 'lightgray',
        borderRadius: '10px',
        boxShadow: '0 0 10px rgba(0, 0, 0, 0.1)',
        
    };

    const defaulImg = "https://cdn.britannica.com/34/235834-050-C5843610/two-different-breeds-of-cats-side-by-side-outdoors-in-the-garden.jpg?w=300"

    return (
        <Card style={style} >
            <Card.Body className="d-flex flex-column justify-content-center align-items-center">
                <Card.Img
                    variant="top"
                    style={{ width: '100px', height: '100px' }}
                    src={userInfo.foto ? userInfo.foto : defaulImg}
                    onError={(e) => {
                        e.target.src = defaulImg
                    }}
                />
                <Card.Title>
                    <label><strong>Nome:</strong></label> {userInfo.nome}
                </Card.Title>

                <Card.Text>
                    <label><strong>Egresso:</strong></label> {userInfo.egresso || 'Convidado'}
                    <br />
                    <label><strong>Pago:</strong></label> {userInfo.pago || 'Não pago'}
                    <br />
                    <label><strong>Telefone:</strong></label> {userInfo.telefone || 'Sem telefone'}
                </Card.Text>
            </Card.Body>
        </Card>
    );
};
