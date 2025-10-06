package ir.mehdiadeli.a37_studentdatabaseproejct.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ir.mehdiadeli.a37_studentdatabaseproejct.db.Student;
import ir.mehdiadeli.a37_studentdatabaseproejct.repository.MyRepository;

//viewModel has not context
//AndroidViewModel
public class MyViewModel extends AndroidViewModel {
    private MyRepository repository;
    private LiveData<List<Student>> allStudents;

    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new MyRepository(application);
    }

    public LiveData<List<Student>> getAllStudents() {
        allStudents= repository.getAllStudents();
        return allStudents;
    }
    public void addNewStudent(Student student){repository.addStudent(student);}
    public void deleteStudent(Student student){repository.deleteStudent(student);}
}
