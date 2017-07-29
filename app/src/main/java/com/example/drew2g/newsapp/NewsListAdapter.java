package com.example.drew2g.newsapp;

/**
 * Created by nyand on 7/28/2017.
 */

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ItemHolder> {
    private Cursor cursor;
    private ItemClickListener listener;
    private String TAG = "newslistadapter";

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    public interface ItemClickListener {
        void onItemClick(int pos, String headline, String body, String time, long id, View view);
    }

    class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView headline;
        TextView body;
        TextView time;
        String head;
        String bod;
        String tim;
        long id;

         ItemHolder(View view) {
             super(view);
             //descr = (TextView) view.findViewById(R.id.description);
             //due = (TextView) view.findViewById(R.id.dueDate);
             headline = (TextView) view.findViewById(R.id.headline);
             body = (TextView) view.findViewById(R.id.body);
             time = (TextView) view.findViewById(R.id.time);
             view.setOnClickListener(this);
         }

        public void bind(ItemHolder holder, int pos) {
            cursor.moveToPosition(pos);
            id = cursor.getLong(cursor.getColumnIndex(Contract.TABLE_TODO._ID));

            head = cursor.getString(cursor.getColumnIndex(Contract.TABLE_TODO.COLUMN_NAME_DUE_DATE));
            bod = cursor.getString(cursor.getColumnIndex(Contract.TABLE_TODO.COLUMN_NAME_DESCRIPTION));
            tim = cursor.getInt(cursor.getColumnIndex(Contract.TABLE_TODO.COLUMN_NAME_COMPLETED));

            headline.setText(head);
            body.setText(bod);
            time.setText(tim);
            holder.itemView.setTag(id);

        }

         @Override
         public void onClick(View v) {

         }
     }
}



}
