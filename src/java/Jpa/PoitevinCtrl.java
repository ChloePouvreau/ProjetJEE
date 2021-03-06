package Jpa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named(value="ctlrpoit")
@SessionScoped
public class PoitevinCtrl implements Serializable{
    
    //Entreprise Java Bean (EJB)
    @EJB
    private PoitevinDao dao;
    private Poitevin poit;
    
    @EJB
    private ObjetDao daoObjet;
    private ObjetCtrl ctrlObjet;
    
    public PoitevinCtrl() {
        this.poit = new Poitevin();
    }
    
    public List<Poitevin> getPoitevins(){
        return dao.findAll();
    }
    
    
    public String addPoitevin(){
        dao.addPoitevin(this.poit);
        this.poit = new Poitevin();
        
        return "Connexion";
    }

    public String deletePoitevin(){
        //deleteObjetPoitevin();
        dao.deletePoitevin(this.poit);
        this.poit.setAge(0);
        this.poit.setNom("");
        this.poit.setPrenom("");
        this.poit.setEmail("");
        this.poit.setLogin("");
        this.poit.setMotDePasse("");
        
        return "index";
    }
    
    public String updatePoitevin(){
        dao.updatePoitevin(this.poit);        
        
        return "Profil";  
    }
    
    public String connexionPoitevin()
    {
        List<Poitevin> listPoitevin = this.getPoitevins();
        Poitevin monPoit;
        boolean trouve = false;
        for (int i = 0; i < listPoitevin.size(); i++){
            monPoit = listPoitevin.get(i);
            if (this.poit.getLogin().equals(monPoit.getLogin()) && this.poit.getMotDePasse().equals(monPoit.getMotDePasse())){
                //this.poit = monPoit;
                setPoit(monPoit);
                trouve = true;
                break;
            }
        }        
        if (trouve == true) {
            return "Accueil";
        } else {
            return "ConnexionErreur";
        }
    }
    
    public void deconnexionPoitevin()
    {
        Poitevin poitevin = new Poitevin();
        this.setPoit(poitevin);
    }
    
    public List<Objet> searchObjectPoitevin()
    {
        return daoObjet.findByPoitevin(this.poit);
    }
    
    public String updateObjetPoitevin(Objet objet)
    {
        daoObjet.updateObjet(objet);
        return "ModificationObjet";
    }           

    public void deleteObjetPoitevin(Objet objet)
    {
        daoObjet.deleteObjet(objet);
    }
    
    public Poitevin getPoit() {
        return this.poit;
    }

    public void setPoit(Poitevin poitevin) {
        this.poit = poitevin;
    }
    
     public List<Objet> myObjet(){
        List<Objet> listObjet = daoObjet.findAll();
        Objet monObjet;
        List<Objet> myObjets = new ArrayList<>();
        for (int i = 0; i < listObjet.size(); i++){
            monObjet = listObjet.get(i);
            if (this.poit.getLogin().equals(monObjet.getIdProprietaire().getLogin())){
                myObjets.add(monObjet);
            }
        }
        
        return myObjets;
    }
}
