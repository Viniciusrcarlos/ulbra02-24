import Profile from "./Profile";

function Gallery ({tittle}) {
    return (
        <div>
            <h1>{tittle}</h1>

            <Profile name={"Maria Curie"} profession={"Physicist and Chemist"} awards={"4 nobel"} discovered={"polonium"} srcImg={"https://i.imgur.com/szV5sdG.jpeg"}/>
            <Profile name={"Katsuko"} profession={"Geochemist"} awards={"2 prizes"} discovered={"a method for...."} srcImg={"https://i.imgur.com/YfeOqp2.jpeg"}/>
        </div>
    )
}

export default Gallery;