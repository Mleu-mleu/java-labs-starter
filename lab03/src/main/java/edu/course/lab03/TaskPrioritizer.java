package edu.course.lab03;

public class TaskPrioritizer {
    private final Prioritypolicy policy;
    public  TaskPrioritizer(Prioritypolicy policy){
        if (policy == null){
            throw new IllegalArgumentException("policy не может быть пустым");
        }
        this.policy = policy;
    }
    public ProjectTask choose(ProjectTask a, ProjectTask b){
        if (a == null || b == null){
            throw new IllegalArgumentException("a и b не могут быть пустыми");
        }
        int pa = policy.calculatePriority(a);
        int pb = policy.calculatePriority(b);
        return pa >= pb ? a : b;
    }
}
