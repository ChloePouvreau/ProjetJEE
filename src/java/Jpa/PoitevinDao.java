/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless


public class PoitevinDao {
    
    @PersistenceContext(unitName="ProjetJEEPU")
    private EntityManager em;
    
    public List<Poitevin> findAll(){
        Query query = em.createNamedQuery("Poitevin.findAll");
        return query.getResultList();
    }
   
    public Object findById(){
        Query query = em.createNamedQuery("Poitevin.findById");
        return (Poitevin)query.getSingleResult();
    }
    
    public List<Poitevin> findForConnexion(String log, String mdp) {
        Query query = em.createNamedQuery("Poitevin.findForConnexion").setParameter("login", log).setParameter("motDePasse", mdp);
        return query.getResultList();
    }
    
    public void addPoitevin(Poitevin e){
        em.persist(e);
        em.flush();
    }
    
    public void updatePoitevin(Poitevin e){
        em.merge(e);
        em.flush();
    }
    
    public void deletePoitevin(Poitevin e){
        em.remove(em.merge(e));
        em.flush();
    }
}
