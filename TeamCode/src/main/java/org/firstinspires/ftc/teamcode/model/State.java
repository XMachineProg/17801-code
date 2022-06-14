package org.firstinspires.ftc.teamcode.model;

import android.util.Log;

public abstract class State {
    protected void init() {
        Log.i("State " + this.getClass().getName(), "initialized");
    };
    protected abstract void loop();
}
