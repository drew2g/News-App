package com.example.drew2g.newsapp.utilities;

import android.provider.BaseColumns;

/**
 * Created by nyand on 7/28/2017.
 */

public class Contract {

    public static class TABLE_NEWS implements BaseColumns {
        public static final String TABLE_NAME = "news_articles";

        public static final String COLUMN_NAME_HEADLINE = "headline";
        public static final String COLUMN_NAME_BODY = "description";
        public static final String COLUMN_NAME_URL = "url";
        public static final String COLUMN_NAME_TIME = "time";
        public static final String COLUMN_NAME_THUMBNAIL = "thumbnail";
    }

}
