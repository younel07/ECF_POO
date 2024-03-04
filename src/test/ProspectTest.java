package test;

import entites.Prospect;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProspectTest extends Prospect {

    @ParameterizedTest
    @ValueSource(strings = {"05/12/2020"})
    void testSetDateProspection(LocalDate dateProspectionTest) {
        assertDoesNotThrow(()->{setDateProspection(dateProspectionTest);});
    }
}