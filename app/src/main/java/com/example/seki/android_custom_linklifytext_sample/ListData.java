package com.example.seki.android_custom_linklifytext_sample;

import android.databinding.ObservableField;
import android.text.Spannable;

public class ListData {
    public final ObservableField<Spannable> text = new ObservableField<>();

    public ListData(Spannable text) {
        this.text.set(text);
    }
}
