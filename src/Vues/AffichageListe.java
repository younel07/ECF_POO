package Vues;

import javax.swing.*;

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

    public AffichageListe(){
        setTitle("Affichage des details");
        setContentPane(contentPane);
        setSize(800,800);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
