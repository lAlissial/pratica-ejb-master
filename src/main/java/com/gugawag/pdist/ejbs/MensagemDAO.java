package com.gugawag.pdist.ejbs;


import com.gugawag.pdist.model.Mensagem;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MensagemDAO {

    @PersistenceContext(unitName = "default")
    private EntityManager em;

    public void inserir(Mensagem novaMensagem){
        em.persist(novaMensagem);
    }

    public List<Mensagem> listar() {
        return em.createQuery("FROM Mensagem").getResultList();
    }

    public Mensagem pesquisarPorId(long idPesquisado){
        return (Mensagem) em.createQuery("SELECT m FROM Mensagem m WHERE m.id = :idmesg").setParameter("idmesg", idPesquisado).getSingleResult();
    }
}
