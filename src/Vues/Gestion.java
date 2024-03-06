package Vues;

import Controlleur.ContAccueil;
import Controlleur.ContGestion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        if (ContGestion.lblOperationManager() == 3) {
            lblCreat.setVisible(true);
            lblAlter.setVisible(false);
            lblDelete.setVisible(false);
        } else if (ContGestion.lblOperationManager() == 2) {
            lblCreat.setVisible(false);
            lblAlter.setVisible(true);
            lblDelete.setVisible(false);
        } else if (ContGestion.lblOperationManager() == 1) {
            lblCreat.setVisible(false);
            lblAlter.setVisible(false);
            lblDelete.setVisible(true);
        }

        if (isClientSelected) {
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
        if (isProspectSelected) {
            txtId.setText(String.valueOf(ContGestion.recupProspect().getId()));
            txtId.setEnabled(false);
            txtRS.setText(ContGestion.recupProspect().getRaisonSociale());
            txtNumRue.setText(ContGestion.recupProspect().getNumRue());
            txtNomRue.setText(ContGestion.recupProspect().getNomRue());
            txtCdPostale.setText(ContGestion.recupProspect().getCdPostal());
            txtVille.setText(ContGestion.recupProspect().getVille());
            txtTelephone.setText(ContGestion.recupProspect().getTelephone());
            txtMail.setText(ContGestion.recupProspect().getMail());
            txtCA.setText(String.valueOf(ContGestion.recupProspect().getDateProspection()));
            txtNbrEmploye.setText(String.valueOf(ContGestion.recupProspect().getProspectInteresse()));
        }
    }
        //Boutton Valider


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
