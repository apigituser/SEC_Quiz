import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws Exception {
        String[] quizTitles = { 
            "BASIC_SCIENCE", "COMPUTER_BASICS", "GENERAL_KNOWLEDGE", "HISTORY_AND_GEOGRAPHY", "SPORTS_TRIVIA"
        };
        String directory = "./questions/";

        QuestionLoader questionLoader = new QuestionLoader();
        ArrayList<Question> questions = questionLoader.loadQuestionsFrom(directory + quizTitles[0] + ".csv");
        
    }
}
