package com.dynamicdevz.ddanimeapp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dynamicdevz.ddanimeapp.databinding.JikanItemLayoutBinding;
import com.dynamicdevz.ddanimeapp.model.JikanResult;

import java.util.ArrayList;
import java.util.List;

public class JikanAdapter extends BaseAdapter {

    private List<JikanResult> results = new ArrayList<>();

    public void setResults(List<JikanResult> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return results.size();
    }

    @Override
    public JikanResult getItem(int i) {
        return results.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        JikanItemLayoutBinding binding = JikanItemLayoutBinding.inflate(
                LayoutInflater.from(
                        viewGroup.getContext()
                ),
                viewGroup,
                false
        );

        JikanResult result = results.get(i);
        binding.synopsisTextview.setText(result.getSynopsis());
        binding.titleTextview.setText(result.getTitle());

        Glide.with(binding.getRoot())
                .applyDefaultRequestOptions(RequestOptions.centerCropTransform())
                .load(result.getImageUrl())
                .into(binding.posterImageview);

        return binding.getRoot();
    }
}












