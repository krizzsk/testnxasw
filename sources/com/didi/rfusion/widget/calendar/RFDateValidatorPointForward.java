package com.didi.rfusion.widget.calendar;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.rfusion.widget.calendar.RFCalendarConstraints;
import java.util.Arrays;

public class RFDateValidatorPointForward implements RFCalendarConstraints.DateValidator {
    public static final Parcelable.Creator<RFDateValidatorPointForward> CREATOR = new Parcelable.Creator<RFDateValidatorPointForward>() {
        public RFDateValidatorPointForward createFromParcel(Parcel parcel) {
            return new RFDateValidatorPointForward(parcel.readLong());
        }

        public RFDateValidatorPointForward[] newArray(int i) {
            return new RFDateValidatorPointForward[i];
        }
    };

    /* renamed from: a */
    private final long f36221a;

    public int describeContents() {
        return 0;
    }

    private RFDateValidatorPointForward(long j) {
        this.f36221a = j;
    }

    public static RFDateValidatorPointForward from(long j) {
        return new RFDateValidatorPointForward(j);
    }

    public static RFDateValidatorPointForward now() {
        return from(C12368e.m27292b().getTimeInMillis());
    }

    public boolean isValid(long j) {
        return j >= this.f36221a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f36221a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof RFDateValidatorPointForward) && this.f36221a == ((RFDateValidatorPointForward) obj).f36221a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f36221a)});
    }
}
