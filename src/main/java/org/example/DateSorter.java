package org.example;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * <p>
 * Implement in single class.
 */
public class DateSorter {
    private static final String SEARCHABLE_CHARACTER = "r";

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2005-07-01, 2005-01-02, 2005-01-01, 2005-05-03)
     * would sort to
     * (2005-01-01, 2005-01-02, 2005-07-01, 2005-05-03)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        System.out.println("Sorted dates collection: " + unsortedDates);

        // Sort the list using the custom comparator
        unsortedDates.sort(this::dateComparator);

        System.out.println("Sorted dates collection: " + unsortedDates);

        // Return the sorted collection
        return unsortedDates;
    }

    private int dateComparator(LocalDate firstDate, LocalDate secondDate) {
        String firstMonth = firstDate.getMonth().toString().toLowerCase();
        String secondMonth = secondDate.getMonth().toString().toLowerCase();

        // Check if the month names contain searchable character
        boolean firstDateHasR = firstMonth.contains(SEARCHABLE_CHARACTER);
        boolean secondDateHasR = secondMonth.contains(SEARCHABLE_CHARACTER);

        // Compare based on the presence of searchable character in the month names
        if (!firstDateHasR && secondDateHasR) {
            return 1; // secondDate sets before firstDate
        } else if (firstDateHasR && !secondDateHasR) {
            return -1; // firstDate sets before secondDate
        } else if (!firstDateHasR) { // if both dates does not have a searchable character
            return secondDate.compareTo(firstDate);
        } else { // if both dates have a searchable character
            return firstDate.compareTo(secondDate);
        }
    }
}