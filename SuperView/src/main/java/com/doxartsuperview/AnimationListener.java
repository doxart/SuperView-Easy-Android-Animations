package com.doxartsuperview;

public interface AnimationListener {
    void onStart();
    void onFinish();
    void onError(String e);
    void onTick(int tick);
}
