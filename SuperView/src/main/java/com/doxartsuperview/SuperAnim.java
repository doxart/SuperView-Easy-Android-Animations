package com.doxartsuperview;

import android.content.Context;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class SuperAnim {
    public static int FADE_IN = R.anim.anim_fade_in;
    public static int FADE_OUT = R.anim.anim_fade_out;
    public static int APPEAR = R.anim.anim_appear;
    public static int PUSH_DOWN_IN = R.anim.anim_push_down_in;
    public static int PUSH_DOWN_OUT = R.anim.anim_push_down_out;
    public static int PUSH_LEFT_IN = R.anim.anim_push_left_in;
    public static int PUSH_LEFT_OUT = R.anim.anim_push_left_out;
    public static int PUSH_RIGHT_IN = R.anim.anim_push_right_in;
    public static int PUSH_RIGHT_OUT = R.anim.anim_push_right_out;
    public static int PUSH_UP_IN = R.anim.anim_push_up_in;
    public static int PUSH_UP_OUT = R.anim.anim_push_up_out;
    public static int ROTATE = R.anim.anim_rotate;
    public static int SCALE_FROM_CORNER = R.anim.anim_scale_from_corner;
    public static int SCALE_TOWARDS_CORNER = R.anim.anim_scale_towards_corner;

    Context context;

    int animationId = FADE_IN;
    Animation animation;
    int duration = 1000;
    int durationTickTolerance = 10;
    int repeatMode = Animation.RESTART;
    int repeatCount = 0;
    boolean fillAfter = false;
    boolean autoStart = true;

    public SuperAnim(Context context, int animationId) {
        this.context = context;
        this.animationId = animationId;

        animation = AnimationUtils.loadAnimation(context, animationId);
    }

    public Animation getAnimation() {
        return animation;
    }

    public SuperAnim setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public SuperAnim setDurationTickTolerance(int durationTickTolerance) {
        this.durationTickTolerance = durationTickTolerance;
        return this;
    }

    public SuperAnim setAnimRepeatMode(int repeatMode) {
        this.repeatMode = repeatMode;
        return this;
    }

    public SuperAnim setAnimRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
        return this;
    }

    public SuperAnim setAnimFillAfter(boolean fillAfter) {
        this.fillAfter = fillAfter;
        return this;
    }

    public SuperAnim setAutoStart(boolean autoStart) {
        this.autoStart = autoStart;
        return this;
    }

    @NonNull
    public SuperAnim apply() {
        animation.setDuration(duration);
        animation.setRepeatMode(repeatMode);
        animation.setRepeatCount(repeatCount);
        animation.setFillAfter(fillAfter);
        return this;
    }

    public Animation getDefault() {
        Animation animation = AnimationUtils.loadAnimation(context, animationId);
        animation.setDuration(duration);
        animation.setRepeatMode(repeatMode);
        animation.setRepeatCount(repeatCount);
        animation.setFillAfter(fillAfter);
        return animation;
    }

    public int getAnimDuration() {
        return duration;
    }

    public int getDurationTickTolerance() {
        return durationTickTolerance;
    }

    public int getRepeatMode() {
        return repeatMode;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public boolean isFillAfter() {
        return fillAfter;
    }

    public boolean isAutoStart() {
        return autoStart;
    }

    public static List<Integer> getAllAnim() {
        List<Integer> list = new ArrayList<>();
        list.add(SuperAnim.FADE_IN);
        list.add(SuperAnim.FADE_OUT);
        list.add(SuperAnim.APPEAR);
        list.add(SuperAnim.PUSH_DOWN_IN);
        list.add(SuperAnim.PUSH_DOWN_OUT);
        list.add(SuperAnim.PUSH_LEFT_IN);
        list.add(SuperAnim.PUSH_LEFT_OUT);
        list.add(SuperAnim.PUSH_RIGHT_IN);
        list.add(SuperAnim.PUSH_RIGHT_OUT);
        list.add(SuperAnim.PUSH_UP_IN);
        list.add(SuperAnim.PUSH_UP_OUT);
        list.add(SuperAnim.ROTATE);
        list.add(SuperAnim.SCALE_FROM_CORNER);
        list.add(SuperAnim.SCALE_TOWARDS_CORNER);
        return list;
    }
}
