# Online Quiz System (`SEC_Quiz`)

A console-based Java application for generating and attempting topic-wise multiple-choice quizzes with timed attempts, user management, and performance-based leaderboards, developed collaboratively using Git and GitHub workflows.

- **GitHub Repository:** [https://github.com/apigituser/SEC_Quiz](https://github.com/apigituser/SEC_Quiz)
- **Contribution & Workflow Guide:** See [`CONTRIBUTING.md`](./CONTRIBUTING.md)

---

## Project Objectives
- Build a modular, object-oriented **Command-Line Interface (CLI)** quiz system in Java.
- Generate and load structured multiple-choice question banks dynamically using `.csv` files inside the `questions/` directory.
- Track per-question and total quiz attempt durations alongside user-specific scores and rankings.
- Practice collaborative version control using **feature branches**, **Pull Requests**, **peer code reviews**, and **merge conflict resolution**.

---

## Team Members & Contributions

| Member | GitHub Profile | Branch | Focus Areas |
| :--- | :--- | :--- | :--- |
| **Vorundeep Singh** | [`apigituser`](https://github.com/apigituser) | `feature-member1` | Quiz Generator, CSV File Interpreter, Timed Quiz Attempts |
| **Sanil Kumar** | [`sanilkumar1108-ui`](https://github.com/sanilkumar1108-ui) | `feature-member2` | Leaderboard, User Management, `README.md` & `CONTRIBUTING.md` |

### Vorundeep Singh ([`apigituser`](https://github.com/apigituser))
1. **Quiz Generator:** Receives the quiz title, number of questions to include in the quiz, options, and the correct option from the user. Uses these parameters to generate a `.csv` file in the `questions/` directory containing all the quizzes.
2. **CSV File Interpreter:** A custom csv file loader reads the `.csv` files from the `questions/` directory and displays those questions during the quiz to the user.
3. **Timed Quiz Attempts:** Specifies the total time taken by the user (in seconds) to attempt the entire quiz, as well as the time taken to attempt each question.

### Sanil Kumar ([`sanilkumar1108-ui`](https://github.com/sanilkumar1108-ui))
1. **Leaderboard:** Implemented a leaderboard system that keeps track of the quiz score scored by the users. Users are ranked based on the quiz performance.
2. **User Management:** User management system allows different users to attempt the quizzes and save their progress. The leaderboard uses the user names during the quiz rankings.
3. **README.md and CONTRIBUTING.md:** Created comprehensive and detailed documentation for the project and wrote the individual contributions done by the team members.

---

## Features & Technologies

### Core Features
1. **Quiz Generator (`QuizGenerator.java`):** Generates `.csv` quiz files inside `questions/` based on user-defined titles, question counts, options, and correct answers.
2. **CSV File Interpreter (`QuestionLoader.java`):** Loads multiple-choice questions from `.csv` files in `questions/` and displays them during quiz sessions.
3. **Timed Quiz Attempts (`QuizRunner.java`):** Measures and reports both per-question response times and total quiz duration in seconds.
4. **Leaderboard System (`App.java`):** Tracks user quiz scores and ranks players according to their quiz performance.
5. **User Management (`User.java`):** Enables multiple users to attempt quizzes, save their progress, and appear by username on the leaderboard.

### Technologies Used
- **Programming Language:** *Java (JDK 17+)*
- **Data Storage:** *Comma-Separated Values (`.csv`)*
- **Version Control & Collaboration:** *Git* & [*GitHub*](https://github.com)

---

## Project Structure

```text
SEC_Quiz/
├── bin/                      # Compiled Java .class files
├── questions/                # Topic-wise and custom generated .csv quiz files
│   └── BASIC_SCIENCE.csv
├── src/
│   ├── App.java              # Main CLI entry point, quiz menu, and leaderboard system
│   ├── Question.java         # Question entity model
│   ├── QuestionLoader.java   # Custom CSV file loader reading from questions/
│   ├── QuizGenerator.java    # Generates custom .csv quiz files from user input
│   ├── QuizRunner.java       # Runs quiz attempts, validates answers, and tracks question/total time
│   └── User.java             # User management and score/progress tracking
├── .gitignore
├── README.md
└── CONTRIBUTING.md
```

---

## Installation & Execution Instructions

### 1. Prerequisites
Ensure the following tools are installed and configured in your system `PATH`:
- **Java Development Kit (JDK 17 or higher):** Verify by running `java -version` and `javac -version` in your terminal.
- **Git:** Verify by running `git --version`.

### 2. Clone the Repository
Open your terminal (PowerShell/Command Prompt on Windows, or Bash/Zsh on Linux/macOS) and run:
```bash
git clone https://github.com/apigituser/SEC_Quiz.git
cd SEC_Quiz
```

### 3. Compile the Java Source Files
Compile all `.java` files from `src/` into the `bin/` output directory:

- **On Windows (PowerShell / CMD):**
  ```powershell
  javac -d bin src\*.java
  ```
- **On Linux / macOS:**
  ```bash
  javac -d bin src/*.java
  ```

### 4. Run the Application
Execute the compiled `App` class from the project root directory (`SEC_Quiz/`) so it can locate the `questions/` folder:
```bash
java -cp bin App
```

> **Note:** Always run `java -cp bin App` from the root `SEC_Quiz/` directory rather than inside `src/` or `bin/`, otherwise the program will not find the `questions/` directory.

---

## Sample Output

```text
=== ONLINE QUIZ SYSTEM ===
1. Start Quiz
2. View Quiz Leaderboard
3. Generate Quiz
4. Exit
Enter your choice: 1

====== SELECT A QUIZ ======
1. BASIC_SCIENCE
2. GENERAL_KNOWELEDGE
3. COLOR QUIZ
4. COMPUTER_BASICS
5. HISTORY_AND_GEOGRAPHY
6. SPORTS_TRIVIA
Enter choice (1-6): 3

Enter your name: Sanil

Welcome, Sanil! Starting COLOR QUIZ...

========================================
          ONLINE QUIZ STARTED
========================================

1. What color is the sky?

(A) BLACK
(B) BLUE
(C) GREEN
(D) PINK

Enter your answer (A/B/C/D): B
Result: Correct!

========================================
              QUIZ RESULTS
========================================
Total Questions : 1
Correct Answers : 1
Final Percentage: 100.0%
Total Time Taken: 6.7 seconds
Time Taken for each question:
1 -> 6.69s
========================================

=== LEADERBOARD: COLOR QUIZ ===
1. Sanil - 1/1
========================================

Do you want to attempt another quiz? (Y/N): n
Exiting Online Quiz System. Goodbye!
```
