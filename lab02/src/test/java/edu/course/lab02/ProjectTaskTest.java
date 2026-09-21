package edu.course.lab02;
import  org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProjectTaskTest {
    @Test
    void constructorCreatesValidTask() {
        ProjectTask task = new ProjectTask("T-1", "Написать тесты", 8);
        assertEquals("T-1", task.getId());
        assertEquals("Написать тесты", task.getTitle());
        assertEquals(8, task.getEstimatedHours());
        assertEquals(TaskStatus.TODO, task.getStatus());
    }

    @Test
    void constructorThrowsForNullId() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask(null, "Title", 8));
    }

    @Test
    void constructorThrowsForEmptyId() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("", "Title", 8));
    }

    @Test
    void constructorThrowsForNullTitle() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("T-1", null, 8));
    }

    @Test
    void constructorThrowsForEmptyTitle() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("T-1", "", 8));
    }

    @Test
    void constructorThrowsForZeroHours() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("T-1", "Title", 0));
    }

    @Test
    void constructorThrowsForNegativeHours() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("T-1", "Title", -5));
    }


    @Test
    void changeStatusUpdatesStatus() {
        ProjectTask task = new ProjectTask("T-1", "Title", 8);
        task.changeStatus(TaskStatus.IN_PROGRESS);
        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
    }

    @Test
    void changeStatusToDoneMarksTaskCompleted() {
        ProjectTask task = new ProjectTask("T-1", "Title", 8);
        task.changeStatus(TaskStatus.DONE);
        assertTrue(task.isCompleted());
    }

    @Test
    void changeStatusThrowsForNull() {
        ProjectTask task = new ProjectTask("T-1", "Title", 8);
        assertThrows(IllegalArgumentException.class, () -> task.changeStatus(null));
    }

    @Test
    void changeStatusThrowsForNullAndKeepsPreviousStatus() {
        ProjectTask task = new ProjectTask("T-1", "Title", 8);
        task.changeStatus(TaskStatus.IN_PROGRESS);
        assertThrows(IllegalArgumentException.class, () -> task.changeStatus(null));
        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
    }


    @Test
    void newTaskIsNotCompleted() {
        ProjectTask task = new ProjectTask("T-1", "Title", 8);
        assertFalse(task.isCompleted());
    }

    @Test
    void taskInProgressIsNotCompleted() {
        ProjectTask task = new ProjectTask("T-1", "Title", 8);
        task.changeStatus(TaskStatus.IN_PROGRESS);
        assertFalse(task.isCompleted());
    }

    @Test
    void doneTaskIsCompleted() {
        ProjectTask task = new ProjectTask("T-1", "Title", 8);
        task.changeStatus(TaskStatus.DONE);
        assertTrue(task.isCompleted());
    }

    @Test
    void addHoursIncreasesEstimatedHours() {
        ProjectTask task = new ProjectTask("T-1", "Title", 8);
        task.addHours(4);
        assertEquals(12, task.getEstimatedHours());
    }

    @Test
    void addHoursThrowsForZero() {
        ProjectTask task = new ProjectTask("T-1", "Title", 8);
        assertThrows(IllegalArgumentException.class, () -> task.addHours(0));
    }

    @Test
    void addHoursThrowsForNegative() {
        ProjectTask task = new ProjectTask("T-1", "Title", 8);
        assertThrows(IllegalArgumentException.class, () -> task.addHours(-3));
    }

    @Test
    void addHoursThrowsAndKeepsPreviousValue() {
        ProjectTask task = new ProjectTask("T-1", "Title", 8);
        assertThrows(IllegalArgumentException.class, () -> task.addHours(-3));
        assertEquals(8, task.getEstimatedHours());
    }


    @Test
    void fullTaskLifecycle() {
        ProjectTask task = new ProjectTask("T-1", "Title", 8);
        assertEquals(TaskStatus.TODO, task.getStatus());
        assertFalse(task.isCompleted());

        task.changeStatus(TaskStatus.IN_PROGRESS);
        task.addHours(2);
        assertEquals(10, task.getEstimatedHours());
        assertFalse(task.isCompleted());

        task.changeStatus(TaskStatus.DONE);
        assertTrue(task.isCompleted());
    }





}
