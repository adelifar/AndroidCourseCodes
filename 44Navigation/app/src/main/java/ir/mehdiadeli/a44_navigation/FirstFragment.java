package ir.mehdiadeli.a44_navigation;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ir.mehdiadeli.a44_navigation.databinding.FragmentFirstBinding;


public class FirstFragment extends Fragment {

  FragmentFirstBinding binding;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_first,container,false);
        binding.btn1.setOnClickListener(view -> {
            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_firstFragment_to_secondFragment);
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}