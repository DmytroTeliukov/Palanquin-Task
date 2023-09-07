package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DateSorterTest {

    @Test
    @DisplayName("should pass when date sorter sort correct")
    void shouldPass_whenDateSorterSortCorrect() {
        // Given
        DateSorter dateSorter = new DateSorter();
        List<LocalDate> unsortedDates = Arrays.asList(
                LocalDate.of(2005, 7, 1),
                LocalDate.of(2005, 1, 2),
                LocalDate.of(2005, 1, 1),
                LocalDate.of(2005, 5, 3)
        );

        // When
        Collection<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);

        // Then
        List<LocalDate> expectedSortedDates = Arrays.asList(
                LocalDate.of(2005, 1, 1),
                LocalDate.of(2005, 1, 2),
                LocalDate.of(2005, 7, 1),
                LocalDate.of(2005, 5, 3)
        );

        assertIterableEquals(expectedSortedDates, sortedDates);
    }
}
