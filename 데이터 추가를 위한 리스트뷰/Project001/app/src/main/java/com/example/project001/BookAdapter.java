package com.example.project001;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by ehclub on 2017-05-29.
 */

public class BookAdapter extends BaseAdapter {
    private ArrayList<Book> books = new ArrayList<>();
    Context context;
    LayoutInflater inflacter;
    int layout;
    public  BookAdapter(Context context, int layout){
        this.context = context;
        inflacter = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout = layout;
    }
    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflacter.inflate(layout,parent,false);
        }

        TextView tv_title = (TextView)convertView.findViewById(R.id.tv_title);
        tv_title.setText(books.get(position).title);

        TextView tv_author = (TextView)convertView.findViewById(R.id.tv_author);
        tv_author.setText(books.get(position).author);

        return convertView;
    }

    public  void addBook(Book book){
        books.add(book);
    }
}