/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Chloe Pouvreau
 */
@ManagedBean
@SessionScoped
public class Search {
    
    @EJB
    private ObjetDao daoObjet;
    private ObjetCtrl objetCtrl;
    private String objet;
    
    @EJB
    private CategorieDao daoCategorie;
    private CategorieCtrl categorieCtrl;
    private String categorie;
    
    private List<Objet> objetRecherche;
    
    public String search(Poitevin poitevin)
    {
        searchObject(this.getObjet(), this.getCategorie(), poitevin);
        return "Accueil";
    }
    
    private void searchObject(String nomObjet, String nomCategorie, Poitevin poitevin)
    {
        this.objetRecherche = new ArrayList<Objet>();
        Categorie categorie = new Categorie();
        categorie.setNom(nomCategorie);
        this.categorieCtrl = new CategorieCtrl();
        this.categorieCtrl.setCategorie(categorie);
        if (this.categorieCtrl.getCategorie().getNom().equals("All"))
        {
            this.setObjetRecherche(daoObjet.findByNomUncomplete(nomObjet, poitevin));
        }
        else
        {
            this.categorieCtrl.getCategorie().setIdCategorie(daoCategorie.findByNom(nomCategorie).getIdCategorie());
            this.categorieCtrl.getCategorie().setImage(daoCategorie.findByNom(nomCategorie).getImage());
            this.setObjetRecherche(daoObjet.findByNomUncompleteAndCategory(nomObjet,categorie, poitevin));
        }
    }
    
    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    
    public String getObjet()
    {
        return objet;
    }
    
    public void setObjet(String objet) {
        this.objet = objet;
    }
    
    public List<Objet> getObjetRecherche()
    {
        return objetRecherche;
    }
    
    public String searchMyObjects(Poitevin poitevin)
    {
        this.setObjetRecherche(daoObjet.findByPoitevin(poitevin));
        return "Reservation";
    }
    
    public void setObjetRecherche(List<Objet> objetRecherche) {
        this.objetRecherche = objetRecherche;
    }
}
