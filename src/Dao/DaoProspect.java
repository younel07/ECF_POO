package Dao;

import entites.EntitiesException;
import entites.Prospect;
import outils.EnumProspectInteresse;
import outils.ListProspects;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class DaoProspect {
    //Methode pour recuperer la liste complete des Prospects avec tous les champs
    public static ArrayList<Prospect> findAllProspects() throws SQLException, IOException {
        Statement statement = null;
        String sql = "SELECT * FROM PROSPECT";
        ArrayList<Prospect> prospects = new ArrayList<>();

        Connection con = Connexion.getConnection();
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int idProspect = rs.getInt("IDPROSPECT");
                String raisonSocial = rs.getString("RAISONSOCIAL");
                String numRue = rs.getString("NUMRUE");
                String nomRue = rs.getString("NOMRUE");
                String cdPostal = rs.getString("CDPOSTAL");
                String ville = rs.getString("ville");
                String telephone = rs.getString("TELEPHONE");
                String mail = rs.getString("MAIL");
                String commentaire = rs.getString("COMMENTAIRES");

                Date date = rs.getDate("DATEPROSPECTION");
                LocalDate dateProspection = date.toLocalDate();

                String prospectOuiNon = rs.getString("PROSPECTINTERESSE");
                EnumProspectInteresse prospectInteresse = EnumProspectInteresse.valueOf(prospectOuiNon);

                Prospect prospect = new Prospect(idProspect, raisonSocial, numRue, nomRue, cdPostal, ville,
                        telephone, mail, commentaire, dateProspection, prospectInteresse);
                prospects.add(prospect);
            }
        } catch (SQLException | EntitiesException e) {
            throw new SQLException("Erreur pour voir la base de donnée");
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return prospects;
    }

    //Methode pour recuperer 1 Prospect selon la raison social avec tous les champs du prospect
    public static Prospect findByNameProspect(String filtreRaisonSocial) throws SQLException, IOException, DaoException {
        PreparedStatement findByNameProspect = null;
        String sql = "SELECT * FROM prospect WHERE RAISONSOCIAL = ?";

        Connection con = Connexion.getConnection();
        try {
            findByNameProspect = con.prepareStatement(sql);
            findByNameProspect.setString(1, filtreRaisonSocial);
            ResultSet rs = findByNameProspect.executeQuery();

            if (rs.next()) {
                int idProspect = rs.getInt("IDPROSPECT");
                String raisonSocial = rs.getString("RAISONSOCIAL");
                String numRue = rs.getString("NUMRUE");
                String nomRue = rs.getString("NOMRUE");
                String cdPostal = rs.getString("CDPOSTAL");
                String ville = rs.getString("ville");
                String telephone = rs.getString("TELEPHONE");
                String mail = rs.getString("MAIL");
                String commentaire = rs.getString("COMMENTAIRES");

                Date date = rs.getDate("DATEPROSPECTION");
                LocalDate dateProspection = date.toLocalDate();

                String prospectOuiNon = rs.getString("PROSPECTINTERESSE");
                EnumProspectInteresse prospectInteresse = EnumProspectInteresse.valueOf(prospectOuiNon);
                return  new Prospect(idProspect, raisonSocial, numRue, nomRue, cdPostal, ville,
                        telephone, mail, commentaire, dateProspection, prospectInteresse);

            } else throw new DaoException("find by name impossible");
        } catch (SQLException | EntitiesException e) {
            throw new SQLException("Erreur pour voir la base de donnée");
        }

    }

    //Methode pour create un prospect
    public static void creatProspect(Prospect prospect) throws SQLException, IOException {
        PreparedStatement creatProspect = null;
        String sql = """
            INSERT INTO prospect (`RAISONSOCIAL`, `NUMRUE`, `NOMRUE`, `CDPOSTAL`, `VILLE`, 
            `TELEPHONE`, `MAIL`, `COMMENTAIRES`, `DATEPROSPECTION`, `PROSPECTINTERESSE`) 
            VALUES (?,?,?,?,?,?,?,?,?,?);""";

        Connection con = Connexion.getConnection();

        try {
            con.setAutoCommit(false);
            creatProspect = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            creatProspect.setString(1, prospect.getRaisonSociale());
            creatProspect.setString(2, prospect.getNumRue());
            creatProspect.setString(3, prospect.getNomRue());
            creatProspect.setString(4, prospect.getCdPostal());
            creatProspect.setString(5, prospect.getVille());
            creatProspect.setString(6, prospect.getTelephone());
            creatProspect.setString(7, prospect.getMail());
            creatProspect.setString(8, prospect.getCommentaire());
            // Conversion LocalDate vers Date
            creatProspect.setDate(9, Date.valueOf(prospect.getDateProspection()));
            // Conversion enum to String
            creatProspect.setString(10, prospect.getProspectInteresse().toString());

            creatProspect.executeUpdate();
            ResultSet rs = creatProspect.getGeneratedKeys();
            // section pour avoir l'id insere
            if (rs.next()) {
                int generatedKey = rs.getInt(1);
                System.out.println("Generated ID is: " + generatedKey);
            } else {
                System.out.println("No Id was generated");
            }
            con.commit();
        } catch (SQLException ex) {
            if (con != null) {
                try {
                    System.err.print("Rollback transaction");
                    con.rollback();
                } catch (SQLException excep) {
                    throw new SQLException(excep.getMessage());
                }
            }
            throw new SQLException("Insert problem: " + ex.getMessage());
        } finally {
            if (creatProspect != null) {
                creatProspect.close();
            }
            if (con != null) {
                con.setAutoCommit(true);
            }
        }
    }

    //Methode pour update un prospect
    public static void updateProspect(Prospect prospect) throws SQLException, IOException {
        PreparedStatement updateProspect = null;
        String sql = """
            UPDATE prospect SET RAISONSOCIAL=?, NUMRUE=?, NOMRUE=?, CDPOSTAL=?, VILLE=? , 
            TELEPHONE=?, MAIL=?, COMMENTAIRES=?, DATEPROSPECTION=?, PROSPECTINTERESSE=? WHERE IDPROSPECT=?
            """;

        Connection con = Connexion.getConnection();

        try {
            con.setAutoCommit(false);
            updateProspect = con.prepareStatement(sql);

            updateProspect.setString(1, prospect.getRaisonSociale());
            updateProspect.setString(2, prospect.getNumRue());
            updateProspect.setString(3, prospect.getNomRue());
            updateProspect.setString(4, prospect.getCdPostal());
            updateProspect.setString(5, prospect.getVille());
            updateProspect.setString(6, prospect.getTelephone());
            updateProspect.setString(7, prospect.getMail());
            updateProspect.setString(8, prospect.getCommentaire());
            // Conversion LocalDate vers Date
            updateProspect.setDate(9, Date.valueOf(prospect.getDateProspection()));
            // Conversion enum to String
            updateProspect.setString(10, prospect.getProspectInteresse().toString());
            updateProspect.setInt(11, prospect.getId());

            int rowsAffected = updateProspect.executeUpdate();

            if (rowsAffected > 0){
                System.out.println("Prospect met a jour.");
            }else {
                System.out.println("Aucun prospect n'est mis a jour.");
            }
            con.commit();
        } catch (SQLException ex) {
            if (con != null) {
                try {
                    System.err.print("Rollback transaction ");
                    con.rollback();
                } catch (SQLException excep) {
                    throw new SQLException(excep.getMessage());
                }
            }
            throw new SQLException("Problem de mise a jour du prospect: " + ex.getMessage());
        } finally {
            if (updateProspect != null) {
                updateProspect.close();
            }
            if (con != null) {
                con.setAutoCommit(true);
            }
        }
    }

    //Methode pour delete un prospect
    public static void deletProspect (int idProspect) throws SQLException, IOException{
        PreparedStatement deletProspect = null;
        String sql = "DELETE FROM prospect WHERE IDPROSPECT = ?";
        Connection con = Connexion.getConnection();

        try{
            con.setAutoCommit(false);
            deletProspect =  con.prepareStatement(sql);

            deletProspect.setInt(1, idProspect);

            int rowsAffected = deletProspect.executeUpdate();

            if (rowsAffected > 0){
                System.out.println("Prospect supprimé avec sucssé.");
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
            if (deletProspect !=null){
                deletProspect.close();
            }
            if (con != null){
                con.setAutoCommit(true);
            }
        }
    }
}