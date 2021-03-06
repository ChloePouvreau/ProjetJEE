/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
public class Booked implements Serializable {
    
    @EJB
    private ObjetDao daoObjet;
    
    @EJB
    private PartageDao daoPartage;
    
    private Date date;
    
    private List<Objet> objetReserve;
    
    public void booked(Objet objet, Poitevin poitevin, Search search)
    {
        objet.setDisponibilite(false);
        daoObjet.updateObjet(objet);
        Partage partage = new Partage();
        partage.setIdObjet(objet);
        partage.setIdLocataire(poitevin);
        partage.setDeadline(this.getDate());
        daoPartage.addPartage(partage);
        
        List<Objet> objets = new ArrayList<Objet>();
        search.setObjetRecherche(objets);
        
    }
    
    public Date getDate()
    {
        return date;
    }
    
    public void setDate(Date date)
    {
        this.date=date;
    }
    
    public String searchMyObjects(Poitevin poitevin)
    {
        this.setObjetReserve(daoObjet.findByPoitevin(poitevin));
        return "Reservation";
    }
    
    public List<Objet> getObjetReserve()
    {
        return objetReserve;
    }
    
    public void setObjetReserve(List<Objet> objetReserve)
    {
        this.objetReserve = objetReserve;
    }
}
