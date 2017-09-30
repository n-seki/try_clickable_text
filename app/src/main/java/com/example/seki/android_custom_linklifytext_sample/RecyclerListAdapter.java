package com.example.seki.android_custom_linklifytext_sample;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ViewHolder> {

    final List<ListData> mData;

    public RecyclerListAdapter() {
        mData = new ArrayList<>();
    }

    static final class ViewHolder extends RecyclerView.ViewHolder {
        final ViewDataBinding binding;

        ViewHolder(View v) {
            super(v);
            ((TextView)v.findViewById(R.id.clickable_text)).setMovementMethod(LinkMovementMethod.getInstance());
            this.binding = DataBindingUtil.bind(v);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.binding.setVariable(com.example.seki.android_custom_linklifytext_sample.BR.data, mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addData(ListData data) {
        mData.add(0, data);
        notifyDataSetChanged();
    }
}
