package test;

import entites.Prospect;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour la classe Prospect.
 * Elle contient des méthodes de test pour vérifier le bon fonctionnement des fonctionnalités de la classe Prospect.
 *
 * @author Younes
 * @version 1.0
 * @since 2024-03-24
 */
class ProspectTest extends Prospect {

    /**
     * Test de la méthode setDateProspection(LocalDate dateProspection).
     * Vérifie si la méthode setDateProspection ne lance aucune exception avec différentes valeurs de date de prospection.
     *
     * @param dateProspectionTest La date de prospection à tester.
     */
    @ParameterizedTest
    @ValueSource(strings = {"05/12/2020"})
    void testSetDateProspection(LocalDate dateProspectionTest) {
        assertDoesNotThrow(()->{setDateProspection(dateProspectionTest);});
    }
}
