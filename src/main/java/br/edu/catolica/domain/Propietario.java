package br.edu.catolica.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries(
        @NamedQuery(name = "proprietario.ImoveisDisponiveis", query = "SELECT p, COUNT(i) FROM Propietario p JOIN p.imoveis i WHERE i.estaAvenda = true GROUP BY p.id, p.nome ORDER BY count(i)")
)
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Contato> contatos;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Imovel> imoveis;
}
