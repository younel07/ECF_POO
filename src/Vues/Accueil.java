package Vues;

import Controlleur.ContAccueil;
import Controlleur.ContAffichList;
import Controlleur.ContGestion;
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
    private JButton btnAlter;
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
    private static boolean isProspectSelected;
    private static boolean isClientSelected;

    public Accueil() {
        setTitle("Accueil");
        setContentPane(contentPane);
        setSize(800, 800);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }


    //check box Clients
    {
        chkBxClients.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        remplirComboBoxClients();
                        chkBxProspect.setSelected(false);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                } else if (!chkBxProspect.isSelected()) {
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
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        remplirComboBoxProspects();
                        chkBxClients.setSelected(false);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                } else if (!chkBxClients.isSelected()) {
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
                try {
                    if (!chkBxClients.isSelected() && !chkBxProspect.isSelected()) {
                        throw new Exception("Sélectionnez client ou prospect pour afficher leurs détails.");
                    } else {
                        Accueil.this.dispose();
                        isClientSelected = chkBxClients.isSelected();
                        isProspectSelected = chkBxProspect.isSelected();
                        ContAccueil.launchAffichageList(isClientSelected, isProspectSelected);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Afficher liste", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    //Boutton New
    {
        btnCreat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!chkBxClients.isSelected() && !chkBxProspect.isSelected()) {
                        throw new Exception("Sélectionnez client ou prospect pour créer un nouveau.");
                    } else {
                        Accueil.this.dispose();
                        isClientSelected = chkBxClients.isSelected();
                        isProspectSelected = chkBxProspect.isSelected();
                        ContAccueil.lblOperationManager(3);
                        ContAccueil.launchGestion(isClientSelected, isProspectSelected);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Creation entité", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    //Boutton Modifier
    {
        btnAlter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!chkBxClients.isSelected() && !chkBxProspect.isSelected()) {
                        throw new Exception("Sélectionnez client ou prospect pour modifier un nouveau.");
                    } else {
                        Accueil.this.dispose();
                        isClientSelected = chkBxClients.isSelected();
                        isProspectSelected = chkBxProspect.isSelected();
                        ContAccueil.lblOperationManager(2);
                        ContAccueil.launchGestion(isClientSelected, isProspectSelected);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Modification entité", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    //Boutton Supprimer
    {
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!chkBxClients.isSelected() && !chkBxProspect.isSelected()) {
                        throw new Exception("Sélectionnez client ou prospect pour le supprimer.");
                    } else {
                        Accueil.this.dispose();
                        isClientSelected = chkBxClients.isSelected();
                        isProspectSelected = chkBxProspect.isSelected();
                        ContAccueil.lblOperationManager(1);
                        ContAccueil.launchGestion(isClientSelected, isProspectSelected);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Suppression entité", JOptionPane.WARNING_MESSAGE);
                }
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
            for (Client client : clients) {
                model.addElement(client.getRaisonSociale());
            }
            comboBox1.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void remplirComboBoxProspects() {
        try {
            ArrayList<Prospect> prospects = ContAccueil.mettreListProspect();//appel methode qui récupre les données

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            for (Prospect prospect : prospects) {
                model.addElement(prospect.getRaisonSociale());
            }
            comboBox1.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //selectionner par la sourie une entité a modifier ou supprimer
    {
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                //je donne la valeur boolean au check box souhaité
                isClientSelected = chkBxClients.isSelected();
                isProspectSelected = chkBxProspect.isSelected();

                if (isProspectSelected) {
                    String selection = String.valueOf(comboBox1.getSelectedItem());
                    try {
                        ContAccueil.findByNameProspect(selection);
                        JOptionPane.showMessageDialog(null, "Vous avez choisi le prospect:\n "
                                + selection);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                } else if (isClientSelected) {
                    String selection2 = String.valueOf(comboBox1.getSelectedItem());
                    try {
                        ContAccueil.findByNameClient(selection2);
                        JOptionPane.showMessageDialog(null, "Vous avez choisi le client:\n "
                                + selection2);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });
    }




}
