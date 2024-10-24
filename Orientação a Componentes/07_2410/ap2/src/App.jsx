import Header from "./components/header/Header.jsx";
import { InfoCliente } from "./components/infoCliente/InfoCliente.jsx";
import { CustomGrid } from "./components/grids/CustomGrid.jsx";
import { CustomCard } from "./components/cards/CustomCard.jsx";
import FormsConvidado from "./components/formsConvidado/FormsConvidado.jsx";
import React from "react";

function App() {
    const [lista, setLista] = React.useState([]);

    const addUser = (user) => {
        const newUser = {
            id: Date.now(),
            nome: user.name,
            telefone: user.phone,
            egresso: user.isEgresso,
            pago: user.isPaid,
            foto: user.photo,
        };

        console.log(newUser);
        setLista((prevLista) => [...prevLista, newUser]);
    };

    return (
        <div>
            <Header />
            <InfoCliente />
            <div style={{ display: 'flex', justifyContent: 'center' }}>
                <CustomGrid>
                    {lista.map((item) => (
                        <CustomCard key={item.id} userInfo={item} /> // Aqui, estamos passando userInfo corretamente
                    ))}
                </CustomGrid>
                <FormsConvidado func={addUser} />
            </div>
        </div>
    );
}

export default App;
