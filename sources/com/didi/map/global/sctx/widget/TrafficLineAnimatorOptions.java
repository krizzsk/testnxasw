package com.didi.map.global.sctx.widget;

public class TrafficLineAnimatorOptions {
    public TrafficLineAnimatorListener animatorListener;
    public long duration;

    public static abstract class TrafficLineAnimatorListener {
        public void onEnd() {
        }

        public void onStart() {
        }
    }
}
