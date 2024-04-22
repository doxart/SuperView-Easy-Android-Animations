package com.doxartsuperview;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;

public class SuperView {
    Context context;
    SuperAnim superAnim;
    Animation animation;
    View view;
    AnimationListener animationListener;
    private Handler handler;
    private Runnable runnable;

    public SuperAnim getSuperAnim() {
        return superAnim;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(AnimationType animation) {
        this.animation = AnimationUtils.loadAnimation(context, animation.getId());
    }

    @NonNull
    public static SuperView getInstance(Context context) {
        SuperView instance = new SuperView();
        instance.context = context;
        return instance;
    }

    @NonNull
    public SuperView into(@NonNull View view) {
        this.view = view;
        return this;
    }

    public SuperView with(SuperAnim animationId) {
        this.superAnim = animationId;
        this.animation = animationId.getAnimation();

        return this;
    }

    public SuperView listener(@NonNull AnimationListener animationListener) {
        getTicker();
        this.animationListener = animationListener;
        return this;
    }

    public void hide() {
        boolean canStart = checkArguments();

        if (canStart) {
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    if (animationListener != null) animationListener.onStart();
                    playing = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    if (animationListener != null) animationListener.onFinish();
                    view.setVisibility(View.GONE);
                    playing = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            if (superAnim.isAutoStart()) {
                view.startAnimation(animation);
                if (animationListener != null) startTicker();
            }

        } else {
            if (animationListener != null) animationListener.onError("View can't be null.");
            Log.d("SuperView", "start: " + context.getPackageName() + " SuperView: View can't be null.");
        }
    }

    int currentTimeInMs = 0;
    private void getTicker() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                currentTimeInMs += 100;
                if (animationListener != null) animationListener.onTick(currentTimeInMs);
                if (playing) handler.postDelayed(this, 100);
                else currentTimeInMs = 0;
            }
        };
    }

    boolean playing = false;

    private void startTicker() {
        handler.post(runnable);
    }

    public void show() {
        boolean canStart = checkArguments();

        if (canStart) {
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    if (animationListener != null) animationListener.onStart();
                    view.setVisibility(View.VISIBLE);
                    playing = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    if (animationListener != null) animationListener.onFinish();
                    playing = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            view.startAnimation(animation);
            if (superAnim.isAutoStart()) {

                if (animationListener != null) startTicker();
            }

        } else {
            if (animationListener != null) animationListener.onError("View can't be null.");
            Log.d("SuperView", "start: " + context.getPackageName() + " SuperView: View can't be null.");
        }
    }

    private boolean checkArguments() {
        return view != null;
    }
}
