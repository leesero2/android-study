package com.example.project001;

public class Book {
    String title;
    String author;
    public  String getTitle(){
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public  Book(String title, String author){
        this.title = title;
        this.author = author;
    }

}
