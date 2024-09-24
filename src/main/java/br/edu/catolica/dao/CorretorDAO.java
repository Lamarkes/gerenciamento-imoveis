package br.edu.catolica.dao;
import br.edu.catolica.domain.Corretor;
import persistence.JPAUtil;

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


}
