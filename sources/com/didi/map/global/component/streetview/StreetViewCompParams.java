package com.didi.map.global.component.streetview;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;

public class StreetViewCompParams {

    /* renamed from: a */
    private boolean f28476a;

    /* renamed from: b */
    private boolean f28477b;

    /* renamed from: c */
    private boolean f28478c;

    /* renamed from: d */
    private boolean f28479d;

    /* renamed from: e */
    private boolean f28480e;

    /* renamed from: f */
    private String f28481f;

    /* renamed from: g */
    private String f28482g;

    /* renamed from: h */
    private String f28483h;

    /* renamed from: i */
    private String f28484i;

    /* renamed from: j */
    private FragmentActivity f28485j;

    /* renamed from: k */
    private StreetVersion f28486k;

    /* renamed from: l */
    private String f28487l;

    public boolean isStreetNamesEnable() {
        return this.f28476a;
    }

    public boolean isZoomGesturesEnable() {
        return this.f28477b;
    }

    public boolean isPanningGesturesEnable() {
        return this.f28478c;
    }

    public boolean isUserNavigationEnabled() {
        return this.f28479d;
    }

    public String getStreetViewUrl() {
        return this.f28481f;
    }

    public String getTripId() {
        return TextUtils.isEmpty(this.f28482g) ? "tripId" : this.f28482g;
    }

    public String getOrderId() {
        return this.f28483h;
    }

    public String getUid() {
        return this.f28484i;
    }

    public boolean isShowGuideTipsText() {
        return this.f28480e;
    }

    public FragmentActivity getActivity() {
        return this.f28485j;
    }

    public StreetVersion getStreetVersion() {
        return this.f28486k;
    }

    public String getStreetHintContent() {
        return this.f28487l;
    }

    private StreetViewCompParams(Builder builder) {
        this.f28485j = builder.activity;
        this.f28476a = builder.streetNamesEnable;
        this.f28477b = builder.zoomGesturesEnable;
        this.f28478c = builder.panningGesturesEnable;
        this.f28479d = builder.userNavigationEnabled;
        this.f28481f = builder.streetViewUrl;
        this.f28482g = builder.tripId;
        this.f28480e = builder.showGuideTipsText;
        this.f28483h = builder.orderId;
        this.f28484i = builder.uid;
        this.f28486k = builder.streetVersion;
        this.f28487l = builder.streetHintContent;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public FragmentActivity activity;
        /* access modifiers changed from: private */
        public String orderId;
        /* access modifiers changed from: private */
        public boolean panningGesturesEnable;
        /* access modifiers changed from: private */
        public boolean showGuideTipsText = true;
        /* access modifiers changed from: private */
        public String streetHintContent;
        /* access modifiers changed from: private */
        public boolean streetNamesEnable;
        /* access modifiers changed from: private */
        public StreetVersion streetVersion;
        /* access modifiers changed from: private */
        public String streetViewUrl;
        /* access modifiers changed from: private */
        public String tripId;
        /* access modifiers changed from: private */
        public String uid;
        /* access modifiers changed from: private */
        public boolean userNavigationEnabled;
        /* access modifiers changed from: private */
        public boolean zoomGesturesEnable;

        private void debugThrowException(String str) {
        }

        public Builder activity(FragmentActivity fragmentActivity) {
            this.activity = fragmentActivity;
            return this;
        }

        public Builder setStreetHintContent(String str) {
            this.streetHintContent = str;
            return this;
        }

        public Builder streetNamesEnabled(boolean z) {
            this.streetNamesEnable = z;
            return this;
        }

        public Builder setStreetVersion(StreetVersion streetVersion2) {
            this.streetVersion = streetVersion2;
            return this;
        }

        public Builder zoomGesturesEnabled(boolean z) {
            this.zoomGesturesEnable = z;
            return this;
        }

        public Builder panningGesturesEnable(boolean z) {
            this.panningGesturesEnable = z;
            return this;
        }

        public Builder userNavigationEnabled(boolean z) {
            this.userNavigationEnabled = z;
            return this;
        }

        public Builder streetViewUrl(String str) {
            this.streetViewUrl = str;
            return this;
        }

        public Builder tripId(String str) {
            this.tripId = str;
            return this;
        }

        public Builder showGuideTipsText(boolean z) {
            this.showGuideTipsText = z;
            return this;
        }

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder uid(String str) {
            this.uid = str;
            return this;
        }

        public StreetViewCompParams build() {
            checkParams();
            return new StreetViewCompParams(this);
        }

        private void checkParams() {
            if (this.activity == null) {
                debugThrowException("activity is null !!!");
            }
        }
    }
}
