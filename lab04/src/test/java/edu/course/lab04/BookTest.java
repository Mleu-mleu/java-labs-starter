package edu.course.lab04;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testFindBySameIsbn() {
        Map<Book, String> library = new HashMap<>();
        Book firstCopy = new Book("978-0134685991", "Effective Java");
        Book secondCopy = new Book("978-0134685991", "Effective Java (3rd Edition)");

        library.put(firstCopy, "Стеллаж 4, полка 2");

        assertNotSame(firstCopy, secondCopy);
        assertEquals(firstCopy, secondCopy);
        assertEquals(firstCopy.hashCode(), secondCopy.hashCode());
        assertEquals("Стеллаж 4, полка 2", library.get(secondCopy));
    }

    @Test
    void testDifferentIsbnNotEqual() {
        Book book1 = new Book("978-0134685991", "Effective Java");
        Book book2 = new Book("978-0596009205", "Effective Java");

        assertNotEquals(book1, book2);
        assertFalse(book1.equals(null));
        assertFalse(book1.equals("978-0134685991"));
    }
}

