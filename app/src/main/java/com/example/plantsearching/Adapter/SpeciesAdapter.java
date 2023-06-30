package com.example.plantsearching.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class SpeciesAdapter extends ArrayAdapter<String> {
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(String item);
    }

    public SpeciesAdapter(Context context, ArrayList<String> data) {
        super(context, android.R.layout.simple_list_item_1, data);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(getItem(position));
                }
            }
        });
        return view;
    }
}