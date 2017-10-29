package com.example.seki.androidCustomLinklifytextSample;

import android.databinding.ObservableField;
import android.text.Spannable;

class ListData(text: Spannable) {
    val text: ObservableField<Spannable> = ObservableField()

    init {
        this.text.set(text)
    }
}
