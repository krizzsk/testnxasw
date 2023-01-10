package com.didi.hawaii.p120ar.utils;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.logging.Logger;

/* renamed from: com.didi.hawaii.ar.utils.Quaternion */
public final class Quaternion {
    public static final Quaternion DIRECTION_Z = new Quaternion();
    public static final Quaternion IDENTITY = new Quaternion();
    public static final Quaternion ZERO = new Quaternion(0.0f, 0.0f, 0.0f, 0.0f);

    /* renamed from: a */
    static final long f25586a = 1;

    /* renamed from: b */
    private static final Logger f25587b = Logger.getLogger(Quaternion.class.getName());

    /* renamed from: w */
    protected float f25588w;

    /* renamed from: x */
    protected float f25589x;

    /* renamed from: y */
    protected float f25590y;

    /* renamed from: z */
    protected float f25591z;

    static {
        DIRECTION_Z.fromAxes(Vector3f.UNIT_X, Vector3f.UNIT_Y, Vector3f.UNIT_Z);
    }

    public Quaternion() {
        this.f25589x = 0.0f;
        this.f25590y = 0.0f;
        this.f25591z = 0.0f;
        this.f25588w = 1.0f;
    }

    public Quaternion(float f, float f2, float f3, float f4) {
        this.f25589x = f;
        this.f25590y = f2;
        this.f25591z = f3;
        this.f25588w = f4;
    }

    public float getX() {
        return this.f25589x;
    }

    public float getY() {
        return this.f25590y;
    }

    public float getZ() {
        return this.f25591z;
    }

    public float getW() {
        return this.f25588w;
    }

    public Quaternion set(float f, float f2, float f3, float f4) {
        this.f25589x = f;
        this.f25590y = f2;
        this.f25591z = f3;
        this.f25588w = f4;
        return this;
    }

    public Quaternion set(Quaternion quaternion) {
        this.f25589x = quaternion.f25589x;
        this.f25590y = quaternion.f25590y;
        this.f25591z = quaternion.f25591z;
        this.f25588w = quaternion.f25588w;
        return this;
    }

    public Quaternion(float[] fArr) {
        fromAngles(fArr);
    }

    public Quaternion(Quaternion quaternion, Quaternion quaternion2, float f) {
        slerp(quaternion, quaternion2, f);
    }

    public Quaternion(Quaternion quaternion) {
        this.f25589x = quaternion.f25589x;
        this.f25590y = quaternion.f25590y;
        this.f25591z = quaternion.f25591z;
        this.f25588w = quaternion.f25588w;
    }

    public void loadIdentity() {
        this.f25591z = 0.0f;
        this.f25590y = 0.0f;
        this.f25589x = 0.0f;
        this.f25588w = 1.0f;
    }

    public boolean isIdentity() {
        return this.f25589x == 0.0f && this.f25590y == 0.0f && this.f25591z == 0.0f && this.f25588w == 1.0f;
    }

    public Quaternion fromAngles(float[] fArr) {
        if (fArr.length == 3) {
            return fromAngles(fArr[0], fArr[1], fArr[2]);
        }
        throw new IllegalArgumentException("Angles array must have three elements");
    }

    public Quaternion fromAngles(float f, float f2, float f3) {
        float f4 = f3 * 0.5f;
        float sin = FastMath.sin(f4);
        float cos = FastMath.cos(f4);
        float f5 = f2 * 0.5f;
        float sin2 = FastMath.sin(f5);
        float cos2 = FastMath.cos(f5);
        float f6 = f * 0.5f;
        float sin3 = FastMath.sin(f6);
        float cos3 = FastMath.cos(f6);
        float f7 = cos2 * cos;
        float f8 = sin2 * sin;
        float f9 = cos2 * sin;
        float f10 = sin2 * cos;
        this.f25588w = (f7 * cos3) - (f8 * sin3);
        this.f25589x = (f7 * sin3) + (f8 * cos3);
        this.f25590y = (f10 * cos3) + (f9 * sin3);
        this.f25591z = (f9 * cos3) - (f10 * sin3);
        normalize();
        return this;
    }

    public float[] toAngles(float[] fArr) {
        float[] fArr2 = fArr;
        if (fArr2 == null) {
            fArr2 = new float[3];
        } else if (fArr2.length != 3) {
            throw new IllegalArgumentException("Angles array must have three elements");
        }
        float f = this.f25588w;
        float f2 = f * f;
        float f3 = this.f25589x;
        float f4 = f3 * f3;
        float f5 = this.f25590y;
        float f6 = f5 * f5;
        float f7 = this.f25591z;
        float f8 = f7 * f7;
        float f9 = f4 + f6 + f8 + f2;
        float f10 = (f3 * f5) + (f7 * f);
        double d = (double) f10;
        float f11 = f6;
        float f12 = f7;
        double d2 = (double) f9;
        if (d > 0.499d * d2) {
            fArr2[1] = FastMath.atan2(f3, f) * 2.0f;
            fArr2[2] = 1.5707964f;
            fArr2[0] = 0.0f;
        } else if (d < d2 * -0.499d) {
            fArr2[1] = FastMath.atan2(f3, f) * -2.0f;
            fArr2[2] = -1.5707964f;
            fArr2[0] = 0.0f;
        } else {
            fArr2[1] = FastMath.atan2(((f5 * 2.0f) * f) - ((f3 * 2.0f) * f12), ((f4 - f11) - f8) + f2);
            fArr2[2] = FastMath.asin((f10 * 2.0f) / f9);
            fArr2[0] = FastMath.atan2(((this.f25589x * 2.0f) * this.f25588w) - ((this.f25590y * 2.0f) * this.f25591z), (((-f4) + f11) - f8) + f2);
        }
        return fArr2;
    }

    public Quaternion fromRotationMatrix(Matrix3f matrix3f) {
        return fromRotationMatrix(matrix3f.m00, matrix3f.m01, matrix3f.m02, matrix3f.m10, matrix3f.m11, matrix3f.m12, matrix3f.m20, matrix3f.m21, matrix3f.m22);
    }

    public Quaternion fromRotationMatrix(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = f + f5 + f9;
        if (f10 >= 0.0f) {
            float sqrt = FastMath.sqrt(f10 + 1.0f);
            this.f25588w = sqrt * 0.5f;
            float f11 = 0.5f / sqrt;
            this.f25589x = (f8 - f6) * f11;
            this.f25590y = (f3 - f7) * f11;
            this.f25591z = (f4 - f2) * f11;
        } else if (f > f5 && f > f9) {
            float sqrt2 = FastMath.sqrt(((f + 1.0f) - f5) - f9);
            this.f25589x = sqrt2 * 0.5f;
            float f12 = 0.5f / sqrt2;
            this.f25590y = (f4 + f2) * f12;
            this.f25591z = (f3 + f7) * f12;
            this.f25588w = (f8 - f6) * f12;
        } else if (f5 > f9) {
            float sqrt3 = FastMath.sqrt(((f5 + 1.0f) - f) - f9);
            this.f25590y = sqrt3 * 0.5f;
            float f13 = 0.5f / sqrt3;
            this.f25589x = (f4 + f2) * f13;
            this.f25591z = (f8 + f6) * f13;
            this.f25588w = (f3 - f7) * f13;
        } else {
            float sqrt4 = FastMath.sqrt(((f9 + 1.0f) - f) - f5);
            this.f25591z = sqrt4 * 0.5f;
            float f14 = 0.5f / sqrt4;
            this.f25589x = (f3 + f7) * f14;
            this.f25590y = (f8 + f6) * f14;
            this.f25588w = (f4 - f2) * f14;
        }
        return this;
    }

    public Matrix3f toRotationMatrix() {
        return toRotationMatrix(new Matrix3f());
    }

    public Matrix3f toRotationMatrix(Matrix3f matrix3f) {
        float norm = norm();
        float f = 2.0f;
        if (norm != 1.0f) {
            f = norm > 0.0f ? 2.0f / norm : 0.0f;
        }
        float f2 = this.f25589x;
        float f3 = f2 * f;
        float f4 = this.f25590y;
        float f5 = f4 * f;
        float f6 = this.f25591z;
        float f7 = f * f6;
        float f8 = f2 * f3;
        float f9 = f2 * f5;
        float f10 = f2 * f7;
        float f11 = this.f25588w;
        float f12 = f3 * f11;
        float f13 = f4 * f5;
        float f14 = f4 * f7;
        float f15 = f5 * f11;
        float f16 = f6 * f7;
        float f17 = f11 * f7;
        matrix3f.m00 = 1.0f - (f13 + f16);
        matrix3f.m01 = f9 - f17;
        matrix3f.m02 = f10 + f15;
        matrix3f.m10 = f9 + f17;
        matrix3f.m11 = 1.0f - (f16 + f8);
        matrix3f.m12 = f14 - f12;
        matrix3f.m20 = f10 - f15;
        matrix3f.m21 = f14 + f12;
        matrix3f.m22 = 1.0f - (f8 + f13);
        return matrix3f;
    }

    public Vector3f getRotationColumn(int i) {
        return getRotationColumn(i, (Vector3f) null);
    }

    public Vector3f getRotationColumn(int i, Vector3f vector3f) {
        if (vector3f == null) {
            vector3f = new Vector3f();
        }
        float norm = norm();
        if (norm != 1.0f) {
            norm = FastMath.invSqrt(norm);
        }
        float f = this.f25589x;
        float f2 = f * f * norm;
        float f3 = this.f25590y;
        float f4 = f * f3 * norm;
        float f5 = this.f25591z;
        float f6 = f * f5 * norm;
        float f7 = this.f25588w;
        float f8 = f * f7 * norm;
        float f9 = f3 * f3 * norm;
        float f10 = f3 * f5 * norm;
        float f11 = f3 * f7 * norm;
        float f12 = f5 * f5 * norm;
        float f13 = f5 * f7 * norm;
        if (i == 0) {
            vector3f.f25609x = 1.0f - ((f9 + f12) * 2.0f);
            vector3f.f25610y = (f4 + f13) * 2.0f;
            vector3f.f25611z = (f6 - f11) * 2.0f;
        } else if (i == 1) {
            vector3f.f25609x = (f4 - f13) * 2.0f;
            vector3f.f25610y = 1.0f - ((f2 + f12) * 2.0f);
            vector3f.f25611z = (f10 + f8) * 2.0f;
        } else if (i == 2) {
            vector3f.f25609x = (f6 + f11) * 2.0f;
            vector3f.f25610y = (f10 - f8) * 2.0f;
            vector3f.f25611z = 1.0f - ((f2 + f9) * 2.0f);
        } else {
            f25587b.warning("Invalid column index.");
            throw new IllegalArgumentException("Invalid column index. " + i);
        }
        return vector3f;
    }

    public Quaternion fromAngleAxis(float f, Vector3f vector3f) {
        fromAngleNormalAxis(f, vector3f.normalize());
        return this;
    }

    public Quaternion fromAngleNormalAxis(float f, Vector3f vector3f) {
        if (vector3f.f25609x == 0.0f && vector3f.f25610y == 0.0f && vector3f.f25611z == 0.0f) {
            loadIdentity();
        } else {
            float f2 = f * 0.5f;
            float sin = FastMath.sin(f2);
            this.f25588w = FastMath.cos(f2);
            this.f25589x = vector3f.f25609x * sin;
            this.f25590y = vector3f.f25610y * sin;
            this.f25591z = sin * vector3f.f25611z;
        }
        return this;
    }

    public float toAngleAxis(Vector3f vector3f) {
        float f = this.f25589x;
        float f2 = this.f25590y;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.f25591z;
        float f5 = f3 + (f4 * f4);
        float f6 = 0.0f;
        if (f5 != 0.0f) {
            f6 = 2.0f * FastMath.acos(this.f25588w);
            if (vector3f != null) {
                float sqrt = 1.0f / FastMath.sqrt(f5);
                vector3f.f25609x = this.f25589x * sqrt;
                vector3f.f25610y = this.f25590y * sqrt;
                vector3f.f25611z = this.f25591z * sqrt;
            }
        } else if (vector3f != null) {
            vector3f.f25609x = 1.0f;
            vector3f.f25610y = 0.0f;
            vector3f.f25611z = 0.0f;
        }
        return f6;
    }

    public Quaternion slerp(Quaternion quaternion, Quaternion quaternion2, float f) {
        if (quaternion.f25589x == quaternion2.f25589x && quaternion.f25590y == quaternion2.f25590y && quaternion.f25591z == quaternion2.f25591z && quaternion.f25588w == quaternion2.f25588w) {
            set(quaternion);
            return this;
        }
        float f2 = quaternion.f25589x;
        float f3 = quaternion2.f25589x;
        float f4 = quaternion.f25590y;
        float f5 = quaternion2.f25590y;
        float f6 = (f2 * f3) + (f4 * f5);
        float f7 = quaternion.f25591z;
        float f8 = quaternion2.f25591z;
        float f9 = f6 + (f7 * f8);
        float f10 = quaternion.f25588w;
        float f11 = quaternion2.f25588w;
        float f12 = f9 + (f10 * f11);
        if (f12 < 0.0f) {
            quaternion2.f25589x = -f3;
            quaternion2.f25590y = -f5;
            quaternion2.f25591z = -f8;
            quaternion2.f25588w = -f11;
            f12 = -f12;
        }
        float f13 = 1.0f - f;
        if (1.0f - f12 > 0.1f) {
            float acos = FastMath.acos(f12);
            float sin = 1.0f / FastMath.sin(acos);
            f13 = FastMath.sin(f13 * acos) * sin;
            f = FastMath.sin(f * acos) * sin;
        }
        this.f25589x = (quaternion.f25589x * f13) + (quaternion2.f25589x * f);
        this.f25590y = (quaternion.f25590y * f13) + (quaternion2.f25590y * f);
        this.f25591z = (quaternion.f25591z * f13) + (quaternion2.f25591z * f);
        this.f25588w = (f13 * quaternion.f25588w) + (f * quaternion2.f25588w);
        return this;
    }

    public void slerp(Quaternion quaternion, float f) {
        if (this.f25589x != quaternion.f25589x || this.f25590y != quaternion.f25590y || this.f25591z != quaternion.f25591z || this.f25588w != quaternion.f25588w) {
            float f2 = this.f25589x;
            float f3 = quaternion.f25589x;
            float f4 = this.f25590y;
            float f5 = quaternion.f25590y;
            float f6 = (f2 * f3) + (f4 * f5);
            float f7 = this.f25591z;
            float f8 = quaternion.f25591z;
            float f9 = f6 + (f7 * f8);
            float f10 = this.f25588w;
            float f11 = quaternion.f25588w;
            float f12 = f9 + (f10 * f11);
            if (f12 < 0.0f) {
                quaternion.f25589x = -f3;
                quaternion.f25590y = -f5;
                quaternion.f25591z = -f8;
                quaternion.f25588w = -f11;
                f12 = -f12;
            }
            float f13 = 1.0f - f;
            if (1.0f - f12 > 0.1f) {
                float acos = FastMath.acos(f12);
                float sin = 1.0f / FastMath.sin(acos);
                f13 = FastMath.sin(f13 * acos) * sin;
                f = FastMath.sin(f * acos) * sin;
            }
            this.f25589x = (this.f25589x * f13) + (quaternion.f25589x * f);
            this.f25590y = (this.f25590y * f13) + (quaternion.f25590y * f);
            this.f25591z = (this.f25591z * f13) + (quaternion.f25591z * f);
            this.f25588w = (f13 * this.f25588w) + (f * quaternion.f25588w);
        }
    }

    public void nlerp(Quaternion quaternion, float f) {
        float f2 = 1.0f - f;
        if (dot(quaternion) < 0.0f) {
            this.f25589x = (this.f25589x * f2) - (quaternion.f25589x * f);
            this.f25590y = (this.f25590y * f2) - (quaternion.f25590y * f);
            this.f25591z = (this.f25591z * f2) - (quaternion.f25591z * f);
            this.f25588w = (f2 * this.f25588w) - (f * quaternion.f25588w);
        } else {
            this.f25589x = (this.f25589x * f2) + (quaternion.f25589x * f);
            this.f25590y = (this.f25590y * f2) + (quaternion.f25590y * f);
            this.f25591z = (this.f25591z * f2) + (quaternion.f25591z * f);
            this.f25588w = (f2 * this.f25588w) + (f * quaternion.f25588w);
        }
        normalizeLocal();
    }

    public Quaternion add(Quaternion quaternion) {
        return new Quaternion(this.f25589x + quaternion.f25589x, this.f25590y + quaternion.f25590y, this.f25591z + quaternion.f25591z, this.f25588w + quaternion.f25588w);
    }

    public Quaternion addLocal(Quaternion quaternion) {
        this.f25589x += quaternion.f25589x;
        this.f25590y += quaternion.f25590y;
        this.f25591z += quaternion.f25591z;
        this.f25588w += quaternion.f25588w;
        return this;
    }

    public Quaternion subtract(Quaternion quaternion) {
        return new Quaternion(this.f25589x - quaternion.f25589x, this.f25590y - quaternion.f25590y, this.f25591z - quaternion.f25591z, this.f25588w - quaternion.f25588w);
    }

    public Quaternion subtractLocal(Quaternion quaternion) {
        this.f25589x -= quaternion.f25589x;
        this.f25590y -= quaternion.f25590y;
        this.f25591z -= quaternion.f25591z;
        this.f25588w -= quaternion.f25588w;
        return this;
    }

    public Quaternion mult(Quaternion quaternion) {
        return mult(quaternion, (Quaternion) null);
    }

    public Quaternion mult(Quaternion quaternion, Quaternion quaternion2) {
        if (quaternion2 == null) {
            quaternion2 = new Quaternion();
        }
        float f = quaternion.f25588w;
        float f2 = quaternion.f25589x;
        float f3 = quaternion.f25590y;
        float f4 = quaternion.f25591z;
        float f5 = this.f25590y;
        float f6 = (this.f25589x * f) + (f5 * f4);
        float f7 = this.f25591z;
        float f8 = this.f25588w;
        quaternion2.f25589x = (f6 - (f7 * f3)) + (f8 * f2);
        float f9 = this.f25589x;
        quaternion2.f25590y = ((-f9) * f4) + (f5 * f) + (f7 * f2) + (f8 * f3);
        float f10 = this.f25590y;
        quaternion2.f25591z = ((f9 * f3) - (f10 * f2)) + (f7 * f) + (f8 * f4);
        quaternion2.f25588w = ((((-f9) * f2) - (f10 * f3)) - (this.f25591z * f4)) + (f8 * f);
        return quaternion2;
    }

    public void apply(Matrix3f matrix3f) {
        float f = this.f25589x;
        float f2 = this.f25590y;
        float f3 = this.f25591z;
        float f4 = this.f25588w;
        fromRotationMatrix(matrix3f);
        float f5 = this.f25589x;
        float f6 = this.f25590y;
        float f7 = this.f25591z;
        float f8 = this.f25588w;
        this.f25589x = (((f * f8) + (f2 * f7)) - (f3 * f6)) + (f4 * f5);
        float f9 = -f;
        this.f25590y = (f9 * f7) + (f2 * f8) + (f3 * f5) + (f4 * f6);
        this.f25591z = ((f * f6) - (f2 * f5)) + (f3 * f8) + (f4 * f7);
        this.f25588w = (((f9 * f5) - (f2 * f6)) - (f3 * f7)) + (f4 * f8);
    }

    public Quaternion fromAxes(Vector3f[] vector3fArr) {
        if (vector3fArr.length == 3) {
            return fromAxes(vector3fArr[0], vector3fArr[1], vector3fArr[2]);
        }
        throw new IllegalArgumentException("Axis array must have three elements");
    }

    public Quaternion fromAxes(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        return fromRotationMatrix(vector3f.f25609x, vector3f2.f25609x, vector3f3.f25609x, vector3f.f25610y, vector3f2.f25610y, vector3f3.f25610y, vector3f.f25611z, vector3f2.f25611z, vector3f3.f25611z);
    }

    public void toAxes(Vector3f[] vector3fArr) {
        Matrix3f rotationMatrix = toRotationMatrix();
        vector3fArr[0] = rotationMatrix.getColumn(0, vector3fArr[0]);
        vector3fArr[1] = rotationMatrix.getColumn(1, vector3fArr[1]);
        vector3fArr[2] = rotationMatrix.getColumn(2, vector3fArr[2]);
    }

    public Vector3f mult(Vector3f vector3f) {
        return mult(vector3f, (Vector3f) null);
    }

    public Vector3f multLocal(Vector3f vector3f) {
        float f = this.f25588w;
        float f2 = (((f * f) * vector3f.f25609x) + (((this.f25590y * 2.0f) * this.f25588w) * vector3f.f25611z)) - (((this.f25591z * 2.0f) * this.f25588w) * vector3f.f25610y);
        float f3 = this.f25589x;
        float f4 = f2 + (f3 * f3 * vector3f.f25609x) + (this.f25590y * 2.0f * this.f25589x * vector3f.f25610y) + (this.f25591z * 2.0f * this.f25589x * vector3f.f25611z);
        float f5 = this.f25591z;
        float f6 = f4 - ((f5 * f5) * vector3f.f25609x);
        float f7 = this.f25590y;
        float f8 = f6 - ((f7 * f7) * vector3f.f25609x);
        float f9 = this.f25589x * 2.0f * this.f25590y * vector3f.f25609x;
        float f10 = this.f25590y;
        float f11 = f9 + (f10 * f10 * vector3f.f25610y) + (this.f25591z * 2.0f * this.f25590y * vector3f.f25611z) + (this.f25588w * 2.0f * this.f25591z * vector3f.f25609x);
        float f12 = this.f25591z;
        float f13 = f11 - ((f12 * f12) * vector3f.f25610y);
        float f14 = this.f25588w;
        float f15 = (f13 + ((f14 * f14) * vector3f.f25610y)) - (((this.f25589x * 2.0f) * this.f25588w) * vector3f.f25611z);
        float f16 = this.f25589x;
        float f17 = f15 - ((f16 * f16) * vector3f.f25610y);
        float f18 = (this.f25589x * 2.0f * this.f25591z * vector3f.f25609x) + (this.f25590y * 2.0f * this.f25591z * vector3f.f25610y);
        float f19 = this.f25591z;
        float f20 = (f18 + ((f19 * f19) * vector3f.f25611z)) - (((this.f25588w * 2.0f) * this.f25590y) * vector3f.f25609x);
        float f21 = this.f25590y;
        float f22 = this.f25589x;
        float f23 = ((f20 - ((f21 * f21) * vector3f.f25611z)) + (((this.f25588w * 2.0f) * this.f25589x) * vector3f.f25610y)) - ((f22 * f22) * vector3f.f25611z);
        float f24 = this.f25588w;
        vector3f.f25611z = f23 + (f24 * f24 * vector3f.f25611z);
        vector3f.f25609x = f8;
        vector3f.f25610y = f17;
        return vector3f;
    }

    public Quaternion multLocal(Quaternion quaternion) {
        float f = this.f25589x;
        float f2 = quaternion.f25588w;
        float f3 = this.f25590y;
        float f4 = quaternion.f25591z;
        float f5 = this.f25591z;
        float f6 = quaternion.f25590y;
        float f7 = this.f25588w;
        float f8 = quaternion.f25589x;
        this.f25588w = ((((-f) * f8) - (f3 * f6)) - (f5 * f4)) + (f7 * f2);
        this.f25589x = (((f * f2) + (f3 * f4)) - (f5 * f6)) + (f7 * f8);
        this.f25590y = ((-f) * f4) + (f3 * f2) + (f5 * f8) + (f7 * f6);
        this.f25591z = ((f * f6) - (f3 * f8)) + (f5 * f2) + (f7 * f4);
        return this;
    }

    public Quaternion multLocal(float f, float f2, float f3, float f4) {
        float f5 = this.f25589x;
        float f6 = this.f25590y;
        float f7 = this.f25591z;
        float f8 = this.f25588w;
        this.f25588w = ((((-f5) * f) - (f6 * f2)) - (f7 * f3)) + (f8 * f4);
        this.f25589x = (((f5 * f4) + (f6 * f3)) - (f7 * f2)) + (f8 * f);
        this.f25590y = ((-f5) * f3) + (f6 * f4) + (f7 * f) + (f8 * f2);
        this.f25591z = ((f5 * f2) - (f6 * f)) + (f7 * f4) + (f8 * f3);
        return this;
    }

    public Vector3f mult(Vector3f vector3f, Vector3f vector3f2) {
        if (vector3f2 == null) {
            vector3f2 = new Vector3f();
        }
        if (vector3f.f25609x == 0.0f && vector3f.f25610y == 0.0f && vector3f.f25611z == 0.0f) {
            vector3f2.set(0.0f, 0.0f, 0.0f);
        } else {
            float f = vector3f.f25609x;
            float f2 = vector3f.f25610y;
            float f3 = vector3f.f25611z;
            float f4 = this.f25588w;
            float f5 = this.f25590y;
            float f6 = (f4 * f4 * f) + (f5 * 2.0f * f4 * f3);
            float f7 = this.f25591z;
            float f8 = this.f25589x;
            vector3f2.f25609x = (((((f6 - (((f7 * 2.0f) * f4) * f2)) + ((f8 * f8) * f)) + (((f5 * 2.0f) * f8) * f2)) + (((f7 * 2.0f) * f8) * f3)) - ((f7 * f7) * f)) - ((f5 * f5) * f);
            float f9 = this.f25589x;
            float f10 = this.f25590y;
            float f11 = (f9 * 2.0f * f10 * f) + (f10 * f10 * f2);
            float f12 = this.f25591z;
            float f13 = this.f25588w;
            vector3f2.f25610y = (((((f11 + (((f12 * 2.0f) * f10) * f3)) + (((f13 * 2.0f) * f12) * f)) - ((f12 * f12) * f2)) + ((f13 * f13) * f2)) - (((f9 * 2.0f) * f13) * f3)) - ((f9 * f9) * f2);
            float f14 = this.f25589x;
            float f15 = this.f25591z;
            float f16 = this.f25590y;
            float f17 = (f14 * 2.0f * f15 * f) + (f16 * 2.0f * f15 * f2) + (f15 * f15 * f3);
            float f18 = this.f25588w;
            vector3f2.f25611z = ((((f17 - (((f18 * 2.0f) * f16) * f)) - ((f16 * f16) * f3)) + (((2.0f * f18) * f14) * f2)) - ((f14 * f14) * f3)) + (f18 * f18 * f3);
        }
        return vector3f2;
    }

    public Quaternion mult(float f) {
        return new Quaternion(this.f25589x * f, this.f25590y * f, this.f25591z * f, f * this.f25588w);
    }

    public Quaternion multLocal(float f) {
        this.f25588w *= f;
        this.f25589x *= f;
        this.f25590y *= f;
        this.f25591z *= f;
        return this;
    }

    public float dot(Quaternion quaternion) {
        return (this.f25588w * quaternion.f25588w) + (this.f25589x * quaternion.f25589x) + (this.f25590y * quaternion.f25590y) + (this.f25591z * quaternion.f25591z);
    }

    public float norm() {
        float f = this.f25588w;
        float f2 = this.f25589x;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.f25590y;
        float f5 = f3 + (f4 * f4);
        float f6 = this.f25591z;
        return f5 + (f6 * f6);
    }

    @Deprecated
    public void normalize() {
        float invSqrt = FastMath.invSqrt(norm());
        this.f25589x *= invSqrt;
        this.f25590y *= invSqrt;
        this.f25591z *= invSqrt;
        this.f25588w *= invSqrt;
    }

    public void normalizeLocal() {
        float invSqrt = FastMath.invSqrt(norm());
        this.f25589x *= invSqrt;
        this.f25590y *= invSqrt;
        this.f25591z *= invSqrt;
        this.f25588w *= invSqrt;
    }

    public Quaternion inverse() {
        float norm = norm();
        if (((double) norm) <= 0.0d) {
            return null;
        }
        float f = 1.0f / norm;
        return new Quaternion((-this.f25589x) * f, (-this.f25590y) * f, (-this.f25591z) * f, this.f25588w * f);
    }

    public Quaternion inverseLocal() {
        float norm = norm();
        if (((double) norm) > 0.0d) {
            float f = 1.0f / norm;
            float f2 = -f;
            this.f25589x *= f2;
            this.f25590y *= f2;
            this.f25591z *= f2;
            this.f25588w *= f;
        }
        return this;
    }

    public void negate() {
        this.f25589x *= -1.0f;
        this.f25590y *= -1.0f;
        this.f25591z *= -1.0f;
        this.f25588w *= -1.0f;
    }

    public String toString() {
        return "(" + this.f25589x + ", " + this.f25590y + ", " + this.f25591z + ", " + this.f25588w + ")";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Quaternion)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Quaternion quaternion = (Quaternion) obj;
        return Float.compare(this.f25589x, quaternion.f25589x) == 0 && Float.compare(this.f25590y, quaternion.f25590y) == 0 && Float.compare(this.f25591z, quaternion.f25591z) == 0 && Float.compare(this.f25588w, quaternion.f25588w) == 0;
    }

    public int hashCode() {
        return ((((((1369 + Float.floatToIntBits(this.f25589x)) * 37) + Float.floatToIntBits(this.f25590y)) * 37) + Float.floatToIntBits(this.f25591z)) * 37) + Float.floatToIntBits(this.f25588w);
    }

    public void readExternal(ObjectInput objectInput) throws IOException {
        this.f25589x = objectInput.readFloat();
        this.f25590y = objectInput.readFloat();
        this.f25591z = objectInput.readFloat();
        this.f25588w = objectInput.readFloat();
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeFloat(this.f25589x);
        objectOutput.writeFloat(this.f25590y);
        objectOutput.writeFloat(this.f25591z);
        objectOutput.writeFloat(this.f25588w);
    }

    public Quaternion opposite() {
        return opposite((Quaternion) null);
    }

    public Quaternion opposite(Quaternion quaternion) {
        if (quaternion == null) {
            quaternion = new Quaternion();
        }
        Vector3f vector3f = new Vector3f();
        quaternion.fromAngleAxis(toAngleAxis(vector3f) + 3.1415927f, vector3f);
        return quaternion;
    }

    public Quaternion oppositeLocal() {
        return opposite(this);
    }

    public Quaternion clone() {
        try {
            return (Quaternion) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
