package outils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * La class outils DateFormatter assure l'affichage de la date de prospection en format (jj/mm/aaaa)
 *
 * @author Younes
 * @version 1.0
 * @since 27/02/2024
 *
 */
public class DateFormatter {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static DateTimeFormatter getDateFormatter() {
        return DATE_FORMATTER;
    }

    //Methode pour verifier le bon format de la date
    //tu peut le mettre dans l'interface pour assurer la format d'insertion de date
    /*public static boolean dateValid (String date){
        try {
            LocalDate.parse(date, DATE_FORMATTER);
            return true;
        } catch (DateTimeParseException e){
            return false;
        }
    }*/
}
