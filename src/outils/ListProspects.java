package outils;

import entites.Client;
import entites.Prospect;

import java.util.ArrayList;

public class ListProspects {
    private static final ArrayList<Prospect> prospectsList = new ArrayList<>();
    public static ArrayList <Prospect> getProspectsList(){
        return prospectsList;
    }
}
