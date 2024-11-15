import { NavLink } from 'react-router-dom'
import './Header.css'

function Header () {
    return (
        <header className="container">
            <div className='logo'>
                <img src="https://s3-alpha-sig.figma.com/img/4e6d/9066/93eb1349338b462dfd3d37994b677eb4?Expires=1731283200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=TuHuQqNWZKkqOiOKTfAe1cE2Z14iYs7mRkWseEUx~7TxvZBLg3jNRY2b11IthH66H9VNhXe07vAfeAE4lG5E9LnnUk6pZ6yzv8MDICC5WOC1Dq1nk78-MmI~Q4NS8OdZSRys0kH6v1TMj0qfBpitcRkiXW0DzttQrWDvM00it9YcfNK2niB3F2RjpcJCTdLuGuCuXLA~18lCq8UG48dAVom3evLMmcl-tqduwN8ZwQ9TH6WV3EtEc5W6br1XoE4sGnSftZGgnRzAGQTzbp4wfA715-Y8dJA9hoISrTNXYOP~SvXtoUNZ8qoKwxcJh-kF0FaQovmp0FjLqzmcLQ~wKQ__"/>
            </div>
            <nav className='navigation'>
                <ul>
                    <NavLink className={({isActive}) => isActive ? "active" : ""} to={'/'}>Home</NavLink>
                    <NavLink to={'/produto'}>Produtos</NavLink>
                    {/*<NavLink to={'/addProduto'}>Cadastrar Produto</NavLink>*/}
                    <NavLink to={'/sobre'}>Sobre</NavLink>
                </ul>
            </nav>
        </header>
    )
}

export default Header