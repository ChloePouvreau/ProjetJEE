package Jpa;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;


@Named(value="ctlrpoit")
@SessionScoped
public class PoitevinCtrl implements Serializable{
    
    //Entreprise Java Bean (EJB)
    @EJB
    private PoitevinDao dao;
    private Poitevin poit;
    
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

    public void deletePoitevin(){
        dao.deletePoitevin(this.poit);
        this.poit.setAge(0);
        this.poit.setNom("");
        this.poit.setPrenom("");
        this.poit.setEmail("");
        this.poit.setLogin("");
        this.poit.setMotDePasse("");
    }
    
    public void updatePoitevin(int a, String nom, String prenom, String mdp, String mail){
        dao.updatePoitevin(this.poit);
        this.poit.setAge(a);
        this.poit.setNom(nom);
        this.poit.setPrenom(prenom);
        this.poit.setMotDePasse(mdp);
        this.poit.setEmail(mail);
    }
    
    public String connexionPoitevin()
    {
        List<Poitevin> listPoitevin = this.getPoitevins();
        Poitevin monPoit;
        boolean trouve = false;
        for (int i = 0; i < listPoitevin.size(); i++){
            monPoit = listPoitevin.get(i);
            if (this.poit.getLogin().equals(monPoit.getLogin()) && this.poit.getMotDePasse().equals(monPoit.getMotDePasse())){
                this.poit = monPoit;
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
    
    public String deconnexionPoitevin()
    {
        
        return "Connexion";
    }
    
    public String profilPoitevin()
    {
        return "Profil";
    }

    public Poitevin getPoit() {
        return poit;
    }

    public void setPoit(Poitevin poitevin) {
        this.poit = poitevin;
    }
    
}
