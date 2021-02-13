window.onload = function () {
    loadAdvertisements();
}

async function loadAdvertisements() {
    try {
        let anuncios = await $.ajax({
            url: "/api/anuncios",
            method: "get",
            dataType: "json"
        });
        showAds(anuncios);

    } catch (err) {
        let elemMain = document.getElementById("main");
        console.log(err);
        elemMain.innerHTML = "<h1> Página não está disponível</h1>";
    }
}

function showAds(anuncios) {
    let elemMain = document.getElementById("main");
    let html = "";
    for (let anuncio of anuncios) {
        html += "<section onclick='showAd(" + anuncio.id + ")'>" +
            "<h3>" + anuncio.tipo + "</h3>" +
            "<p> Anunciante: " + anuncio.cliente.nome + "</p></section>";
    }
    elemMain.innerHTML = html;
}


function showAd(id) {
    sessionStorage.setItem("id", id);
    window.location = "advertisementCliente.html";
}


async function filterTipo() {
    try {
        let tipo = document.getElementById("tipo").value;
        alert(tipo);
        let anuncios = await $.ajax({
            url: "/api/anuncios/tipo/" + tipo,
            method: "get",
            dataType: "json"
        });
        showAds(anuncios);
    } catch (err) {
        let elemMain = document.getElementById("main");
        console.log(err);
        elemMain.innerHTML = "<h1> Página não está disponível</h1>";
    }
}