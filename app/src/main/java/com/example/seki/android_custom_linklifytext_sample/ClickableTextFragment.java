package com.example.seki.android_custom_linklifytext_sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ClickableTextFragment extends Fragment implements ClickableTextPresenter.View {

    ClickableTextPresenter mPresenter;

    EditText mClickableStrings;
    EditText mText;
    Button mSubmitButton;

    RecyclerListAdapter mListAdapter;

    public static ClickableTextFragment getInstance() {
        return new ClickableTextFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_clickable_text, parent, false);
        initRecyclerView(rootView);

        mClickableStrings = (EditText) rootView.findViewById(R.id.clickable_strings);
        mText = (EditText)rootView.findViewById(R.id.text);
        mSubmitButton = (Button)rootView.findViewById(R.id.submit_button);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String clickableStrings = mClickableStrings.getText().toString();
                final String text = mText.getText().toString();
                mPresenter.onClickSubmit(clickableStrings, text);
            }
        });


        return rootView;
    }

    private void initRecyclerView(View rootView) {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        final RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.recycler_list);
        recyclerView.setLayoutManager(layoutManager);

        mListAdapter = new RecyclerListAdapter();
        recyclerView.setAdapter(mListAdapter);
        recyclerView.setHasFixedSize(false);

        final DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void setPresenter(ClickableTextPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void addData(Spannable text) {
        final ListData data = new ListData(text);
        mListAdapter.addData(data);
    }

    @Override
    public void clearInputText() {
        mClickableStrings.getText().clear();
        mText.getText().clear();
    }

    @Override
    public void showTextEmptyMessage() {
        Toast.makeText(getActivity(), "please input text", Toast.LENGTH_SHORT).show();
    }
}
