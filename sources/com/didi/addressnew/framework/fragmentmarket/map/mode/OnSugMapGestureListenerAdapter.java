package com.didi.addressnew.framework.fragmentmarket.map.mode;

import com.didi.common.map.listener.OnMapGestureListener;

public abstract class OnSugMapGestureListenerAdapter implements OnMapGestureListener {
    public boolean onDoubleTap(float f, float f2) {
        return false;
    }

    public boolean onDown(float f, float f2) {
        return false;
    }

    public boolean onFling(float f, float f2) {
        return false;
    }

    public boolean onLongPress(float f, float f2) {
        return false;
    }

    public void onMapStable() {
    }

    public boolean onScroll(float f, float f2) {
        return false;
    }

    public boolean onSingleTap(float f, float f2) {
        return false;
    }

    public boolean onUp(float f, float f2) {
        return false;
    }
}
