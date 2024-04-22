package com.doxartsuperview;

import android.view.animation.Animation;

public class AnimationType {
    String name, description;
    int id;

    public AnimationType(){}

    public AnimationType(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public AnimationType(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }
}
