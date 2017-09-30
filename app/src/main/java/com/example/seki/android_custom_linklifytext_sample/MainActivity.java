package com.example.seki.android_custom_linklifytext_sample;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            final ClickableTextFragment clickableTextFragment = ClickableTextFragment.getInstance();
            new ClickableTextPresenter(clickableTextFragment);
            fragmentTransaction.replace(R.id.fragment_container, clickableTextFragment, "clickable");
            fragmentTransaction.commit();
        }
    }
}
