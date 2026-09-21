package edu.course.lab02;

public class ProjectTask {
    private final String id;
    private final String title;
    private TaskStatus status;
    private int estimatedHours;


    public ProjectTask(String id, String title, int estimatedHours) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("id не может быть пустым");
        }
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("title не может быть пустым");
        }
        if (estimatedHours <= 0) {
            throw new IllegalArgumentException("estimatedHours не может быть меньше 0");
        }
        this.id = id;
        this.title = title;
        this.estimatedHours = estimatedHours;
        this.status = TaskStatus.TODO;
    }

    public void changeStatus(TaskStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("newStatus не может быть пустым");
        }
        this.status = newStatus;
    }

    public boolean isCompleted() {
        return status == TaskStatus.DONE;
    }

    public void addHours(int hours) {
        if (hours <= 0) {
            throw new IllegalArgumentException("hours не может быть меньше 0");
        }
        estimatedHours += hours;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }
}
