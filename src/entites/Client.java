package entites;

import logs.MyLogger;
import outils.ListClients;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La class Client représente un client héritant de la classe Societe.
 * Elle stocke des informations spécifiques aux clients tels que le chiffre d'affaires et le nombre d'employés.
 *
 * @author Younes
 * @version 1.0
 */
public class Client extends Societe {
    private double chiffreAffaire;
    private int nbrEmploye;

    public Client(int idSociete, String raisonSociale,
                  String numRue, String nomRue, String cdPostal, String ville,
                  String telephone, String mail, String commentaire,
                  double p_chiffreAffaire, int p_nbrEmployes) throws EntitiesException {
        super(idSociete, raisonSociale, numRue, nomRue, cdPostal, ville, telephone, mail, commentaire);
        setChiffreAffaire(p_chiffreAffaire);
        setNbrEmploye(p_nbrEmployes);
        ListClients.getClientList().add(this);
    }
    //public Client ()throws EntitiesException{}
    public void setChiffreAffaire (double p_chiffreAffaire) throws EntitiesException {
        if (p_chiffreAffaire > 200) {
            chiffreAffaire = p_chiffreAffaire;
        } else {
            throw new EntitiesException("Le chiffre d'affaires doit être supérieur à 200");
        }
    }
    public double getChiffreAffaire() {
        return chiffreAffaire;
    }
    public void setNbrEmploye (int p_nbrEmployes) throws EntitiesException{
        if (p_nbrEmployes > 0) {
            nbrEmploye = p_nbrEmployes;
        } else {
            throw new EntitiesException("Le nombre d'employés doit être strictement supérieur à zéro");
        }
    }
    public int getNbrEmploye() {
        return nbrEmploye;
    }

    public String toString(){
        return "Client { "+
                " id Societe: " + getId() +
                ", Raison Sociale: '" + getRaisonSociale() + '\'' +
                " ,Chiffre D'affaire: '"+ getChiffreAffaire() + '\''+
                " ,Nombre d'employés: '"+ getNbrEmploye()+'\''+
                " }";
    }
}
