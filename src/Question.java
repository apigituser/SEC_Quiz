public class Question {
    
    private int questionID;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private char correctOption;

    public Question(int questionID, String question, String optionA, String optionB, String optionC, String optionD, char correctOption) {
        this.questionID = questionID;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = Character.toUpperCase(correctOption);
    }

    public boolean isCorrect(char answer) {
        return Character.toUpperCase(answer) == correctOption;
    }

    public String toString() {
        return questionID + ". " + question + "\n\n"
            + "(A) " + optionA + "\n" + "(B) " + optionB + "\n" 
            + "(C) " + optionC + "\n" + "(D) " + optionD + "\n";
    }
}