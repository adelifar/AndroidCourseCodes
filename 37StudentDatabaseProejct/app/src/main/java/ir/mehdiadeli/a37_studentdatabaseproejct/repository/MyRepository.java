package ir.mehdiadeli.a37_studentdatabaseproejct.repository;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ir.mehdiadeli.a37_studentdatabaseproejct.db.MyDatabase;
import ir.mehdiadeli.a37_studentdatabaseproejct.db.Student;
import ir.mehdiadeli.a37_studentdatabaseproejct.db.StudentDAO;

public class MyRepository {
    private StudentDAO studentDAO;
    ExecutorService executor;

    public MyRepository(Application application) {
        MyDatabase database=MyDatabase.getInstance(application);
        this.studentDAO = database.getStudentDao();
        executor= Executors.newSingleThreadExecutor();
    }
    public void addStudent(Student student){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                studentDAO.insert(student);
            }
        });

    }
    public void deleteStudent(Student student){
        executor.execute(()-> studentDAO.delete(student)); //lambda expression

    }
    public LiveData< List<Student>> getAllStudents(){
        return studentDAO.getAllStudents();
    }
}
