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

/**
 *
 * @author Chloe Pouvreau
 */
@Stateless
public class PartageDao {
    
    @PersistenceContext(unitName="ProjetJEEPU")
    private EntityManager em;
    
    public List<Partage> findAll(){
        Query query = em.createNamedQuery("Partage.findAll");
        return query.getResultList();
    }
   
    public Object findById(){
        Query query = em.createNamedQuery("Partage.findById");
        return (Partage)query.getSingleResult();
    }
    
    public List<Partage> findByIdLocataire(Poitevin poitevin){
        Query query = em.createNamedQuery("Partage.findByIdLocataire");
        query.setParameter("idLocataire", poitevin);
        List<Partage> result = query.getResultList();
        return result;
    }
    
    public void addPartage(Partage p){
        em.persist(p);
        em.flush();
    }
    
}
