package ir.mehdiadeli.a42_quizproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import ir.mehdiadeli.a42_quizproject.databinding.ActivityMainBinding;
import ir.mehdiadeli.a42_quizproject.model.Answer;
import ir.mehdiadeli.a42_quizproject.model.Question;
import ir.mehdiadeli.a42_quizproject.viewmodel.QuizViewModel;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private QuizViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(QuizViewModel.class);
        viewModel.getQuestionList().observe(this, questions -> {
            viewModel.setQuestions(questions);
            binding.setQuestion(questions.get(0));
        });
        binding.nextQuestion.setOnClickListener(view -> handleClick(viewModel));
    }

    private void handleClick(QuizViewModel viewModel) {
        if (binding.usernameEdit.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();
            return;
        }
        if (binding.nextQuestion.getText().toString().equals(getString(R.string.finish_text))){
            showAnswers();
            return;
        }
        binding.usernameEdit.setEnabled(false);
        saveAnswer(binding.getQuestion(), binding.optionsRadio.getCheckedRadioButtonId());
        binding.optionsRadio.clearCheck();
        viewModel.getNextQuestion().observe(MainActivity.this, question -> {
                    if (question.getId() != binding.getQuestion().getId())
                        binding.setQuestion(question);
                    else binding.nextQuestion.setText(R.string.finish_text);
                }

        );
    }

    private void showAnswers() {
       Intent intent=new Intent(MainActivity.this,ResultActivity.class);
       intent.putExtra(getString(R.string.username),binding.usernameEdit.getText().toString());
       startActivity(intent);
    }

    private void saveAnswer(Question question, int checkedRadioButtonId) {
        var username=binding.usernameEdit.getText().toString();
        int selectedAnswer=getSelectedOption(checkedRadioButtonId);
        var answer=new Answer(username,question.getId(),selectedAnswer);
        viewModel.addAnswer(answer);
    }

    private int getSelectedOption(int checkedRadioButtonId) {
        int selectedAnswer=0;
        if (checkedRadioButtonId==binding.option1.getId())
            selectedAnswer=1;
        else if (checkedRadioButtonId==binding.option2.getId())
            selectedAnswer=2;
        else if (checkedRadioButtonId == binding.option3.getId()) selectedAnswer = 3;
        else if (checkedRadioButtonId == binding.option4.getId()) selectedAnswer = 4;
        return selectedAnswer;
    }
}