package com.didi.sdk.audiorecorder.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.didi.sdk.audiorecorder.utils.MediaUtil;
import java.io.File;

public class RecordResult implements Parcelable {
    public static final Parcelable.Creator<RecordResult> CREATOR = new Parcelable.Creator<RecordResult>() {
        public RecordResult createFromParcel(Parcel parcel) {
            return new RecordResult(parcel);
        }

        public RecordResult[] newArray(int i) {
            return new RecordResult[i];
        }
    };
    public static final String TABLE_NAME = "record_result";

    /* renamed from: a */
    private static final String f38186a = "null";

    /* renamed from: b */
    private static final String f38187b = "";

    /* renamed from: c */
    private static final String f38188c = "{}";

    /* renamed from: d */
    private static final int f38189d = 1000;

    /* renamed from: e */
    private String f38190e;

    /* renamed from: f */
    private String f38191f;

    /* renamed from: g */
    private String f38192g;

    /* renamed from: h */
    private String f38193h;

    /* renamed from: i */
    private long f38194i;

    /* renamed from: j */
    private long f38195j;

    /* renamed from: k */
    private long f38196k;

    /* renamed from: l */
    private long f38197l;

    /* renamed from: m */
    private String f38198m;

    /* renamed from: n */
    private int f38199n;

    /* renamed from: o */
    private int f38200o;

    /* renamed from: p */
    private String f38201p;

    /* renamed from: q */
    private String f38202q;

    /* renamed from: r */
    private int f38203r;

    /* renamed from: s */
    private String f38204s;

    /* renamed from: t */
    private String f38205t;

    /* renamed from: u */
    private String f38206u;

    /* renamed from: v */
    private String f38207v;

    public int describeContents() {
        return 0;
    }

    public String getAudioFilePath() {
        return this.f38193h;
    }

    public void setAudioFilePath(String str) {
        this.f38193h = str;
    }

    public long getStartRecordTime() {
        return this.f38196k;
    }

    public void setStartRecordTime(long j) {
        this.f38196k = j;
    }

    public long getFinishRecordTime() {
        return this.f38197l;
    }

    public void setFinishRecordTime(long j) {
        this.f38197l = j;
    }

    public String getOrderIds() {
        return this.f38198m;
    }

    public void setOrderIds(String str) {
        this.f38198m = str;
    }

    public int getClientType() {
        return this.f38199n;
    }

    public void setClientType(int i) {
        this.f38199n = i;
    }

    public int getUtcOffsetInMinutes() {
        return this.f38200o;
    }

    public void setUtcOffsetInMinutes(int i) {
        this.f38200o = i;
    }

    public String getToken() {
        return this.f38201p;
    }

    public void setToken(String str) {
        this.f38201p = str;
    }

    public String getLanguage() {
        return this.f38202q;
    }

    public void setLanguage(String str) {
        this.f38202q = str;
    }

    public long getFileSizeInBytes() {
        return this.f38194i;
    }

    public void setFileSizeInBytes(long j) {
        this.f38194i = j;
    }

    public long getVoiceLenInSeconds() {
        return this.f38195j;
    }

    public void setVoiceLenInSeconds(long j) {
        this.f38195j = j;
    }

    public int getUploadRetryCount() {
        return this.f38203r;
    }

    public void setUploadRetryCount(int i) {
        this.f38203r = i;
    }

    public String getCaller() {
        return this.f38190e;
    }

    public void setCaller(String str) {
        this.f38190e = str;
    }

    public String getBusinessId() {
        return this.f38191f;
    }

    public void setBusinessId(String str) {
        this.f38191f = str;
    }

    public String getExtraJson() {
        return this.f38204s;
    }

    public void setExtraJson(String str) {
        this.f38204s = str;
    }

    public String getUploadUrl() {
        return this.f38205t;
    }

    public void setUploadUrl(String str) {
        this.f38205t = str;
    }

    public String getSignKey() {
        return this.f38206u;
    }

    public void setSignKey(String str) {
        this.f38206u = str;
    }

    public String getUserId() {
        return this.f38207v;
    }

    public void setUserId(String str) {
        this.f38207v = str;
    }

    public String getBusinessAlias() {
        return this.f38192g;
    }

    public void setBusinessAlias(String str) {
        this.f38192g = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && hashCode() == obj.hashCode()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f38196k;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        return "RecordResult{, caller='" + this.f38190e + '\'' + ", audioFilePath='" + this.f38193h + '\'' + ", fileSizeInBytes=" + this.f38194i + ", voiceLenInSeconds=" + this.f38195j + ", startRecordTime=" + this.f38196k + ", finishRecordTime=" + this.f38197l + ", orderIds='" + this.f38198m + '\'' + ", clientType=" + this.f38199n + ", utcOffsetInMinutes=" + this.f38200o + ", token='" + this.f38201p + '\'' + ", language='" + this.f38202q + '\'' + ", uploadRetryCount=" + this.f38203r + ", businessId=" + this.f38191f + ", businessAlias=" + this.f38192g + ", extraJson=" + this.f38204s + ", uploadUrl=" + this.f38205t + ", signKey=" + this.f38206u + ", userId=" + this.f38207v + '}';
    }

    public void resolveIfNeed() {
        long mediaDuration = MediaUtil.getMediaDuration(this.f38193h);
        if (mediaDuration <= 0) {
            long j = this.f38197l;
            long j2 = this.f38196k;
            mediaDuration = j >= j2 ? j - j2 : 0;
        }
        long round = Math.round((((double) mediaDuration) * 1.0d) / 1000.0d);
        this.f38195j = round;
        if (this.f38197l <= 0 && round > 0) {
            this.f38197l = this.f38196k + (round * 1000);
        }
        if (this.f38194i == 0) {
            this.f38194i = new File(this.f38193h).length();
        }
        m28817a();
    }

    /* renamed from: a */
    private void m28817a() {
        if (TextUtils.isEmpty(this.f38190e) || "null".equals(this.f38190e)) {
            this.f38190e = "";
        }
        if (TextUtils.isEmpty(this.f38191f) || "null".equals(this.f38191f)) {
            this.f38191f = "";
        }
        if (TextUtils.isEmpty(this.f38204s) || "null".equals(this.f38204s)) {
            this.f38204s = f38188c;
        }
    }

    public boolean isTooShort() {
        return this.f38197l - this.f38196k <= 1000 || this.f38195j <= 1;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f38190e);
        parcel.writeString(this.f38191f);
        parcel.writeString(this.f38192g);
        parcel.writeString(this.f38193h);
        parcel.writeLong(this.f38194i);
        parcel.writeLong(this.f38195j);
        parcel.writeLong(this.f38196k);
        parcel.writeLong(this.f38197l);
        parcel.writeString(this.f38198m);
        parcel.writeInt(this.f38199n);
        parcel.writeInt(this.f38200o);
        parcel.writeString(this.f38201p);
        parcel.writeString(this.f38202q);
        parcel.writeInt(this.f38203r);
        parcel.writeString(this.f38204s);
        parcel.writeString(this.f38205t);
        parcel.writeString(this.f38206u);
        parcel.writeString(this.f38207v);
    }

    public void readFromParcel(Parcel parcel) {
        this.f38190e = parcel.readString();
        this.f38191f = parcel.readString();
        this.f38192g = parcel.readString();
        this.f38193h = parcel.readString();
        this.f38194i = parcel.readLong();
        this.f38195j = parcel.readLong();
        this.f38196k = parcel.readLong();
        this.f38197l = parcel.readLong();
        this.f38198m = parcel.readString();
        this.f38199n = parcel.readInt();
        this.f38200o = parcel.readInt();
        this.f38201p = parcel.readString();
        this.f38202q = parcel.readString();
        this.f38203r = parcel.readInt();
        this.f38204s = parcel.readString();
        this.f38205t = parcel.readString();
        this.f38206u = parcel.readString();
        this.f38207v = parcel.readString();
    }

    public RecordResult() {
    }

    protected RecordResult(Parcel parcel) {
        this.f38190e = parcel.readString();
        this.f38191f = parcel.readString();
        this.f38192g = parcel.readString();
        this.f38193h = parcel.readString();
        this.f38194i = parcel.readLong();
        this.f38195j = parcel.readLong();
        this.f38196k = parcel.readLong();
        this.f38197l = parcel.readLong();
        this.f38198m = parcel.readString();
        this.f38199n = parcel.readInt();
        this.f38200o = parcel.readInt();
        this.f38201p = parcel.readString();
        this.f38202q = parcel.readString();
        this.f38203r = parcel.readInt();
        this.f38204s = parcel.readString();
        this.f38205t = parcel.readString();
        this.f38206u = parcel.readString();
        this.f38207v = parcel.readString();
    }
}
