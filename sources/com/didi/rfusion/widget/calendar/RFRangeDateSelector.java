package com.didi.rfusion.widget.calendar;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.Pair;
import com.didi.rfusion.material.internal.RFPreconditions;
import java.util.ArrayList;
import java.util.Collection;

public class RFRangeDateSelector implements RFDateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RFRangeDateSelector> CREATOR = new Parcelable.Creator<RFRangeDateSelector>() {
        public RFRangeDateSelector createFromParcel(Parcel parcel) {
            RFRangeDateSelector rFRangeDateSelector = new RFRangeDateSelector();
            Long unused = rFRangeDateSelector.f36226a = (Long) parcel.readValue(Long.class.getClassLoader());
            Long unused2 = rFRangeDateSelector.f36227b = (Long) parcel.readValue(Long.class.getClassLoader());
            return rFRangeDateSelector;
        }

        public RFRangeDateSelector[] newArray(int i) {
            return new RFRangeDateSelector[i];
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Long f36226a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Long f36227b = null;

    /* renamed from: a */
    private boolean m27241a(long j, long j2) {
        return j <= j2;
    }

    public int describeContents() {
        return 0;
    }

    public void select(long j) {
        Long l = this.f36226a;
        if (l == null) {
            this.f36226a = Long.valueOf(j);
        } else if (this.f36227b != null || !m27241a(l.longValue(), j)) {
            this.f36227b = null;
            this.f36226a = Long.valueOf(j);
        } else {
            this.f36227b = Long.valueOf(j);
        }
    }

    public boolean isSelectionComplete() {
        Long l = this.f36226a;
        return (l == null || this.f36227b == null || !m27241a(l.longValue(), this.f36227b.longValue())) ? false : true;
    }

    public void setSelection(Pair<Long, Long> pair) {
        if (!(pair.first == null || pair.second == null)) {
            RFPreconditions.checkArgument(m27241a(((Long) pair.first).longValue(), ((Long) pair.second).longValue()));
        }
        Long l = null;
        this.f36226a = pair.first == null ? null : Long.valueOf(C12368e.m27281a(((Long) pair.first).longValue()));
        if (pair.second != null) {
            l = Long.valueOf(C12368e.m27281a(((Long) pair.second).longValue()));
        }
        this.f36227b = l;
    }

    public Pair<Long, Long> getSelection() {
        return new Pair<>(this.f36226a, this.f36227b);
    }

    public Collection<Pair<Long, Long>> getSelectedRanges() {
        if (this.f36226a == null || this.f36227b == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(this.f36226a, this.f36227b));
        return arrayList;
    }

    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l = this.f36226a;
        if (l != null) {
            arrayList.add(l);
        }
        Long l2 = this.f36227b;
        if (l2 != null) {
            arrayList.add(l2);
        }
        return arrayList;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f36226a);
        parcel.writeValue(this.f36227b);
    }
}
