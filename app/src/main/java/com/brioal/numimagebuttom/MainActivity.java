package com.brioal.numimagebuttom;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.brioal.view.NumImageButton;

public class MainActivity extends AppCompatActivity {
    private NumImageButton mNumImageButton1;
    private NumImageButton mNumImageButton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumImageButton1 = (NumImageButton) findViewById(R.id.numImageButton1);
        mNumImageButton2 = (NumImageButton) findViewById(R.id.numImageButton2);

        mNumImageButton2.setNum(10)
                .setTextColor(Color.WHITE)
                .setDrawable(getResources().getDrawable(R.drawable.ic_launcher))
                .setNumBg(getResources().getDrawable(R.drawable.round_bg_accent));

    }
}
