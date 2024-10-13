function Header ({tittle, sizeList, index}) {
    return(
        <div>
            <h1>{tittle}</h1>
            <p>{index} of {sizeList}</p>
        </div>
    )
    
}

export default Header;