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
    public static void initAccueil (){
        Accueil accueil = new Accueil();
    }
    public static ArrayList<Client> mettreListClient () throws Exception {
        return DaoClient.findAllClient();
    }
    public static ArrayList<Prospect> mettreListProspect () throws Exception{
        return DaoProspect.findAllProspects();
    }


}
