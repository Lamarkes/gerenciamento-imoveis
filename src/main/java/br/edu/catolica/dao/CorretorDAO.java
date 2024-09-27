package br.edu.catolica.dao;
import br.edu.catolica.domain.Corretor;
import br.edu.catolica.domain.Imovel;
import persistence.JPAUtil;

import javax.persistence.Query;
import java.util.List;

public class CorretorDAO {

    private final JPAUtil jpaUtil;

    public CorretorDAO(){
        this.jpaUtil = new JPAUtil();
    }

    public void save(Corretor corretor){
        jpaUtil.getEntityManager().getTransaction().begin();
        jpaUtil.getEntityManager().persist(corretor);
        jpaUtil.getEntityManager().getTransaction().commit();
        jpaUtil.getEntityManager().close();
    }

    public Corretor getById(Long id){
        jpaUtil.getEntityManager().getTransaction().begin();
        var corretor = jpaUtil.getEntityManager().find(Corretor.class, id);
        return corretor;
    }

    public List<Object[]> corretorMaisContratos(){
        Query query = jpaUtil.getEntityManager()
                .createNamedQuery("corretor.CorretorMaisContratos")
                .setMaxResults(1);

        return query.getResultList();

    }


}
