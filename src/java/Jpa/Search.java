/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Chloe Pouvreau
 */
@ManagedBean
public class Search {
    
    @EJB
    private CategorieDao daoCategorie;
    private ObjetDao daoObjet;
    private CategorieCtrl categorieCtrl;
    private ObjetCtrl objetCtrl;
    
    public void search()
    {
        searchObject(this.categorieCtrl.getTexte(), this.categorieCtrl.getCategorie().getNom());
        this.categorieCtrl.setCategorie(new Categorie());
    }
    
    public void searchObject(String texte, String nomCategorie)
    {
        this.objetCtrl.getObjet().setNom(texte);
        if (nomCategorie=="")
        {
            daoObjet.findByNomUncomplete();
        }
        else
        {
            Categorie categorie = new Categorie(daoCategorie.findByNom().getIdCategorie(), daoCategorie.findByNom().getNom(), daoCategorie.findByNom().getImage());
            this.objetCtrl.getObjet().setCategorie(categorie);
            daoObjet.findByNomUncompleteAndCategory();
        }
    }
}
