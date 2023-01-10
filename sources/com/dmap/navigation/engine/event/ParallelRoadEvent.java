package com.dmap.navigation.engine.event;

public class ParallelRoadEvent extends NaviEvent {
    public static final int MAIN_ROAD = 3;
    public static final int SERVING_ROAD = 4;

    /* renamed from: a */
    private final int f54490a;

    /* renamed from: b */
    private final int f54491b;

    public ParallelRoadEvent(int i, int i2) {
        this.f54490a = i;
        this.f54491b = i2;
    }

    public String toString() {
        return "ParallelRoadEvent{updateType=" + this.f54490a + ", type=" + this.f54491b + '}';
    }

    public int getUpdateType() {
        return this.f54490a;
    }

    public int getType() {
        return this.f54491b;
    }
}
