package com.example.daobunso.index;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;


//自定義的類別，用來實現首頁的跑馬燈效果

public class RunningTextView extends TextView {
    public RunningTextView(Context context) {
        super(context);
    }

    public RunningTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RunningTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean isFocused() {
        return true;
    }
}
