package br.edu.catolica;


import br.edu.catolica.Enum.TipoDeImovel;
import br.edu.catolica.dao.*;
import br.edu.catolica.domain.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {


        var corretorDAO = new CorretorDAO();
        var corretor1 = Corretor.builder()
                .nome("Lamark")
                .creci("12345")
                .endereco(Endereco.builder()
                        .pais("brasil")
                        .estado("paraiba")
                        .cidade("cajazeiras")
                        .rua("Sit")
                        .numero("sn")
                        .bairro("centro")
                        .build())
                .contatos(List.of(
                        Contato.builder()
                                .email("leomax@gmail.com")
                                .telefone("839513236")
                                .build()
                ))
                .build();
        Imovel imovel = Imovel.builder()
                .endereco(Endereco.builder()
                        .pais("brasil")
                        .estado("paraiba")
                        .cidade("cachoeira")
                        .rua("rua das cachoeiras")
                        .numero("221")
                        .bairro("centro")
                        .build())
                .areaDoImovel(30.0)
                .qtdDeComodos(4)
                .estaAvenda(true)
                .tipoDeImovel(TipoDeImovel.APARTAMENTO).build();

        //imovelDAO.save(imovel);

        Cliente cliente = Cliente.builder()
                .nome("Emanuel Hebert")
                .contato(
                        List.of(
                                Contato.builder()
                                        .email("emanuel@gmail.com")
                                        .telefone("898921893829")
                                        .build()
                        ))
                .data_nacimento(new Date(2004,1,12))
                .endereco(
                        Endereco.builder()
                                .pais("brasil")
                                .estado("paraiba")
                                .cidade("cachoeira")
                                .rua("rua das cachoeiras")
                                .numero("92")
                                .bairro("Sao paulo")
                                .build()
                )
                .build();

        ClienteDAO clienteDAO = new ClienteDAO();

        //clienteDAO.save(cliente);


        Propietario propietario = Propietario.builder()
                .nome("Jose maria")
                .contatos(
                        List.of(
                                Contato.builder()
                                        .email("jose@gmail.com")
                                        .telefone("8821892198")
                                        .build()
                        )
                )
                .imoveis(
                        List.of(
                              imovel
                        )
                )
                .endereco(
                        Endereco.builder()
                                .pais("brasil")
                                .estado("Paraiba")
                                .cidade("Cajazeiras")
                                .rua("Pio X")
                                .numero("322")
                                .bairro("centro")
                                .build()
                )
                .build();

        ProprietarioDAO proprietarioDAO = new ProprietarioDAO();

        //proprietarioDAO.save(propietario);

        ImovelDAO imovelDAO = new ImovelDAO();

        Imovel imovelSalvo = imovelDAO.imovelById(14L);
        Corretor corretorSalvo = corretorDAO.getById(5L);
        System.out.println(imovelSalvo);
        Contrato contrato = Contrato.builder()
                .cliente(cliente)
                .corretor(corretorSalvo)
                .data_geracao(new Date())
                .descricao("Um imovel muito grande")
                .imovel(imovelSalvo)
                .propietario(propietario)
                .valor(new BigDecimal(300000))
                .build();

        ContratoDAO contratoDAO = new ContratoDAO();

       // contratoDAO.save(contrato);


        //corretorDAO.save(corretor1);

       // System.out.println(imovelDAO.imovelMaisCaro());


//        var imoveis = imovelDAO.imovelPorEndereco("centro");
//
//        for (Imovel i: imoveis){
//            System.out.println(i);
//        }

//        var corretores = corretorDAO.corretorMaisContratos();
//
//        Object[] row = corretores.get(0);
//
//        String corretorResult =(String) row[0];
//        Long totalContratos =(Long) row[1];
//
//        System.out.println(corretorResult +": "+ totalContratos);

//        var imoveisEntre = imovelDAO.getImoveisEntre( BigDecimal.valueOf(200000.00), BigDecimal.valueOf(310000.00));
//
//        for (Imovel i: imoveisEntre){
//            System.out.println(i);
//        }

//        var proprietarios = proprietarioDAO.proprietarioComImoveis();
//
//        Object[] objProprietario = proprietarios.get(0);
//        Propietario proprietario = (Propietario) objProprietario[0];
//        Long totalImoveisDisponiveis = (Long) objProprietario[1];
//
//        System.out.println("Proprietário: " + proprietario.getNome());
//        System.out.println("Imoveis disponiveis: " + totalImoveisDisponiveis);
//        System.out.println("Imovel para vender: " + proprietario.getImoveis().stream().filter(i -> i.isEstaAvenda()).count());
//        System.out.println("Imovel para alugar: " + proprietario.getImoveis().stream().filter(i -> i.isEstaAluguel()).count());


          }
}