package br.edu.catolica.dao;

import br.edu.catolica.domain.Imovel;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;


public class ImovelDAO {

    private final persistence.JPAUtil jpaUtil;

    public ImovelDAO(){
        this.jpaUtil = new persistence.JPAUtil();
    }

    public void save(Imovel imovel){
        jpaUtil.getEntityManager().getTransaction().begin();
        jpaUtil.getEntityManager().persist(imovel);
        jpaUtil.getEntityManager().getTransaction().commit();
        jpaUtil.getEntityManager().close();
    }

    public List<Imovel> imovelPorEndereco(String bairro){

        Query query = jpaUtil.getEntityManager()
                .createNamedQuery("imovel.ImoveisPeloBairro");
        var list = query.setParameter("bairro",bairro);

        return list.getResultList();
    }

    public List imovelMaisCaro(){
        Query query = jpaUtil.getEntityManager()
                .createNamedQuery("imovel.imoveilMaisCaro");

        return query.getResultList();
    }

    public Imovel imovelById(Long id){
        jpaUtil.getEntityManager().getTransaction().begin();
        var imovel = jpaUtil.getEntityManager().find(Imovel.class, id);
        return imovel;
    }

    public List<Imovel> getImoveisEntre(BigDecimal valorInicial, BigDecimal valorFinal){
        Query query = jpaUtil.getEntityManager()
                .createNamedQuery("imoveis.imoveisEntre");
        var list = query.setParameter("valorInicial",valorInicial)
                .setParameter("valorFinal",valorFinal);

        return list.getResultList();

    }
}
