package com.dynamicdevz.ddanimeapp.presenter;

import com.dynamicdevz.ddanimeapp.model.JikanResult;

import java.util.List;

public interface Presenter {

    interface JikanPresenter {
        void getJikanResults(String query);
    }

    interface JikanView {
        void displayResults(List<JikanResult> jikanResults);
        void displayError(String error);
    }


}
