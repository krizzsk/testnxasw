package com.didi.common.map.model;

import java.util.ArrayList;
import java.util.List;

public final class LatLngBounds {
    public List<LatLng> latLngList;
    public final LatLng northeast;
    public final LatLng southwest;

    /* renamed from: c */
    private static double m10742c(double d, double d2) {
        return (((d * 1000000.0d) - (d2 * 1000000.0d)) + 3.6E8d) % 3.6E8d;
    }

    /* renamed from: d */
    private static double m10743d(double d, double d2) {
        return (((d2 * 1000000.0d) - (d * 1000000.0d)) + 3.6E8d) % 3.6E8d;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean contains(LatLng latLng) {
        return m10739a(latLng.latitude) && m10741b(latLng.longitude);
    }

    public LatLngBounds including(LatLng latLng) {
        double min = Math.min(this.southwest.latitude, latLng.latitude);
        double max = Math.max(this.northeast.latitude, latLng.latitude);
        double d = this.northeast.longitude;
        double d2 = this.southwest.longitude;
        double d3 = latLng.longitude;
        if (!m10741b(d3)) {
            if (m10742c(d2, d3) < m10743d(d, d3)) {
                d2 = d3;
            } else {
                d = d3;
            }
        }
        return new LatLngBounds(new LatLng(min, d2), new LatLng(max, d));
    }

    /* renamed from: a */
    private boolean m10739a(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    /* renamed from: b */
    private boolean m10741b(double d) {
        int i = (this.southwest.longitude > this.northeast.longitude ? 1 : (this.southwest.longitude == this.northeast.longitude ? 0 : -1));
        int i2 = (this.southwest.longitude > d ? 1 : (this.southwest.longitude == d ? 0 : -1));
        if (i > 0) {
            return i2 <= 0 || d <= this.northeast.longitude;
        }
        if (i2 > 0 || d > this.northeast.longitude) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        if (!this.southwest.equals(latLngBounds.southwest) || !this.northeast.equals(latLngBounds.northeast)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    static double m10736a(double d, double d2) {
        return m10742c(d, d2);
    }

    /* renamed from: b */
    static double m10740b(double d, double d2) {
        return m10743d(d, d2);
    }

    public LatLng getCenter() {
        double d = (this.southwest.latitude + this.northeast.latitude) / 2.0d;
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        if (d3 > d2) {
            d2 += 360.0d;
        }
        return new LatLng(d, (d2 + d3) / 2.0d);
    }

    public static final class Builder {

        /* renamed from: a */
        private double f12663a = Double.POSITIVE_INFINITY;

        /* renamed from: b */
        private double f12664b = Double.NEGATIVE_INFINITY;

        /* renamed from: c */
        private double f12665c = Double.NaN;

        /* renamed from: d */
        private double f12666d = Double.NaN;
        private final List<LatLng> latLngList = new ArrayList();

        public double roundValue(double d) {
            return ((double) ((int) (d * 1000000.0d))) / 1000000.0d;
        }

        public Builder include(LatLng latLng) {
            if (latLng == null) {
                return this;
            }
            LatLng latLng2 = new LatLng(roundValue(latLng.latitude), roundValue(latLng.longitude));
            if (!Double.isNaN(latLng2.latitude) && !Double.isNaN(latLng2.longitude)) {
                this.latLngList.add(latLng2);
                this.f12663a = Math.min(this.f12663a, latLng2.latitude);
                this.f12664b = Math.max(this.f12664b, latLng2.latitude);
                double d = latLng2.longitude;
                if (Double.isNaN(this.f12665c)) {
                    this.f12665c = d;
                    this.f12666d = d;
                } else if (!content(d)) {
                    if (LatLngBounds.m10736a(this.f12665c, d) < LatLngBounds.m10740b(this.f12666d, d)) {
                        this.f12665c = d;
                    } else {
                        this.f12666d = d;
                    }
                }
            }
            return this;
        }

        public Builder include(List<LatLng> list) {
            if (list == null) {
                return this;
            }
            this.latLngList.addAll(list);
            for (LatLng include : list) {
                include(include);
            }
            return this;
        }

        private boolean content(double d) {
            double d2 = this.f12665c;
            double d3 = this.f12666d;
            if (d2 > d3) {
                return d2 <= d || d <= d3;
            }
            if (d2 > d || d > d3) {
                return false;
            }
        }

        public LatLngBounds build() {
            LatLngBounds latLngBounds = new LatLngBounds(new LatLng(this.f12663a, this.f12665c), new LatLng(this.f12664b, this.f12666d));
            latLngBounds.m10738a(this.latLngList);
            return latLngBounds;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10738a(List<LatLng> list) {
        this.latLngList = list;
    }
}
