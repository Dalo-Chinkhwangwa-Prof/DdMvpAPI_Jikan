package com.dynamicdevz.ddanimeapp.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dynamicdevz.ddanimeapp.R;
import com.dynamicdevz.ddanimeapp.databinding.ActivityMainBinding;
import com.dynamicdevz.ddanimeapp.model.JikanResult;
import com.dynamicdevz.ddanimeapp.model.network.JikanNetwork;
import com.dynamicdevz.ddanimeapp.presenter.JikanPresenter;
import com.dynamicdevz.ddanimeapp.presenter.Presenter;
import com.dynamicdevz.ddanimeapp.view.adapter.JikanAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Presenter.JikanView {

    private Presenter.JikanPresenter presenter = new JikanPresenter(this);
    private ActivityMainBinding binding;
    private JikanAdapter adapter = new JikanAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.jikanListview.setAdapter(adapter);
        binding.loadingProgressbar.setVisibility(View.VISIBLE);
        presenter.getJikanResults("goku");
    }

    @Override
    public void displayResults(List<JikanResult> jikanResults) {
        hideProgressBar();
        runOnUiThread(() ->{
            adapter.setResults(jikanResults);
        });
    }

    private void hideProgressBar() {
        runOnUiThread(() -> {

            binding.loadingProgressbar.setVisibility(View.GONE);

        });
    }

    @Override
    public void displayError(String error) {
        hideProgressBar();
        runOnUiThread(() -> {
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        });

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}








