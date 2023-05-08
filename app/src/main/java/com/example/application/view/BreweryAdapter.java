package com.example.application.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.databinding.ItemBreweryBinding;
import com.example.application.model.Brewery;

import java.util.ArrayList;
import java.util.List;

public class BreweryAdapter extends RecyclerView.Adapter<BreweryAdapter.BreweryViewHolder> {

    List<Brewery> breweryList = new ArrayList<>();
    private OnItemClickListener listener = null;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.listener = onItemClickListener;
    }
    public void updateList(List<Brewery> newList){
        breweryList = newList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public BreweryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BreweryViewHolder(
                ItemBreweryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BreweryViewHolder holder, int position) {
        holder.bind(breweryList.get(position));
    }

    @Override
    public int getItemCount() {
        return breweryList.size();
    }

    public class BreweryViewHolder extends RecyclerView.ViewHolder{
        private ItemBreweryBinding binding;
        public BreweryViewHolder(ItemBreweryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Brewery brewery){
            binding.textViewName.setText(brewery.name);
            binding.getRoot().setOnClickListener(view -> {
                if(listener!=null){
                    listener.onItemClick(brewery);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Brewery brewery);
    }
}
