import { Card } from "react-bootstrap";

export const CustomCard = ({ userInfo }) => {
    const style = {
        padding: '20px',
        backgroundColor: 'lightgray',
        borderRadius: '10px',
        boxShadow: '0 0 10px rgba(0, 0, 0, 0.1)',
    };

    return (
        <Card style={style}>
            <Card.Body>
                <Card.Img
                    variant="top"
                    style={{ width: '100px', height: '100px' }}
                    src={userInfo.foto || "https://example.com/default-avatar.png"} // Garante que a imagem padrão será usada se a foto não existir
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
