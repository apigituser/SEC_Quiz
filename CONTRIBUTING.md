# Contributing Guidelines & Collaboration Workflow

This document outlines the **individual contributions**, **branching strategy**, **pull requests**, and **code review process** followed by the team during the development of [`SEC_Quiz`](https://github.com/apigituser/SEC_Quiz).

---

## 1. Individual Contributions

### Vorundeep Singh — [`apigituser`](https://github.com/apigituser) (`feature-member1`)
1. **Quiz Generator (`QuizGenerator.java`):** Receives the quiz title, number of questions to include in the quiz, options, and the correct option from the user. Uses these parameters to generate a `.csv` file in the `questions/` directory containing all the quizzes.
2. **CSV File Interpreter (`QuestionLoader.java`):** A custom csv file loader reads the `.csv` files from the `questions/` directory and displays those questions during the quiz to the user.
3. **Timed Quiz Attempts (`QuizRunner.java`):** Specifies the total time taken by the user (in seconds) to attempt the entire quiz, as well as the time taken to attempt each question.

### Sanil Kumar — [`sanilkumar1108-ui`](https://github.com/sanilkumar1108-ui) (`feature-member2`)
1. **Leaderboard (`App.java`):** Implemented a leaderboard system that keeps track of the quiz score scored by the users. Users are ranked based on the quiz performance.
2. **User Management (`User.java`):** User management system allows different users to attempt the quizzes and save their progress. The leaderboard uses the user names during the quiz rankings.
3. **README.md and CONTRIBUTING.md:** Created comprehensive and detailed documentation for the project and wrote the individual contributions done by the team members.
4. **Cross-Platform Fix & Conflict Resolution (`src/App.java`):** Fixed directory file-name parsing (`entry.getName()`) for Windows/Linux compatibility and resolved the `APP_TITLE` merge conflict.

---

## 2. Branches

To keep the main codebase stable and allow parallel development without interfering with each other's work, the team followed a three-branch workflow:

| Branch Name | Owner / Role | Purpose |
| :--- | :--- | :--- |
| **`main`** | Shared (Protected Integration) | Holds stable, compiled, and peer-reviewed code ready for execution. Direct pushes were avoided in favor of Pull Requests. |
| **`feature-member1`** | Vorundeep Singh (`apigituser`) | Isolated development branch for the Quiz Generator, CSV File Interpreter, and Timed Quiz Attempts. |
| **`feature-member2`** | Sanil Kumar (`sanilkumar1108-ui`) | Isolated development branch for User Management, the Leaderboard system, cross-platform fixes, and project documentation. |

### Branching Rules Followed
- Each member worked exclusively on their assigned feature branch and made focused, descriptive commits.
- Before opening or updating a Pull Request, members synced their local branches with `main` (`git pull origin main`) to incorporate merged changes.

---

## 3. Pull Requests

All feature additions, bug fixes, merge conflict resolutions, and documentation updates were integrated into `main` through **Pull Requests (PRs)**:

1. **Feature Integration PRs (`feature-member1` -> `main` & `feature-member2` -> `main`):**
   - Separate Pull Requests were raised for core modules (`QuestionLoader`, `QuizRunner`, `User`, Leaderboard, `QuizGenerator`, and Timed Attempts) with descriptive titles summarizing the changes.
2. **Merge Conflict Demonstration & Resolution PR (`feature-member2` -> `main`):**
   - Both team members edited the same `APP_TITLE` constant in `src/App.java` concurrently on their respective feature branches.
   - After merging `feature-member1` into `main`, pulling `origin main` onto `feature-member2` triggered `CONFLICT (content): Merge conflict in src/App.java`.
   - The conflict markers (`<<<<<<< HEAD`, `=======`, `>>>>>>>`) were manually resolved to `=== ONLINE QUIZ SYSTEM ===`, committed (`b31c900`), and pushed to update the open PR before merging into `main` (`28caddd`).
3. **Final Documentation PR (`feature-member2` -> `main`):**
   - Submitted `README.md` and `CONTRIBUTING.md` via a final Pull Request to complete the repository documentation.

---

## 4. Code Reviews

Every Pull Request underwent peer review on GitHub before being merged into `main`:

- **Cross-Review Assignment:**
  - **Vorundeep Singh (`apigituser`)** acted as the reviewer for all Pull Requests opened from `feature-member2` (User Management, Leaderboard, cross-platform `entry.getName()` fix, `APP_TITLE` conflict resolution, and documentation).
  - **Sanil Kumar (`sanilkumar1108-ui`)** acted as the reviewer for all Pull Requests opened from `feature-member1` (CSV File Interpreter, Timed Quiz Attempts, and Quiz Generator).
- **Review Checklist:**
  - Verified that all `.java` files compiled cleanly (`javac -d bin src/*.java`) without syntax or runtime errors.
  - Confirmed cross-platform compatibility across Linux and Windows environments.
  - Ensured no leftover Git conflict markers (`<<<<<<<`, `=======`, `>>>>>>>`) or unintended `bin/*.class` conflicts existed before clicking **Approve** and **Merge pull request**.