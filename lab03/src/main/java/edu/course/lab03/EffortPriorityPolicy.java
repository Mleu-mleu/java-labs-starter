package edu.course.lab03;

public class EffortPriorityPolicy implements  Prioritypolicy{
    @Override
    public int calculatePriority(ProjectTask task){
        if (task == null){
            throw new IllegalArgumentException("task не может быть пустым");
        }
        return task.goEffort();
    }
}
