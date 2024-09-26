package br.edu.catolica.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class pessoa_juridica extends Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String razao_social;

    private String nome_fantasia;

    private String cnpj;

    private Date data_fundacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;

}
