import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();

// Linux CLI Quiz Bank (compatible with Question.java)
        questions.add(new Question(1, "Which Linux command prints the full path of your current working directory?",
                "ls -l", "pwd", "cd ~", "whoami", 'B'));

        questions.add(new Question(2, "What permissions does 'chmod 754 script.sh' assign to owner, group, and others?",
                "Owner: rwx, Group: r-x, Others: r--",
                "Owner: rwx, Group: rw-, Others: r-x",
                "Owner: rw-, Group: r-x, Others: r--",
                "Owner: rwx, Group: r--, Others: r-x", 'A'));

        questions.add(new Question(3, "Which command searches recursively for 'error' with line numbers inside /var/log?",
                "find /var/log -text 'error'",
                "cat /var/log | sort 'error'",
                "grep -rn 'error' /var/log",
                "locate -n 'error' /var/log", 'C'));

        questions.add(new Question(4, "Which signal is sent by 'kill -9 <PID>' to forcefully terminate a process?",
                "SIGTERM (15)", "SIGINT (2)", "SIGHUP (1)", "SIGKILL (9)", 'D'));

        questions.add(new Question(5, "Which command displays disk space usage on mounted filesystems in human-readable units?",
                "du -s", "df -h", "free -m", "lsblk -f", 'B'));

        questions.add(new Question(6, "What does the '>>' redirection operator do in a Bash shell?",
                "Overwrites the target file with standard output",
                "Redirects standard error to /dev/null",
                "Appends standard output to a file without overwriting existing content",
                "Passes standard output to another command", 'C'));

        questions.add(new Question(7, "Which command creates a symbolic (soft) link named 'app_link' pointing to '/opt/app/run.sh'?",
                "ln -s /opt/app/run.sh app_link",
                "ln /opt/app/run.sh app_link",
                "cp -l /opt/app/run.sh app_link",
                "mv -s /opt/app/run.sh app_link", 'A'));

        questions.add(new Question(8, "Which command extracts a gzip-compressed tar archive named 'backup.tar.gz'?",
                "tar -czvf backup.tar.gz",
                "gzip -c backup.tar.gz",
                "unzip -x backup.tar.gz",
                "tar -xzvf backup.tar.gz", 'D'));

        questions.add(new Question(9, "Which command searches inside /home for all files ending with the '.log' extension?",
                "grep -f '*.log' /home",
                "find /home -type f -name '*.log'",
                "ls -R /home/*.log",
                "whereis *.log /home", 'B'));

        questions.add(new Question(10, "What is the purpose of the pipe operator '|' in Linux?",
                "Runs two commands in parallel in the background",
                "Executes the second command only if the first fails",
                "Sends stdout of the left command as stdin to the right command",
                "Saves command history to a hidden file", 'C'));

        QuizRunner runner = new QuizRunner();
        runner.startQuiz(questions, scanner);

        scanner.close();
    }
}