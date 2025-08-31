package ir.mehdiadeli.a30_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_second,container,false);
        Button secondButton=view.findViewById(R.id.secondFragmentButton);
        secondButton.setOnClickListener(view1 ->
                Toast.makeText(getActivity(), "Bye from second Fragment", Toast.LENGTH_SHORT).show());
        return view;
    }
}