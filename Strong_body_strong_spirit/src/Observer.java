import java.util.*;
//Observer
public interface Observer {
    void update(String message);
}

class Trainee implements Observer {
    private String name;
    private List<String> trainingHistory = new ArrayList<>();

    public Trainee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getTrainingHistory() {
        return trainingHistory;
    }

    public void addTraining(String training) {
        trainingHistory.add(training);
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received update: " + message);
    }
}
