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
}
