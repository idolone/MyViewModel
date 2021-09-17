package com.example.mytest.myviewmodelsp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import com.example.mytest.R;
import com.example.mytest.databinding.ActivityMain5Binding;

public class MainActivity5 extends AppCompatActivity {
    private ActivityMain5Binding binding;
    private MyViewMode5 myViewMode5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main5);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main5);
        myViewMode5 = new ViewModelProvider(this,
                new SavedStateViewModelFactory(getApplication(),this))
                .get(MyViewMode5.class);

        binding.setData(myViewMode5);
        binding.setLifecycleOwner(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        myViewMode5.save();
    }
}