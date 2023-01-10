package com.didi.sdk.misconfig.p154v2.impl;

import com.didi.sdk.misconfig.store.ICityChangeListener;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.sdk.misconfig.v2.impl.CityChangedNotifier */
public class CityChangedNotifier {

    /* renamed from: a */
    private List<ICityChangeListener> f39620a = new ArrayList();

    public void registerCityChangeListener(ICityChangeListener iCityChangeListener) {
        if (iCityChangeListener != null) {
            synchronized (this.f39620a) {
                if (!this.f39620a.contains(iCityChangeListener)) {
                    this.f39620a.add(iCityChangeListener);
                }
            }
        }
    }

    public void unRegisterCityChangeListener(ICityChangeListener iCityChangeListener) {
        if (iCityChangeListener != null) {
            synchronized (this.f39620a) {
                this.f39620a.remove(iCityChangeListener);
            }
        }
    }

    public void dispatchCityChangeEvent(int i, int i2) {
        synchronized (this.f39620a) {
            if (this.f39620a != null) {
                int size = this.f39620a.size();
                for (int i3 = 0; i3 < size; i3++) {
                    this.f39620a.get(i3).onCityChange(i, i2);
                }
            }
        }
    }
}
