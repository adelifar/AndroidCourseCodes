package ir.mehdiadeli.a34_viewmodel.viewmodel;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
//    int counter=0;
    private MutableLiveData<Integer> counter=new MutableLiveData<>(0);
    public void increment(View view){
//        counter++;
        int currentValue=counter.getValue()!=null?counter.getValue():0;
        counter.setValue(currentValue+1);
    }

    public LiveData<Integer> getCounter() {
        return counter;
    }
}
