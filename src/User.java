import java.util.*;

public class User {
    private String name;
    private Map<String, Integer> quizBestScores;

    public User(String name) {
        this.name = name;
        this.quizBestScores = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    // Saves the score only if it beats the player's previous best on that specific quiz
    public void recordScore(String quizName, int score) {
        int currentBest = quizBestScores.getOrDefault(quizName, -1);
        if (score > currentBest) {
            quizBestScores.put(quizName, score);
        }
    }

    // Returns null if the player has not attempted this quiz yet
    public Integer getScoreForQuiz(String quizName) {
        return quizBestScores.get(quizName);
    }
}
