import java.util.*;
//Singleton
public class Gym {
    private static Gym instance;
    private List<Observer> trainees = new ArrayList<>();

    private Gym() {}

    public static Gym getInstance() {
        if (instance == null) {
            instance = new Gym();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        trainees.add(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : trainees) {
            observer.update(message);
        }
    }
}
