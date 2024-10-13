function Avatar({srcImg, size}) {
    return (
        <img style={{borderRadius: 500}} width={size} height={size} src={srcImg}/>
    )
}

export default Avatar;