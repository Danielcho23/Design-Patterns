import java.util.*;
// Strategy
public interface TrainingStrategy {
    void train();
}

class CardioTraining implements TrainingStrategy {
    @Override
    public void train() {
        System.out.println("Performing cardio training.");
    }
}

class StrengthTraining implements TrainingStrategy {
    @Override
    public void train() {
        System.out.println("Performing strength training.");
    }
}

class TrainingProgram {
    private TrainingStrategy strategy;

    public void setStrategy(TrainingStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeTraining() {
        strategy.train();
    }
}
