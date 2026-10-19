package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }


    @Test
    void returnsTrueForOddNumber() {
        boolean result = CourseToolkit.isEven(0);

        assertTrue(result);
    }



    @Test
    void isPrimeReturnsFalseForNumbersBelowTwo() {
        boolean result = CourseToolkit.isPrime(-5);
        boolean result1 = CourseToolkit.isPrime(0);
        boolean result2 = CourseToolkit.isPrime(1);
        assertFalse(result);
        assertFalse(result1);
        assertFalse(result2);

    }

    @Test
    void isPrimeReturnsTrueForTwo() {
        boolean result = CourseToolkit.isPrime(2);
        assertTrue(result);
    }

    @Test
    void isPrimeReturnsTrueForOddPrime() {
        boolean result = CourseToolkit.isPrime(13);
        assertTrue(result);
    }

    @Test
    void isPrimeReturnsFalseForComposite() {
        boolean result = CourseToolkit.isPrime(15);
        assertFalse(result);
    }

    @Test
    void isPrimeHandlesSquareOfPrime() {
        boolean result = CourseToolkit.isPrime(49); //7*7
        boolean result1 = CourseToolkit.isPrime(9); //3*3
        assertFalse(result);
        assertFalse(result1);
    }

    @Test
    void isPalindromeReturnsTrueForSimplePalindrome() {
        boolean result = CourseToolkit.isPalindrome("rer");
        assertTrue(result);
    }

    @Test
    void isPalindromeIsCaseSensitive() {
        boolean result = CourseToolkit.isPalindrome("Level");
        assertFalse(result);
    }

    @Test
    void isPalindromeIsSpaceSensitive() {
        boolean result = CourseToolkit.isPalindrome("шалаш");
        assertTrue(result);
    }
    @Test
    void averageReturnsFractionalResult() {
        assertEquals(2.5, CourseToolkit.average(new int[]{1, 2, 3, 4}), 1e-9);
    }

    @Test
    void averageWorksWithNegativeValues() {
        assertEquals(-2.0, CourseToolkit.average(new int[]{-1, -3}), 1e-9);
    }

    @Test
    void averageDoesNotModifyInputArray() {
        int[] values = {4, 8, 15, 16, 23, 42};
        int[] copy = values.clone();
        CourseToolkit.average(values);
        assertArrayEquals(copy, values);
    }

    @Test
    void averageThrowsForNull() {
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.average(null));
    }

    @Test
    void averageThrowsForEmptyArray() {
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.average(new int[0]));
    }


    @Test
    void minFindsSmallestValue() {
        assertEquals(1, CourseToolkit.min(new int[]{4, 1, 7, 3}));
    }

    @Test
    void minWorksWithNegativeValues() {
        assertEquals(-15, CourseToolkit.min(new int[]{-3, -15, -7}));
    }

    @Test
    void minOnSingleElement() {
        assertEquals(42, CourseToolkit.min(new int[]{42}));
    }

    @Test
    void minThrowsForNull() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.min(null));
    }

    @Test
    void maxFindsLargestValue() {
        assertEquals(7, CourseToolkit.max(new int[]{4, 1, 7, 3}));
    }

    @Test
    void maxWorksWithNegativeValues() {
        assertEquals(-3, CourseToolkit.max(new int[]{-3, -15, -7}));
    }

    @Test
    void maxOnSingleElement() {
        assertEquals(42, CourseToolkit.max(new int[]{42}));
    }

    @Test
    void maxThrowsForNull() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.max(null));
    }

    @Test
    void maxThrowsForEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.max(new int[0]));
    }


}
