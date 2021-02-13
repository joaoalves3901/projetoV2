package pt.iade.projectoeico2_db.Models.Repositories;


import org.springframework.data.repository.CrudRepository;


import pt.iade.projectoeico2_db.Models.ConectorAnuncioCondutor;

public interface ConectorRepository extends CrudRepository <ConectorAnuncioCondutor, Integer> {

    /*String QueryAddDoneAnuncio = "insert into condutor_has_anuncio (cond_anuncio_id, cond_id, estado) values (:#{#anuncio.getId()}, "+
    ":#{#condutor.getCondutorid()}, :#{#ConectorAnuncioCondutor.getEstado()})";

    @Modifying
    @Transactional
    @Query(value=QueryAddDoneAnuncio, nativeQuery=true)
    int saveAlbumTrack(@Param("anuncioID") int id);*/

}
