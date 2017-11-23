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
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Chloe Pouvreau
 */
@Named(value="ctrlobjet")
@SessionScoped
public class ObjetCtrl implements Serializable
{
    @EJB
    private ObjetDao dao;
    private Objet objet;
    
    @EJB
    private PoitevinDao daoPoit;
    private PoitevinCtrl ctrlPoit;
    
    
    public ObjetCtrl() {
        this.objet = new Objet();
    }
    
    public List<Objet> getObjets(){
        return dao.findAll();
    }   

    public Objet getObjet() {
        return objet;
    }

    public void setObjet(Objet objet) {
        this.objet = objet;
    }
    
    public String addObjet(){
        this.objet.setIdProprietaire(ctrlPoit.getPoit());
        dao.addObjet(this.objet);
        this.objet = new Objet();
        
        return "Profil";
    }
    
    public void deleteObjet(){
        dao.deleteObjet(this.objet);
        //this.objet.setId(0);
        //this.objet.setNom("");
        //this.objet.setCategorie("");
        //this.objet.setDescription("");
        //this.objet.setIdProprietaire("");
        
    }
    
    public String updateObjet(){
        dao.updateObjet(this.objet);        
        
        return "Profil";  
    }
}