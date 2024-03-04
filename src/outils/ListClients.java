package outils;

import entites.Client;

import java.util.ArrayList;

public class ListClients {
    private static final ArrayList<Client> clientsList = new ArrayList<>();
    public static ArrayList <Client> getClientList(){
        return clientsList;
    }
}
