package com.didi.map.global.sdk.movement.sensor;

public class PdrPoint {

    /* renamed from: x */
    public float f30192x;

    /* renamed from: y */
    public float f30193y;

    public PdrPoint() {
        this.f30192x = 0.0f;
        this.f30193y = 0.0f;
    }

    public PdrPoint(PdrPoint pdrPoint) {
        this.f30192x = pdrPoint.f30192x;
        this.f30193y = pdrPoint.f30193y;
    }

    public PdrPoint(float f, float f2) {
        this.f30192x = f;
        this.f30193y = f2;
    }

    public String toString() {
        return "Point(" + this.f30192x + "," + this.f30193y + ")";
    }

    public static PdrPoint getNextPoint(PdrPoint pdrPoint, float f, float f2) {
        if (pdrPoint == null) {
            return null;
        }
        if (f2 >= 0.0f && f2 <= 90.0f) {
            PdrPoint pdrPoint2 = new PdrPoint();
            double d = (double) f;
            double d2 = (double) (90.0f - f2);
            pdrPoint2.f30192x = ((float) Math.round((((double) pdrPoint.f30192x) + (Math.cos(Math.toRadians(d2)) * d)) * 100.0d)) / 100.0f;
            pdrPoint2.f30193y = ((float) Math.round((((double) pdrPoint.f30193y) + (d * Math.sin(Math.toRadians(d2)))) * 100.0d)) / 100.0f;
            return pdrPoint2;
        } else if (f2 > 90.0f && f2 <= 180.0f) {
            PdrPoint pdrPoint3 = new PdrPoint();
            double d3 = (double) f;
            double d4 = (double) (f2 - 90.0f);
            pdrPoint3.f30192x = ((float) Math.round((((double) pdrPoint.f30192x) + (Math.cos(Math.toRadians(d4)) * d3)) * 100.0d)) / 100.0f;
            pdrPoint3.f30193y = ((float) Math.round((((double) pdrPoint.f30193y) - (d3 * Math.sin(Math.toRadians(d4)))) * 100.0d)) / 100.0f;
            return pdrPoint3;
        } else if (f2 > 180.0f && f2 <= 270.0f) {
            PdrPoint pdrPoint4 = new PdrPoint();
            double d5 = (double) f;
            double d6 = (double) (270.0f - f2);
            pdrPoint4.f30192x = ((float) Math.round((((double) pdrPoint.f30192x) - (Math.cos(Math.toRadians(d6)) * d5)) * 100.0d)) / 100.0f;
            pdrPoint4.f30193y = ((float) Math.round((((double) pdrPoint.f30193y) - (d5 * Math.sin(Math.toRadians(d6)))) * 100.0d)) / 100.0f;
            return pdrPoint4;
        } else if (f2 <= 270.0f || f2 >= 360.0f) {
            return null;
        } else {
            PdrPoint pdrPoint5 = new PdrPoint();
            double d7 = (double) f;
            double d8 = (double) (f2 - 270.0f);
            pdrPoint5.f30192x = ((float) Math.round((((double) pdrPoint.f30192x) - (Math.cos(Math.toRadians(d8)) * d7)) * 100.0d)) / 100.0f;
            pdrPoint5.f30193y = ((float) Math.round((((double) pdrPoint.f30193y) + (d7 * Math.sin(Math.toRadians(d8)))) * 100.0d)) / 100.0f;
            return pdrPoint5;
        }
    }

    public static float getDirectBetweenPoints(PdrPoint pdrPoint, PdrPoint pdrPoint2) {
        if (!(pdrPoint == null || pdrPoint2 == null)) {
            if (pdrPoint.f30193y == pdrPoint2.f30193y && pdrPoint.f30192x > pdrPoint2.f30192x) {
                return 270.0f;
            }
            if (pdrPoint.f30193y == pdrPoint2.f30193y && pdrPoint.f30192x < pdrPoint2.f30192x) {
                return 90.0f;
            }
            if (pdrPoint.f30193y == pdrPoint2.f30193y && pdrPoint.f30192x == pdrPoint2.f30192x) {
                return Float.NaN;
            }
            if (pdrPoint.f30193y > pdrPoint2.f30193y && pdrPoint.f30192x == pdrPoint2.f30192x) {
                return 180.0f;
            }
            if (pdrPoint.f30193y < pdrPoint2.f30193y && pdrPoint.f30192x == pdrPoint2.f30192x) {
                return 0.0f;
            }
            float atan2 = (float) ((Math.atan2((double) Math.abs(pdrPoint.f30193y - pdrPoint2.f30193y), (double) Math.abs(pdrPoint.f30192x - pdrPoint2.f30192x)) * 180.0d) / 3.141592653589793d);
            if (pdrPoint.f30193y > pdrPoint2.f30193y && pdrPoint.f30192x > pdrPoint2.f30192x) {
                return 270.0f - atan2;
            }
            if (pdrPoint.f30193y > pdrPoint2.f30193y && pdrPoint.f30192x < pdrPoint2.f30192x) {
                return atan2 + 90.0f;
            }
            if (pdrPoint.f30193y < pdrPoint2.f30193y && pdrPoint.f30192x > pdrPoint2.f30192x) {
                return atan2 + 270.0f;
            }
            if (pdrPoint.f30193y < pdrPoint2.f30193y && pdrPoint.f30192x < pdrPoint2.f30192x) {
                return 90.0f - atan2;
            }
        }
        return Float.NaN;
    }

    public static float getDistanceBetweenPoints(PdrPoint pdrPoint, PdrPoint pdrPoint2) {
        if (pdrPoint == null || pdrPoint2 == null) {
            return Float.NaN;
        }
        return (float) Math.sqrt(Math.pow((double) (pdrPoint.f30192x - pdrPoint2.f30192x), 2.0d) + Math.pow((double) (pdrPoint.f30193y - pdrPoint2.f30193y), 2.0d));
    }
}
