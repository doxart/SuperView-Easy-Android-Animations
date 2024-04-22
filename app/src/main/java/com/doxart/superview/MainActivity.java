package com.doxart.superview;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;

import androidx.appcompat.app.AppCompatActivity;

import com.doxart.superview.databinding.ActivityMainBinding;
import com.doxartsuperview.AnimationListener;
import com.doxartsuperview.SuperAnim;
import com.doxartsuperview.SuperView;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "SuperViewActivity";
    ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        SuperAnim superAnim = new SuperAnim(this, SuperAnim.FADE_IN)
                .setAutoStart(true)
                .setDuration(6000)
                .setAnimFillAfter(false)
                .setAnimRepeatCount(2)
                .setAnimRepeatMode(Animation.RESTART)
                .setDurationTickTolerance(100)
                .apply();

        SuperView.getInstance(this).into(b.myAnimatedView).with(superAnim).listener(new AnimationListener() {
            @Override
            public void onStart() {
                Log.d(TAG, "onStart: " + b.myAnimatedView.getId());
            }

            @Override
            public void onFinish() {
                Log.d(TAG, "onFinish: " + b.myAnimatedView.getId());
            }

            @Override
            public void onError(String e) {
                Log.d(TAG, "onError: " + e);
            }

            @Override
            public void onTick(int tick) {
                Log.d(TAG, "onTick: " + tick);
            }
        }).show();
    }
}