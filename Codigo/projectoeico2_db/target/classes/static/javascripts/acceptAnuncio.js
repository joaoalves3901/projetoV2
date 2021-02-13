window.onload = async function() {
    let id = sessionStorage.getItem("id");

    let anuncio = await $.ajax({
        url: "/api/anuncios/"+ id,
        method: "get",
        dataType: "json"
    });
    console.log(anuncio);

    document.getElementById("cliente").innerHTML = anuncio.cliente.nome;
    document.getElementById("origem").innerHTML = anuncio.origem;
    document.getElementById("tipo").innerHTML = anuncio.tipo;
    document.getElementById("peso").innerHTML = anuncio.peso;
    document.getElementById("preco").innerHTML = anuncio.preco;    

}

async function acceptAdvertisement() {
    try {
        let anuncioaceite = {
            anuncioId: sessionStorage.getItem("id"),
            condutor: {condutorid: sessionStorage.getItem("condutorId")},
            estado: "Confirmada",
            destino: document.getElementById("destino").value
        }
        console.log(JSON.stringify(anuncioaceite));
        let result = await $.ajax({
            url: "/api/anunciosaceites",
            method: "post",
            dataType: "json",
            data:JSON.stringify(anuncioaceite),
            contentType: "application/json"
        });
        console.log(JSON.stringify(result));
        // Change to album page
                                                                                        sessionStorage.setItem("id",result.id);
        window.location = "indexCondutor.html";
    } catch(err) {
        console.log(err);
        // mensagem para o utilizador
    }
}