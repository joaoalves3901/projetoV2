window.onload = async function() {
    try {
        let condutores = await $.ajax({
            url: "/api/condutores",
            method: "get",
            dataType: "json"
        });
        let html="";
        for (let condutor of condutores) {
            html+= "<option value="+condutor.condutorid+">"+condutor.cliente.nome+
                "</option>";
        }
        document.getElementById("condutorlog").innerHTML = html;
    } catch (err) {
        console.log(err);
        // mensagem de erro para o utilizador      
    }

    try {
        let clientes = await $.ajax({
            url: "/api/clientes",
            method: "get",
            dataType: "json"
        });
        let html="";
        for (let cliente of clientes) {
            html+= "<option value="+cliente.clienteid+">"+cliente.nome+
                "</option>";
        }
        document.getElementById("clientelog").innerHTML = html;
    } catch (err) {
        console.log(err);
        // mensagem de erro para o utilizador      
    }

}

function getCliente() {
    let clienteId = document.getElementById("clientelog").value;
    sessionStorage.setItem("clienteId",clienteId);
   window.location = "indexCliente.html";
 }

 function getCondutor() {
    let condutorId = document.getElementById("condutorlog").value;
    sessionStorage.setItem("condutorId",condutorId);
   window.location = "indexCondutor.html";
 }
