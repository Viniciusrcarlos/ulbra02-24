export const ButtonCustom = ({ text, onClick ,style}) => {
    const styleDefault = {
        backgroundColor: 'blue',
        color: 'white',
        borderRadius: '50px',
        padding: '0px 30px',
        height: '30px',
        margin: '10px',
        cursor: 'pointer',
        border: 'none'
    };

    return (
        <button
            style={style ?style: styleDefault}
                      onClick={onClick}
        >
            {text}
        </button>
    );
};
