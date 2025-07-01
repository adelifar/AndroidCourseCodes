package com.tosinso.a24_bookgrid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.tosinso.a24_bookgrid.adapter.BookAdapter;
import com.tosinso.a24_bookgrid.model.Book;
import com.tosinso.a24_bookgrid.repository.BookRepository;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String TITLE="title";
    public static final String COVER="cover";
    public static final String DESCRIPTION="descriptionId";
GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        gridView=findViewById(R.id.grid1);
        BookRepository repository=new BookRepository(MainActivity.this);
        ArrayList<Book> books=repository.getBooks();
        BookAdapter adapter=new BookAdapter(MainActivity.this,books);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Book book=books.get(i);
                Intent intent=new Intent(MainActivity.this,BookViewActivity.class);
                intent.putExtra(TITLE,book.getTitle());
                intent.putExtra(COVER,book.getImageResourceId());
                intent.putExtra(DESCRIPTION,book.getDescriptionResourceId());
                startActivity(intent);
            }
        });





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}