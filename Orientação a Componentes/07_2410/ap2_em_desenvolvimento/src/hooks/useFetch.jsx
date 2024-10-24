import {useEffect, useState} from "react"

const useFetch = (url) => {
    const [data, setData] = useState({})

    async function getData() {
        const dataJson = await fetch(url)
        const cep = await dataJson.json()
        setData (() => cep)
    }

    useEffect(() => {
        getData()
    }, [url])

    return [data]
}

export default useFetch  