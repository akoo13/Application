package com.example.application.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.application.databinding.MainFragmentBinding;
import com.example.application.model.Brewery;
import com.example.application.viewmodel.MainViewModel;

public class MainFragment extends Fragment {

    private MainFragmentBinding binding;
    private BreweryAdapter adapter = new BreweryAdapter();
    private MainViewModel viewModel = new MainViewModel();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = MainFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        setObservers();
        setListeners();
    }

    private void setListeners(){
        adapter.setOnItemClickListener(new BreweryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Brewery brewery) {
                Navigation.findNavController(binding.getRoot()).navigate(MainFragmentDirections.actionMainFragmentToDetailFragment(
                        brewery.brewery_type, String.valueOf(brewery.address_1), brewery.country, String.valueOf(brewery.phone), String.valueOf(brewery.website_url)
                ));
            }
        });
    }

    private void init(){
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.recyclerBreweries.setAdapter(adapter);
        viewModel.getBreweries();
    }

    private void setObservers(){
        viewModel.breweryLiveData.observe(getViewLifecycleOwner(), breweries -> {
            adapter.updateList(breweries);
        });
    }
}
