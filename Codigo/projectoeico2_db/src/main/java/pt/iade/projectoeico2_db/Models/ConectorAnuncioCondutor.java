package pt.iade.projectoeico2_db.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "condutor_has_anuncio")
    public class ConectorAnuncioCondutor {
        
        @Id @Column(name ="cond_anuncio_id")
        private int anuncioId;

            @ManyToOne @JoinColumn(name="cond_id")
            @JsonIgnoreProperties({"condutores"})
            private Condutor condutor;

            @Column(name="estado") private String estado;
            @Column(name="destino") private String destino;

            public ConectorAnuncioCondutor() {}

            public String getEstado() {
                return estado;
            }

            public int getAnuncioId() {
                return anuncioId;
            }

            public Condutor getCondutor() {
                return condutor;
            }
            
            public String getDestino() {
                return destino;
            }

    }