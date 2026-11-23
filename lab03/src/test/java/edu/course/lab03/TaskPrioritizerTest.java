package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskPrioritizerTest {

    private final ProjectTask smallTask = new ProjectTask("Мелкая задача", ProjectTask.Status.NEW, 2);
    private final ProjectTask bigTask = new ProjectTask("Крупная задача", ProjectTask.Status.NEW, 10);
    private final ProjectTask blockedTask = new ProjectTask("Заблокированная задача", ProjectTask.Status.BLOCKED, 3);

    @Test
    void effortPolicy_choosesTaskWithMoreEffort() {
        TaskPrioritizer prioritizer = new TaskPrioritizer(new EffortPriorityPolicy());
        assertSame(bigTask, prioritizer.choose(smallTask, bigTask));
        assertSame(bigTask, prioritizer.choose(bigTask, smallTask));
    }

    @Test
    void effortPolicy_ignoresStatus() {
        TaskPrioritizer prioritizer = new TaskPrioritizer(new EffortPriorityPolicy());
        assertSame(bigTask, prioritizer.choose(blockedTask, bigTask));
    }

    @Test
    void statusPolicy_choosesBlockedOverNew() {
        TaskPrioritizer prioritizer = new TaskPrioritizer(new StatusPriorityPolicy());
        assertSame(blockedTask, prioritizer.choose(smallTask, blockedTask));
    }

    @Test
    void statusPolicy_doesNotChangeTasks() {
        TaskPrioritizer prioritizer = new TaskPrioritizer(new StatusPriorityPolicy());
        prioritizer.choose(smallTask, blockedTask);
        assertEquals(ProjectTask.Status.NEW, smallTask.goStatus());
        assertEquals(ProjectTask.Status.BLOCKED, blockedTask.goStatus());
    }

    @Test
    void prioritizer_changesResultWhenStrategyIsSwapped() {
        // Создаем две задачи
        ProjectTask taskA = new ProjectTask("Задача А", ProjectTask.Status.NEW, 5);
        ProjectTask taskB = new ProjectTask("Задача Б", ProjectTask.Status.BLOCKED, 2);

        TaskPrioritizer byEffort = new TaskPrioritizer(new EffortPriorityPolicy());
        assertSame(taskA, byEffort.choose(taskA, taskB));

        TaskPrioritizer byStatus = new TaskPrioritizer(new StatusPriorityPolicy());
        assertSame(taskB, byStatus.choose(taskA, taskB));

    }
    @Test
    void prioritizer_throwsExceptionOnNullPolicy() {
        assertThrows(IllegalArgumentException.class, () -> new TaskPrioritizer(null));
    }

    @Test
    void prioritizer_throwsExceptionOnNullTask() {
        TaskPrioritizer prioritizer = new TaskPrioritizer(new EffortPriorityPolicy());
        assertThrows(IllegalArgumentException.class,
                () -> prioritizer.choose(smallTask, null));
    }
}
