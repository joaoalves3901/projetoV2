var $jsName = document.querySelector('#peso');
var $jsValue = document.querySelector('.jsValue');

if ($jsName) {
    $jsName.addEventListener('input', function(event){
        var preco = 0;
        let tipo = document.getElementById('tipopost').value;
        switch(tipo) {
    
            case 'Vidro':
                preco = 0.10 * $jsName.value;
                break;
            
            case 'Papel':
                preco = 0.05 * $jsName.value;
                break;
    
            case 'Indiferenciado':
                preco = 0.02 * $jsName.value;
                break;
            
            case 'Metal':
                preco = 0.50 * $jsName.value;
                break;
    
            case 'Plastico':
                preco = 0.20 * $jsName.value;
                break;
            
        }
        $jsValue.innerHTML = preco;
        sessionStorage.setItem("preco", preco);

    }, false);
}

async function addAnuncio() {
    try {
        let anuncio = {
            cliente: {clienteid: sessionStorage.getItem("condutorId")},
            origem: document.getElementById("origem").value,
            tipo: document.getElementById("tipopost").value,
            peso: document.getElementById("peso").value,
            preco: sessionStorage.getItem("preco")
        }
            
        console.log(JSON.stringify(anuncio));
        let result = await $.ajax({
            url: "/api/anuncios",
            method: "post",
            dataType: "json",
            data:JSON.stringify(anuncio),
            contentType: "application/json"
        });
        console.log(JSON.stringify(result));
        // Change to album page
        sessionStorage.setItem("id",result.id);
        window.location = "advertisementCondutor.html";
    } catch(err) {
        console.log(err);
        // mensagem para o utilizador
    } 
}