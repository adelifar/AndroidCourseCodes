package ir.mehdiadeli.a36_database.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insert(User user);
    @Delete
    void delete(User user);
    @Query("select * from users")
    List<User> getAllUsers();
    @Update
    void update(User user);
}
