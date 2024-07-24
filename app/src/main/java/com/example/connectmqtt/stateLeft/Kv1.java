package com.example.connectmqtt.stateLeft;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.connectmqtt.R;
import com.example.connectmqtt.databinding.FragmentKv1Binding;




public class Kv1 extends Fragment {
    private FragmentKv1Binding binding ;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentKv1Binding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewPager2 viewPager2 = requireActivity().findViewById(R.id.vpg2);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}