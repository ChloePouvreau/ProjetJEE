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
@Named(value="ctrlobjet")
@ViewScoped
public class ObjetCtrl implements Serializable
{
    @EJB
    private ObjetDao dao;
    private Objet objet;
    
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
}
