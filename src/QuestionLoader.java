import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;


public class QuestionLoader {
    
    private Scanner fileScanner;
    ArrayList<Question> questions;

    public QuestionLoader() {
        questions = new ArrayList<>();   
    }

    public ArrayList<Question> loadQuestionsFrom(String fileName) {

        try {
            File file = new File(fileName);

            fileScanner = new Scanner(file);
            fileScanner.nextLine();

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] lineArray = line.split(",");

                Question question = new Question(Integer.parseInt(lineArray[0]), lineArray[1], lineArray[2], lineArray[3], lineArray[4], lineArray[5], lineArray[6].charAt(0));

                questions.add(question);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return questions;
    }
}
