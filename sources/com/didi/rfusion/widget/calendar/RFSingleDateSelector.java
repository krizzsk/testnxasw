package com.didi.rfusion.widget.calendar;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.Pair;
import java.util.ArrayList;
import java.util.Collection;

public class RFSingleDateSelector implements RFDateSelector<Long> {
    public static final Parcelable.Creator<RFSingleDateSelector> CREATOR = new Parcelable.Creator<RFSingleDateSelector>() {
        public RFSingleDateSelector createFromParcel(Parcel parcel) {
            RFSingleDateSelector rFSingleDateSelector = new RFSingleDateSelector();
            Long unused = rFSingleDateSelector.f36228a = (Long) parcel.readValue(Long.class.getClassLoader());
            return rFSingleDateSelector;
        }

        public RFSingleDateSelector[] newArray(int i) {
            return new RFSingleDateSelector[i];
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Long f36228a;

    public int describeContents() {
        return 0;
    }

    public void select(long j) {
        this.f36228a = Long.valueOf(j);
    }

    /* renamed from: a */
    private void m27244a() {
        this.f36228a = null;
    }

    public void setSelection(Long l) {
        this.f36228a = l == null ? null : Long.valueOf(C12368e.m27281a(l.longValue()));
    }

    public boolean isSelectionComplete() {
        return this.f36228a != null;
    }

    public Collection<Pair<Long, Long>> getSelectedRanges() {
        return new ArrayList();
    }

    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l = this.f36228a;
        if (l != null) {
            arrayList.add(l);
        }
        return arrayList;
    }

    public Long getSelection() {
        return this.f36228a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f36228a);
    }
}
