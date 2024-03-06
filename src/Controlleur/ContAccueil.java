package Controlleur;

import Dao.DaoClient;
import Dao.DaoProspect;
import Vues.Accueil;
import entites.Client;
import entites.EntitiesException;
import entites.Prospect;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class ContAccueil {
    public static int operation;
    public static Client clientSelectionne;
    public static Prospect prospectSelectionne;
    public static void initAccueil (){
        Accueil accueil = new Accueil();
    }
    public static void launchGestion (boolean isClientSelected, boolean isProspectSelected){
        ContGestion.initGestion(isClientSelected, isProspectSelected);
    }
    public static void launchAffichageList (boolean isClientSelected, boolean isProspectSelected) throws Exception {
        ContAffichList.initAfficherList(isClientSelected, isProspectSelected);
    }
    public static void findByNameProspect (String filtreRaisonSocial) throws Exception{
        prospectSelectionne = DaoProspect.findByNameProspect(filtreRaisonSocial);
    }
    public static void findByNameClient (String filtreRaisonSocial) throws Exception{
        clientSelectionne = DaoClient.findByNameClient(filtreRaisonSocial);
    }
    public static ArrayList<Client> mettreListClient () throws Exception {
        return DaoClient.findAllClient();
    }
    public static ArrayList<Prospect> mettreListProspect () throws Exception{
        return DaoProspect.findAllProspects();
    }
    public static void lblOperationManager (int operationLbl ){
        switch (operationLbl){
            case 1:operation = 1; break;
            case 2:operation = 2; break;
            default: operation = 3;
        }
    }


}
