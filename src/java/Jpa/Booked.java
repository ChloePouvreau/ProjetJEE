/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
    private ObjetDao dao;
    private ObjetCtrl objetCtrl;
    private Date date;
    
    public String booked(Objet objet, Poitevin poitevin)
    {
        objet.setDisponibilite(false);
        dao.updateObjet(objet);
        return "Reservation";
    }
    
    public Date getDate()
    {
        return date;
    }
    
    public void setDate(Date date)
    {
        this.date=date;
    }
}
