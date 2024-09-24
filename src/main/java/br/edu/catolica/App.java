package br.edu.catolica;


import br.edu.catolica.dao.CorretorDAO;
import br.edu.catolica.domain.Contato;
import br.edu.catolica.domain.Corretor;
import br.edu.catolica.domain.Endereco;

import java.util.List;

public class App {
    public static void main(String[] args) {



        var corretorDAO = new CorretorDAO();
        var corretor = Corretor.builder()
                .nome("Janderson")
                .creci("123")
                .endereco(Endereco.builder()
                        .pais("brasil")
                        .estado("paraiba")
                        .cidade("sao jose")
                        .rua("Sit")
                        .numero("sn")
                        .build())
                .contatos(List.of(
                        Contato.builder()
                                .email("janderson@gmail.com")
                                .telefone("83981245536")
                                .build()
                ))
                .build();

        corretorDAO.save(corretor);

        System.out.println(corretorDAO);

    }
}