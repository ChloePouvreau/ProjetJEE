package Jpa;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named(value="ctlrpoit")
@ViewScoped
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
    
    public void addPoitevin(){
        dao.addPoitevin(this.poit);
        this.poit = new Poitevin();
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

    public Poitevin getPoitevin() {
        return poit;
    }

    public void setPoitevin(Poitevin poitevin) {
        this.poit = poitevin;
    }
    
}
