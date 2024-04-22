package com.doxart.superview;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.doxart.superview.databinding.ActivityMainBinding;
import com.doxartsuperview.AnimationListener;
import com.doxartsuperview.SuperAnim;
import com.doxartsuperview.SuperView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        SuperAnim superAnim = new SuperAnim(this, SuperAnim.FADE_IN).setAutoStart(true).setDuration(6000).apply();

        SuperView.getInstance(this).into(b.card).with(superAnim).listener(new AnimationListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onFinish() {

            }

            @Override
            public void onError(String e) {
                Log.d("Error", "onError: " + e);
            }

            @Override
            public void onTick(int tick) {
                Log.d("Error", "onTick: " + tick);
            }
        }).show();
    }
}