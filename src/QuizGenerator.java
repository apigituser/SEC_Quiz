import java.util.*;
import java.io.FileWriter;
import java.io.File;

public class QuizGenerator {
    
    private Scanner scanner;
    private ArrayList<Question> questions;

    public QuizGenerator() {
        scanner = new Scanner(System.in);
        questions = new ArrayList<>();
    }

    public void generateFile() {
        System.out.print("Quiz Title: ");
        String quizTitle = scanner.nextLine().toUpperCase();

        ArrayList<Question> questions = getQuestions();

        try {
            FileWriter writer = new FileWriter("questions/" + quizTitle + ".csv");

            writer.write(quizTitle + "\n");
            for (Question question: questions) {
                writer.write(question.getQuestionID() + "," + question.getQuestion() + "," + question.getOptionA() + "," + question.getOptionB() + "," + question.getOptionC() + "," + question.getOptionD() + "," + question.getCorrectOption() + "\n");
            }
            writer.close();

            System.out.println("Quiz Generated Successfully. Saved File (questions/" + quizTitle + ".csv)");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private ArrayList<Question> getQuestions() {

        while (true) {
            System.out.print("Number of questions to include: ");
            String input = scanner.nextLine().trim();
            try {
                int questionCount = Integer.parseInt(input);
                if (questionCount <= 0) {
                    System.out.println("Number of questions cannot be zero. Enter a valid number.");
                    continue;
                }
                for (int i = 1; i <= questionCount; i++) {
                    System.out.print("Question: ");
                    String question = scanner.nextLine().trim();
                    
                    String optionA, optionB, optionC, optionD;
                    System.out.print("Option A: ");
                    optionA = scanner.nextLine().trim().toUpperCase();
                    System.out.print("Option B: ");
                    optionB = scanner.nextLine().trim().toUpperCase();
                    System.out.print("Option C: ");
                    optionC = scanner.nextLine().trim().toUpperCase();
                    System.out.print("Option D: ");
                    optionD = scanner.nextLine().trim().toUpperCase();

                    System.out.print("Correct Option (A/B/C/D): ");
                    char correctOption = scanner.nextLine().toUpperCase().charAt(0);
                    
                    while (validateOptions(correctOption) == false) {
                        System.out.println("Invalid input. Please enter A, B, C, or D.");
                        correctOption = scanner.nextLine().toUpperCase().charAt(0);
                    }

                    Question newQuestion = new Question(i, question, optionA, optionB, optionC, optionD, correctOption);
                    questions.add(newQuestion);
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a valid number.");
            }            
        }
        return questions;
    }

    private boolean validateOptions(char option) {
        ArrayList<Character> options = new ArrayList<>(List.of('A','B','C','D'));
        return options.contains(option);
    }
}
