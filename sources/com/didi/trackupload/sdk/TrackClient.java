package com.didi.trackupload.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.util.MD5;
import com.didi.trackupload.sdk.datachannel.protobuf.ClientType;
import com.didi.trackupload.sdk.utils.TrackLog;
import java.util.Locale;

public class TrackClient {

    /* renamed from: a */
    private static final String f46527a = "TrackClient";

    /* renamed from: b */
    private TrackClientType f46528b;

    /* renamed from: c */
    private String f46529c;

    /* renamed from: d */
    private TrackOptions f46530d;

    /* renamed from: e */
    private ITrackDataDelegate f46531e;

    /* renamed from: f */
    private String f46532f;

    TrackClient(TrackClientType trackClientType, String str) {
        this.f46528b = trackClientType;
        this.f46529c = str;
        this.f46532f = m34693a(trackClientType, str);
    }

    public int startTrack() {
        int a = TrackController.getIntance().mo115842a(this);
        TrackLog.m34830d(f46527a, "startTrack err=" + TrackErrInfo.toErrString(a) + " client=" + toString());
        StringBuilder sb = new StringBuilder();
        sb.append("startTrack trace=");
        sb.append(Log.getStackTraceString(new Throwable()));
        TrackLog.m34830d(f46527a, sb.toString());
        return a;
    }

    public int stopTrack() {
        int b = TrackController.getIntance().mo115847b(this);
        TrackLog.m34830d(f46527a, "stopTrack err=" + TrackErrInfo.toErrString(b) + " client=" + toSimpleString());
        StringBuilder sb = new StringBuilder();
        sb.append("stopTrack trace=");
        sb.append(Log.getStackTraceString(new Throwable()));
        TrackLog.m34830d(f46527a, sb.toString());
        return b;
    }

    public int setTrackOptions(TrackOptions trackOptions) {
        this.f46530d = trackOptions;
        int c = TrackController.getIntance().mo115848c(this);
        TrackLog.m34830d(f46527a, "setTrackOptions err=" + TrackErrInfo.toErrString(c) + " client=" + toString());
        return c;
    }

    public int setTrackDataDelegate(ITrackDataDelegate iTrackDataDelegate) {
        this.f46531e = iTrackDataDelegate;
        int c = TrackController.getIntance().mo115848c(this);
        TrackLog.m34830d(f46527a, "setTrackDataDelegate err=" + TrackErrInfo.toErrString(c) + " client=" + toString());
        return c;
    }

    public boolean isRunning() {
        return TrackController.getIntance().mo115849d(this);
    }

    public TrackClientType getClientType() {
        return this.f46528b;
    }

    public String getTrackId() {
        return this.f46529c;
    }

    public TrackOptions getTrackOptions() {
        return this.f46530d;
    }

    public ITrackDataDelegate getTrackDataDelegate() {
        return this.f46531e;
    }

    /* renamed from: a */
    static String m34693a(TrackClientType trackClientType, String str) {
        ClientType protoValue = trackClientType != null ? trackClientType.getProtoValue() : null;
        int value = protoValue != null ? protoValue.getValue() : 0;
        if (!TextUtils.isEmpty(str)) {
            String md5 = MD5.toMD5("" + value + str);
            if (md5 != null && md5.length() == 32) {
                return md5.toLowerCase().substring(12, 20);
            }
        }
        return "(" + value + str + ")";
    }

    public String getTrackTag() {
        return this.f46532f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public TrackClient mo115825a() {
        TrackClient trackClient = new TrackClient(this.f46528b, this.f46529c);
        TrackOptions trackOptions = this.f46530d;
        if (trackOptions != null) {
            trackClient.f46530d = new TrackOptions(trackOptions.getGatherIntervalMode(), this.f46530d.getUploadIntervalMode());
        }
        ITrackDataDelegate iTrackDataDelegate = this.f46531e;
        if (iTrackDataDelegate != null) {
            trackClient.f46531e = iTrackDataDelegate;
        }
        return trackClient;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TrackClient) {
            return TextUtils.equals(getTrackTag(), ((TrackClient) obj).getTrackTag());
        }
        return false;
    }

    public int hashCode() {
        String str = this.f46532f;
        return 0 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "TrackClient@%s{type=%s, trackid=%s, tag=%s, options=%s, dataDelegate=%s}", new Object[]{Integer.toHexString(hashCode()), this.f46528b, this.f46529c, this.f46532f, this.f46530d, this.f46531e});
    }

    public String toSimpleString() {
        return String.format(Locale.getDefault(), "TrackClient@%s{tag=%s}", new Object[]{Integer.toHexString(hashCode()), this.f46532f});
    }
}
