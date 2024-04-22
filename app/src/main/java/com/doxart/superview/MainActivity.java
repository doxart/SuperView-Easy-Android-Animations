package com.doxart.superview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.doxart.superview.databinding.ActivityMainBinding;
import com.doxartsuperview.AnimationListener;
import com.doxartsuperview.AnimationType;
import com.doxartsuperview.SuperAnim;
import com.doxartsuperview.SuperView;

import java.util.ArrayList;
import java.util.List;

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
                .setAnimRepeatCount(0)
                .setAnimRepeatMode(Animation.RESTART)
                .setDurationTickTolerance(100)
                .apply();

        SuperView superView = SuperView.getInstance(this).into(b.myAnimatedView).with(superAnim).listener(new AnimationListener() {
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
        });

        List<AnimationType> list = SuperAnim.getAllAnim();
        List<String> strList = new ArrayList<>();

        for (AnimationType i : list) {
            strList.add(i.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, strList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        b.spinner.setAdapter(adapter);

        b.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                superView.setAnimation(list.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        b.startBt.setOnClickListener(v -> {
            if (!b.duration.getText().toString().isEmpty()) superView.getAnimation().setDuration(Integer.parseInt(b.duration.getText().toString()));
            if (b.checkInputLay.getCheckedRadioButtonId() == R.id.hideBt) superView.hide();
            else superView.show();
        });
    }
}