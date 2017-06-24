package com.example.drew2g.newsapp.data;

/**
 * Created by nyand on 6/21/2017.
 */
import android.content.Context;

public class NewsPreferences {
    private static final String DEFAULT_SOURCE = "associated-press";

    public static String getPreferredSource(Context context) {
        return getDefaultSource();
    }

    public static String getDefaultSource() {
        return DEFAULT_SOURCE;
    }
}
