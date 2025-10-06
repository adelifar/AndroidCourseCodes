package ir.mehdiadeli.a37_studentdatabaseproejct;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ir.mehdiadeli.a37_studentdatabaseproejct.adapter.StudentAdapter;
import ir.mehdiadeli.a37_studentdatabaseproejct.databinding.ActivityMainBinding;
import ir.mehdiadeli.a37_studentdatabaseproejct.db.Student;
import ir.mehdiadeli.a37_studentdatabaseproejct.handlers.MainActivityClickHandlers;
import ir.mehdiadeli.a37_studentdatabaseproejct.viewmodel.MyViewModel;

public class MainActivity extends AppCompatActivity {
    private List<Student> students = new ArrayList<>();
    private StudentAdapter adapter;
    private ActivityMainBinding mainBinding;
    MainActivityClickHandlers handlers;

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
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);
//        viewModel.addNewStudent(new Student("Adeli","16.3"));

        adapter = new StudentAdapter(students);
        viewModel.getAllStudents().observe(this, stdList -> {
            students.clear();
            students.addAll(stdList);
            adapter.setStudents(stdList);
        });
        handlers=new MainActivityClickHandlers(this);
        mainBinding.setHandler(handlers);
        mainBinding.recycler.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.recycler.setHasFixedSize(true);
        mainBinding.recycler.setAdapter(adapter);
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Student student=students.get(viewHolder.getBindingAdapterPosition());
                viewModel.deleteStudent(student);
                Toast.makeText(MainActivity.this, "دانش آموز "+student.getName()+" حذف شد", Toast.LENGTH_SHORT).show();
            }
        });
        itemTouchHelper.attachToRecyclerView(mainBinding.recycler);

    }
}