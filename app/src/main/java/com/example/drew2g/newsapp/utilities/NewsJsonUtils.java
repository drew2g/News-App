package com.example.drew2g.newsapp.utilities;

import android.content.ContentValues;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Created by nyand on 6/23/2017.
 */

public class NewsJsonUtils {

    public static String[] getNewsFromJSON(Context context, String JsonStr) throws JSONException {
        String[] parsedNewsData = null;

        final String news_articles = "articles";

        JSONObject NewsJson = new JSONObject(JsonStr); //get entire json object response

        //validation here

        JSONArray newsArray = NewsJson.getJSONArray(news_articles); //get array in entire response with key = articles
        parsedNewsData = new String[newsArray.length()];

        for (int i = 0; i < newsArray.length(); i++) {
            String author = "author";
            String title = "title";
            String description = "description";
            String image = "urlToImage";
            String totalString = "";

            JSONObject article = newsArray.getJSONObject(i);

            String Jauthor = article.getString(author);
            String Jtitle = article.getString(title);
            String Jdescription = article.getString(description);
            String Jimage = article.getString(image);


            totalString =
                    Jtitle+ "\n\n"+
                    Jauthor+ "\n"+
                    Jdescription;

            parsedNewsData[i]=totalString;
        }

        return parsedNewsData;
    }
}
