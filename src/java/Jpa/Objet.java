/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author agath
 */
@Entity
@Table(name = "objet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Objet.findAll", query = "SELECT o FROM Objet o")
    , @NamedQuery(name = "Objet.findById", query = "SELECT o FROM Objet o WHERE o.id = :id")
    , @NamedQuery(name = "Objet.findByNom", query = "SELECT o FROM Objet o WHERE o.nom = :nom")
    , @NamedQuery(name = "Objet.findByDisponibilite", query = "SELECT o FROM Objet o WHERE o.disponibilite = :disponibilite")
    , @NamedQuery(name = "Objet.findByNomUncomplete", query = "SELECT o FROM Objet o WHERE o.nom LIKE :nom AND o.disponibilite=1")
    , @NamedQuery(name = "Objet.findByNomUncompleteAndCategory", query = "SELECT o FROM Objet o WHERE o.nom LIKE :nom AND o.categorie = :categorie AND o.disponibilite=1")})
public class Objet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private boolean disponibilite;
    private Categorie categorie;
    private Poitevin idProprietaire;

    public Objet() {
    }

    public Objet(Integer id) {
        this.id = id;
    }

    public Objet(Integer id, String nom, boolean disponibilite) {
        this.id = id;
        this.nom = nom;
        this.disponibilite = disponibilite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Poitevin getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(Poitevin idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Objet)) {
            return false;
        }
        Objet other = (Objet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Jpa.Objet[ id=" + id + " ]";
    }
    
}
