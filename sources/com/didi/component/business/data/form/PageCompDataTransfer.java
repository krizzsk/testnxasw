package com.didi.component.business.data.form;

import com.didi.component.business.data.form.listener.CommonListener;
import com.didi.component.business.data.form.listener.ConfirmGetListener;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.data.form.listener.HomeListener;
import com.didi.component.business.data.form.listener.TripListener;

public class PageCompDataTransfer {

    /* renamed from: a */
    private CommonListener f13122a;

    /* renamed from: b */
    private HomeListener f13123b;

    /* renamed from: c */
    private ConfirmListener f13124c;

    /* renamed from: d */
    private ConfirmGetListener f13125d;

    /* renamed from: e */
    private TripListener f13126e;

    private PageCompDataTransfer() {
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final PageCompDataTransfer INSTANCE = new PageCompDataTransfer();

        private SingletonHolder() {
        }
    }

    public static PageCompDataTransfer getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void setHomeListener(HomeListener homeListener) {
        this.f13123b = homeListener;
    }

    public HomeListener getHomeListener() {
        return this.f13123b;
    }

    public void setConfirmListener(ConfirmListener confirmListener) {
        this.f13124c = confirmListener;
    }

    public ConfirmListener getConfirmListener() {
        return this.f13124c;
    }

    public ConfirmGetListener getConfirmGetListener() {
        return this.f13125d;
    }

    public void setConfirmGetListener(ConfirmGetListener confirmGetListener) {
        this.f13125d = confirmGetListener;
    }

    public void setTripListener(TripListener tripListener) {
        this.f13126e = tripListener;
    }

    public TripListener getTripListener() {
        return this.f13126e;
    }

    public CommonListener getCommonListener() {
        return this.f13122a;
    }

    public void setCommonListener(CommonListener commonListener) {
        this.f13122a = commonListener;
    }
}
