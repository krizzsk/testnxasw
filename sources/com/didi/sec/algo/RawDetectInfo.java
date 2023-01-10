package com.didi.sec.algo;

import java.util.Locale;

public class RawDetectInfo {
    public float bScore;
    public byte[] data;
    public int disState;
    public int label;
    public boolean notCentered;
    public float qScore;
    public int qState;
    public float rScore;
    public float score;
    public long time;

    /* renamed from: x1 */
    public int f41227x1;

    /* renamed from: x2 */
    public int f41228x2;

    /* renamed from: y1 */
    public int f41229y1;

    /* renamed from: y2 */
    public int f41230y2;

    public boolean isGoodQuality() {
        return this.qState == 0;
    }

    public String getStatsInfo() {
        return this.label + ", " + String.format(Locale.CHINA, "%.6f, %.6f, %.6f, %.6f", new Object[]{Float.valueOf(this.score), Float.valueOf(this.qScore), Float.valueOf(this.bScore), Float.valueOf(this.rScore)});
    }

    public String toString() {
        return "RawDetectInfo{label=" + this.label + ", score=" + String.format(Locale.CHINA, "%.6f", new Object[]{Float.valueOf(this.score)}) + ", qScore=" + String.format(Locale.CHINA, "%.6f", new Object[]{Float.valueOf(this.qScore)}) + ", bScore=" + String.format(Locale.CHINA, "%.6f", new Object[]{Float.valueOf(this.bScore)}) + ", rScore=" + String.format(Locale.CHINA, "%.6f", new Object[]{Float.valueOf(this.rScore)}) + ", disState=" + this.disState + ", notCentered=" + this.notCentered + "}";
    }
}
