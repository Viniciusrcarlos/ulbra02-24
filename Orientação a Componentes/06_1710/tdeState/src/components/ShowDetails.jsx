import {useState} from "react";

function ShowDetails({ description }) {
    const [enable, setEneble] = useState(false);

    function enableDetails () {
        setEneble(!enable)
    }

    return (
        <div style={{padding: 20}}>
            <button onClick={enableDetails}>{enable ? "Hide" : "Show"} Details</button>
            {enable && <p>{description}</p>}
        </div>
    )
}

export default ShowDetails;