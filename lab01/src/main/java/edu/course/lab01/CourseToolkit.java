package edu.course.lab01;

/**
 * Небольшие методы для первой лабораторной работы.
 */
public final class CourseToolkit {

    private CourseToolkit() {
        // Утилитарный класс не должен иметь экземпляров.
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int a = 2; a * a <= number; a++) {
            if (number % a == 0) {
                return false;
            }
        }
        return true;

    }

    public static boolean isPalindrome(String text){
        if (text == null){
            throw new IllegalArgumentException("text не может быть пустым");
        }
        int left = 0;
        int right = text.length() - 1;
        while (left < right){
            if (text.charAt(left) != text.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static double average(int[] values){
        if (values == null || values.length == 0){
            throw new IllegalArgumentException("values не может быть пустым");
        }
        long sum = 0;
        for (int i = 0; i < values.length; i++){
            int value = values[i];
            sum += value;
        }
        return (double) sum / values.length;
    }
    /**
     * Возвращает true, если число четное.
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int min(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("values must not be null or empty");
        }
        int minimum = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] < minimum) {
                minimum = values[i];
            }
        }
        return minimum;
    }

    public static int max(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("values must not be null or empty");
        }
        int maximum = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > maximum) {
                maximum = values[i];
            }
        }
        return maximum;
    }
}
