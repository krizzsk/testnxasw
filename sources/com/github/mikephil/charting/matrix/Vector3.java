package com.github.mikephil.charting.matrix;

public final class Vector3 {
    public static final Vector3 UNIT_X = new Vector3(1.0f, 0.0f, 0.0f);
    public static final Vector3 UNIT_Y = new Vector3(0.0f, 1.0f, 0.0f);
    public static final Vector3 UNIT_Z = new Vector3(0.0f, 0.0f, 1.0f);
    public static final Vector3 ZERO = new Vector3(0.0f, 0.0f, 0.0f);

    /* renamed from: x */
    public float f54996x;

    /* renamed from: y */
    public float f54997y;

    /* renamed from: z */
    public float f54998z;

    public Vector3() {
    }

    public Vector3(float[] fArr) {
        set(fArr[0], fArr[1], fArr[2]);
    }

    public Vector3(float f, float f2, float f3) {
        set(f, f2, f3);
    }

    public Vector3(Vector3 vector3) {
        set(vector3);
    }

    public final void add(Vector3 vector3) {
        this.f54996x += vector3.f54996x;
        this.f54997y += vector3.f54997y;
        this.f54998z += vector3.f54998z;
    }

    public final void add(float f, float f2, float f3) {
        this.f54996x += f;
        this.f54997y += f2;
        this.f54998z += f3;
    }

    public final void subtract(Vector3 vector3) {
        this.f54996x -= vector3.f54996x;
        this.f54997y -= vector3.f54997y;
        this.f54998z -= vector3.f54998z;
    }

    public final void subtractMultiple(Vector3 vector3, float f) {
        this.f54996x -= vector3.f54996x * f;
        this.f54997y -= vector3.f54997y * f;
        this.f54998z -= vector3.f54998z * f;
    }

    public final void multiply(float f) {
        this.f54996x *= f;
        this.f54997y *= f;
        this.f54998z *= f;
    }

    public final void multiply(Vector3 vector3) {
        this.f54996x *= vector3.f54996x;
        this.f54997y *= vector3.f54997y;
        this.f54998z *= vector3.f54998z;
    }

    public final void divide(float f) {
        if (f != 0.0f) {
            this.f54996x /= f;
            this.f54997y /= f;
            this.f54998z /= f;
        }
    }

    public final void set(Vector3 vector3) {
        this.f54996x = vector3.f54996x;
        this.f54997y = vector3.f54997y;
        this.f54998z = vector3.f54998z;
    }

    public final void set(float f, float f2, float f3) {
        this.f54996x = f;
        this.f54997y = f2;
        this.f54998z = f3;
    }

    public final float dot(Vector3 vector3) {
        return (this.f54996x * vector3.f54996x) + (this.f54997y * vector3.f54997y) + (this.f54998z * vector3.f54998z);
    }

    public final Vector3 cross(Vector3 vector3) {
        float f = this.f54997y;
        float f2 = vector3.f54998z;
        float f3 = this.f54998z;
        float f4 = vector3.f54997y;
        float f5 = (f * f2) - (f3 * f4);
        float f6 = vector3.f54996x;
        float f7 = this.f54996x;
        return new Vector3(f5, (f3 * f6) - (f2 * f7), (f7 * f4) - (f * f6));
    }

    public final float length() {
        return (float) Math.sqrt((double) length2());
    }

    public final float length2() {
        float f = this.f54996x;
        float f2 = this.f54997y;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.f54998z;
        return f3 + (f4 * f4);
    }

    public final float distance2(Vector3 vector3) {
        float f = this.f54996x - vector3.f54996x;
        float f2 = this.f54997y - vector3.f54997y;
        float f3 = this.f54998z - vector3.f54998z;
        return (f * f) + (f2 * f2) + (f3 * f3);
    }

    public final float normalize() {
        float length = length();
        if (length != 0.0f) {
            this.f54996x /= length;
            this.f54997y /= length;
            this.f54998z /= length;
        }
        return length;
    }

    public final void zero() {
        set(0.0f, 0.0f, 0.0f);
    }

    public final boolean pointsInSameDirection(Vector3 vector3) {
        return dot(vector3) > 0.0f;
    }
}
