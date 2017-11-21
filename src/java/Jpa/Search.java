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
    private ObjetCtrl objetCtrl;
    private String texte;
    private Categorie categorie;
    
    public String search()
    {
        //searchObject(this.getTexte(), this.getCategorie().getNom());
        //this.setCategorie(new Categorie());
        return "index";
    }
    
    private void searchObject(String texte, String nomCategorie)
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
    
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
    public String getTexte()
    {
        return texte;
    }
    
    public void setTexte(String texte) {
        this.texte = texte;
    }
}
