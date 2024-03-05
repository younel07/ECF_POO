package Dao;

import entites.Client;
import entites.EntitiesException;
import outils.ListClients;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Class DaoClient permet a ...
 * @author Younes
 * @version 1.0
 */
public class DaoClient {
    //Methode pour recuperer la liste complete des clients avec tous les champs
    public static ArrayList<Client> findAllClient() throws SQLException, EntitiesException, IOException {
        Statement statement = null;
        String sql = "SELECT * FROM CLIENT";
        ArrayList<Client> clients = new ArrayList<>();

        Connection con = Connexion.getConnection();
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()){
            int idClient = rs.getInt("IDCLIENT");
            String raisonSocial = rs.getString("RAISONSOCIAL");
            String numRue = rs.getString("NUMRUE");
            String nomRue = rs.getString("NOMRUE");
            String cdPostal = rs.getString("CDPOSTAL");
            String ville = rs.getString("ville");
            String telephone = rs.getString("TELEPHONE");
            String mail = rs.getString("MAIL");
            String commentaire = rs.getString("COMMENTAIRES");
            double chiffreAffaire = rs.getDouble("CHIFFREAFFAIRES");
            int nbrEmployes = rs.getInt("NBREMPLOYES");

                Client client = new Client(idClient,raisonSocial,numRue,nomRue,cdPostal,ville,
                        telephone,mail,commentaire,chiffreAffaire,nbrEmployes);
                clients.add(client);
            }

        } catch (EntitiesException e){
            throw new EntitiesException ("Erreur pour voir la base de donnée");
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    return clients;
    }

    //Methode pour recuperer 1 client selon la raison social avec tous les champs du client
    public static ArrayList<Client> findByNameClient(String filterRaisonSocial) throws SQLException, IOException {
        PreparedStatement findByNameClient = null;
        String sql = "SELECT * FROM client WHERE RAISONSOCIAL = ?";
        ArrayList<Client> clients = new ArrayList<>();

        Connection con = Connexion.getConnection();
        try {
            findByNameClient = con.prepareStatement(sql);
            findByNameClient.setString(1, filterRaisonSocial);
            ResultSet rs = findByNameClient.executeQuery();

            while (rs.next()) {
                int idClient = rs.getInt("IDCLIENT");
                String raisonSocial = rs.getString("RAISONSOCIAL");
                String numRue = rs.getString("NUMRUE");
                String nomRue = rs.getString("NOMRUE");
                String cdPostal = rs.getString("CDPOSTAL");
                String ville = rs.getString("ville");
                String telephone = rs.getString("TELEPHONE");
                String mail = rs.getString("MAIL");
                String commentaire = rs.getString("COMMENTAIRES");
                double chiffreAffaire = rs.getDouble("CHIFFREAFFAIRES");
                int nbrEmployes = rs.getInt("NBREMPLOYES");

                Client client = new Client(idClient,raisonSocial,numRue,nomRue,cdPostal,ville,
                        telephone,mail,commentaire,chiffreAffaire,nbrEmployes);
                clients.add(client);
            }

        }catch (SQLException |EntitiesException e){
            throw new SQLException("Erreur pour voir la base de donnée");
        } finally {
            if (findByNameClient !=null){findByNameClient.close();}
        }
    return clients;
    }

    //Methode pour create un client
    public static void creatClient (Client client)throws SQLException, IOException{
        PreparedStatement creatClient = null;
        String sql = "INSERT INTO client (`RAISONSOCIAL`, `NUMRUE`, `NOMRUE`, `CDPOSTAL`, `VILLE`, \n" +
                "`TELEPHONE`, `MAIL`, `COMMENTAIRES`, `CHIFFREAFFAIRES`, `NBREMPLOYES`) \n" +
                "VALUES (?,?,?,?,?,?,?,?,?,?);";
        Connection con = Connexion.getConnection();

        try {
            con.setAutoCommit(false);// debut de transaction (false to enable the rollback and commit)
            creatClient =con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            creatClient.setString(1, client.getRaisonSociale());
            creatClient.setString(2, client.getNumRue());
            creatClient.setString(3, client.getNomRue());
            creatClient.setString(4, client.getCdPostal());
            creatClient.setString(5, client.getVille());
            creatClient.setString(6, client.getTelephone());
            creatClient.setString(7, client.getMail());
            creatClient.setString(8, client.getCommentaire());
            creatClient.setDouble(9, client.getChiffreAffaire());
            creatClient.setInt(10, client.getNbrEmploye());

            creatClient.executeUpdate();

            ResultSet rs = creatClient.getGeneratedKeys();
            //section to have the id generated
            if (rs.next()){
                int generatedKey = rs.getInt(1);
                System.out.println("Generated ID is: "+generatedKey);
            } else{
                System.out.println("No ID were generated");
            }
            con.commit();
            //rollback transaction on error
        }catch (SQLException ex){
            if (con !=null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    con.rollback();
                }catch (SQLException excep)
                {
                    throw new SQLException (excep.getMessage());
                }
            }
            throw new SQLException ("Insert problem: "+ex.getMessage());
            }finally {
            if (creatClient !=null){creatClient.close();}
            //This ensures that we don't try to call setAutoCommit(true) on a null object.
            con.setAutoCommit(true);
        }
    }

    //Methode pour update un client
    public static void updateClient (Client client) throws SQLException, IOException{
        PreparedStatement updateClient = null;
        String sql = "UPDATE client SET RAISONSOCIAL=?, NUMRUE=?, NOMRUE=?, CDPOSTAL=?, VILLE=?, " +
                "TELEPHONE=?, MAIL=?, COMMENTAIRES=?, CHIFFREAFFAIRES=?, NBREMPLOYES=? WHERE IDCLIENT=?";
        Connection con = Connexion.getConnection();

        try {
            con.setAutoCommit(false);// Begin transaction (false to enable the rollback and commit)
            updateClient = con.prepareStatement(sql);

            updateClient.setString(1, client.getRaisonSociale());
            updateClient.setString(2, client.getNumRue());
            updateClient.setString(3, client.getNomRue());
            updateClient.setString(4, client.getCdPostal());
            updateClient.setString(5, client.getVille());
            updateClient.setString(6, client.getTelephone());
            updateClient.setString(7, client.getMail());
            updateClient.setString(8, client.getCommentaire());
            updateClient.setDouble(9, client.getChiffreAffaire());
            updateClient.setInt(10, client.getNbrEmploye());
            updateClient.setInt(11, client.getId());

            int rowsAffected = updateClient.executeUpdate();

            if (rowsAffected > 0){
                System.out.println("Client met a jour.");
            }else {
                System.out.println("Aucun client n'est mis a jour.");
            }

            con.commit();
        }catch (SQLException ex){
            if (con != null){
                try {
                    System.err.print("Rollback transaction");
                    con.rollback();
                }catch (SQLException excep){
                    throw new SQLException(excep.getMessage());
                }
            }
            throw new SQLException("Problem de mise a jour du client: "+ex.getMessage());
        }finally {
            if (updateClient != null){
                updateClient.close();
            }
            if (con != null){
                con.setAutoCommit(true);
            }
        }
    }

    //Methode pour delete un client
    public static void deletClient (int idClient) throws SQLException, IOException{
        PreparedStatement deletClient = null;
        String sql = "DELETE FROM client WHERE IDCLIENT = ?";
        Connection con = Connexion.getConnection();

        try{
            con.setAutoCommit(false);
            deletClient =  con.prepareStatement(sql);

            deletClient.setInt(1, idClient);

            int rowsAffected = deletClient.executeUpdate();

            if (rowsAffected > 0){
                System.out.println("Client supprimé avec sucssé.");
            }else {
                System.out.println("Aucune suppression");
            }
            con.commit();
        }catch (SQLException ex){
            if (con != null){
                try {
                    System.err.print("Rollback transaction");
                    con.rollback();
                }catch (SQLException excp){
                    throw new SQLException(excp.getMessage());
                }
            }
            throw new SQLException("Problem de suppression: "+ex.getMessage());
        }finally {
            if (deletClient !=null){
                deletClient.close();
            }
            if (con != null){
                con.setAutoCommit(true);
            }
        }
    }
}