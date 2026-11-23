package edu.course.lab04;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.*;

class IssueRegistryTest {

    @Test
    void testFindByEqualKey() {
        IssueRegistry registry = new IssueRegistry();
        IssueId id1 = new IssueId("PROJ", 101);
        IssueId id2 = new IssueId("PROJ", 101);
        ProjectTask task = new ProjectTask("Настроить CI/CD", "Алексей");

        registry.put(id1, task);

        assertNotSame(id1, id2);
        assertEquals(id1, id2);
        assertTrue(registry.containsKey(id2));
        assertEquals(task, registry.get(id2));
    }

    @Test
    void testReplaceValue() {
        IssueRegistry registry = new IssueRegistry();
        ProjectTask initialTask = new ProjectTask("Старое описание", "Иван");
        ProjectTask updatedTask = new ProjectTask("Новое описание", "Мария");

        registry.put(new IssueId("API", 7), initialTask);
        registry.put(new IssueId("API", 7), updatedTask);

        assertEquals(1, registry.size());
        assertEquals(updatedTask, registry.get(new IssueId("API", 7)));
    }

    @Test
    void testRemoveTask() {
        IssueRegistry registry = new IssueRegistry();
        IssueId id = new IssueId("WEB", 15);
        ProjectTask task = new ProjectTask("Починить верстку", "Дмитрий");

        registry.put(id, task);
        assertEquals(1, registry.size());

        ProjectTask removed = registry.remove(id);
        assertEquals(task, removed);
        assertFalse(registry.containsKey(id));
        assertNull(registry.get(id));
        assertEquals(0, registry.size());
    }

    @Test
    void testEqualsEdgeCases() {
        IssueId id = new IssueId("CORE", 1);

        assertFalse(id.equals(null));
        assertFalse(id.equals("CORE-1"));
        assertFalse(id.equals(1));
    }

    static final class CollidingKey {
        private final String code;

        CollidingKey(String code) {
            this.code = code;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CollidingKey that)) return false;
            return Objects.equals(code, that.code);
        }

        @Override
        public int hashCode() {
            return 42;
        }
    }

    @Test
    void testHashCollision() {
        Map<CollidingKey, String> map = new HashMap<>();
        CollidingKey key1 = new CollidingKey("TASK-1");
        CollidingKey key2 = new CollidingKey("TASK-2");

        assertEquals(key1.hashCode(), key2.hashCode());
        assertNotEquals(key1, key2);

        map.put(key1, "Задача 1");
        map.put(key2, "Задача 2");

        assertEquals(2, map.size());
        assertEquals("Задача 1", map.get(key1));
        assertEquals("Задача 2", map.get(key2));
    }

    static class MutableKey {
        private int number;

        MutableKey(int number) {
            this.number = number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MutableKey that)) return false;
            return number == that.number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(number);
        }
    }

    @Test
    void testMutableKeyProblem() {
        Map<MutableKey, String> map = new HashMap<>();
        MutableKey key = new MutableKey(10);

        map.put(key, "Важные данные");
        assertEquals("Важные данные", map.get(key));

        key.setNumber(99);

        assertNull(map.get(key));
        assertNull(map.get(new MutableKey(10)));
        assertEquals(1, map.size());
    }
}
