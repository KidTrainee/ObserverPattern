package com.example.binh.observerpattern;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class FirstFragment extends Fragment implements Observer{


    private TextView textView;
    private FragmentImplementingListener listener;

    public FirstFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (FragmentImplementingListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.getClass().getSimpleName() + "\t" + e.getMessage());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        textView = view.findViewById(R.id.fragment_first_text_view);
        SecondFragment secondFragment = new SecondFragment();
        getChildFragmentManager().beginTransaction().add(R.id.fragment_first_fl, secondFragment).commit();
        listener.onFinish(secondFragment);
        return view;
    }

    @Override
    public void update(boolean checked) {
        textView.setText(checked ? "ON" : "OFF");
    }

    public interface FragmentImplementingListener {
        void onFinish(Observer observer);
    }
}
