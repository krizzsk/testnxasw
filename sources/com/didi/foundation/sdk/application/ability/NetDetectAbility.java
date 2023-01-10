package com.didi.foundation.sdk.application.ability;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didi.foundation.sdk.location.LocationService;
import com.didi.foundation.sdk.service.AccountService;
import com.didi.foundation.sdk.service.DeviceService;
import com.didi.foundation.sdk.utils.NetUtil;
import com.didi.one.netdetect.DetectionTaskManager;
import com.didi.one.netdetect.model.DetectionParam;
import com.didi.one.netdetect.security.SignGenerator;
import com.didi.sdk.util.SystemUtil;
import com.didi.security.wireless.adapter.SecurityWrapper;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import didihttp.internal.trace.IdGenrator;
import java.util.Map;

public class NetDetectAbility {

    /* renamed from: a */
    private static final int f23022a = 180000;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Handler f23023b;

    /* renamed from: c */
    private String f23024c;

    /* renamed from: d */
    private String f23025d;

    /* renamed from: e */
    private String f23026e;

    /* renamed from: f */
    private Application f23027f;

    private NetDetectAbility(Builder builder) {
        this.f23023b = new Handler(Looper.getMainLooper());
        this.f23024c = builder.mTripCountry;
        this.f23025d = builder.mDataType;
        this.f23026e = builder.mApolloToggle;
        this.f23027f = builder.mContext;
    }

    public void init() {
        m18992a(this.f23027f, this.f23026e, this.f23025d, this.f23024c);
    }

    /* renamed from: a */
    private void m18992a(Application application, String str, String str2, String str3) {
        DetectionParam detectionParam = new DetectionParam();
        detectionParam.apolloName = str;
        if (!TextUtils.isEmpty(AccountService.getInstance().getCityId())) {
            detectionParam.cityId = Integer.parseInt(AccountService.getInstance().getCityId());
        } else {
            detectionParam.cityId = 0;
        }
        detectionParam.datatype = str2;
        detectionParam.phone = AccountService.getInstance().getPhone();
        detectionParam.uid = AccountService.getInstance().getUid();
        DIDILocation lastKnownLocation = LocationService.getInstance().getLastKnownLocation();
        if (lastKnownLocation != null) {
            detectionParam.lat = lastKnownLocation.getLatitude();
            detectionParam.lng = lastKnownLocation.getLongitude();
        }
        detectionParam.appVersion = SystemUtil.getVersionName(application);
        detectionParam.deviceId = DeviceService.getInstance().getDeviceId();
        detectionParam.traceId = IdGenrator.generate(NetUtil.getIpv4Address());
        detectionParam.tripCountry = str3;
        DetectionTaskManager.getInstance().init(application, detectionParam, new SignGenerator() {
            public String genSign(Map<String, String> map) {
                return SecurityWrapper.doSign(SecurityWrapper.prepareSign(map));
            }
        });
    }

    public void startDetection() {
        this.f23023b.postDelayed(new PingRunnable(), 180000);
    }

    public void startDetection(int i) {
        this.f23023b.postDelayed(new PingRunnable(), (long) i);
    }

    public void resumeDetection() {
        DetectionTaskManager.getInstance().resumeDetection();
    }

    public void stopDetection() {
        DetectionTaskManager.getInstance().stopDetection();
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public String mApolloToggle;
        /* access modifiers changed from: private */
        public Application mContext;
        /* access modifiers changed from: private */
        public String mDataType;
        /* access modifiers changed from: private */
        public String mTripCountry;

        public Builder setContext(Application application) {
            this.mContext = application;
            return this;
        }

        public Builder setDataType(String str) {
            this.mDataType = str;
            return this;
        }

        public Builder setTripCountry(String str) {
            this.mTripCountry = str;
            return this;
        }

        public Builder setApolloToggle(String str) {
            this.mApolloToggle = str;
            return this;
        }

        public NetDetectAbility Builder() {
            if (this.mContext == null) {
                throw new RuntimeException("mContext is null");
            } else if (TextUtils.isEmpty(this.mDataType)) {
                throw new RuntimeException("mDataType is null");
            } else if (!TextUtils.isEmpty(this.mApolloToggle)) {
                return new NetDetectAbility(this);
            } else {
                throw new RuntimeException("mApolloToggle is null");
            }
        }
    }

    private class PingRunnable implements Runnable {
        private PingRunnable() {
        }

        public void run() {
            DetectionTaskManager.getInstance().startDetection();
            NetDetectAbility.this.f23023b.postDelayed(this, 180000);
        }
    }
}
