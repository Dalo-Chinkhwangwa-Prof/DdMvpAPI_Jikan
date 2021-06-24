package com.dynamicdevz.ddanimeapp.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dynamicdevz.ddanimeapp.R;
import com.dynamicdevz.ddanimeapp.model.JikanResult;
import com.dynamicdevz.ddanimeapp.model.network.JikanNetwork;
import com.dynamicdevz.ddanimeapp.presenter.JikanPresenter;
import com.dynamicdevz.ddanimeapp.presenter.Presenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Presenter.JikanView {

    private Presenter.JikanPresenter presenter = new JikanPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.getJikanResults("goku");
    }

    @Override
    public void displayResults(List<JikanResult> jikanResults) {
        for(int i = 0; i < jikanResults.size(); i ++){
            Log.d("TAG_X", "Item "+jikanResults.get(i).getTitle());
        }
    }

    @Override
    public void displayError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}








