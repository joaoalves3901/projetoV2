package pt.iade.projectoeico2_db.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "condutor")
    public class Condutor {
        @Id @GeneratedValue
            (strategy = GenerationType.IDENTITY)
            @Column(name="cond_id") private int condutorid;

            @ManyToOne @JoinColumn(name="cliente_id")
            @JsonIgnoreProperties({"anuncios"})
            private Cliente cliente;

            @Column(name="cond_carta") private Integer carta;

            public Condutor() {}

            public Cliente getCliente() {
                return cliente;
            }

            public Integer getCarta() {
                return carta;
            }

            public int getCondutorid() {
                return condutorid;
            }

    }