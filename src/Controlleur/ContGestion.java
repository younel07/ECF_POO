package Controlleur;

import Dao.DaoClient;
import Dao.DaoProspect;
import Vues.Gestion;
import entites.Client;
import entites.Prospect;

public class ContGestion {
    public static void initGestion (boolean isClientSelected, boolean isProspectSelected){
        Gestion gestion = new Gestion(isClientSelected, isProspectSelected);
    }
    public static void findByNameProspect (String filtreRaisonSocial) throws Exception{
       DaoProspect.findByNameProspect(filtreRaisonSocial);
    }
    public static void findByNameClient (String filtreRaisonSocial) throws Exception{
        DaoClient.findByNameClient(filtreRaisonSocial);
    }
    public static int lblOperationManager (){
        return ContAccueil.operation;
    }
    public static Client recupClient (){
        return ContAccueil.clientSelectionne;
    }
    public static Prospect recupProspect (){
        return ContAccueil.prospectSelectionne;
    }
}
