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
public class CategorieDao {
    
    @PersistenceContext(unitName="ProjetJEEPU")
    private EntityManager em;
    
    public List<Categorie> findAll(){
        return em.createNamedQuery("Categorie.findAll").getResultList();
    }
   
    public Object findByIdCategorie(){
        Query query = em.createNamedQuery("Categorie.findByIdCategorie");
        return (Categorie)query.getSingleResult();
    }
    
    public Categorie findByNom(String nom){
        Query query = em.createNamedQuery("Categorie.findByNom");
        query.setParameter("nom", nom);
        Categorie result = (Categorie)query.getSingleResult();
        return result;
    }
    
    public Categorie findByImage(){
        Query query = em.createNamedQuery("Categorie.findByImage");
        return (Categorie)query.getSingleResult();
    }    
}
