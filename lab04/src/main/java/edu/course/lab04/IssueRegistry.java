package edu.course.lab04;
import java.util.HashMap;
import java.util.Objects;
import java.util.Map;
import java.util.Objects;

public class IssueRegistry {
    private final Map<IssueId, ProjectTask> storage = new HashMap<>();
    public ProjectTask put(IssueId id, ProjectTask task){
        if (id == null){
            throw new NullPointerException("id не может быть null");
        }
        if (task == null){
            throw new NullPointerException("task не может быть null");
        }
        return storage.put(id, task);
    }
    public ProjectTask get(IssueId id){
        return storage.get(id);
    }
    public ProjectTask remove(IssueId id){
        return storage.remove(id);
    }
    public boolean containsKey(IssueId id){
        return  storage.containsKey(id);
    }
    public int size(){
        return storage.size();
    }
}
