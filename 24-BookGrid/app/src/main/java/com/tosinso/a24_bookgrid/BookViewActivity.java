package com.tosinso.a24_bookgrid;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BookViewActivity extends AppCompatActivity {
    ImageView coverImage;
    TextView titleText;
    TextView descriptionText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book_view);

        titleText=findViewById(R.id.titleTextPreview);
        descriptionText=findViewById(R.id.descriptionText);
        coverImage=findViewById(R.id.coverImagePreview);
        descriptionText.setMovementMethod(new ScrollingMovementMethod());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent=getIntent();
        Bundle extras=intent.getExtras();
        String title=extras.getString(MainActivity.TITLE);
        int coverId=extras.getInt(MainActivity.COVER);
        int descriptionId=extras.getInt(MainActivity.DESCRIPTION);
        titleText.setText(title);
        coverImage.setImageResource(coverId);
        descriptionText.setText(getRawTextFileContent(descriptionId));
    }
    private String getRawTextFileContent(int rawId){
        InputStream inputStream=getResources().openRawResource(rawId);
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder=new StringBuilder();
        String line;
        try {


            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append("\n");
            }
            reader.close();
            return builder.toString();
        }catch (IOException exception){
            exception.printStackTrace();
        }
        return null;
    }
}