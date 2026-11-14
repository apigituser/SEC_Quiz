import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws Exception {
        String directory = "./questions/";

        QuestionLoader questionLoader = new QuestionLoader();
        ArrayList<Question> questions = questionLoader.loadQuestionsFrom(directory + "quiz1.csv");

        for (Question question: questions) {
            System.out.println(question);
        }
        // Question question = new Question(1, "What is the capital of France?", "Berlin", "Madrid", "Paris", "Rome", 'C');

        // System.out.println(question);
        // System.out.println(question.isCorrect('A'));
        // System.out.println(question.isCorrect('B'));
        // System.out.println(question.isCorrect('C'));
        // System.out.println(question.isCorrect('D'));
    }
}
