package Vues;

import Controlleur.ContAccueil;
import Controlleur.ContAffichList;
import entites.Client;
import entites.Prospect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class Accueil extends JDialog {
    private JPanel contentPane;
    private JPanel pnlBtns;
    private JPanel pnlTitre;
    private JLabel lblAccueil;
    private JButton btnAfficheList;
    private JButton btnCreat;
    private JButton btn;
    private JButton btnDelete;
    private JButton btnQuit;
    private JPanel pnlClients;
    private JPanel pnlCentre;
    private JPanel pnlComboBox;
    private JPanel pnlProspects;
    private JCheckBox chkBxClients;
    private JLabel lblClients;
    private JLabel lblProspect;
    private JCheckBox chkBxProspect;
    private JComboBox comboBox1;
    private JButton buttonOK;

    public Accueil (){
        setTitle("Accueil");
        setContentPane(contentPane);
        setSize(800,800);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
    //check box Clients
    {
        chkBxClients.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    try {
                        remplirComboBoxClients();
                        chkBxProspect.setSelected(false);
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }else if (!chkBxProspect.isSelected()) {
                    comboBox1.removeAllItems();
                }
            }
        });
    }
    //check box Prospcts
    {
        chkBxProspect.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    try {
                        remplirComboBoxProspects();
                        chkBxClients.setSelected(false);
                    } catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }else if (!chkBxClients.isSelected()) {
                    comboBox1.removeAllItems();
                }
            }
        });
    }
    //Boutton Afficher List
    {
        btnAfficheList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Accueil.this.dispose();
                ContAffichList.initAfficherList();
            }
        });
    }
    //Boutton New
    {
        btnCreat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    //Boutton Modifier
    {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    //Boutton Supprimer
    {
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    //Boutton Quitter
    {
        btnQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    //combobox

        //remplire la comboboxe
    private void remplirComboBoxClients() {
        try {
            ArrayList<Client> clients = ContAccueil.mettreListClient();//appel methode qui récupre les données

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            for (Client client : clients){
                model.addElement(client.getRaisonSociale());
            }
            comboBox1.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    private void remplirComboBoxProspects() {
        try {
            ArrayList<Prospect> prospects = ContAccueil.mettreListProspect();//appel methode qui récupre les données

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            for (Prospect prospect : prospects){
                model.addElement(prospect.getRaisonSociale());
            }
            comboBox1.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }


}
