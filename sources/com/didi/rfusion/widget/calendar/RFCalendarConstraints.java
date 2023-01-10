package com.didi.rfusion.widget.calendar;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.ObjectsCompat;
import java.util.Arrays;

public final class RFCalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<RFCalendarConstraints> CREATOR = new Parcelable.Creator<RFCalendarConstraints>() {
        public RFCalendarConstraints createFromParcel(Parcel parcel) {
            return new RFCalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()));
        }

        public RFCalendarConstraints[] newArray(int i) {
            return new RFCalendarConstraints[i];
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Month f36189a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Month f36190b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final DateValidator f36191c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Month f36192d;

    /* renamed from: e */
    private final int f36193e;

    /* renamed from: f */
    private final int f36194f;

    public interface DateValidator extends Parcelable {
        boolean isValid(long j);
    }

    public int describeContents() {
        return 0;
    }

    private RFCalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3) {
        this.f36189a = month;
        this.f36190b = month2;
        this.f36192d = month3;
        this.f36191c = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (month3 == null || month3.compareTo(month2) <= 0) {
            this.f36194f = month.mo93958b(month2) + 1;
            this.f36193e = (month2.f36161b - month.f36161b) + 1;
        } else {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo93988a(long j) {
        if (this.f36189a.mo93954a(1) <= j) {
            Month month = this.f36190b;
            if (j <= month.mo93954a(month.f36163d)) {
                return true;
            }
        }
        return false;
    }

    public DateValidator getDateValidator() {
        return this.f36191c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Month mo93986a() {
        return this.f36189a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Month mo93989b() {
        return this.f36190b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Month mo93991c() {
        return this.f36192d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo93987a(Month month) {
        this.f36192d = month;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo93992d() {
        return this.f36194f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo93994e() {
        return this.f36193e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFCalendarConstraints)) {
            return false;
        }
        RFCalendarConstraints rFCalendarConstraints = (RFCalendarConstraints) obj;
        if (!this.f36189a.equals(rFCalendarConstraints.f36189a) || !this.f36190b.equals(rFCalendarConstraints.f36190b) || !ObjectsCompat.equals(this.f36192d, rFCalendarConstraints.f36192d) || !this.f36191c.equals(rFCalendarConstraints.f36191c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f36189a, this.f36190b, this.f36192d, this.f36191c});
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f36189a, 0);
        parcel.writeParcelable(this.f36190b, 0);
        parcel.writeParcelable(this.f36192d, 0);
        parcel.writeParcelable(this.f36191c, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Month mo93990b(Month month) {
        if (month.compareTo(this.f36189a) < 0) {
            return this.f36189a;
        }
        return month.compareTo(this.f36190b) > 0 ? this.f36190b : month;
    }

    public static final class Builder {
        private static final String DEEP_COPY_VALIDATOR_KEY = "DEEP_COPY_VALIDATOR_KEY";
        static final long DEFAULT_END = C12368e.m27281a(Month.m27200a(2100, 11).f36164e);
        static final long DEFAULT_START = C12368e.m27281a(Month.m27200a(1970, 0).f36164e);
        private long end = DEFAULT_END;
        private Long openAt;
        private long start = DEFAULT_START;
        private DateValidator validator = RFDateValidatorPointForward.from(Long.MIN_VALUE);

        public Builder() {
        }

        Builder(RFCalendarConstraints rFCalendarConstraints) {
            this.start = rFCalendarConstraints.f36189a.f36164e;
            this.end = rFCalendarConstraints.f36190b.f36164e;
            this.openAt = Long.valueOf(rFCalendarConstraints.f36192d.f36164e);
            this.validator = rFCalendarConstraints.f36191c;
        }

        public Builder setStart(long j) {
            this.start = j;
            return this;
        }

        public Builder setEnd(long j) {
            this.end = j;
            return this;
        }

        public Builder setOpenAt(long j) {
            this.openAt = Long.valueOf(j);
            return this;
        }

        public Builder setValidator(DateValidator dateValidator) {
            this.validator = dateValidator;
            return this;
        }

        public RFCalendarConstraints build() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(DEEP_COPY_VALIDATOR_KEY, this.validator);
            Month a = Month.m27201a(this.start);
            Month a2 = Month.m27201a(this.end);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable(DEEP_COPY_VALIDATOR_KEY);
            Long l = this.openAt;
            return new RFCalendarConstraints(a, a2, dateValidator, l == null ? null : Month.m27201a(l.longValue()));
        }
    }
}
