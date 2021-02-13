package pt.iade.projectoeico2_db.Controllers;

import pt.iade.projectoeico2_db.Models.ConectorAnuncioCondutor;
import pt.iade.projectoeico2_db.Models.Repositories.ConectorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import java.util.Optional; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping(path="/api/anunciosaceites")

public class ConectorController {
    private Logger logger = LoggerFactory.getLogger(CondutorController.class);
    @Autowired
    private ConectorRepository conectorRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ConectorAnuncioCondutor> getAcceptedAdver() {
        logger.info("Sending all accepted advertisements");
        return conectorRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Optional<ConectorAnuncioCondutor> getAcceptedAdverById(@PathVariable Integer id) {
        logger.info("Sending accepted advertisement with id:"+ id);
        return conectorRepository.findById(id);
    }

    @PostMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public ConectorAnuncioCondutor saveAnuncio(@RequestBody ConectorAnuncioCondutor newAcceptedAnuncio) {
        logger.info("Linking this driver with this advertisement:"+ newAcceptedAnuncio.getAnuncioId());
        ConectorAnuncioCondutor conectoranunciocondutor = conectorRepository.save(newAcceptedAnuncio);
        return conectoranunciocondutor;
    }

}
