package com.didi.common.map.util;

public class DDMathUtil {

    /* renamed from: a */
    static final double f12775a = 6371009.0d;

    public static double clamp(double d, double d2, double d3) {
        return d < d2 ? d2 : d > d3 ? d3 : d;
    }

    public static double mod(double d, double d2) {
        return ((d % d2) + d2) % d2;
    }

    DDMathUtil() {
    }

    public static double wrap(double d, double d2, double d3) {
        return (d < d2 || d >= d3) ? mod(d - d2, d3 - d2) + d2 : d;
    }

    public static double mercator(double d) {
        return Math.log(Math.tan((d * 0.5d) + 0.7853981633974483d));
    }

    public static double inverseMercator(double d) {
        return (Math.atan(Math.exp(d)) * 2.0d) - 1.5707963267948966d;
    }

    public static double hav(double d) {
        double sin = Math.sin(d * 0.5d);
        return sin * sin;
    }

    public static double arcHav(double d) {
        return Math.asin(Math.sqrt(d)) * 2.0d;
    }

    public static double sinFromHav(double d) {
        return Math.sqrt(d * (1.0d - d)) * 2.0d;
    }

    public static double havFromSin(double d) {
        double d2 = d * d;
        return (d2 / (Math.sqrt(1.0d - d2) + 1.0d)) * 0.5d;
    }

    public static double sinSumFromHav(double d, double d2) {
        double sqrt = Math.sqrt((1.0d - d) * d);
        double sqrt2 = Math.sqrt((1.0d - d2) * d2);
        return ((sqrt + sqrt2) - (((sqrt * d2) + (sqrt2 * d)) * 2.0d)) * 2.0d;
    }

    public static double havDistance(double d, double d2, double d3) {
        return hav(d - d2) + (hav(d3) * Math.cos(d) * Math.cos(d2));
    }

    public static boolean equal(double d, double d2) {
        return Math.abs(d - d2) < 1.0E-6d;
    }

    public static double computeAngle(float f, float f2) {
        return Math.toDegrees(Math.atan((double) (f / f2)));
    }
}
