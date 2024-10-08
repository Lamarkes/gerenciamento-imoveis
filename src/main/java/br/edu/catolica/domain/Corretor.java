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
        @NamedQuery(name = "corretor.CorretorMaisContratos", query = "SELECT c.corretor.nome, count(c.id) FROM Contrato c GROUP BY c.corretor.id ORDER BY c.corretor.id")
)
public class Corretor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String creci;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Contato> contatos;
}
