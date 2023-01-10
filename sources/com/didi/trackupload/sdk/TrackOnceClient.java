package com.didi.trackupload.sdk;

import android.text.TextUtils;
import com.didi.trackupload.sdk.utils.TrackLog;
import java.util.Locale;
import rui.config.RConfigConstants;

public class TrackOnceClient {

    /* renamed from: a */
    private static final String f46545a = "TrackOnceClient";

    /* renamed from: b */
    private TrackClientType f46546b;

    /* renamed from: c */
    private String f46547c;

    /* renamed from: d */
    private ITrackDataDelegate f46548d;

    /* renamed from: e */
    private String f46549e;

    TrackOnceClient(TrackClientType trackClientType, String str) {
        this.f46546b = trackClientType;
        this.f46547c = str;
        this.f46549e = m34718a(trackClientType, str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo115876a() {
        int a = TrackController.getIntance().mo115843a(this);
        TrackLog.m34830d(f46545a, "startTrackOnce err=" + TrackErrInfo.toErrString(a) + " client=" + toString());
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo115877a(ITrackDataDelegate iTrackDataDelegate) {
        this.f46548d = iTrackDataDelegate;
        return 0;
    }

    public TrackClientType getClientType() {
        return this.f46546b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo115878b() {
        return this.f46547c;
    }

    public ITrackDataDelegate getTrackDataDelegate() {
        return this.f46548d;
    }

    /* renamed from: a */
    private static String m34718a(TrackClientType trackClientType, String str) {
        return RConfigConstants.KEYWORD_COLOR_SIGN + TrackClient.m34693a(trackClientType, str);
    }

    public String getTrackTag() {
        return this.f46549e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TrackOnceClient) {
            return TextUtils.equals(getTrackTag(), ((TrackOnceClient) obj).getTrackTag());
        }
        return false;
    }

    public int hashCode() {
        String str = this.f46549e;
        return 0 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "TrackOnceClient@%s{type=%s, trackid=%s, tag=%s, dataDelegate=%s}", new Object[]{Integer.toHexString(hashCode()), this.f46546b, this.f46547c, this.f46549e, this.f46548d});
    }

    public String toSimpleString() {
        return String.format(Locale.getDefault(), "TrackOnceClient@%s{tag=%s}", new Object[]{Integer.toHexString(hashCode()), this.f46549e});
    }
}
