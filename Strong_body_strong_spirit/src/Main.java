import java.util.*;


public class Main {

    public static void main(String[] args) {
        Gym gym = Gym.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of trainees: ");
        int numTrainees = scanner.nextInt();
        scanner.nextLine();

        Map<String, Trainee> traineeMap = new HashMap<>();

        for (int i = 0; i < numTrainees; i++) {
            System.out.print("Enter the name of trainee " + (i + 1) + ": ");
            String name = scanner.nextLine();
            Trainee trainee = new Trainee(name);
            gym.addObserver(trainee);
            traineeMap.put(name, trainee);
        }

        TrainingProgram program = new TrainingProgram();
        int index = 0;
        List<String> traineeNames = new ArrayList<>(traineeMap.keySet());

        while (index < traineeNames.size()) {
            String traineeName = traineeNames.get(index);
            Trainee trainee = traineeMap.get(traineeName);
            System.out.println("\nEnter the type of training for " + traineeName + " (cardio/strength) or 'exit' to quit: ");
            String trainingType = scanner.nextLine().toLowerCase();

            if (trainingType.equals("exit")) {
                break;
            }

            switch (trainingType) {
                case "cardio":
                    gym.notifyObservers("New training program for " + traineeName + ": Cardio");
                    program.setStrategy(new CardioTraining());
                    program.executeTraining();

                    Exercise basicTraining = new BasicTraining();
                    Exercise cardioTraining = new CardioDecorator(basicTraining);
                    cardioTraining.perform();

                    trainee.addTraining("Cardio Training");
                    index++;
                    break;

                case "strength":
                    gym.notifyObservers("New training program for " + traineeName + ": Strength");
                    program.setStrategy(new StrengthTraining());
                    program.executeTraining();

                    Exercise strengthTraining = new StrengthDecorator(new BasicTraining());
                    strengthTraining.perform();

                    trainee.addTraining("Strength Training");
                    index++;
                    break;

                default:
                    System.out.println("Invalid training type. Please enter 'cardio' or 'strength'.");
                    break;
            }


            System.out.println("Training history for " + traineeName + ":");
            for (String training : trainee.getTrainingHistory()) {
                System.out.println(training);
            }
        }

        scanner.close();
    }
}