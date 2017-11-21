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
    private ObjetDao daoObjet;
    private ObjetCtrl objetCtrl;
    private Objet objet;
    private String objetRecherche;
    
    @EJB
    private CategorieDao daoCategorie;
    private CategorieCtrl categorieCtrl;
    private Categorie categorie;
    private String categorieRecherche;
    
    public String search()
    {
        searchObject(this.getObjetRecherche(), this.getCategorieRecherche());
        return "index";
    }
    
    private void searchObject(String nomObjet, String nomCategorie)
    {
        this.objet = new Objet();
        this.objet.setNom(nomObjet);
        this.objetCtrl = new ObjetCtrl();
        this.objetCtrl.setObjet(this.objet);
        
        this.categorie = new Categorie();
        this.categorie.setNom(nomCategorie);
        this.categorieCtrl = new CategorieCtrl();
        this.categorieCtrl.setCategorie(this.categorie);
        //this.objetCtrl.getObjet().setNom(texte);
        if (this.getCategorie().getNom().equals("All"))
        {
            daoObjet.findByNomUncomplete(nomObjet);
        }
        else
        {
            //this.categorieCtrl.getCategorie().setNom(nomCategorie);
            //Categorie categorie = new Categorie(daoCategorie.findByNom().getIdCategorie(), daoCategorie.findByNom().getNom(), daoCategorie.findByNom().getImage());
            this.categorieCtrl.getCategorie().setIdCategorie(daoCategorie.findByNom().getIdCategorie());
            this.categorieCtrl.getCategorie().setIdCategorie(daoCategorie.findByNom().getIdCategorie());
            this.categorieCtrl.getCategorie().setImage(daoCategorie.findByNom().getImage());
            //this.objetCtrl.getObjet().setCategorie(categorie);
            daoObjet.findByNomUncompleteAndCategory();
        }
    }
    
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
    public Objet getObjet()
    {
        return objet;
    }
    
    public void setObjet(Objet objet) {
        this.objet = objet;
    }
    
    public String getCategorieRecherche() {
        return categorieRecherche;
    }

    public void setCategorieRecherche(String categorie) {
        this.categorieRecherche = categorie;
    }
    
    public String getObjetRecherche()
    {
        return objetRecherche;
    }
    
    public void setObjetRecherche(String objet) {
        this.objetRecherche = objet;
    }
}
