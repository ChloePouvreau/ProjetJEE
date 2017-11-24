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
import javax.persistence.Id;
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
@Table(name = "poitevin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poitevin.findAll", query = "SELECT p FROM Poitevin p")
    , @NamedQuery(name = "Poitevin.findByLogin", query = "SELECT p FROM Poitevin p WHERE p.login = :login")
    , @NamedQuery(name = "Poitevin.findForConnexion", query = "SELECT p FROM Poitevin p WHERE p.login = :login AND p.motDePasse = :motDePasse")
    , @NamedQuery(name = "Poitevin.findByNom", query = "SELECT p FROM Poitevin p WHERE p.nom = :nom")
    , @NamedQuery(name = "Poitevin.findByPrenom", query = "SELECT p FROM Poitevin p WHERE p.prenom = :prenom")
    , @NamedQuery(name = "Poitevin.findByAge", query = "SELECT p FROM Poitevin p WHERE p.age = :age")
    , @NamedQuery(name = "Poitevin.findByEmail", query = "SELECT p FROM Poitevin p WHERE p.email = :email")
    , @NamedQuery(name = "Poitevin.findByMotDePasse", query = "SELECT p FROM Poitevin p WHERE p.motDePasse = :motDePasse")})
public class Poitevin implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLocataire")
    private Collection<Partage> partageCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Age")
    private int age;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MotDePasse")
    private String motDePasse;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "idProprietaire")
    private Collection<Objet> objetCollection;

    public Poitevin() {
    }

    public Poitevin(String login) {
        this.login = login;
    }

    public Poitevin(String login, String nom, String prenom, int age, String email, String motDePasse) {
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @XmlTransient
    public Collection<Objet> getObjetCollection() {
        return objetCollection;
    }

    public void setObjetCollection(Collection<Objet> objetCollection) {
        this.objetCollection = objetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poitevin)) {
            return false;
        }
        Poitevin other = (Poitevin) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Jpa.Poitevin[ login=" + login + " ]";
    }

    @XmlTransient
    public Collection<Partage> getPartageCollection() {
        return partageCollection;
    }

    public void setPartageCollection(Collection<Partage> partageCollection) {
        this.partageCollection = partageCollection;
    }
    
}
