function ButtonNext({ret, next}) {
    return (
        <div>
            <button style={{margin: 10}} type="button" onClick={ret}> 
                Return
            </button>
            <button type="button" onClick={next}> 
                Next
            </button>
        </div>
        
    )
    
}

export default ButtonNext;