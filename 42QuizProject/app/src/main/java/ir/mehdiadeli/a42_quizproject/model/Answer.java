package ir.mehdiadeli.a42_quizproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Answer {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("questionId")
    @Expose
    private int questionId;
    @SerializedName("selected_option")
    @Expose
    private int selectedOption;

    public Answer() {
    }

    public Answer( String username, int questionId, int selectedOption) {
        this.id = id;
        this.username = username;
        this.questionId = questionId;
        this.selectedOption = selectedOption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(int selectedOption) {
        this.selectedOption = selectedOption;
    }
}
