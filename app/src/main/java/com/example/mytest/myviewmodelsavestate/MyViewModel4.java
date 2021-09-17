package com.example.mytest.myviewmodelsavestate;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class MyViewModel4 extends ViewModel {
   // private MutableLiveData<Integer> num;
    private SavedStateHandle handle;

    public MyViewModel4(SavedStateHandle handle) {
       this.handle = handle;
    }

    public MutableLiveData<Integer> getNum() {
        if( !handle.contains(MainActivity4.KEY_NUM)){
            handle.set(MainActivity4.KEY_NUM,0);
        }
        return handle.getLiveData(MainActivity4.KEY_NUM);
    }

    public void add(int p){
       // num.setValue(num.getValue() + p);
       getNum().setValue(getNum().getValue() + p);
    }
}
