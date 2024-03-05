package entites;

import outils.EnumProspectInteresse;
import outils.ListProspects;

import java.time.LocalDate;

/**
 * La class Prospect herite de la class societe tous les infos d'identite
 * contient: la date de rentre en base de donnee comme prospect en respectant le format francais
 * contient: si le prospect est interesse ou non
 * @author Younes
 * @version 1.0
 * @since 27/02/2024
 *
 */
public class Prospect extends Societe{
    private LocalDate dateProspection;
    private EnumProspectInteresse prospectInteresse;
    private String dateStr;

    public Prospect(int idSociete, String raisonSociale,
                    String numRue, String nomRue, String cdPostal, String ville,
                    String telephone, String mail, String commentaire,
                    LocalDate p_dateProspection, EnumProspectInteresse p_prospectInteresse)
            throws EntitiesException
    {
        super(idSociete, raisonSociale, numRue, nomRue, cdPostal, ville, telephone, mail, commentaire);
        setDateProspection(p_dateProspection);
        setProspectInteresse(p_prospectInteresse);
    }
    //utilisation dans test
    public Prospect(){}

    public void setDateProspection(LocalDate p_dateProspection) throws EntitiesException {
        if (p_dateProspection !=null)
        {
        dateProspection = p_dateProspection;
        }else throw new EntitiesException("Champ date obligatoir ");
    }
    public LocalDate getDateProspection(){
        return dateProspection;
    }
    public void setProspectInteresse(EnumProspectInteresse p_prospectInteresse) {
        prospectInteresse = p_prospectInteresse;
    }
    public EnumProspectInteresse getProspectInteresse() {
        return prospectInteresse;
    }

    public String toString() {
        return "Prospect { " +
                "id Societe= " + getId() +
                ", Raison Sociale: " + getRaisonSociale() + '\'' +
                ", Date de la prospection: " + getDateProspection() +
                ", Prospect Interessé: " + getProspectInteresse() + '\'' +
                "}";
    }
}
