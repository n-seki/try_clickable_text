package com.example.seki.androidCustomLinklifytextSample;

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            val clickableTextFragment = ClickableTextFragment.getInstance()
            ClickableTextPresenter(clickableTextFragment)
            fragmentTransaction.replace(R.id.fragment_container, clickableTextFragment, "clickable")
            fragmentTransaction.commit()
        }
    }
}
