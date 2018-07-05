package com.example.binh.observerpattern;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FirstFragment.FragmentImplementingListener {

    private ThirdFragment thirdFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vp = findViewById(R.id.view_pager);

        FirstFragment firstFragment = new FirstFragment();
        thirdFragment = new ThirdFragment();

        thirdFragment.register(firstFragment);
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(),
                new Fragment[] {firstFragment, thirdFragment});
        vp.setAdapter(adapter);
    }

    @Override
    public void onFinish(Observer observer) {
        thirdFragment.register(observer);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        private final Fragment[] fragments;

        public MyPagerAdapter(FragmentManager fm, Fragment[] fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int pos) {
            return fragments[pos];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }
    }
}

