package com.didi.map.global.component.line.component.traffic;

public class TrafficData {
    public int color;
    public int fromIndex;
    public int minorColor;
    public int toIndex;

    public boolean isSameData(TrafficData trafficData) {
        return trafficData != null && this.color == trafficData.color && this.fromIndex == trafficData.fromIndex && this.toIndex == trafficData.toIndex;
    }
}
