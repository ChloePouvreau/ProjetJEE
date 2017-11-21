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
public class ObjetDao {
    
    @PersistenceContext(unitName="ProjetJEEPU")
    private EntityManager em;
    
    public List<Objet> findAll(){
        return em.createNamedQuery("Objet.findAll").getResultList();
    }
   
    public Object findById(){
        Query query = em.createNamedQuery("Objet.findById");
        return (Objet)query.getSingleResult();
    }
    
    public Object findByNomUncomplete(){
        Query query = em.createNamedQuery("Objet.findByNomUncomplete");
        return query.getResultList();
    }
    
    public Object findByNomUncompleteAndCategory(){
        Query query = em.createNamedQuery("Objet.findByNomUncompleteAndCategory");
        return query.getResultList();
    }  
}
