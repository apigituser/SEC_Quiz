import java.util.*;

public class App {
    private static final String APP_TITLE = "=== ONLINE QUIZ SYSTEM ===";

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
        List<User> users = new ArrayList<>();
        Map<String, Integer> quizQuestionCounts = new HashMap<>();
        QuizRunner runner = new QuizRunner();

        while (true) {
            System.out.println("\n" + APP_TITLE);
            System.out.println("1. Start Quiz");
            System.out.println("2. View Quiz Leaderboard");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");
            String menuChoice = scanner.nextLine().trim();

            if (menuChoice.equals("1")) {
                // 1. Capture player name before starting
                String playerName = "";
                while (playerName.isEmpty()) {
                    System.out.print("Enter your name: ");
                    playerName = scanner.nextLine().trim();
                    if (playerName.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                    }
                }

                // 2. Select one of the 5 quizzes
                int quizIndex = selectQuiz(scanner, false);
                String selectedQuizName = QUIZ_NAMES[quizIndex];
                String selectedQuizFile = QUIZ_FILES[quizIndex];

                // 3. Load questions using a  QuestionLoader instance
                QuestionLoader loader = new QuestionLoader();
                ArrayList<Question> questions = loader.loadQuestionsFrom(selectedQuizFile);

                if (questions == null || questions.isEmpty()) {
                    System.out.println("No questions loaded from " + selectedQuizFile + ". Check the file path.");
                    continue;
                }
                quizQuestionCounts.put(selectedQuizName, questions.size());

                // 4. Run the quiz and record the score for this quiz
                System.out.println("\nWelcome, " + playerName + "! Starting " + selectedQuizName + "...");
                int score = runner.startQuiz(questions, scanner);

                User currentUser = findOrCreateUser(users, playerName);
                currentUser.recordScore(selectedQuizName, score);

                // 5. Display the ranked leaderboard for the quiz just completed
                displaySingleQuizLeaderboard(selectedQuizName, users, questions.size());

                // 6. Pause before continuing or exiting
                System.out.print("\nDo you want to attempt another quiz? (Y/N): ");
                String again = scanner.nextLine().trim().toUpperCase();
                if (!again.equals("Y")) {
                    System.out.println("Exiting Online Quiz System. Goodbye!");
                    break;
                }

            } else if (menuChoice.equals("2")) {
                int selection = selectQuiz(scanner, true);
                if (selection == QUIZ_NAMES.length) {
                    for (String quizName : QUIZ_NAMES) {
                        int total = quizQuestionCounts.getOrDefault(quizName, 0);
                        displaySingleQuizLeaderboard(quizName, users, total);
                    }
                } else {
                    String quizName = QUIZ_NAMES[selection];
                    int total = quizQuestionCounts.getOrDefault(quizName, 0);
                    displaySingleQuizLeaderboard(quizName, users, total);
                }

            } else if (menuChoice.equals("3")) {
                System.out.println("Exiting Online Quiz System. Goodbye!");
                break;

            } else {
                System.out.println("Invalid option. Please enter 1, 2, or 3.");
            }
        }

        scanner.close();
    }

    private static User findOrCreateUser(List<User> users, String playerName) {
        for (User u : users) {
            if (u.getName().equalsIgnoreCase(playerName)) {
                return u;
            }
        }
        User newUser = new User(playerName);
        users.add(newUser);
        return newUser;
    }

    private static int selectQuiz(Scanner scanner, boolean includeAllOption) {
        int maxOption = includeAllOption ? QUIZ_NAMES.length + 1 : QUIZ_NAMES.length;
        while (true) {
            System.out.println("\n========= SELECT A QUIZ =========");
            for (int i = 0; i < QUIZ_NAMES.length; i++) {
                System.out.println((i + 1) + ". " + QUIZ_NAMES[i]);
            }
            if (includeAllOption) {
                System.out.println(maxOption + ". View All 5 Quiz Leaderboards");
            }
            System.out.print("Enter choice (1-" + maxOption + "): ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= maxOption) {
                    return choice - 1;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Invalid choice. Please enter a number between 1 and " + maxOption + ".");
        }
    }

    private static void displaySingleQuizLeaderboard(String quizName, List<User> users, int totalQuestions) {
        System.out.println("\n=== LEADERBOARD: " + quizName + " ===");

        List<User> participants = new ArrayList<>();
        for (User u : users) {
            if (u.getScoreForQuiz(quizName) != null) {
                participants.add(u);
            }
        }

        if (participants.isEmpty()) {
            System.out.println("No attempts recorded for this quiz yet.");
            System.out.println("==========================================");
            return;
        }

        participants.sort((a, b) -> Integer.compare(
                b.getScoreForQuiz(quizName),
                a.getScoreForQuiz(quizName)
        ));

        for (int i = 0; i < participants.size(); i++) {
            User u = participants.get(i);
            int best = u.getScoreForQuiz(quizName);
            String scoreText = (totalQuestions > 0) ? (best + "/" + totalQuestions) : (best + " pts");
            System.out.println((i + 1) + ". " + u.getName() + " - " + scoreText);
        }
        System.out.println("==========================================");
    }
}