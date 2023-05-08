package com.example.application.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.application.databinding.DetailsFragmentBinding;

public class DetailFragment extends Fragment {

    private DetailsFragmentBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DetailsFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String brewery_type = getArguments().getString("brewery_type");
        binding.textViewBreweryType.setText(brewery_type);
        String address_1 = getArguments().getString("address_1");
        binding.textViewAddress.setText(address_1);
        String country = getArguments().getString("country");
        binding.textViewCountry.setText(country);
        String phone = getArguments().getString("phone");
        binding.textViewPhone.setText(phone);
        String website_url = getArguments().getString("website_url");
        binding.textViewWebsite.setText(website_url);

        binding.button.setOnClickListener(view1 -> {
            Navigation.findNavController(view).popBackStack();
        });
    }
}
