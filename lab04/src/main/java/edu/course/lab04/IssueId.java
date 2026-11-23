package edu.course.lab04;
import java.util.Objects;

public final class IssueId {
    private final String projectCode;
    private final int number;
    public IssueId(String projectCode, int number){
        this.projectCode = projectCode;
        if (projectCode == null){
            throw new NullPointerException("projectCode не может быть null");
        }
        this.number = number;
    }
    public String getProjectCode(){
        return projectCode;
    }
    public int getnumber(){
        return number;
    }
    @Override
    public boolean equals(Object o){
        if (this == o){
            return  true;
        }
        if (!(o instanceof IssueId issueId)){
            return false;
        }
        return  number == issueId.number && Objects.equals(projectCode, issueId.projectCode );
    }
    @Override
    public int hashCode(){
        return Objects.hash(projectCode, number);
    }

    @Override
    public String toString(){
        return projectCode + "-" + number;
    }
}
