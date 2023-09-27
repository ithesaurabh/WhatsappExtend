package com.example.wappextend;

import static android.net.Uri.parse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.numb);
        button = findViewById(R.id.button3);
        button2 = findViewById(R.id.button2);
        String link = "https://api.whatsapp.com/send/?phone=91";

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse(link  + editText.getText().toString());
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                if (intent.resolveActivity(getPackageManager()) == null) {
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, link + editText.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    button2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            gotoUrl("https://www.instagram.com/kirmada.apk/");
        }

        private void gotoUrl(String s) {
                Uri uri = parse(s);
                Intent intent1 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent1);
            }

    });
    }
}