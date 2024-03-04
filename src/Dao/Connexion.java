package Dao;

import logs.MyLogger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;

public class Connexion {
    private static Connection connection;
//initialisation de la connexion depuis le ficher databaseClientProspect.properties
    private static void startConnection() throws IOException, SQLException{
        Properties dataProperties = new Properties();
        File fichier = new File("databaseClientProspect.properties");
        try (FileInputStream input = new FileInputStream(fichier)){
            dataProperties.load(input);
        }
        String url = dataProperties.getProperty("url");
        String username = dataProperties.getProperty("username");
        String password = dataProperties.getProperty("password");
// La connexion sera fermée automatiquement si une exception se produit dans le bloc try-with-resources
        connection = DriverManager.getConnection(url,username,password);
    }
//methode pour obtenir la connexion a la base de donnees
    public static Connection getConnection() throws SQLException, IOException{
        if (connection == null){
            startConnection();
        }
        return connection;
    }
//fermeture de la connesion a l'arret de l'application
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                if (connection != null){
                    try{
                        MyLogger.LOGGER.info("Base de données fermée");
                        connection.close();
                    }catch (SQLException ex){
                        MyLogger.LOGGER.log(Level.SEVERE, ex.getMessage());
                    }
                }
            }
        });
}
//initialisation static
    static {
        try {
            startConnection();
        } catch (IOException | SQLException e) {
            System.err.println("Erreur lors de l'initialisation de la connexion : " + e.getMessage());
            // En cas d'erreur lors de l'initialisation, mieux vaut ne pas laisser une connexion non initialisée
            // Nous allons juste imprimer l'erreur, la connexion restera null
        }
    }
}
