package com.example.binh.observerpattern;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class ThirdFragment extends Fragment implements Subject {

    private static final String EXTRA_ARRAY_OBSERVER = "extra_array_observer";
    private static String EXTRA_LIST_OBSERVER = "extra_list_observer";
    private List<Observer> observers = new ArrayList<>();
    private ToggleButton button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);

        button = view.findViewById(R.id.toggle_button);
        button.setOnClickListener((v) -> notifyObservers());
        return view;
    }

    @Override
    public void register(Observer observer) {
        if (!observers.contains(observer))
            observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (final Observer observer : observers) {
            observer.update(button.isChecked());
        }
    }
}
