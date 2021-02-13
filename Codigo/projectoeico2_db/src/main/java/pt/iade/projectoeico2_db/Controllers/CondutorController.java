package pt.iade.projectoeico2_db.Controllers;

import pt.iade.projectoeico2_db.Models.Condutor;
import pt.iade.projectoeico2_db.Models.Repositories.CondutorRepository;

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
@RequestMapping(path="/api/condutores")

public class CondutorController {
    private Logger logger = LoggerFactory.getLogger(CondutorController.class);
    @Autowired
    private CondutorRepository condutorRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Condutor> getClientes() {
        logger.info("Sending all drivers");
        return condutorRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Optional<Condutor> getCondutorById(@PathVariable Integer id) {
        logger.info("Sending user with id:"+ id);
        return condutorRepository.findById(id);
    }

}
