package com.google.android.gms.internal.instantapps;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzey extends zzez<FieldDescriptorType, Object> {
    zzey(int i) {
        super(i, (zzey) null);
    }

    public final void zzs() {
        if (!isImmutable()) {
            for (int i = 0; i < zzdr(); i++) {
                Map.Entry zzav = zzav(i);
                if (((zzcs) zzav.getKey()).zzbp()) {
                    zzav.setValue(Collections.unmodifiableList((List) zzav.getValue()));
                }
            }
            for (Map.Entry entry : zzds()) {
                if (((zzcs) entry.getKey()).zzbp()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzs();
    }
}
