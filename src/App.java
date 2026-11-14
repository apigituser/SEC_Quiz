
public class App {

    public static void main(String[] args) throws Exception {
        
        Question question = new Question(1, "What is the capital of France?", "Berlin", "Madrid", "Paris", "Rome", 'C');

        System.out.println(question);
        System.out.println(question.isCorrect('A'));
        System.out.println(question.isCorrect('B'));
        System.out.println(question.isCorrect('C'));
        System.out.println(question.isCorrect('D'));
    }
}
