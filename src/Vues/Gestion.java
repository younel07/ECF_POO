package Vues;

import Controlleur.ContAccueil;
import Controlleur.ContGestion;
import Dao.DaoException;
import entites.EntitiesException;
import outils.EnumProspectInteresse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Gestion  extends JDialog {
    private JPanel pnlTitre;
    private JPanel pnlBtns;
    private JPanel pnlLableOperations;
    private JPanel pnlMainDataEntry;
    private JPanel pnlLablesEntites;
    private JLabel lblGestioinClient;
    private JLabel lblGestionProspect;
    private JButton btnRetour;
    private JButton btnValider;
    private JButton btnQuitter;
    private JPanel pnlContent;
    private JLabel lblClient;
    private JLabel lblCreat;
    private JLabel lblAlter;
    private JLabel lblDelete;
    private JLabel lblProspect;
    private JLabel lblId;
    private JLabel lblRS;
    private JLabel lblNumRue;
    private JLabel lblNomRue;
    private JLabel lblCdPostale;
    private JLabel lblVille;
    private JLabel lblTele;
    private JLabel lblMail;
    private JLabel lblCommentaire;
    private JTextField txtId;
    private JTextField txtRS;
    private JTextField txtNumRue;
    private JTextField txtNomRue;
    private JTextField txtCdPostale;
    private JTextField txtVille;
    private JTextField txtTelephone;
    private JTextField txtMail;
    private JTextField txtCA;
    private JTextField txtNbrEmploye;
    private JTextField txtCommentaire;
    private JPanel pnlCAorDtPros;
    private JLabel lblCA;
    private JLabel lblDtPros;
    private JPanel pnlNbrEmOrPros;
    private JLabel lblNbrEmployes;
    private JLabel lblProspectInteresse;
    private JLabel lblChampOblig;

    public Gestion(boolean isClientSelected, boolean isProspectSelected) {
        setTitle("Gestion des entités");
        setContentPane(pnlContent);
        setSize(1000, 800);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //-------Visibilite des labels et champs de text----------
        {
            //Visibilite des labels concernant le Client
            lblGestioinClient.setVisible(isClientSelected);
            lblClient.setVisible(isClientSelected);
            lblCA.setVisible(isClientSelected);
            lblNbrEmployes.setVisible(isClientSelected);

            //Visibilite des labels concernant le Prospect
            lblGestionProspect.setVisible(isProspectSelected);
            lblProspect.setVisible(isProspectSelected);
            lblDtPros.setVisible(isProspectSelected);
            lblProspectInteresse.setVisible(isProspectSelected);

            //Visiblilite des labels conceranant la creation modification ou suppression
            if (ContGestion.lblOperationManager() == 3) {
                lblCreat.setVisible(true);
                lblAlter.setVisible(false);
                lblDelete.setVisible(false);
            }
            else if (ContGestion.lblOperationManager() == 2) {
                lblCreat.setVisible(false);
                lblAlter.setVisible(true);
                lblDelete.setVisible(false);
            }
            else if (ContGestion.lblOperationManager() == 1) {
                lblCreat.setVisible(false);
                lblAlter.setVisible(false);
                lblDelete.setVisible(true);
            }

            //id non editable pour creation
            if (isClientSelected || isProspectSelected && ContGestion.lblOperationManager() == 3) {
                txtId.setEnabled(false);
            }

            //remplissage des champs pour la modification
            if (isClientSelected && ContGestion.lblOperationManager() == 2) {
                txtId.setText(String.valueOf(ContGestion.recupClient().getId()));
                txtId.setEnabled(false);
                txtRS.setText(ContGestion.recupClient().getRaisonSociale());
                txtNumRue.setText(ContGestion.recupClient().getNumRue());
                txtNomRue.setText(ContGestion.recupClient().getNomRue());
                txtCdPostale.setText(ContGestion.recupClient().getCdPostal());
                txtVille.setText(ContGestion.recupClient().getVille());
                txtTelephone.setText(ContGestion.recupClient().getTelephone());
                txtMail.setText(ContGestion.recupClient().getMail());
                txtCA.setText(String.valueOf(ContGestion.recupClient().getChiffreAffaire()));
                txtNbrEmploye.setText(String.valueOf(ContGestion.recupClient().getNbrEmploye()));
                txtCommentaire.setText(ContGestion.recupClient().getCommentaire());
            }
            if (isProspectSelected && ContGestion.lblOperationManager() == 2) {
                txtId.setText(String.valueOf(ContGestion.recupProspect().getId()));
                txtId.setEnabled(false);
                txtRS.setText(ContGestion.recupProspect().getRaisonSociale());
                txtNumRue.setText(ContGestion.recupProspect().getNumRue());
                txtNomRue.setText(ContGestion.recupProspect().getNomRue());
                txtCdPostale.setText(ContGestion.recupProspect().getCdPostal());
                txtVille.setText(ContGestion.recupProspect().getVille());
                txtTelephone.setText(ContGestion.recupProspect().getTelephone());
                txtMail.setText(ContGestion.recupProspect().getMail());
                txtCA.setText(ContGestion.afficherDate(ContGestion.recupProspect().getDateProspection()));
                txtNbrEmploye.setText(String.valueOf(ContGestion.recupProspect().getProspectInteresse()));
                txtCommentaire.setText(ContGestion.recupProspect().getCommentaire());
            }

            //remplissage des champs pour la suppression a condition qu'ils soient non editable
            if (isClientSelected && ContGestion.lblOperationManager() == 1) {
                txtId.setText(String.valueOf(ContGestion.recupClient().getId()));
                txtId.setEnabled(false);
                txtRS.setText(ContGestion.recupClient().getRaisonSociale());
                txtRS.setEnabled(false);
                txtNumRue.setText(ContGestion.recupClient().getNumRue());
                txtNumRue.setEnabled(false);
                txtNomRue.setText(ContGestion.recupClient().getNomRue());
                txtNomRue.setEnabled(false);
                txtCdPostale.setText(ContGestion.recupClient().getCdPostal());
                txtCdPostale.setEnabled(false);
                txtVille.setText(ContGestion.recupClient().getVille());
                txtVille.setEnabled(false);
                txtTelephone.setText(ContGestion.recupClient().getTelephone());
                txtTelephone.setEnabled(false);
                txtMail.setText(ContGestion.recupClient().getMail());
                txtMail.setEnabled(false);
                txtCA.setText(String.valueOf(ContGestion.recupClient().getChiffreAffaire()));
                txtCA.setEnabled(false);
                txtNbrEmploye.setText(String.valueOf(ContGestion.recupClient().getNbrEmploye()));
                txtNbrEmploye.setEnabled(false);
                txtCommentaire.setText(ContGestion.recupClient().getCommentaire());
                txtCommentaire.setEnabled(false);
            }
            if (isProspectSelected && ContGestion.lblOperationManager() == 1) {
                txtId.setText(String.valueOf(ContGestion.recupProspect().getId()));
                txtId.setEnabled(false);
                txtRS.setText(ContGestion.recupProspect().getRaisonSociale());
                txtRS.setEnabled(false);
                txtNumRue.setText(ContGestion.recupProspect().getNumRue());
                txtNumRue.setEnabled(false);
                txtNomRue.setText(ContGestion.recupProspect().getNomRue());
                txtNomRue.setEnabled(false);
                txtCdPostale.setText(ContGestion.recupProspect().getCdPostal());
                txtCdPostale.setEnabled(false);
                txtVille.setText(ContGestion.recupProspect().getVille());
                txtVille.setEnabled(false);
                txtTelephone.setText(ContGestion.recupProspect().getTelephone());
                txtTelephone.setEnabled(false);
                txtMail.setText(ContGestion.recupProspect().getMail());
                txtMail.setEnabled(false);
                txtCA.setText(ContGestion.afficherDate(ContGestion.recupProspect().getDateProspection()));
                txtCA.setEnabled(false);
                txtNbrEmploye.setText(String.valueOf(ContGestion.recupProspect().getProspectInteresse()));
                txtNbrEmploye.setEnabled(false);
                txtCommentaire.setText(ContGestion.recupProspect().getCommentaire());
                txtCommentaire.setEnabled(false);
            }
        }


        //Boutton Valider
        {
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            //---------------- Validation de la création ---------------------
            //creation de client
            if (isClientSelected && ContGestion.lblOperationManager()==3){
                try
                {
                    if (
                            txtCA.getText().isEmpty() ||
                            txtNumRue.getText().isEmpty() ||
                            txtNomRue.getText().isEmpty() ||
                            txtCdPostale.getText().isEmpty() ||
                            txtVille.getText().isEmpty() ||
                            txtTelephone.getText().isEmpty() ||
                            txtMail.getText().isEmpty() ||
                            txtCA.getText().isEmpty() ||
                            txtNbrEmploye.getText().isEmpty()
                    )
                    {JOptionPane.showMessageDialog(null, "Champs avec * sont obligatoirs");}
                    else {
                        int confirmation = JOptionPane.showConfirmDialog(null,
                                "Confirmer la création du client", "Confirmation",
                                JOptionPane.OK_CANCEL_OPTION);
                        if (confirmation == JOptionPane.OK_OPTION) {
                            String raisonSocial = txtRS.getText();
                            String numRue = txtNumRue.getText();
                            String nomRue = txtNomRue.getText();
                            String cdPostal = txtCdPostale.getText();
                            String ville = txtVille.getText();
                            String telephone = txtTelephone.getText();
                            String mail = txtMail.getText();
                            double chiffreAffaire = Double.parseDouble(txtCA.getText());
                            int nbrEmployes = Integer.parseInt(txtNbrEmploye.getText());
                            String commentaire = txtCommentaire.getText();

                            ContGestion.inseretClient(raisonSocial, numRue, nomRue, cdPostal, ville, telephone, mail,
                                    chiffreAffaire, nbrEmployes, commentaire);
                            JOptionPane.showMessageDialog(null, "Client créer avec succé",
                                    "Confirmation de la création", JOptionPane.INFORMATION_MESSAGE);
                            ContGestion.launchAccueil();
                            Gestion.this.dispose();
                        }
                    }
                } catch (SQLException | IOException | DaoException | EntitiesException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }

            //Creation de Prospect
            if (isProspectSelected && ContGestion.lblOperationManager()==3){
                try
                {
                    if (
                            txtCA.getText().isEmpty() ||
                            txtNumRue.getText().isEmpty() ||
                            txtNomRue.getText().isEmpty() ||
                            txtCdPostale.getText().isEmpty() ||
                            txtVille.getText().isEmpty() ||
                            txtTelephone.getText().isEmpty() ||
                            txtMail.getText().isEmpty() ||
                            txtCA.getText().isEmpty() ||
                            txtNbrEmploye.getText().isEmpty()
                    )
                    {JOptionPane.showMessageDialog(null, "Champs avec * sont obligatoirs");}
                    else {
                        int confirmation = JOptionPane.showConfirmDialog(null,
                                "Confirmer la création du prospet", "Confirmation",
                                JOptionPane.OK_CANCEL_OPTION);
                        if (confirmation == JOptionPane.OK_OPTION) {
                            String raisonSocial = txtRS.getText();
                            String numRue = txtNumRue.getText();
                            String nomRue = txtNomRue.getText();
                            String cdPostal = txtCdPostale.getText();
                            String ville = txtVille.getText();
                            String telephone = txtTelephone.getText();
                            String mail = txtMail.getText();
                            LocalDate dateProspection = ContGestion.convertirDate(txtCA.getText());
                            EnumProspectInteresse prostIntere = EnumProspectInteresse.valueOf(txtNbrEmploye.getText());
                            String commentaire = txtCommentaire.getText();

                            ContGestion.insertProspect(raisonSocial, numRue, nomRue, cdPostal, ville, telephone, mail,
                                    dateProspection, prostIntere, commentaire);
                            JOptionPane.showMessageDialog(null, "Prospet créer avec succé",
                                    "Confirmation de la création", JOptionPane.INFORMATION_MESSAGE);
                            ContGestion.launchAccueil();
                            Gestion.this.dispose();
                        }
                    }
                } catch (SQLException | IOException | DaoException | EntitiesException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }catch (DateTimeParseException dte){
                    JOptionPane.showMessageDialog(null, "Date n'est pas en bon format");
                }
            }

            //----------------- Validation de la modification -----------------
            //Modification de Client
            if (isClientSelected && ContGestion.lblOperationManager()==2){
                try
                {
                    if (
                            txtCA.getText().isEmpty() ||
                            txtNumRue.getText().isEmpty() ||
                            txtNomRue.getText().isEmpty() ||
                            txtCdPostale.getText().isEmpty() ||
                            txtVille.getText().isEmpty() ||
                            txtTelephone.getText().isEmpty() ||
                            txtMail.getText().isEmpty() ||
                            txtCA.getText().isEmpty() ||
                            txtNbrEmploye.getText().isEmpty()
                    )
                    {JOptionPane.showMessageDialog(null, "Champs avec * sont obligatoirs");}
                    else {
                        int confirmation = JOptionPane.showConfirmDialog(null,
                                "Confirmer la modification du client", "Confirmation",
                                JOptionPane.OK_CANCEL_OPTION);
                        if (confirmation == JOptionPane.OK_OPTION) {
                            int idClient = Integer.parseInt(txtId.getText());
                            String raisonSocial = txtRS.getText();
                            String numRue = txtNumRue.getText();
                            String nomRue = txtNomRue.getText();
                            String cdPostal = txtCdPostale.getText();
                            String ville = txtVille.getText();
                            String telephone = txtTelephone.getText();
                            String mail = txtMail.getText();
                            double chiffreAffaire = Double.parseDouble(txtCA.getText());
                            int nbrEmployes = Integer.parseInt(txtNbrEmploye.getText());
                            String commentaire = txtCommentaire.getText();

                            ContGestion.modifierClient(raisonSocial, numRue, nomRue, cdPostal, ville, telephone, mail,
                                    chiffreAffaire, nbrEmployes, commentaire, idClient);
                            JOptionPane.showMessageDialog(null, "Client modifier avec succé",
                                    "Confirmation de la modification", JOptionPane.INFORMATION_MESSAGE);
                            ContGestion.launchAccueil();
                            Gestion.this.dispose();
                        }
                    }
                } catch (SQLException | IOException | DaoException | EntitiesException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }

            //Modification de Prospect
            if (isProspectSelected && ContGestion.lblOperationManager()==3){
                    try
                    {
                        if (
                                txtCA.getText().isEmpty() ||
                                txtNumRue.getText().isEmpty() ||
                                txtNomRue.getText().isEmpty() ||
                                txtCdPostale.getText().isEmpty() ||
                                txtVille.getText().isEmpty() ||
                                txtTelephone.getText().isEmpty() ||
                                txtMail.getText().isEmpty() ||
                                txtCA.getText().isEmpty() ||
                                txtNbrEmploye.getText().isEmpty()
                        )
                        {JOptionPane.showMessageDialog(null, "Champs avec * sont obligatoirs");}
                        else {
                            int confirmation = JOptionPane.showConfirmDialog(null,
                                    "Confirmer la modification du prospet", "Confirmation",
                                    JOptionPane.OK_CANCEL_OPTION);
                            if (confirmation == JOptionPane.OK_OPTION) {
                                int idProspect = Integer.parseInt(txtId.getText());
                                String raisonSocial = txtRS.getText();
                                String numRue = txtNumRue.getText();
                                String nomRue = txtNomRue.getText();
                                String cdPostal = txtCdPostale.getText();
                                String ville = txtVille.getText();
                                String telephone = txtTelephone.getText();
                                String mail = txtMail.getText();
                                LocalDate dateProspection = ContGestion.convertirDate(txtCA.getText());
                                EnumProspectInteresse prostIntere = EnumProspectInteresse.valueOf(txtNbrEmploye.getText());
                                String commentaire = txtCommentaire.getText();

                                ContGestion.modifierProspect(raisonSocial, numRue, nomRue, cdPostal, ville, telephone, mail,
                                        dateProspection, prostIntere, commentaire,idProspect);
                                JOptionPane.showMessageDialog(null, "Prospet modifier avec succé",
                                        "Confirmation de la modification", JOptionPane.INFORMATION_MESSAGE);
                                ContGestion.launchAccueil();
                                Gestion.this.dispose();
                            }
                        }
                    } catch (SQLException | IOException | DaoException | EntitiesException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }catch (DateTimeParseException dte){
                        JOptionPane.showMessageDialog(null, "Date n'est pas en bon format");
                    }
                }

            //----------------- Validation de la suppression -----------------
            //Suppression d'un Client
            if(isClientSelected && ContGestion.lblOperationManager()==1){
                try {
                    int idClient = Integer.parseInt(txtId.getText());
                    String raisonSocial = txtRS.getText();
                    int confirmation = JOptionPane.showConfirmDialog(null,
                            "Voulez vous vraiment supprimer le client\n"+raisonSocial, "Confirmation",
                            JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
                    if (confirmation == JOptionPane.OK_OPTION){
                        ContGestion.supprimerClient(idClient);
                        JOptionPane.showMessageDialog(null, "Client supprimer avec succé",
                                "Confirmation de la modification", JOptionPane.INFORMATION_MESSAGE);
                        ContGestion.launchAccueil();
                        Gestion.this.dispose();
                    }
                } catch (SQLException | IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (DaoException ex) {
                    throw new RuntimeException(ex);// gere la
                }
            }
            //Supression d'un Prospect
            if(isProspectSelected && ContGestion.lblOperationManager()==1){
                    try {
                        int idProspect = Integer.parseInt(txtId.getText());
                        String raisonSocial = txtRS.getText();
                        int confirmation = JOptionPane.showConfirmDialog(null,
                                "Voulez vous vraiment supprimer le prospet\n"+raisonSocial, "Confirmation",
                                JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
                        if (confirmation == JOptionPane.OK_OPTION){
                            ContGestion.supprimerProspect(idProspect);
                            JOptionPane.showMessageDialog(null, "Prospet supprimer avec succé",
                                    "Confirmation de la modification", JOptionPane.INFORMATION_MESSAGE);
                            ContGestion.launchAccueil();
                            Gestion.this.dispose();
                        }
                    } catch (SQLException | IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    } catch (DaoException ex) {
                        throw new RuntimeException(ex);//gere la--------------------
                    }
            }
            }
        });
        }
    }


        //Boutton Retour
        {
            btnRetour.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Gestion.this.dispose();
                    ContAccueil.initAccueil();
                }
            });
        }
        //Boutton quitter
        {
            btnQuitter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
        }
    }
