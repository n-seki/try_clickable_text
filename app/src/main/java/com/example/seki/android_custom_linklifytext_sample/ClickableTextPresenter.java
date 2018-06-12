package com.example.seki.android_custom_linklifytext_sample;

import android.text.Spannable;

import com.example.seki.android_custom_linklifytext_sample.clickableString.ClickableString;

public class ClickableTextPresenter {

    final View mView;

    public interface View {
        void setPresenter(ClickableTextPresenter presenter);
        void addData(Spannable text);
        void clearInputText();
        void showTextEmptyMessage();
    }

    public ClickableTextPresenter(View v) {
        mView = v;
        mView.setPresenter(this);
    }

    public void onClickSubmit(String clickableStrings, String text) {
        if (text.isEmpty()) {
            mView.showTextEmptyMessage();
            mView.clearInputText();
            return;
        }

        mView.addData(ClickableString.create(clickableStrings, text));
        mView.clearInputText();
    }
}
