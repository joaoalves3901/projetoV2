window.onload = async function() {
    let id = sessionStorage.getItem("id");

    let anuncio = await $.ajax({
        url: "/api/anuncios/"+ id,
        method: "get",
        dataType: "json"
    });
    console.log("AD COND " + anuncio);

    document.getElementById("cliente").innerHTML = anuncio.cliente.nome;
    document.getElementById("origem").innerHTML = anuncio.origem;
    document.getElementById("tipo").innerHTML = anuncio.tipo;
    document.getElementById("peso").innerHTML = anuncio.peso;
    document.getElementById("preco").innerHTML = anuncio.preco;
}


