package br.edu.catolica.dao;

import br.edu.catolica.domain.Cliente;
import br.edu.catolica.domain.Corretor;
import br.edu.catolica.domain.Propietario;

import javax.persistence.Query;
import java.util.List;

public class ProprietarioDAO {

    private final persistence.JPAUtil jpaUtil;

    public ProprietarioDAO(){
        this.jpaUtil = new persistence.JPAUtil();
    }

    public void save(Propietario propietario){
        jpaUtil.getEntityManager().getTransaction().begin();
        jpaUtil.getEntityManager().persist(propietario);
        jpaUtil.getEntityManager().getTransaction().commit();
        jpaUtil.getEntityManager().close();
    }

    public List<Object[]> proprietarioComImoveis(){
        Query query = jpaUtil.getEntityManager()
                .createNamedQuery("proprietario.ImoveisDisponiveis");

        return query.getResultList();
    }

    public Propietario getById(Long id){
        jpaUtil.getEntityManager().getTransaction().begin();
        var propietario = jpaUtil.getEntityManager().find(Propietario.class, id);
        return propietario;
    }
}
