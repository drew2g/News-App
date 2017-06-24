package com.example.drew2g.newsapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import com.example.drew2g.newsapp.utilities.NetworkUtils;
import com.example.drew2g.newsapp.data.NewsPreferences;
import com.example.drew2g.newsapp.utilities.NewsJsonUtils;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.Menu;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView NewsTextView;
    private EditText search;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NewsTextView = (TextView) findViewById(R.id.news_data);
        progress = (ProgressBar) findViewById(R.id.progressBar);
        search = (EditText) findViewById(R.id.searchQuery);
        loadNewsData();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemNumber = item.getItemId();


        if (itemNumber == R.id.search) {
            String s = search.getText().toString();
            //FetchNews task = new FetchNews(s);
            NewsTextView.setText("");
            new FetchNews().execute(s);


        }
        return true;
    }

    private void loadNewsData() {
        String source = NewsPreferences.getPreferredSource(this);
        new FetchNews().execute(source);
    }

    public class FetchNews extends AsyncTask<String, Void, String[]> {

        @Override
        protected String[] doInBackground(String... params) {

            /* If there's no source, there's nothing to look up. */
            if (params.length == 0) {
                return null;
            }

            String source = params[0];
            URL newsRequestUrl = NetworkUtils.buildUrl(source);

            try {
                String jsonNewsResponse = NetworkUtils
                        .getResponseFromHttpUrl(newsRequestUrl);

                String[] simpleNewsData = NewsJsonUtils
                        .getNewsFromJSON(MainActivity.this, jsonNewsResponse);
                //String[] test = {"a","b","c"};
                //return test;
                //System.out.println(simpleNewsData);
                return simpleNewsData;


            } catch (Exception e) {

                e.printStackTrace();
                String except = "Oops... that's not a valid source\n" +
                        "Sources include: the-next-web, techcrunch, bbc-news, and more\n" +
                        "check this website for the full list\n" +
                        "https://newsapi.org/sources";
                String[] exceptArray = new String[1];
                exceptArray[0] = except;

                return exceptArray;
            }
        }

        @Override
        protected void onPostExecute(String[] newsData) {
            if (newsData != null) {
                /*
                 * Iterate through the array and append the Strings to the TextView. The reason why we add
                 * the "\n\n\n" after the String is to give visual separation between each String in the
                 * TextView. Later, we'll learn about a better way to display lists of data.
                 */
                for (String newsString : newsData) {
                    NewsTextView.append((newsString) + "\n\n\n");
                }
            }
        }
    }
}

