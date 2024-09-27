package br.edu.catolica.dao;

import br.edu.catolica.domain.Cliente;
import br.edu.catolica.domain.Corretor;

public class ClienteDAO {

    private final persistence.JPAUtil jpaUtil;

    public ClienteDAO(){
        this.jpaUtil = new persistence.JPAUtil();
    }

    public void save(Cliente cliente){
        jpaUtil.getEntityManager().getTransaction().begin();
        jpaUtil.getEntityManager().persist(cliente);
        jpaUtil.getEntityManager().getTransaction().commit();
        jpaUtil.getEntityManager().close();
    }


    public Cliente getById(Long id){
        jpaUtil.getEntityManager().getTransaction().begin();
        var cliente = jpaUtil.getEntityManager().find(Cliente.class, id);
        return cliente;
    }

}
