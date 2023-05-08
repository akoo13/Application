package com.example.application.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.application.model.Brewery;
import com.example.application.model.RetrofitInstance;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    private CompositeDisposable disposables = new CompositeDisposable();
    public MutableLiveData<List<Brewery>> breweryLiveData = new MutableLiveData<>();


    public void getBreweries(){
        disposables.add(
                RetrofitInstance.getBreweryService().getBreweries()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(breweries -> {
                            breweryLiveData.setValue(breweries);
                        })
        );
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }
}
