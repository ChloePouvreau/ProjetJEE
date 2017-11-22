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
   
    public Objet findById(){
        Query query = em.createNamedQuery("Objet.findById");
        return (Objet)query.getSingleResult();
    }
    
    public List<Objet> findByNomUncomplete(String nom){
        Query query = em.createNamedQuery("Objet.findByNomUncomplete");
        query.setParameter("nom", "%"+nom+"%");
        List<Objet> result = query.getResultList();
        return result;
    }
    
    public List<Objet> findByNomUncompleteAndCategory(String nom, Categorie categorie){
        Query query = em.createNamedQuery("Objet.findByNomUncompleteAndCategory");
        query.setParameter("nom", "%"+nom+"%");
        query.setParameter("categorie", categorie);
        List<Objet> result = query.getResultList();
        return result;
    }  
    
    public List<Objet> findByPoitevin(Poitevin poitevin){
        Query query = em.createNamedQuery("Objet.findByPoitevin");
        query.setParameter("idProprietaire", poitevin);
        List<Objet> result = query.getResultList();
        return result;
    }  
    
    public void deleteObjet(Objet o){
        em.remove(em.merge(o));
        em.flush();
    }
}
