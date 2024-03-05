package test;

import entites.EntitiesException;
import entites.Societe;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SocieteTest extends Societe {


    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {""})
    void testInvalidSetNumRue(String numRueTest) {
        assertThrows(EntitiesException.class,()->{setNumRue(numRueTest);});
    }

    @ParameterizedTest
    @ValueSource(strings = {"55ll"})
    void testSetNumRue(String numRueTest) {
        assertDoesNotThrow(()->{setNumRue(numRueTest);});
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"", "mail", "email.com", "email@com", "email@com.'123"})
    void testInvalidSetMail(String mailTest) {
        assertThrows(EntitiesException.class,()->{setMail(mailTest);});
    }

    @ParameterizedTest
    @ValueSource(strings = {"validemail123@example.com"})
    void testSetMail(String numRueTest) {
        assertDoesNotThrow(()->{setNumRue(numRueTest);});
    }


}
