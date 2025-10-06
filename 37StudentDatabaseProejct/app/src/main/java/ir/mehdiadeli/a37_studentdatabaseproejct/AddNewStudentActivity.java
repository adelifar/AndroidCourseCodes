package ir.mehdiadeli.a37_studentdatabaseproejct;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import ir.mehdiadeli.a37_studentdatabaseproejct.databinding.ActivityAddNewStudentBinding;
import ir.mehdiadeli.a37_studentdatabaseproejct.db.Student;
import ir.mehdiadeli.a37_studentdatabaseproejct.handlers.AddNewStudentActivityClickHandlers;
import ir.mehdiadeli.a37_studentdatabaseproejct.viewmodel.MyViewModel;

public class AddNewStudentActivity extends AppCompatActivity {
private Student student;
ActivityAddNewStudentBinding binding;
AddNewStudentActivityClickHandlers handlers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_student);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding= DataBindingUtil.setContentView(this,R.layout.activity_add_new_student);
        student=new Student();
        binding.setStudent(student);
        MyViewModel viewModel=new ViewModelProvider(this).get(MyViewModel.class);
        handlers=new AddNewStudentActivityClickHandlers(student,this,viewModel);
        binding.setClickHandler(handlers);
    }
}