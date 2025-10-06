package ir.mehdiadeli.a37_studentdatabaseproejct.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class}, version = 1)
//migration
public abstract class MyDatabase extends RoomDatabase {
    public abstract StudentDAO getStudentDao();

    //singleton pattern
    private static MyDatabase instance;

    public synchronized static MyDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            MyDatabase.class, "myDatabase")
                    .fallbackToDestructiveMigration(false)
                    .build();
        }
        return instance;
    }
}
