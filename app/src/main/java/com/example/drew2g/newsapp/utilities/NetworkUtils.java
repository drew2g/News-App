package com.example.drew2g.newsapp.utilities;

/**
 * Created by nyand on 6/21/2017.
 */
import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public final class NetworkUtils {
    private static final String TAG = NetworkUtils.class.getSimpleName();

    private static final String DYNAMIC_NEWS_URL =
            "https://newsapi.org/v1/articles";


    private static final String BASE_URL = DYNAMIC_NEWS_URL;

    private static final String format = "json";
    final static String QUERY_PARAM = "source";
    final static String API_KEY = "apiKey";
    final static String KEY = "f1aeec25f5a0493188c6d8b639b3912e";

    //BuildURL===================================================================
    public static URL buildUrl(String sourceQuery) {
        Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter(QUERY_PARAM, sourceQuery)
                .appendQueryParameter(API_KEY, KEY)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Log.v(TAG, "Built URI " + url);

        return url;
    }

    //GetRestponseFromHTTPURL====================================================
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }



}

