package Controlleur;

import Dao.DaoClient;
import Dao.DaoProspect;
import Vues.AffichageListe;
import entites.Client;
import entites.Prospect;

import java.util.ArrayList;

public class ContAffichList {
    public static void initAfficherList (boolean isClientSelected, boolean isProspectSelected) throws Exception{
        AffichageListe affichageListe = new AffichageListe(isClientSelected, isProspectSelected);
    }
    public static ArrayList<Client> mettreListClient () throws Exception {
        return DaoClient.findAllClient();
    }
    public static ArrayList<Prospect> mettreListProspect () throws Exception{
        return DaoProspect.findAllProspects();
    }

}
