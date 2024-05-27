import java.util.*;
// Decorator
public interface Exercise {
    void perform();
}

class BasicTraining implements Exercise {
    @Override
    public void perform() {
        System.out.println("Performing basic training.");
    }
}

class ExerciseDecorator implements Exercise {
    protected Exercise decoratedExercise;

    public ExerciseDecorator(Exercise decoratedExercise) {
        this.decoratedExercise = decoratedExercise;
    }

    @Override
    public void perform() {
        decoratedExercise.perform();
    }
}

class CardioDecorator extends ExerciseDecorator {
    public CardioDecorator(Exercise decoratedExercise) {
        super(decoratedExercise);
    }

    @Override
    public void perform() {
        decoratedExercise.perform();
        System.out.println("Adding cardio exercises.");
    }
}

class StrengthDecorator extends ExerciseDecorator {
    public StrengthDecorator(Exercise decoratedExercise) {
        super(decoratedExercise);
    }

    @Override
    public void perform() {
        decoratedExercise.perform();
        System.out.println("Adding strength exercises.");
    }
}
