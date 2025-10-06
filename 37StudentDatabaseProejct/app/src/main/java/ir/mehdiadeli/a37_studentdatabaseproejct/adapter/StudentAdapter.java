package ir.mehdiadeli.a37_studentdatabaseproejct.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.mehdiadeli.a37_studentdatabaseproejct.R;
import ir.mehdiadeli.a37_studentdatabaseproejct.databinding.StudentItemBinding;
import ir.mehdiadeli.a37_studentdatabaseproejct.db.Student;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private List<Student> students;

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        StudentItemBinding itemBinding=
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext())
                                , R.layout.student_item,parent,false
                );
        return new StudentViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student currentStudent=students.get(position);
        holder.studentBinding.setStudent(currentStudent);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        StudentItemBinding studentBinding;

        public StudentViewHolder(@NonNull StudentItemBinding binding) {
            super(binding.getRoot());
            this.studentBinding=binding;
        }
    }

    public void setStudents(List<Student> students) {
        this.students = students;
        notifyDataSetChanged();
    }
}
