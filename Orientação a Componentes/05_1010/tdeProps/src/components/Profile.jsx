import './Profile.css'
import './Avatar.jsx'
import Avatar from './Avatar.jsx';

function Profile({name, profession, awards, discovered}) {
    return (
        <div id='tudo'>
            <h1>{name}</h1>

            <Avatar/>

            <ul>
                <li>Profession: {profession}</li>
                <li>Awards: {awards}</li>
                <li>Discovered: {discovered}</li>
            </ul>


        </div>
    )
}

export default Profile;