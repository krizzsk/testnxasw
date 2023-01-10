package com.didi.map.outer.model;

public final class LatLngBounds {
    public final LatLng northeast;
    public final LatLng southwest;

    /* renamed from: a */
    private static double m23540a(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    /* renamed from: b */
    private static double m23542b(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    public static final class Builder {

        /* renamed from: F */
        private double f30392F = Double.POSITIVE_INFINITY;

        /* renamed from: G */
        private double f30393G = Double.NEGATIVE_INFINITY;

        /* renamed from: H */
        private double f30394H = Double.NaN;

        /* renamed from: I */
        private double f30395I = Double.NaN;

        public Builder include(LatLng latLng) {
            this.f30392F = Math.min(this.f30392F, latLng.latitude);
            this.f30393G = Math.max(this.f30393G, latLng.latitude);
            double d = latLng.longitude;
            if (Double.isNaN(this.f30394H)) {
                this.f30394H = d;
                this.f30395I = d;
            } else if (!m23546a(d)) {
                if (LatLngBounds.m23544c(this.f30394H, d) < LatLngBounds.m23545d(this.f30395I, d)) {
                    this.f30394H = d;
                } else {
                    this.f30395I = d;
                }
            }
            return this;
        }

        public Builder include(Iterable<LatLng> iterable) {
            if (iterable != null) {
                for (LatLng include : iterable) {
                    include(include);
                }
            }
            return this;
        }

        /* renamed from: a */
        private boolean m23546a(double d) {
            double d2 = this.f30394H;
            double d3 = this.f30395I;
            return d2 <= d3 ? d2 <= d && d <= d3 : d2 <= d || d <= d3;
        }

        public LatLngBounds build() {
            return new LatLngBounds(new LatLng(this.f30392F, this.f30394H), new LatLng(this.f30393G, this.f30395I));
        }
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean contains(LatLng latLng) {
        return m23543b(latLng.latitude) && m23541a(latLng.longitude);
    }

    public LatLngBounds including(LatLng latLng) {
        double min = Math.min(this.southwest.latitude, latLng.latitude);
        double max = Math.max(this.northeast.latitude, latLng.latitude);
        double d = this.northeast.longitude;
        double d2 = this.southwest.longitude;
        double d3 = latLng.longitude;
        if (!m23541a(d3)) {
            if (m23540a(d2, d3) < m23542b(d, d3)) {
                d2 = d3;
            } else {
                d = d3;
            }
        }
        return new LatLngBounds(new LatLng(min, d2), new LatLng(max, d));
    }

    public LatLngBounds including(LatLngBounds latLngBounds) {
        return including(latLngBounds.northeast).including(latLngBounds.southwest);
    }

    public LatLng getCenter() {
        return new LatLng((this.southwest.latitude + this.northeast.latitude) / 2.0d, (this.southwest.longitude + this.northeast.longitude) / 2.0d);
    }

    /* renamed from: b */
    private boolean m23543b(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    /* renamed from: a */
    private boolean m23541a(double d) {
        if (this.southwest.longitude <= this.northeast.longitude) {
            if (this.southwest.longitude > d || d > this.northeast.longitude) {
                return false;
            }
            return true;
        } else if (this.southwest.longitude <= d || d <= this.northeast.longitude) {
            return true;
        } else {
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

    /* renamed from: c */
    static double m23544c(double d, double d2) {
        return m23540a(d, d2);
    }

    /* renamed from: d */
    static double m23545d(double d, double d2) {
        return m23542b(d, d2);
    }

    public String toString() {
        return "LatLngBounds{southwest=" + this.southwest + ", northeast=" + this.northeast + '}';
    }
}
