package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.Utils;

public class Entry extends BaseEntry implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator<Entry>() {
        public Entry createFromParcel(Parcel parcel) {
            return new Entry(parcel);
        }

        public Entry[] newArray(int i) {
            return new Entry[i];
        }
    };

    /* renamed from: a */
    private float f54917a = 0.0f;

    public int describeContents() {
        return 0;
    }

    public Entry() {
    }

    public Entry(float f, float f2) {
        super(f2);
        this.f54917a = f;
    }

    public Entry(float f, float f2, Object obj) {
        super(f2, obj);
        this.f54917a = f;
    }

    public Entry(float f, float f2, Drawable drawable) {
        super(f2, drawable);
        this.f54917a = f;
    }

    public Entry(float f, float f2, Drawable drawable, Object obj) {
        super(f2, drawable, obj);
        this.f54917a = f;
    }

    public float getX() {
        return this.f54917a;
    }

    public void setX(float f) {
        this.f54917a = f;
    }

    public Entry copy() {
        return new Entry(this.f54917a, getY(), getData());
    }

    public boolean equalTo(Entry entry) {
        if (entry != null && entry.getData() == getData() && Math.abs(entry.f54917a - this.f54917a) <= Utils.FLOAT_EPSILON && Math.abs(entry.getY() - getY()) <= Utils.FLOAT_EPSILON) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Entry, x: " + this.f54917a + " y: " + getY();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f54917a);
        parcel.writeFloat(getY());
        if (getData() == null) {
            parcel.writeInt(0);
        } else if (getData() instanceof Parcelable) {
            parcel.writeInt(1);
            parcel.writeParcelable((Parcelable) getData(), i);
        } else {
            throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
        }
    }

    protected Entry(Parcel parcel) {
        this.f54917a = parcel.readFloat();
        setY(parcel.readFloat());
        if (parcel.readInt() == 1) {
            setData(parcel.readParcelable(Object.class.getClassLoader()));
        }
    }
}
