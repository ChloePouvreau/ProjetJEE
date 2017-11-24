/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jpa;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chloe Pouvreau
 */
@Entity
@Table(name = "partage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partage.findAll", query = "SELECT p FROM Partage p")
    , @NamedQuery(name = "Partage.findById", query = "SELECT p FROM Partage p WHERE p.id = :id")
    , @NamedQuery(name = "Partage.findByIdLocataire", query = "SELECT p FROM Partage p WHERE p.idLocataire = :idLocataire")
    , @NamedQuery(name = "Partage.findByDeadline", query = "SELECT p FROM Partage p WHERE p.deadline = :deadline")})
public class Partage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deadline")
    @Temporal(TemporalType.DATE)
    private Date deadline;
    @JoinColumn(name = "id_objet", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Objet idObjet;
    @JoinColumn(name = "id_locataire", referencedColumnName = "Login")
    @ManyToOne(optional = false)
    private Poitevin idLocataire;

    public Partage() {
    }

    public Partage(Integer id) {
        this.id = id;
    }

    public Partage(Integer id, Date deadline) {
        this.id = id;
        this.deadline = deadline;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Objet getIdObjet() {
        return idObjet;
    }

    public void setIdObjet(Objet idObjet) {
        this.idObjet = idObjet;
    }

    public Poitevin getIdLocataire() {
        return idLocataire;
    }

    public void setIdLocataire(Poitevin idLocataire) {
        this.idLocataire = idLocataire;
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
        if (!(object instanceof Partage)) {
            return false;
        }
        Partage other = (Partage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Jpa.Partage[ id=" + id + " ]";
    }
    
}
