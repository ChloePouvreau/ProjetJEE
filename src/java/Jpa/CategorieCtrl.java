/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.swing.JOptionPane;

/**
 *
 * @author Chloe Pouvreau
 */
@Named(value="ctrlcategorie")
@ViewScoped
public class CategorieCtrl implements Serializable
{
    @EJB
    private CategorieDao dao;
    private Categorie categorie;
    private String texte;
    
    public CategorieCtrl() {
        this.categorie = new Categorie();
    }
    
    public List<Categorie> getCategories(){
        return dao.findAll();
    }
    
    public List<String> getCategoriesName(){
        List<String> noms = new ArrayList<String>();
        List<Categorie> categories = getCategories();
        for(Categorie uneCategorie : getCategories())
        {
            noms.add(uneCategorie.getNom());
        }
        return noms;
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
