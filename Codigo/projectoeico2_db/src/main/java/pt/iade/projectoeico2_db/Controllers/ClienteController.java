package pt.iade.projectoeico2_db.Controllers;

import pt.iade.projectoeico2_db.Models.Cliente;
import pt.iade.projectoeico2_db.Models.Repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import java.util.Optional; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping(path="/api/clientes")

public class ClienteController {
    private Logger logger = LoggerFactory.getLogger(ClienteController.class);
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Cliente> getClientes() {
        logger.info("Sending all users");
        return clienteRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Optional<Cliente> getClienteById(@PathVariable Integer id) {
        logger.info("Sending user with id:"+ id);
        return clienteRepository.findById(id);
    }

}
