package Jpa;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.swing.JOptionPane;


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
    
    
    public String addPoitevin(){
        dao.addPoitevin(this.poit);
        this.poit = new Poitevin();
        
        return "index";
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
    
    public String connexionPoitevin(String login, String mdp)
    {
        if (dao.findForConnexion(login, mdp).size() == 1) {
            return "Accueil";
        } else {
            return "indexErreur";
        }
    }

    public Poitevin getPoit() {
        return poit;
    }

    public void setPoit(Poitevin poitevin) {
        this.poit = poitevin;
    }
    
}
