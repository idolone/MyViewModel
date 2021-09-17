package com.example.mytest.myviewmodelsavestate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.mytest.R;
import com.example.mytest.databinding.ActivityMain4Binding;

public class MainActivity4 extends AppCompatActivity {
    public static final String KEY_NUM = "key_num";
    private MyViewModel4 myViewModel4;
    private ActivityMain4Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main4);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main4);
        myViewModel4 = new ViewModelProvider(this,new SavedStateViewModelFactory(getApplication(),this
        )).get(MyViewModel4.class);

        binding.setData(myViewModel4);
        binding.setLifecycleOwner(this);
    }
}