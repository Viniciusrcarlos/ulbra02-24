import data from '../data'
import ButtonNext from './ButtonNext.jsx'
import Header from './Header.jsx'
import ShowDetails from './ShowDetails.jsx'
import Image from "./Image.jsx"
import { useState } from 'react'

function Gallery () {

    const [index, setIndex] = useState(0);

    function nextIndex() {
        if (index + 1 !== data.length) {
            setIndex(index + 1)
        }
        
    }

    function returnIndex() {
        if (index !== 0) {
            setIndex(index + -1)
        }
    }

    let galleryData = data[index ]

    return (
        <div>
        <ButtonNext ret={returnIndex} next={nextIndex}/>
        <Header tittle={galleryData.name} sizeList={data.length} index={index + 1}/>
        <ShowDetails description={galleryData.description}/>
        <Image urlImage={galleryData.url} alt={galleryData.alt}/>
        </div>
    )
}


export default Gallery;