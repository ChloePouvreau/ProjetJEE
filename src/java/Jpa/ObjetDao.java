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
        Query query = em.createNamedQuery("Objet.findAll");
        List<Objet> lst = query.getResultList();
        return lst;
    }
   
    public Objet findById(){
        Query query = em.createNamedQuery("Objet.findById");
        return (Objet)query.getSingleResult();
    }
    
    public List<Objet> findByNomUncomplete(String nom, Poitevin poitevin){
        Query query = em.createNamedQuery("Objet.findByNomUncomplete");
        query.setParameter("nom", "%"+nom+"%");
        query.setParameter("idProprietaire", poitevin);
        List<Objet> result = query.getResultList();
        return result;
    }
    
    public List<Objet> findByNomUncompleteAndCategory(String nom, Categorie categorie, Poitevin poitevin){
        Query query = em.createNamedQuery("Objet.findByNomUncompleteAndCategory");
        query.setParameter("nom", "%"+nom+"%");
        query.setParameter("categorie", categorie);
        query.setParameter("idProprietaire", poitevin);
        List<Objet> result = query.getResultList();
        return result;
    }  
    
    public List<Objet> findByPoitevin(Poitevin poitevin){
        Query query = em.createNamedQuery("Objet.findByPoitevin");
        query.setParameter("idProprietaire", poitevin);
        List<Objet> result = query.getResultList();
        return result;
    }  
    
    public void addObjet(Objet o){
        em.persist(o);
        em.flush();
    }
    
    public void updateObjet(Objet o){
        em.merge(o);
        em.flush();
    }
    
    public void deleteObjet(Objet o){
        em.remove(em.merge(o));
        em.flush();
    }
}
