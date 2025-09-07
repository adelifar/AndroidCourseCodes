package ir.mehdiadeli.a35listdatabinding.viewModel;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import ir.mehdiadeli.a35listdatabinding.model.User;

public class MyViewModel extends ViewModel {
    private List<User> users;

    public MyViewModel() {
       users=new ArrayList<>();
        users.add(new User("Mehdi","Mehdi@gmail.com"));
        users.add(new User("John","John@yahoo.com"));
        users.add(new User("Jack","jack@ymail.com"));
        users.add(new User("Liz","Liz@gmail.com"));
    }

    public List<User> getUsers() {
        return users;
    }
}
