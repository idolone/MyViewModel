package com.example.mytest.myviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mytest.R;

public class MainActivity extends AppCompatActivity {
    private MyViewModel myViewModel;
    TextView textView;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myViewModel = new ViewModelProvider
                (this,new ViewModelProvider.AndroidViewModelFactory(getApplication()))
                .get(MyViewModel.class);
        textView = findViewById(R.id.textView);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        textView.setText(String.valueOf(myViewModel.Num));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             myViewModel.Num++;
             textView.setText(String.valueOf(myViewModel.Num));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.Num--;
                textView.setText(String.valueOf(myViewModel.Num));
            }
        });





    }
}