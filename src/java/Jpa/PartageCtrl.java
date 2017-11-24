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
@Named(value="ctrlpartage")
@SessionScoped
public class PartageCtrl implements Serializable
{
    
    //Entreprise Java Bean (EJB)
    @EJB
    private PartageDao dao;
    private Partage partage;
    
    public PartageCtrl() {
        this.partage = new Partage();
    }
    
    public List<Partage> getPartages(){
        return dao.findAll();
    }
    
    public List<Partage> getMyPartages(Poitevin poitevin){
        return dao.findByIdLocataire(poitevin);
    }
    
    public List<Partage> getMyObjects(Poitevin poitevin)
    {
        List<Partage> mesObjetsPartages = new ArrayList<Partage>();
        for (Partage p : getPartages())
        {
            if (p.getIdObjet().getIdProprietaire().equals(poitevin))
            {
                mesObjetsPartages.add(p);
            }
        }
        return mesObjetsPartages;
    }
    
    public void addPartage(){
        dao.addPartage(this.partage);
        this.partage = new Partage();
    }
    
}
