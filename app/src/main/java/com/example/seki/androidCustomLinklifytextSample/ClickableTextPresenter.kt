package com.example.seki.androidCustomLinklifytextSample;

import android.text.Spannable;

import com.example.seki.androidCustomLinklifytextSample.clickableString.ClickableString

class ClickableTextPresenter(v: View) {

    private var mView: View? = null

    interface View {
        fun setPresenter(presenter: ClickableTextPresenter)
        fun addData(text: Spannable)
        fun clearInputText()
        fun showTextEmptyMessage()
    }

    init {
        mView = v
        mView!!.setPresenter(this)
    }

    fun onClickSubmit(clickableStrings: String, text: String) {
        if (text.length <= 0) {
            mView!!.showTextEmptyMessage()
            mView!!.clearInputText()
            return
        }

        mView!!.addData(ClickableString.create(clickableStrings, text))
        mView!!.clearInputText()
    }
}
