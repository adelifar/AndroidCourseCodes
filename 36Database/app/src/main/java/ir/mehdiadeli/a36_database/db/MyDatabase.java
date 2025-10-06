package ir.mehdiadeli.a36_database.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract UserDAO getUserDao();

    //singleton
    private static MyDatabase instance;

    public synchronized static MyDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, "Mydatabase")
                    .fallbackToDestructiveMigration(false)
                    .allowMainThreadQueries().build();
        }
        return instance;
    }
}
