package br.edu.catolica.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    private String descricao;

    private Date data_geracao;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "corretor_id")
    private Corretor corretor;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "imovel_id")
    private Imovel imovel;
}
