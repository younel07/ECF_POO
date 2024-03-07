package Vues;

import Controlleur.ContAccueil;
import Controlleur.ContAffichList;
import Dao.DaoException;
import entites.Client;
import entites.Prospect;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class AffichageListe extends JDialog {
    private JPanel pnlTritre;
    private JPanel pnlBtns;
    private JPanel pnlCenter;
    private JLabel lblAffichageList;
    private JButton btnRetour;
    private JButton btnQuitter;
    private JPanel pnlLableCltPros;
    private JTable bddList;
    private JLabel lblListeClient;
    private JLabel lblListeProspect;
    private JPanel contentPane;
    private JScrollPane scrlTable;

    public AffichageListe(boolean isClientSelected, boolean isProspectSelected){
        setTitle("Affichage des details");
        setContentPane(contentPane);
        setSize(1000,500);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        lblListeClient.setVisible(isClientSelected);
        lblListeProspect.setVisible(isProspectSelected);
        if (isClientSelected) {
            remplirBddClient();
        }
        else if (isProspectSelected) {
            remplirBddProspect();
        }
    }
    //Jtable qui affiche les details des Clients
    private void remplirBddClient (){
        try {
            ArrayList<Client> clients = ContAffichList.mettreListClient();
            Object[][] tableau = new Object[clients.size()][10];
            for (int i = 0; i< clients.size(); i++){
                Client client = clients.get(i);
                tableau[i][0] = client.getId();
                tableau[i][1] = client.getRaisonSociale();
                tableau[i][2] = client.getNumRue();
                tableau[i][3] = client.getNomRue();
                tableau[i][4] = client.getCdPostal();
                tableau[i][5] = client.getVille();
                tableau[i][6] = client.getTelephone();
                tableau[i][7] = client.getMail();
                tableau[i][8] = client.getChiffreAffaire();
                tableau[i][9] = client.getNbrEmploye();
            }
            String [] columsName ={"ID","Raison Social","N° Rue","Nom Rue","Code Postal","Ville","Téléphone","Email"
                                    ,"Chiffre d'affaire", "Nombre d'emplpyes"};
            DefaultTableModel model = new DefaultTableModel(tableau, columsName);
            bddList.setModel(model);
            scrlTable.setViewportView(bddList);

        } catch (DaoException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Base de données", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    //Jtable qui affiche les details des prospects
    private void remplirBddProspect (){
        try {
            ArrayList<Prospect> prospects = ContAffichList.mettreListProspect();
            Object[][] tableau = new Object[prospects.size()][11];
            for (int i = 0; i< prospects.size(); i++){
                Prospect prospect = prospects.get(i);
                tableau[i][0] = prospect.getId();
                tableau[i][1] = prospect.getRaisonSociale();
                tableau[i][2] = prospect.getNumRue();
                tableau[i][3] = prospect.getNomRue();
                tableau[i][4] = prospect.getCdPostal();
                tableau[i][5] = prospect.getVille();
                tableau[i][6] = prospect.getTelephone();
                tableau[i][7] = prospect.getMail();
                tableau[i][8] = prospect.getDateProspection();
                tableau[i][9] = prospect.getProspectInteresse();
            }
            String [] columsName ={"ID","Raison Social","N° Rue","Nom Rue","Code Postal","Ville","Téléphone","Email"
                    ,"Date prospection", "Prospect interessé"};
            DefaultTableModel model = new DefaultTableModel(tableau, columsName);
            bddList.setModel(model);
            scrlTable.setViewportView(bddList);

        } catch (DaoException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Base de données", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    //Boutton retour
    {
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AffichageListe.this.dispose();
                ContAccueil.initAccueil();
            }
        });
    }
    //Boutton Quitter
    {
        btnQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
