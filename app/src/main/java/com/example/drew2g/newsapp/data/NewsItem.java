package com.example.drew2g.newsapp.data;

/**
 * Created by nyand on 7/28/2017.
 */

public class NewsItem {

    private String body;

    private String headline;

    private String url;

    private String time;

    public NewsItem(String headline, String body){
        this.headline = headline;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
