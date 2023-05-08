package com.example.application.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.application.databinding.StartFragmentBinding;

public class StartFragment extends Fragment {

    private StartFragmentBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = StartFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListeners();
    }
    private void setListeners(){
        binding.buttonGetApi.setOnClickListener(view -> {
            Navigation.findNavController(binding.getRoot()).navigate(StartFragmentDirections.actionStartFragmentToMainFragment());
        });
    }
}
