import Dao.DaoClient;
import Dao.DaoException;
import Dao.DaoProspect;
import entites.Client;
import entites.EntitiesException;
import entites.Prospect;
import logs.MyLogger;
import outils.DateFormatter;
import outils.EnumProspectInteresse;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = MyLogger.LOGGER; // Logger instance
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

        //test class metier client
        /*try {
            Client younes = new Client(5, "uni", "5", "mdj", "54000", "V", "5555555555",
                    "fd@gmail.com", "ok", 250.15, 15);
            LOGGER.log(Level.INFO, "Client created: {0}", younes);

        } catch (EntitiesException e) {
            LOGGER.log(Level.SEVERE, "Error occurred: {0}", e.getMessage());// template for logger to put it in vues
        }*/


        //test findAllClient
        /*try{
            DaoClient.findAllClient();
        }catch (SQLException | IOException e){
            throw new DaoException("DAO Problem :"+e.getMessage());
        }*/

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
            throw new DaoException("DAO Problem :" + e.getMessage());
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


