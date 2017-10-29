package com.example.seki.androidCustomLinklifytextSample;

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Spannable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ClickableTextFragment: Fragment(), ClickableTextPresenter.View {

    private var mPresenter: ClickableTextPresenter? = null

    private var mClickableStrings: EditText? = null
    private var mText: EditText? = null
    private var mSubmitButton: Button? = null

    private var mListAdapter: RecyclerListAdapter? = null

    companion object {
        fun getInstance() = ClickableTextFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView = inflater.inflate(R.layout.fragment_clickable_text, parent, false)
        initRecyclerView(rootView)

        mClickableStrings = rootView.findViewById(R.id.clickable_strings)
        mText = rootView.findViewById(R.id.text)
        mSubmitButton = rootView.findViewById(R.id.submit_button)

        mSubmitButton!!.setOnClickListener({_ ->
                val clickableStrings = mClickableStrings!!.text.toString()
                val text = mText!!.text.toString()
                mPresenter!!.onClickSubmit(clickableStrings, text)
        })


        return rootView
    }

    private fun initRecyclerView(rootView: View) {
        val layoutManager = LinearLayoutManager(activity)

        val recyclerView = rootView.findViewById<RecyclerView>(R.id.recycler_list)
        recyclerView.layoutManager = layoutManager

        mListAdapter = RecyclerListAdapter()
        recyclerView.adapter = mListAdapter
        recyclerView.setHasFixedSize(false)

        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, layoutManager.orientation)
        recyclerView.addItemDecoration(dividerItemDecoration)
    }

    override fun setPresenter(presenter: ClickableTextPresenter) {
        mPresenter = presenter
    }

    override fun addData(text: Spannable) {
        val data = ListData(text)
        mListAdapter!!.addData(data)
    }

    override fun clearInputText() {
        mClickableStrings!!.text.clear()
        mText!!.text.clear()
    }

    override fun showTextEmptyMessage() {
        Toast.makeText(activity, "please input text", Toast.LENGTH_SHORT).show()
    }
}
