import { useNavigate } from "react-router-dom";

function HomePage () {
    const navigate = useNavigate();
    function handleClick() {
        navigate("/sobre")
    }

    return (
        <>
            <h1>Home</h1>
            <button onClick={handleClick}>Vai para sobre</button>
        </>
    )
}

export default HomePage;