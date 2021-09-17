package com.example.mytest.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.mytest.R;
import com.example.mytest.myviewmodellivedata.MyViewModel1;

public class MainActivity3 extends AppCompatActivity {
    private ActivityMain3Binding binding;
    private MyViewModel1 myViewModel1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main3);
       // setContentView(R.layout.activity_main3);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        myViewModel1 = new ViewModelProvider
                           (this,new ViewModelProvider.AndroidViewModelFactory(getApplication()))
                         .get(MyViewModel1.class);

        binding.setData(myViewModel1);
        binding.setLifecycleOwner(this);

    }
}