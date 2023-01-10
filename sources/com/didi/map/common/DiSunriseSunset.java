package com.didi.map.common;

public class DiSunriseSunset {

    enum DiSunEvent {
        DiSunEventRise,
        DiSunEventSet
    }

    /* renamed from: a */
    private static double m21211a(double d) {
        return d * 0.017453292519943295d;
    }

    /* renamed from: a */
    private static double m21212a(double d, double d2) {
        while (d < 0.0d) {
            d += d2;
        }
        while (d >= d2) {
            d -= d2;
        }
        return d;
    }

    /* renamed from: b */
    private static double m21214b(double d) {
        return d * 57.29577951308232d;
    }

    /* renamed from: c */
    private static double m21215c(double d) {
        return Math.sin(m21211a(d));
    }

    /* renamed from: d */
    private static double m21216d(double d) {
        return m21214b(Math.asin(d));
    }

    /* renamed from: e */
    private static double m21217e(double d) {
        return m21214b(Math.atan(d));
    }

    /* renamed from: f */
    private static double m21218f(double d) {
        return Math.tan(m21211a(d));
    }

    /* renamed from: g */
    private static double m21219g(double d) {
        return Math.cos(m21211a(d));
    }

    /* renamed from: h */
    private static double m21220h(double d) {
        return m21214b(Math.acos(d));
    }

    public static double getSunriseDate(double d, double d2, int i, int i2, int i3) {
        return m21213a(DiSunEvent.DiSunEventRise, 90.0d, d, d2, i, i2, i3);
    }

    public static double getSunsetDate(double d, double d2, int i, int i2, int i3) {
        return m21213a(DiSunEvent.DiSunEventSet, 90.0d, d, d2, i, i2, i3);
    }

    /* renamed from: a */
    private static double m21213a(DiSunEvent diSunEvent, double d, double d2, double d3, int i, int i2, int i3) {
        double d4;
        DiSunEvent diSunEvent2 = diSunEvent;
        double d5 = (double) i2;
        double d6 = (double) i;
        double floor = ((Math.floor((275.0d * d5) / 9.0d) - (Math.floor((d5 + 9.0d) / 12.0d) * (Math.floor(((d6 - (Math.floor(d6 / 4.0d) * 4.0d)) + 2.0d) / 3.0d) + 1.0d))) + ((double) i3)) - 30.0d;
        double d7 = d3 / 15.0d;
        double d8 = floor + (((diSunEvent2 == DiSunEvent.DiSunEventRise ? 6.0d : 18.0d) - d7) / 24.0d);
        double d9 = (0.9856d * d8) - 3.289d;
        double a = m21212a(d9 + (m21215c(d9) * 1.916d) + (m21215c(d9 * 2.0d) * 0.02d) + 282.634d, 360.0d);
        double a2 = m21212a(m21217e(m21218f(a) * 0.91764d), 360.0d);
        double floor2 = (a2 + ((Math.floor(a / 90.0d) * 90.0d) - (Math.floor(a2 / 90.0d) * 90.0d))) / 15.0d;
        double c = m21215c(a) * 0.39782d;
        double g = (m21219g(d) - (c * m21215c(d2))) / (m21219g(m21216d(c)) * m21219g(d2));
        if (g > 1.0d || g < -1.0d) {
            return 0.0d;
        }
        if (diSunEvent2 == DiSunEvent.DiSunEventRise) {
            d4 = 360.0d - m21220h(g);
        } else {
            d4 = m21220h(g);
        }
        double a3 = m21212a(m21212a(((((d4 / 15.0d) + floor2) - (d8 * 0.06571d)) - 6.622d) - d7, 24.0d) + ((double) 8), 24.0d);
        if (diSunEvent2 == DiSunEvent.DiSunEventRise) {
            return a3 - (m21215c(d3 * 0.0174532925199433d) * 2.0d);
        }
        return a3 + (m21215c(d3 * 0.0174532925199433d) * 2.0d) + 0.01d;
    }
}
