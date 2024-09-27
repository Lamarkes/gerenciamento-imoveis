package br.edu.catolica.dao;

import br.edu.catolica.domain.Cliente;
import br.edu.catolica.domain.Contrato;
import br.edu.catolica.domain.Corretor;

public class ContratoDAO {

    private final persistence.JPAUtil jpaUtil;

    public ContratoDAO(){
        this.jpaUtil = new persistence.JPAUtil();
    }

    public void save(Contrato contrato){
        jpaUtil.getEntityManager().getTransaction().begin();
        jpaUtil.getEntityManager().merge(contrato);
        jpaUtil.getEntityManager().getTransaction().commit();
        jpaUtil.getEntityManager().close();
    }

    public Contrato getById(Long id){
        jpaUtil.getEntityManager().getTransaction().begin();
        var contrato = jpaUtil.getEntityManager().find(Contrato.class, id);
        return contrato;
    }
}
