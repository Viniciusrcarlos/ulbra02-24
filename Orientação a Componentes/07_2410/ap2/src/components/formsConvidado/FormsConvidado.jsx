import { useState } from "react";
import { isEmpty } from "lodash";
import { ButtonCustom } from "../buttons/ButtonCustom.jsx";

const FormsConvidado = ({ func }) => {
    const [userForm, setUserForm] = useState({
        name: "",
        phone: "",
        isEgresso: null, // Sim ou Não
        isPaid: null, // Sim ou Não
        photo: "", // URL da foto
    });

    const [errors, setErrors] = useState({
        name: null,
        phone: null,
        isEgresso: null,
        isPaid: null,
        photo: null,
    });

    const handleSubmit = () => {
        let formIsValid = true;

        if (isEmpty(userForm.name)) {
            setErrors((prev) => ({ ...prev, name: "Nome é obrigatório." }));
            formIsValid = false;
        } else {
            setErrors((prev) => ({ ...prev, name: null }));
        }

        if (isEmpty(userForm.phone)) {
            setErrors((prev) => ({ ...prev, phone: "Telefone é obrigatório." }));
            formIsValid = false;
        } else {
            setErrors((prev) => ({ ...prev, phone: null }));
        }

        if (userForm.isEgresso === null) {
            setErrors((prev) => ({ ...prev, isEgresso: "Selecione se é egresso ou convidado." }));
            formIsValid = false;
        } else {
            setErrors((prev) => ({ ...prev, isEgresso: null }));
        }

        if (userForm.isPaid === null) {
            setErrors((prev) => ({ ...prev, isPaid: "Selecione se é pago." }));
            formIsValid = false;
        } else {
            setErrors((prev) => ({ ...prev, isPaid: null }));
        }

        if (isEmpty(userForm.photo)) {
            setErrors((prev) => ({ ...prev, photo: "URL da foto é obrigatória." }));
            formIsValid = false;
        } else {
            setErrors((prev) => ({ ...prev, photo: null }));
        }

        if (!formIsValid) return;

        // Chama a função passada como prop com os dados do formulário
        func(userForm);
    };

    const style = {
        card: {
            backgroundColor: 'white',
            borderRadius: '10px',
            padding: '40px',
            boxShadow: '0 0 10px rgba(0, 0, 0, 0.1)',
            width: '25vh',
            margin: 'auto',
        },
        input: {
            borderRadius: '10px',
            padding: '10px',
            boxShadow: '0 0 10px rgba(0, 0, 0, 0.1)',
            marginTop: '10px',
            width: '100%',
        },
    };

    return (
        <div className="container mt-4">
            <div className="card" style={style.card}>
                <div className="card-body">
                    <h5 className="card-title text-center mb-5" style={{ color: '#333',fontSize: "20px" }}>Cadastrar Convidado</h5>

                    <div className="form-group mb-3"  style={{
                        display: 'flex',
                        flexDirection: 'column',
                        justifyContent: 'flex-start',
                        alignItems: 'flex-start',
                    }}>
                        <label htmlFor="name" className="form-label mb-3">Nome</label>
                            <input
                                id="name"
                                className={`form-control ${errors?.name && "is-invalid"}`}
                                type="text"
                                placeholder="Nome" // Placeholder em branco para FloatingLabel
                                value={userForm.name}
                                onChange={(e) => setUserForm((prev) => ({ ...prev, name: e.target.value }))}
                                style={style.input}
                            />
                            {errors?.name && <div className="invalid-feedback">{errors?.name}</div>}
                    </div>

                    <div className="form-group mb-3" style={{
                        display: 'flex',
                        flexDirection: 'column',
                        justifyContent: 'flex-start',
                        alignItems: 'flex-start',
                    }}>
                        <label htmlFor="phone" className="form-label mb-3">Telefone</label>
                            <input
                                id="phone"
                                className={`form-control ${errors?.phone && "is-invalid"}`}
                                type="text"
                                placeholder="Telefone" // Placeholder em branco para FloatingLabel
                                value={userForm.phone}
                                onChange={(e) => setUserForm((prev) => ({ ...prev, phone: e.target.value }))}
                                style={style.input}
                            />
                            {errors?.phone && <div className="invalid-feedback">{errors?.phone}</div>}
                    </div>

                    <div className="form-group mb-3" style={{
                        display: 'flex',
                        flexDirection: 'column',
                        justifyContent: 'flex-start',
                        alignItems: 'flex-start',
                    }}>
                        <label htmlFor="isEgresso" className="form-label mb-3">Egresso</label>
                            <select
                                id="isEgresso"
                                className={`form-control ${errors?.isEgresso && "is-invalid"}`}
                                value={userForm.isEgresso}
                                onChange={(e) => setUserForm((prev) => ({ ...prev, isEgresso: e.target.value }))}
                                style={style.input}
                            >
                                <option value={null}>Selecione...</option>
                                <option value="sim">Sim</option>
                                <option value="nao">Não</option>
                            </select>
                            {errors?.isEgresso && <div className="invalid-feedback">{errors?.isEgresso}</div>}

                    </div>

                    <div className="form-group mb-3" style={{
                        display: 'flex',
                        flexDirection: 'column',
                        justifyContent: 'flex-start',
                        alignItems: 'flex-start',
                    }}>
                        <label htmlFor="isPaid" className="form-label mb-3">Pago</label>
                            <select
                                id="isPaid"
                                className={`form-control ${errors?.isPaid && "is-invalid"}`}
                                value={userForm.isPaid}
                                onChange={(e) => setUserForm((prev) => ({ ...prev, isPaid: e.target.value }))}
                                style={style.input}
                            >
                                <option value={null}>Selecione...</option>
                                <option value="sim">Sim</option>
                                <option value="nao">Não</option>
                            </select>
                            {errors?.isPaid && <div className="invalid-feedback">{errors?.isPaid}</div>}

                    </div>

                    <div className="form-group mb-4"
                         //alinar o input a esquerda
                    style={{
                        display: 'flex',
                        flexDirection: 'column',
                        justifyContent: 'flex-start',
                        alignItems: 'flex-start',
                    }}
                    >
                        <label htmlFor="photo" className="form-label mb-3">URL da Foto</label>
                            <input
                                id="photo"
                                className={`form-control ${errors?.photo && "is-invalid"}`}
                                type="text"
                                placeholder="URL da Foto" // Placeholder em branco para FloatingLabel
                                value={userForm.photo}
                                onChange={(e) => setUserForm((prev) => ({ ...prev, photo: e.target.value }))}
                                style={style.input}
                            />
                            {errors?.photo && <div className="invalid-feedback">{errors?.photo}</div>}
                    </div>

                    <ButtonCustom text="Cadastrar" onClick={handleSubmit} />
                </div>
            </div>
        </div>
    );
};

export default FormsConvidado;
