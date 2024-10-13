function Image({ urlImage, alt}) {
    return (
        <img src={urlImage} width={190} height={190} alt={alt}/>
    )
}

export default Image;