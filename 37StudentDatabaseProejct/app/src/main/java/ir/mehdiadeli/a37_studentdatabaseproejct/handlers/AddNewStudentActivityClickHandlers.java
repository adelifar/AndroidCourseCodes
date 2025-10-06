package ir.mehdiadeli.a37_studentdatabaseproejct.handlers;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import ir.mehdiadeli.a37_studentdatabaseproejct.MainActivity;
import ir.mehdiadeli.a37_studentdatabaseproejct.db.Student;
import ir.mehdiadeli.a37_studentdatabaseproejct.viewmodel.MyViewModel;

public class AddNewStudentActivityClickHandlers {
    private Student student;
    private Context context;
private MyViewModel viewModel;
    public AddNewStudentActivityClickHandlers(Student student, Context context, MyViewModel viewModel) {
        this.student = student;
        this.context = context;
        this.viewModel = viewModel;
    }

    public void onAddClicked(View view){
        if (student.getName()==null || student.getAverage()==null){
            Toast.makeText(context, "لطفا فیلدها را پر کنید!", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent=new Intent(context, MainActivity.class);
//        intent.putExtra("name",student.getName())
        viewModel.addNewStudent(student);
        context.startActivity(intent);
    }
}
