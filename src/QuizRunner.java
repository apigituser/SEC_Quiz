import java.util.*;

public class QuizRunner {

    public int startQuiz(List<Question> questions, Scanner scanner) {
        if (questions == null || questions.isEmpty()) {
            System.out.println("No questions available in the quiz.");
            return 0;
        }

        int score = 0;
        System.out.println("\n=========================================");
        System.out.println("           ONLINE QUIZ STARTED           ");
        System.out.println("=========================================");

        ArrayList<Double> seconds = new ArrayList<>();

        // Loop through every Question object in the list
        for (Question q : questions) {
            // 1. Display question and options (calls Question.toString() automatically)
            System.out.println("\n" + q);

            // 2. Take and validate user input (A, B, C, or D)
            char userAnswer = ' ';
            while (true) {
                long startTime = System.nanoTime();
                System.out.print("Enter your answer (A/B/C/D): ");
                String input = scanner.nextLine().trim().toUpperCase();

                if (input.length() == 1 && "ABCD".indexOf(input.charAt(0)) != -1) {
                    userAnswer = input.charAt(0);
                    long endTime = System.nanoTime();
                    seconds.add((endTime - startTime) / 1_000_000_000.0);
                    break;
                }
                System.out.println("Invalid input. Please enter A, B, C, or D.");
            }

            // 3. Check answer using Student 1's isCorrect() method
            if (q.isCorrect(userAnswer)) {
                System.out.println("Result: Correct!");
                score++;
            } else {
                System.out.println("Result: Wrong!");
            }
        }

        // Calculating total time taken for the quiz
        Double totalTime = 0.0;
        for (Double time: seconds) {
            totalTime += time;
        }

        // 4. Display final result summary
        double percentage = ((double) score / questions.size()) * 100;
        System.out.println("\n=========================================");
        System.out.println("              QUIZ RESULTS               ");
        System.out.println("=========================================");
        System.out.println("Total Questions : " + questions.size());
        System.out.println("Correct Answers : " + score);
        System.out.printf("Final Percentage: %.1f%%\n", percentage);
        System.out.printf("Total Time Taken: %.1f seconds\n", totalTime);
        System.out.println("Time Taken for each question: ");

        int i = 1;
        for (Double time: seconds) {
            System.out.printf("%d -> %.2fs\n", i, time);
            i++;
        }
        System.out.println("=========================================");

        return score;
    }
}