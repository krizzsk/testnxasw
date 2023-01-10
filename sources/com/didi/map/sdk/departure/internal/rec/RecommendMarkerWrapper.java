package com.didi.map.sdk.departure.internal.rec;

public class RecommendMarkerWrapper implements Comparable<RecommendMarkerWrapper> {

    /* renamed from: a */
    private Square f30677a = null;
    public boolean mIsDuplicate = false;

    public RecommendMarkerWrapper(Square square) {
        this.f30677a = square;
    }

    public Square getTarget() {
        return this.f30677a;
    }

    public boolean mayCollisionTest(RecommendMarkerWrapper recommendMarkerWrapper) {
        Square target = recommendMarkerWrapper.getTarget();
        double a = m23648a(this.f30677a);
        double b = m23649b(this.f30677a);
        double a2 = m23648a(target);
        double abs = Math.abs(b - m23649b(target)) - ((double) ((target.getHeight() + this.f30677a.getHeight()) / 2.0f));
        if (Math.abs(a - a2) - ((double) ((target.getWidth() + this.f30677a.getWidth()) / 2.0f)) < 0.0d && abs < 0.0d) {
            return true;
        }
        if (Math.abs(a - (a2 - ((double) this.f30677a.getWidth()))) - ((double) ((target.getWidth() + this.f30677a.getWidth()) / 2.0f)) >= 0.0d || abs >= 0.0d) {
            return false;
        }
        return true;
    }

    public boolean collisionTest(RecommendMarkerWrapper recommendMarkerWrapper) {
        Square target = recommendMarkerWrapper.getTarget();
        return Math.abs(m23648a(this.f30677a) - m23648a(target)) - ((double) ((target.getWidth() + this.f30677a.getWidth()) / 2.0f)) < 0.0d && Math.abs(m23649b(this.f30677a) - m23649b(target)) - ((double) ((target.getHeight() + this.f30677a.getHeight()) / 2.0f)) < 0.0d;
    }

    /* renamed from: a */
    private double m23648a(Square square) {
        return square.getX();
    }

    /* renamed from: b */
    private double m23649b(Square square) {
        return square.getY();
    }

    public int compareTo(RecommendMarkerWrapper recommendMarkerWrapper) {
        Square target = recommendMarkerWrapper.getTarget();
        double a = m23648a(this.f30677a);
        double a2 = m23648a(target);
        if (a < a2) {
            return -1;
        }
        return a > a2 ? 1 : 0;
    }

    public boolean isCollision(RecommendMarkerWrapper recommendMarkerWrapper, double d) {
        double d2;
        Square target = recommendMarkerWrapper.getTarget();
        double a = m23648a(this.f30677a);
        double b = m23649b(this.f30677a);
        double width = (double) this.f30677a.getWidth();
        double height = (double) this.f30677a.getHeight();
        double a2 = m23648a(target);
        double b2 = m23649b(target);
        double width2 = (double) target.getWidth();
        double height2 = (double) target.getHeight();
        if (a < a2) {
            d2 = Math.abs(a - a2) - width;
        } else {
            d2 = Math.abs(a - a2) - width2;
        }
        return d2 - (d * 2.0d) < 0.0d && (Math.abs(b - b2) - ((height + height2) / 2.0d)) - (d * 2.0d) < 0.0d;
    }
}
