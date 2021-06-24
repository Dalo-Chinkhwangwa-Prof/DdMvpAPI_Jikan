package com.dynamicdevz.ddanimeapp.model.network;
import com.dynamicdevz.ddanimeapp.model.JikanResponse;
import com.dynamicdevz.ddanimeapp.model.JikanResult;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class JikanNetwork {

    //1. constructor should be private
    private JikanNetwork(){}

    //2. private static instance
    private static JikanNetwork instance = null;
    //3. static getter for instance

    public static JikanNetwork getInstance() {
        //if instance is null create new instance
        if(instance == null){
            instance = new JikanNetwork();
        }
        return  instance;
    }
    private static final String BASE_URL = "https://api.jikan.moe/";
    private static String END_POINT = "v3/search/anime?";
    private HttpURLConnection urlConnection;

    public List<JikanResult> searchJikan(String query) throws Exception {

        URL jikanURL = new URL(BASE_URL + END_POINT + "q=" + query);

        urlConnection = (HttpURLConnection)jikanURL.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();

        BufferedReader bReader = new BufferedReader(
                new InputStreamReader(urlConnection.getInputStream())
        );

        String line;
        StringBuilder sBuilder = new StringBuilder();

        while((line = bReader.readLine())!= null){
            sBuilder.append(line);
        }
        urlConnection.disconnect();
        Gson gson = new Gson();
        JikanResponse response = gson.fromJson(sBuilder.toString(), JikanResponse.class);

        return response.getResults();
    }

}








