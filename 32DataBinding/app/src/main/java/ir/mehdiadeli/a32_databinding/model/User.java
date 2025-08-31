package ir.mehdiadeli.a32_databinding.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import ir.mehdiadeli.a32_databinding.BR;

public class User extends BaseObservable {
    String name;

    public User(String name) {
        this.name = name;
    }

    public User() {
    }
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}
