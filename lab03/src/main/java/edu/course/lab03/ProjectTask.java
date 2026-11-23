package edu.course.lab03;

public class ProjectTask {
    public enum Status {
        NEW, IN_PROGRESS, DONE, BLOCKED
    }
    private final String title;
    private final Status status;
    private final int effort;

    public ProjectTask(String title, Status status, int effort){
        if (title == null || title.isBlank()){
            throw new IllegalArgumentException("Титул не может быть пустым");
        }
        if (status == null){
            throw new IllegalArgumentException("Статус не может быть пустым ");
        }
        if (effort < 0){
            throw new IllegalArgumentException("effort не может быть меньше нуля");
        }
        this.title = title;
        this.status = status;
        this.effort = effort;
    }
    public String goTitle(){
        return title;
    }
    public Status goStatus(){
        return status;
    }
    public int goEffort(){
        return effort;
    }

    @Override
    public String toString(){
        return "ProjectTask{"+ title + ", effort=" + effort + ", status=" + status + "}";
    }
}
