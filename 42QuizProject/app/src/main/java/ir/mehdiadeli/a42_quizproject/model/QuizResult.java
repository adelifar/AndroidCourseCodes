package ir.mehdiadeli.a42_quizproject.model;

public class QuizResult {
    private int correct;
    private int wrong;
    private int total;

    public QuizResult() {
    }

    public QuizResult(int correct, int wrong, int total) {
        this.correct = correct;
        this.wrong = wrong;
        this.total = total;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
