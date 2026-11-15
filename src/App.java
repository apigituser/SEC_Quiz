import java.util.*;

public class App {
    // Shared constant kept at the top for the merge conflict task later
    private static final String APP_TITLE = "=== ONLINE QUIZ SYSTEM ===";

    // Update these 5 titles and paths to match your partner's 5 CSV files
    private static final String[] QUIZ_NAMES = {
        "BASIC SCIENCE",
        "COMPUTER BASICS",
        "GENERAL KNOWLEDGE",
        "HISTORY AND GEOGRAPHY",
        "SPORTS TRIVIA"
    };

    private static final String[] QUIZ_FILES = {
        "questions/BASIC_SCIENCE.csv",
        "questions/COMPUTER_BASICS.csv",
        "questions/GENERAL_KNOWLEDGE.csv",
        "questions/HISTORY_AND_GEOGRAPHY.csv",
        "questions/SPORTS_TRIVIA.csv"
    }; 

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        QuizRunner runner = new QuizRunner();

        while (true) {
            System.out.println("\n" + APP_TITLE);
            for (int i = 0; i < QUIZ_NAMES.length; i++) {
                System.out.println((i + 1) + ". " + QUIZ_NAMES[i]);
            }
            System.out.println((QUIZ_NAMES.length + 1) + ". Exit");
            System.out.print("Select a quiz (1-" + (QUIZ_NAMES.length + 1) + "): ");

            String input = scanner.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            if (choice == QUIZ_NAMES.length + 1) {
                System.out.println("Exiting Online Quiz System. Goodbye!");
                break;
            }

            if (choice < 1 || choice > QUIZ_NAMES.length) {
                System.out.println("Invalid choice. Please select between 1 and " + (QUIZ_NAMES.length + 1) + ".");
                continue;
            }

            String selectedQuizName = QUIZ_NAMES[choice - 1];
            String selectedQuizFile = QUIZ_FILES[choice - 1];

            // Create a fresh QuestionLoader for the selected CSV file
            QuestionLoader loader = new QuestionLoader();
            ArrayList<Question> questions = loader.loadQuestionsFrom(selectedQuizFile);

            if (questions == null || questions.isEmpty()) {
                System.out.println("No questions loaded from " + selectedQuizFile + ". Check the file path.");
                continue;
            }

            System.out.println("\nStarting " + selectedQuizName + "...");
            runner.startQuiz(questions, scanner);

            // Pause after showing results instead of jumping straight to the menu
            System.out.print("\nDo you want to attempt another quiz? (Y/N): ");
            String again = scanner.nextLine().trim().toUpperCase();
            if (!again.equals("Y")) {
                System.out.println("Exiting Online Quiz System. Goodbye!");
                break;
            }
        }

        scanner.close();
    }
}