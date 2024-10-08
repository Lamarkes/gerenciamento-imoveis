package br.edu.catolica.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class contrato_aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data_inicio;

    private Date data_fim;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;




}
