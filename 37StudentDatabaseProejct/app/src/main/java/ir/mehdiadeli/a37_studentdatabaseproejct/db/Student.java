package ir.mehdiadeli.a37_studentdatabaseproejct.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity()
public class Student {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String average;

    public Student(String name, String average) {
        this.name = name;
        this.average = average;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }
}
