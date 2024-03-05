import Dao.DaoClient;
import Dao.DaoException;
import Dao.DaoProspect;
import entites.Client;
import entites.EntitiesException;
import entites.Prospect;
import logs.FormatterLog;
import logs.MyLogger;
import outils.DateFormatter;
import outils.EnumProspectInteresse;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = MyLogger.LOGGER;// Logger instance
    private static FileHandler fh = null;
    public static void main(String[] args) throws EntitiesException, DaoException, SQLException, IOException {
        //test class metier prospect + date pour la vue
        /*  String date = "25/12/2024";//rentrez votre date "formulaire"
        if (DateFormatter.dateValid(date))
        {
            LocalDate p_prospectionDate = LocalDate.parse(date, DateFormatter.getDateFormatter());
            Prospect younes = new Prospect(5, "uni", "5", "mdj", "54000", "V", "5555555555",
                    "fd@gmail.com", "ok", p_prospectionDate, EnumProspectInteresse.OUI);
            System.out.println(younes);
        }*/

        //test class metier client avec les log
        /*try {
            Client younes = new Client(5, "uni2", "5", "mdj",
                    "54000", "V", "5555555555",
                    "fd@gmail.com", "ok", 250.15, 15);
            DaoClient.creatClient(younes);
            fh = new FileHandler("logReverso.log", true);
            LOGGER.setUseParentHandlers(false);
            fh.setFormatter(new FormatterLog());
            LOGGER.log(Level.INFO, "Debut main");

        } catch (IOException | SecurityException fe) {
            System.out.println("message d'erreur fichier  "+ fe.getMessage() + " " + fe);
            LOGGER.log(Level.SEVERE, "Erreur fichier: ", fe.getMessage()+" "+fe);
        }
        catch (EntitiesException e) {
            System.out.println("message de l'exception  "+ e.getMessage() + " " + e);
            LOGGER.log(Level.SEVERE, "message de la classe Exception  "+ e.getMessage() + " " + e);
        }*/


        //test findAllClient
        /*try{
            DaoClient.findAllClient();
        }catch (SQLException | IOException e){
            throw new DaoException(e.getMessage());
        }
        JOptionPane.showMessageDialog(null,DaoClient.findAllClient().toArray());*/

        //test findAllProspects
        /*try{
            DaoProspect.findAllProspects();
        }catch (SQLException | IOException e){
            throw new DaoException("DAO Problem :"+e.getMessage());
        }*/

        //test findByNameClient
        /*try {
            DaoClient.findByNameClient("uni");
        } catch (SQLException | IOException e) {
            throw new DaoException(e.getMessage());
        }*/

        //test findByNameProspect
         /*try {
            DaoProspect.findByNameProspect("uni");
        } catch (SQLException | IOException e) {
            throw new DaoException("DAO Problem :" + e.getMessage());
        }*/

        //test createClient
        /*try {
            Client jack = new Client(20,"javaaa","5bis","toto",
                    "54500","rabat","0123456789",
                    "test1@lv.com","ok",321.50,50);
            DaoClient.creatClient(jack);
        }catch (SQLException | IOException e) {
            throw new DaoException("DaoClient probleme:  "+e.getMessage());
        } catch (EntitiesException e) {
            throw new RuntimeException(e);
        }*/

        //test creatProspect
         /*try {
             String date = "07/07/1995";//rentrez votre date "formulaire"
             if (DateFormatter.dateValid(date)) {
                 LocalDate p_prospectionDate = LocalDate.parse(date, DateFormatter.getDateFormatter());
                 Prospect younes = new Prospect(1, "AFPA", "5", "AIN",
                         "21000", "CASA", "0123456789",
                         "TEST1@gmail.com", "ok", p_prospectionDate, EnumProspectInteresse.OUI);
                 DaoProspect.creatProspect(younes);
             }
         }catch (SQLException | IOException e) {
            throw new DaoException("DaoProspec probleme:  "+e.getMessage());
        } catch (EntitiesException e) {
            throw new RuntimeException(e);
        }*/

        //test updateClient
        /*try {
            Client jack = new Client(5,"javaloo","5bis","toto",
                    "54500","rabat","0123456789",
                    "test1@lv.com","ok",321.50,50);

            //si tu modifi quelque chose dans l'instensiation sa semodifi dans la BDD
            DaoClient.updateClient(jack);
        }catch (SQLException | IOException e) {
            throw new DaoException("DaoClient probleme:  "+e.getMessage());
        } catch (EntitiesException e) {
            throw new RuntimeException(e);
        }*/

        //test updateProspect
        /*try {
            String date = "07/07/1995";//rentrez votre date "formulaire"
            if (DateFormatter.dateValid(date)) {
                LocalDate p_prospectionDate = LocalDate.parse(date, DateFormatter.getDateFormatter());
                //attention raison social doit etre unique
                Prospect younes = new Prospect(1, "AFPA", "5", "AIN",
                        "21000", "CASA", "0123456789",
                        "TEST1@gmail.com", "ok", p_prospectionDate, EnumProspectInteresse.OUI);
                DaoProspect.updateProspect(younes);
            }
        }catch (SQLException | IOException e) {
            throw new DaoException("DaoProspec probleme:  "+e.getMessage());
        } catch (EntitiesException e) {
            throw new RuntimeException(e);
        }*/

        //test deleteClient
        /*try {
            DaoClient.deletClient(5);//change l'id si tu veut choisir quel client a supprimer
        }catch (SQLException | IOException e) {
            throw new DaoException("DaoClient probleme:  "+e.getMessage());
        }*/

        //test deleteProspect
        /*try {
            DaoProspect.deletProspect(2);//change l'id si tu veut choisir quel client a supprimer
        }catch (SQLException | IOException e) {
            throw new DaoException("DaoClient probleme:  "+e.getMessage());
        }*/
    }
}


