import Avatar from "./Avatar";

function Profile({name, profession, awards, discovered, srcImg}) {
    return (
        <div style={{border: "1px solid white", margin: 10, borderRadius: 10}}>
            <h1>{name}</h1>
            <Avatar srcImg={srcImg} size={140}/>
            <ul style={{textAlign: "left"}}>
                <li>Profession: {profession}</li>
                <li>Awards: {awards}</li>
                <li>Discovered: {discovered}</li>
            </ul>
        </div>
    )
}

export default Profile;