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
public class pessoa_fisica{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;

    private String nome;

    private String sexo;

    private String profisao;

    private Date data_nascimento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_propietario")
    Propietario propietario;

}
