package com.didi.beatles.p101im.module.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Map;

/* renamed from: com.didi.beatles.im.module.entity.IMBusinessParam */
public class IMBusinessParam implements Parcelable {
    public static final Parcelable.Creator<IMBusinessParam> CREATOR = new Parcelable.Creator<IMBusinessParam>() {
        public IMBusinessParam createFromParcel(Parcel parcel) {
            return new IMBusinessParam(parcel);
        }

        public IMBusinessParam[] newArray(int i) {
            return new IMBusinessParam[i];
        }
    };

    /* renamed from: a */
    private static final String f11104a = IMBusinessParam.class.getSimpleName();

    /* renamed from: A */
    private String f11105A;

    /* renamed from: B */
    private String f11106B;

    /* renamed from: b */
    private long f11107b;

    /* renamed from: c */
    private int f11108c;

    /* renamed from: d */
    private long f11109d;

    /* renamed from: e */
    private long f11110e;

    /* renamed from: f */
    private String f11111f;

    /* renamed from: g */
    private String f11112g;

    /* renamed from: h */
    private String f11113h;

    /* renamed from: i */
    private String f11114i;

    /* renamed from: j */
    private String f11115j;

    /* renamed from: k */
    private long f11116k;

    /* renamed from: l */
    private long f11117l;

    /* renamed from: m */
    private int f11118m;

    /* renamed from: n */
    private String f11119n;

    /* renamed from: o */
    private String f11120o;

    /* renamed from: p */
    private String f11121p;

    /* renamed from: q */
    private int f11122q;

    /* renamed from: r */
    private String f11123r;

    /* renamed from: s */
    private int f11124s;

    /* renamed from: t */
    private String f11125t;

    /* renamed from: u */
    private String f11126u;

    /* renamed from: v */
    private int f11127v;

    /* renamed from: w */
    private String f11128w;

    /* renamed from: x */
    private Map<String, String> f11129x;
    @Deprecated

    /* renamed from: y */
    private String f11130y;

    /* renamed from: z */
    private Boolean f11131z;

    public int describeContents() {
        return 0;
    }

    public IMBusinessParam(long j, int i, long j2, long j3, String str, String str2, String str3, String str4, String str5) {
        this.f11111f = "";
        this.f11118m = -1;
        this.f11125t = "";
        this.f11126u = "";
        this.f11131z = false;
        this.f11107b = j;
        this.f11108c = i;
        this.f11109d = j2;
        this.f11110e = j3;
        this.f11111f = str;
        this.f11112g = str2;
        this.f11113h = str3;
        this.f11114i = str4;
        this.f11115j = str5;
    }

    public IMBusinessParam() {
        this.f11111f = "";
        this.f11118m = -1;
        this.f11125t = "";
        this.f11126u = "";
        this.f11131z = false;
    }

    public int getBottomInputConfig() {
        return this.f11124s;
    }

    public void setBottomInputConfig(int i) {
        this.f11124s = i;
    }

    public int getSessionType() {
        return this.f11127v;
    }

    public void setSessionType(int i) {
        this.f11127v = i;
    }

    public String getUserDraft() {
        return this.f11119n;
    }

    public void setUserDraft(String str) {
        this.f11119n = str;
    }

    public long getSessionId() {
        return this.f11107b;
    }

    public void setSessionId(long j) {
        this.f11107b = j;
    }

    public int getProductId() {
        return this.f11108c;
    }

    public int getBusinessId() {
        return this.f11108c;
    }

    public void setBusinessId(int i) {
        this.f11108c = i;
    }

    public long getSelfUid() {
        return this.f11109d;
    }

    public void setSelfUid(long j) {
        this.f11109d = j;
    }

    public long getPeerUid() {
        return this.f11110e;
    }

    public void setPeerUid(long j) {
        this.f11110e = j;
    }

    public String getSecret() {
        return this.f11111f;
    }

    public void setSecret(String str) {
        this.f11111f = str;
    }

    public void clearSecret() {
        this.f11111f = "";
    }

    public boolean isSecretValid() {
        return !TextUtils.isEmpty(this.f11111f);
    }

    public String getPeerUserName() {
        return this.f11114i;
    }

    public void setPeerUserName(String str) {
        this.f11114i = str;
    }

    public String getPeerUserAvatar() {
        return this.f11115j;
    }

    public void setPeerUserAvatar(String str) {
        this.f11115j = str;
    }

    public String getSelfUserName() {
        return this.f11112g;
    }

    public void setSelfUserName(String str) {
        this.f11112g = str;
    }

    public String getSelfUserAvatar() {
        return this.f11113h;
    }

    public void setSelfUserAvatar(String str) {
        this.f11113h = str;
    }

    public long getOrderId() {
        return this.f11116k;
    }

    public void setOrderId(long j) {
        this.f11116k = j;
    }

    public long getRouteId() {
        return this.f11117l;
    }

    public void setRouteId(long j) {
        this.f11117l = j;
    }

    public int getSourceId() {
        return this.f11118m;
    }

    public void setSourceId(int i) {
        this.f11118m = i;
    }

    public int getIsQuick() {
        return this.f11122q;
    }

    public void setIsQuick(int i) {
        this.f11122q = i;
    }

    public String getCityID() {
        return this.f11121p;
    }

    public void setCityID(String str) {
        this.f11121p = str;
    }

    public String getsOrderId() {
        return this.f11120o;
    }

    public void setsOrderId(String str) {
        this.f11120o = str;
    }

    public String getPeerEngNickName() {
        return this.f11126u;
    }

    public void setPeerEngNickName(String str) {
        this.f11126u = str;
    }

    public String getSelfEngNickName() {
        return this.f11125t;
    }

    public void setSelfEngNickName(String str) {
        this.f11125t = str;
    }

    public String getSceneKey() {
        return this.f11123r;
    }

    public void setSceneKey(String str) {
        this.f11123r = str;
    }

    public String getExtraInfo() {
        return this.f11128w;
    }

    public void setExtraInfo(String str) {
        this.f11128w = str;
    }

    public Map<String, String> getExtraTraceMap() {
        return this.f11129x;
    }

    public void setPhoneNum(String str) {
        this.f11130y = str;
    }

    public String getPhoneNum() {
        return this.f11130y;
    }

    public boolean getShowChatTitleRightIcon() {
        return this.f11131z.booleanValue();
    }

    public void setShowChatTitleRightIcon(boolean z) {
        this.f11131z = Boolean.valueOf(z);
    }

    public void setPhoneFuncGuide(String str) {
        this.f11105A = str;
    }

    public String getPhoneFuncGuide() {
        return this.f11105A;
    }

    public String getRobotGuideId() {
        return this.f11106B;
    }

    public void setRobotGuideId(String str) {
        this.f11106B = str;
    }

    public void setExtraTraceMap(Map<String, String> map) {
        this.f11129x = map;
    }

    public String toString() {
        return "IMBusinessParam{sessionId=" + this.f11107b + ", businessId=" + this.f11108c + ", selfUid=" + this.f11109d + ", peerUid=" + this.f11110e + ", secret='" + this.f11111f + '\'' + ", selfUserName='" + this.f11112g + '\'' + ", selfUserAvatar='" + this.f11113h + '\'' + ", peerUserName='" + this.f11114i + '\'' + ", peerUserAvatar='" + this.f11115j + '\'' + ", orderId=" + this.f11116k + ", routeId=" + this.f11117l + ", sourceId=" + this.f11118m + ", userDraft='" + this.f11119n + '\'' + ", sOrderId='" + this.f11120o + '\'' + ", cityID='" + this.f11121p + '\'' + ", isQuick=" + this.f11122q + '\'' + ", session_type=" + this.f11127v + '\'' + ", self_nick_eng_name =" + this.f11125t + '\'' + ", extraInfo =" + this.f11128w + '\'' + ", showChatTitleRightIcon" + this.f11131z + '\'' + ", peer_nick_eng_name =" + this.f11126u + ", robotGuideId =" + this.f11106B + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f11107b);
        parcel.writeInt(this.f11108c);
        parcel.writeLong(this.f11109d);
        parcel.writeLong(this.f11110e);
        parcel.writeString(this.f11111f);
        parcel.writeString(this.f11112g);
        parcel.writeString(this.f11113h);
        parcel.writeString(this.f11114i);
        parcel.writeString(this.f11115j);
        parcel.writeLong(this.f11116k);
        parcel.writeLong(this.f11117l);
        parcel.writeInt(this.f11118m);
        parcel.writeString(this.f11119n);
        parcel.writeString(this.f11120o);
        parcel.writeString(this.f11121p);
        parcel.writeInt(this.f11122q);
        parcel.writeInt(this.f11127v);
        parcel.writeInt(this.f11124s);
        parcel.writeString(this.f11125t);
        parcel.writeString(this.f11126u);
        parcel.writeString(this.f11123r);
        parcel.writeString(this.f11128w);
        parcel.writeString(this.f11130y);
        parcel.writeByte(this.f11131z.booleanValue() ? (byte) 1 : 0);
        parcel.writeString(this.f11105A);
    }

    protected IMBusinessParam(Parcel parcel) {
        this.f11111f = "";
        this.f11118m = -1;
        this.f11125t = "";
        this.f11126u = "";
        boolean z = false;
        this.f11131z = false;
        this.f11107b = parcel.readLong();
        this.f11108c = parcel.readInt();
        this.f11109d = parcel.readLong();
        this.f11110e = parcel.readLong();
        this.f11111f = parcel.readString();
        this.f11112g = parcel.readString();
        this.f11113h = parcel.readString();
        this.f11114i = parcel.readString();
        this.f11115j = parcel.readString();
        this.f11116k = parcel.readLong();
        this.f11117l = parcel.readLong();
        this.f11118m = parcel.readInt();
        this.f11119n = parcel.readString();
        this.f11120o = parcel.readString();
        this.f11121p = parcel.readString();
        this.f11122q = parcel.readInt();
        this.f11127v = parcel.readInt();
        this.f11124s = parcel.readInt();
        this.f11125t = parcel.readString();
        this.f11126u = parcel.readString();
        this.f11123r = parcel.readString();
        this.f11128w = parcel.readString();
        this.f11130y = parcel.readString();
        this.f11131z = Boolean.valueOf(parcel.readByte() != 0 ? true : z);
        this.f11105A = parcel.readString();
    }
}
