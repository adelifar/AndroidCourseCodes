package ir.mehdiadeli.a44_navigation;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ir.mehdiadeli.a44_navigation.databinding.FragmentSecondBinding;


public class SecondFragment extends Fragment {
FragmentSecondBinding binding;

    public SecondFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    binding= DataBindingUtil.inflate(inflater,R.layout.fragment_second,container,false);
    binding.secondButton.setOnClickListener(view -> {
        Navigation.findNavController(view).navigateUp();
    });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}