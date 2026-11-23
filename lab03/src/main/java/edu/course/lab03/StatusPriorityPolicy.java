package edu.course.lab03;

public class StatusPriorityPolicy implements Prioritypolicy{
    @Override
    public int calculatePriority(ProjectTask task){
        if (task == null){
            throw new IllegalArgumentException("task не оможет быть пустым");
        }
        switch (task.goStatus()) {
            case BLOCKED:     return 4;
            case IN_PROGRESS: return 3;
            case NEW:         return 2;
            case DONE:        return 1;
            default:          return 0;
        }
    }
}
