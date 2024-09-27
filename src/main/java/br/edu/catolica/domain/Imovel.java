package br.edu.catolica.domain;

import br.edu.catolica.Enum.TipoDeImovel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "imovel.ImoveisPeloBairro", query = "select i from Imovel i join Endereco e on i.endereco.id = e.id where e.bairro = :bairro AND i.estaAvenda = true"),
        @NamedQuery(name = "imovel.imoveilMaisCaro", query = "select max(c.valor) from Contrato c join Imovel i on i.id = c.imovel.id where i.estaAvenda = true"),
        @NamedQuery(name = "imoveis.imoveisEntre", query = "select i from Contrato c join c.imovel i where (c.valor BETWEEN  :valorInicial AND :valorFinal) and i.estaAvenda = true")
})
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    private Double areaDoImovel;
    private Integer qtdDeComodos;
    private TipoDeImovel tipoDeImovel;
    private boolean estaAvenda;
    private boolean estaAluguel;

}
