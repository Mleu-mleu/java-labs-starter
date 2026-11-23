package edu.course.lab04;
import java.util.Objects;
public class ProjectTask {
    private final String summary;
    private final String assignee;
    public ProjectTask(String summary, String assignee){
        if (summary == null){
            throw  new NullPointerException("summary не может быть null");
        }
        if (assignee == null){
            throw new NullPointerException("assignee не модет быть null");
        }
        this.summary = summary;
        this.assignee = assignee;
    }
    public String getSummary(){
        return summary;
    }
    public String getAssignee(){
        return assignee;
    }
    @Override
    public boolean equals(Object o){
        if (this == null){
            return true;
        }
        if (!(o instanceof ProjectTask that)){
            return false;
        }
        return Objects.equals(summary, that.summary) && Objects.equals(assignee, that.assignee);
    }

    @Override
    public int hashCode(){
        return Objects.hash(summary, assignee);
    }
}

