package com.tosinso.a24_bookgrid.repository;

import android.content.Context;

import com.tosinso.a24_bookgrid.R;
import com.tosinso.a24_bookgrid.model.Book;

import java.util.ArrayList;

public class BookRepository {
    private ArrayList<Book> books;
    public BookRepository(Context context){
        books=new ArrayList<>();
        books.add(
                new Book(
                        context.getResources().getString(R.string.anakarnina)
                        ,R.drawable.anakarnina
                        ,R.raw.anakarnina));
        books.add(new Book(context.getResources().getString(R.string.badgir), R.drawable.badgir, R.raw.badgir));
        books.add(new Book(context.getResources().getString(R.string.big_gatsby), R.drawable.big_gatsby, R.raw.big_gatsby));
        books.add(new Book(context.getResources().getString(R.string.catch22), R.drawable.catch22, R.raw.catch22));
        books.add(new Book(context.getResources().getString(R.string.don), R.drawable.don, R.raw.don));
        books.add(new Book(context.getResources().getString(R.string.jenayat), R.drawable.jenayat, R.raw.jenayat));
        books.add(new Book(context.getResources().getString(R.string.khashm), R.drawable.khashm, R.raw.khashm));
        books.add(new Book(context.getResources().getString(R.string.mobi), R.drawable.mobi, R.raw.mobi));
        books.add(new Book(context.getResources().getString(R.string.nator), R.drawable.nator, R.raw.nator));
        books.add(new Book(context.getResources().getString(R.string.nineteen), R.drawable.nineteen, R.raw.nineteen));
        books.add(new Book(context.getResources().getString(R.string.sad_sal), R.drawable.sad_sal, R.raw.sad_sal));
        books.add(new Book(context.getResources().getString(R.string.war), R.drawable.war, R.raw.war));
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
