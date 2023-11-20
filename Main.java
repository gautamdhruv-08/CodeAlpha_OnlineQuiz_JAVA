
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private ArrayList<String> options;
    private int correctOptionIndex;

    public Question(String questionText, ArrayList<String> options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

class Quiz {
    private ArrayList<Question> questions;
    private int score;

    public Quiz(ArrayList<Question> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestionText());

            ArrayList<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Enter your choice (1-" + options.size() + "): ");
            int userChoice = scanner.nextInt();

            if (userChoice == question.getCorrectOptionIndex() + 1) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + (question.getCorrectOptionIndex() + 1) + ". " +
                        options.get(question.getCorrectOptionIndex()) + "\n");
            }
        }

        System.out.println("Quiz completed. Your score: " + score + "/" + questions.size());
    }
}

public class Main {
    public static void main(String[] args) {
        // Create questions
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", new ArrayList<>(
            List.of("London", "Paris", "Berlin")), 1));
        questions.add(new Question("Which programming language is this quiz written in?", new ArrayList<>(List.of("Java", "Python", "C++")), 0));
        // Add more questions as needed

        // Create quiz
        Quiz quiz = new Quiz(questions);

        // Start quiz
        quiz.startQuiz();
    }
}

