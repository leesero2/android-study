package com.example.project001;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    BookAdapter bookAdapter;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.lv);

        bookAdapter = new BookAdapter(this,R.layout.item);
        lv.setAdapter(bookAdapter);

        //임시 리스트 어뎁터 데이터
//        bookAdapter.addBook(new Book("C언어","언휴"));
//        bookAdapter.addBook(new Book("Java","EH"));
//        bookAdapter.addBook(new Book("파이썬","언제나"));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                ListView lv = (ListView)parent;
                Book book = (Book)lv.getItemAtPosition(position);
                TextView tv_title = (TextView)findViewById(R.id.tv_title);
                tv_title.setText(book.getTitle());
                TextView tv_author = (TextView)findViewById(R.id.tv_author);
                tv_author.setText(book.getAuthor());
            }
        });
    }
    public  void addButtonClick(View view){
        EditText et_title = (EditText)findViewById(R.id.et_title) ;
        String title = et_title.getText().toString();
        EditText et_author = (EditText)findViewById(R.id.et_author) ;
        String author = et_author.getText().toString();

        bookAdapter.addBook(new Book(title,author));
        et_title.setText("");
        et_author.setText("");
    }
}