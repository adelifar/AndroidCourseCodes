package ir.mehdiadeli.a37_studentdatabaseproejct.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDAO {
    //crud
    //insert
    @Insert
    void insert(Student student);

    @Delete
    void delete(Student student);
    @Query("select * from student")
    LiveData< List<Student>> getAllStudents();
}
