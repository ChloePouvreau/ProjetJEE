/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Chloe Pouvreau
 */
@Entity
@Table(name = "objet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Objet.findAll", query = "SELECT o FROM Objet o")
    , @NamedQuery(name = "Objet.findById", query = "SELECT o FROM Objet o WHERE o.id = :id")
    , @NamedQuery(name = "Objet.findByNom", query = "SELECT o FROM Objet o WHERE o.nom = :nom")
    , @NamedQuery(name = "Objet.findByDescription", query = "SELECT o FROM Objet o WHERE o.description = :description")
    , @NamedQuery(name = "Objet.findByDisponibilite", query = "SELECT o FROM Objet o WHERE o.disponibilite = :disponibilite")
    , @NamedQuery(name = "Objet.findByNomUncomplete", query = "SELECT o FROM Objet o WHERE o.nom LIKE :nom AND o.disponibilite=1 AND o.idProprietaire!=:idProprietaire")
    , @NamedQuery(name = "Objet.findByNomUncompleteAndCategory", query = "SELECT o FROM Objet o WHERE o.nom LIKE :nom AND o.categorie = :categorie AND o.disponibilite=1 AND o.idProprietaire!=:idProprietaire")
    , @NamedQuery(name = "Objet.findByPoitevin", query = "SELECT o FROM Objet o WHERE o.idProprietaire = :idProprietaire")})
public class Objet implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idObjet")
    private Collection<Partage> partageCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Nom")
    private String nom;
    @Size(max = 200)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "disponibilite")
    private boolean disponibilite;
    @JoinColumn(name = "Categorie", referencedColumnName = "idCategorie")
    @ManyToOne(optional = false)
    private Categorie categorie;
    @JoinColumn(name = "id_proprietaire", referencedColumnName = "Login")
    @ManyToOne(optional = false)
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @XmlTransient
    public Collection<Partage> getPartageCollection() {
        return partageCollection;
    }

    public void setPartageCollection(Collection<Partage> partageCollection) {
        this.partageCollection = partageCollection;
    }
    
}
