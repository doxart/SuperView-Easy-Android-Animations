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
    public static AnimationType FADE_IN = new AnimationType("Fade In", R.anim.anim_fade_in);
    public static AnimationType FADE_OUT = new AnimationType("Fade Out", R.anim.anim_fade_out);
    public static AnimationType APPEAR = new AnimationType("Appear", R.anim.anim_appear);
    public static AnimationType PUSH_DOWN_IN = new AnimationType("Push Down In", R.anim.anim_push_down_in);
    public static AnimationType PUSH_DOWN_OUT = new AnimationType("Push Down Out", R.anim.anim_push_down_out);
    public static AnimationType PUSH_LEFT_IN = new AnimationType("Push Left In", R.anim.anim_push_left_in);
    public static AnimationType PUSH_LEFT_OUT = new AnimationType("Push Left Out", R.anim.anim_push_left_out);
    public static AnimationType PUSH_RIGHT_IN = new AnimationType("Push Right In", R.anim.anim_push_right_in);
    public static AnimationType PUSH_RIGHT_OUT = new AnimationType("Push Right Out", R.anim.anim_push_right_out);
    public static AnimationType PUSH_UP_IN = new AnimationType("Push Up In", R.anim.anim_push_up_in);
    public static AnimationType PUSH_UP_OUT = new AnimationType("Push Up Out", R.anim.anim_push_up_out);
    public static AnimationType ROTATE = new AnimationType("Rotate", R.anim.anim_rotate);
    public static AnimationType SCALE_FROM_CORNER = new AnimationType("Scale From Corner", R.anim.anim_scale_from_corner);
    public static AnimationType SCALE_TOWARDS_CORNER = new AnimationType("Scale Towards Corner", R.anim.anim_scale_towards_corner);

    Context context;

    AnimationType animationId = new AnimationType("Fade In", R.anim.anim_fade_in);
    Animation animation;
    int duration = 1000;
    int durationTickTolerance = 10;
    int repeatMode = Animation.RESTART;
    int repeatCount = 0;
    boolean fillAfter = false;
    boolean autoStart = true;

    public SuperAnim(Context context, AnimationType animationId) {
        this.context = context;
        this.animationId = animationId;

        animation = AnimationUtils.loadAnimation(context, animationId.getId());
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
        Animation animation = AnimationUtils.loadAnimation(context, animationId.getId());
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

    public static List<AnimationType> getAllAnim() {
        List<AnimationType> list = new ArrayList<>();
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
