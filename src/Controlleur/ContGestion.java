package Controlleur;

import Dao.DaoClient;
import Dao.DaoException;
import Dao.DaoProspect;
import Vues.Gestion;
import entites.Client;
import entites.EntitiesException;
import entites.Prospect;
import outils.DateFormatter;
import outils.EnumProspectInteresse;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class ContGestion {

    //initiation des pages
    public static void launchAccueil (){
        ContAccueil.initAccueil();
    }
    public static void initGestion (boolean isClientSelected, boolean isProspectSelected){
        Gestion gestion = new Gestion(isClientSelected, isProspectSelected);
    }
    //insertion d'un client
    public static void inseretClient (String raisonSocial, String numRue, String nomRue, String cdPostal, String ville,
                                      String telephone, String mail,double chiffreAffaire, int nbrEmploye,
                                      String commentaire)
            throws DaoException, SQLException, IOException, EntitiesException {
        Client client = new Client(1,raisonSocial,numRue,nomRue,cdPostal, ville,telephone,mail,
                commentaire,chiffreAffaire,nbrEmploye);
        DaoClient.creatClient(client);
    }
    //insertion d'un Prospect, bear in mind dateFormatter
    public static void insertProspect (String raisonSocial, String numRue, String nomRue, String cdPostal, String ville,
                                       String telephone, String mail,LocalDate dateProspection ,
                                       EnumProspectInteresse prospectInteresse,
                                       String commentaire)
            throws DaoException, SQLException, IOException, EntitiesException {
        Prospect prospect = new Prospect(1,raisonSocial,numRue,nomRue,cdPostal, ville,telephone,mail,
                commentaire,dateProspection,prospectInteresse);
        DaoProspect.creatProspect(prospect);
    }
    //Modification d'un client
    public static void modifierClient (String raisonSocial, String numRue, String nomRue, String cdPostal, String ville,
                                       String telephone, String mail,double chiffreAffaire, int nbrEmploye,
                                       String commentaire, int idClient)
            throws DaoException, SQLException, IOException, EntitiesException {
        Client client = new Client(idClient,raisonSocial,numRue,nomRue,cdPostal, ville,telephone,mail,
                commentaire,chiffreAffaire,nbrEmploye);
        DaoClient.updateClient(client);
    }
    //Modification d'un prospect
    public static void modifierProspect (String raisonSocial,String numRue,String nomRue,String cdPostal, String ville,
                                       String telephone, String mail,LocalDate dateProspection ,
                                       EnumProspectInteresse prospectInteresse,
                                       String commentaire, int idProspect)
            throws DaoException, SQLException, IOException, EntitiesException {
        Prospect prospect = new Prospect(idProspect,raisonSocial,numRue,nomRue,cdPostal, ville,telephone,mail,
                commentaire,dateProspection,prospectInteresse);
        DaoProspect.updateProspect(prospect);
    }
    //suppression d'un client
    public static void  supprimerClient (int idClient) throws SQLException, IOException, DaoException {
        DaoClient.deletClient(idClient);
    }
    //suppression d'un prospect
    public static void  supprimerProspect (int idProspect) throws SQLException, IOException, DaoException {
        DaoProspect.deletProspect(idProspect);
    }
    //Designation de l'opperation creation modification suppression
    public static int lblOperationManager (){
        return ContAccueil.operation;
    }
    //methode pour recupperer le client ou prospect
    public static Client recupClient (){
        return ContAccueil.clientSelectionne;
    }
    public static Prospect recupProspect (){
        return ContAccueil.prospectSelectionne;
    }
    //Affichage de date en bonne format jj/mm/aaaa
    public static String afficherDate (LocalDate date){
        return date.format(DateFormatter.getDateFormatter());
    }
    //Convertir la date jj/mm/aaaa en format LocalDate
    public static LocalDate convertirDate (String strDate){
        return LocalDate.parse(strDate, DateFormatter.getDateFormatter());
    }

}
