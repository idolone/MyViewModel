package com.example.mytest.myviewmodelsp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import java.util.Map;
import java.util.Set;

public class MyViewMode5 extends AndroidViewModel {
    public static final String KEY_NUM = "key_num";
    public static final String KEY_SHNAME = "key_shname";

    private SavedStateHandle handle;
    public MyViewMode5(@NonNull Application application,SavedStateHandle handle) {
        super(application);
        this.handle = handle;
        if(!handle.contains(KEY_NUM)){
            handle.set(KEY_NUM,0);
            load();
        }

    }

    public MutableLiveData<Integer> getNum(){
        return handle.getLiveData(KEY_NUM);
    }

    public void add(int p){
        // getNum().setValue(getNum().getValue() + p);
        handle.set(KEY_NUM,getNum().getValue() + p);
    }

    private void load() {
        SharedPreferences shp = getApplication().getSharedPreferences(KEY_SHNAME, Context.MODE_PRIVATE) ;
       // SharedPreferences.Editor editor = shp.edit();
        int a = shp.getInt(KEY_NUM,0);
        handle.set(KEY_NUM,a);
    }

    public void save(){
        SharedPreferences shp = getApplication().getSharedPreferences(KEY_SHNAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt(KEY_NUM,getNum().getValue());
        editor.commit();
    }

}
