package br.edu.catolica.domain;

import javax.persistence.*;
import java.util.Date;

public class contrato_compra extends Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data_compra;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;

}
