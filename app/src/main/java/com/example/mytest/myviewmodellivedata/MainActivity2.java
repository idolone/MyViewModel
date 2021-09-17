package com.example.mytest.myviewmodellivedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mytest.R;
import com.example.mytest.myviewmodel.MyViewModel;

public class MainActivity2 extends AppCompatActivity {
    private MyViewModel1 myViewModel;
    TextView textView;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myViewModel = new ViewModelProvider
                (this,new ViewModelProvider.AndroidViewModelFactory(getApplication()))
                .get(MyViewModel1.class);
        textView = findViewById(R.id.textView);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);

        myViewModel.getNum().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(String.valueOf(integer));
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.add(1);
                //textView.setText(String.valueOf(myViewModel.Num));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.add(-1);
                //textView.setText(String.valueOf(myViewModel.Num));
            }
        });

    }
}