package com.dmap.navigation.engine.event;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.jni.swig.MissionButtonInfo;
import com.dmap.navigation.jni.swig.MissionButtonList;
import com.dmap.navigation.jni.swig.NaviLatLng;
import com.dmap.navigation.simple.SimpleLatlng;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissionEvent extends NaviEvent {
    public static final int MISSION_DISPLAY_HIDE_ICON_SHOW_BUBBLE = 3;
    public static final int MISSION_DISPLAY_NOT_SHOW = 1;
    public static final int MISSION_DISPLAY_NULL = 0;
    public static final int MISSION_DISPLAY_SHOW_ICON = 2;

    /* renamed from: a */
    private final long f54478a;

    /* renamed from: b */
    private final int f54479b;

    /* renamed from: c */
    private final String f54480c;

    /* renamed from: d */
    private final String f54481d;

    /* renamed from: e */
    private final LatLng f54482e;

    /* renamed from: f */
    private final byte[] f54483f;

    /* renamed from: g */
    private final BigInteger f54484g;

    /* renamed from: h */
    private final List<IMissionButtonInfo> f54485h;

    /* renamed from: i */
    private final int f54486i;

    /* renamed from: j */
    private final String f54487j;

    public interface IMissionButtonInfo {
        String getButtonPicUrl();

        String getButtonTitle();

        int getButtonType();

        int getButtonValue();
    }

    public MissionEvent(long j, int i, String str, String str2, NaviLatLng naviLatLng, byte[] bArr, BigInteger bigInteger, MissionButtonList missionButtonList, int i2, String str3) {
        this.f54478a = j;
        this.f54479b = i;
        this.f54480c = str;
        this.f54481d = str2;
        this.f54482e = new SimpleLatlng(naviLatLng.getLat(), naviLatLng.getLng());
        this.f54483f = bArr;
        this.f54484g = bigInteger;
        this.f54486i = i2;
        this.f54487j = str3;
        int size = (int) missionButtonList.size();
        if (size > 0) {
            this.f54485h = new ArrayList();
            for (int i3 = 0; i3 < size; i3++) {
                this.f54485h.add(new SimpleMissionButtonInfo(missionButtonList.get(i3)));
            }
            return;
        }
        this.f54485h = null;
    }

    public String toString() {
        return "MissionEvent{missionId=" + this.f54478a + ", missionType=" + this.f54479b + ", missionTitle='" + this.f54480c + '\'' + ", missionTitlePicUrl='" + this.f54481d + '\'' + ", missionPos=" + this.f54482e + ", missionPbData=" + Arrays.toString(this.f54483f) + ", routeId=" + this.f54484g + ", buttonList=" + this.f54485h + ", missionDisplay=" + this.f54486i + ", missionDescription=" + this.f54487j + '}';
    }

    public long getMissionId() {
        return this.f54478a;
    }

    public int getMissionType() {
        return this.f54479b;
    }

    public String getMissionTitle() {
        return this.f54480c;
    }

    public String getMissionTitlePicUrl() {
        return this.f54481d;
    }

    public LatLng getMissionPos() {
        return this.f54482e;
    }

    public byte[] getMissionPbData() {
        return this.f54483f;
    }

    public BigInteger getRouteId() {
        return this.f54484g;
    }

    public int getMissionDisplay() {
        return this.f54486i;
    }

    public String getMissionDescription() {
        return this.f54487j;
    }

    public List<IMissionButtonInfo> getButtonList() {
        return this.f54485h;
    }

    public static class SimpleMissionButtonInfo implements IMissionButtonInfo {
        private final String buttonPicUrl;
        private final String buttonTitle;
        private final int buttonType;
        private final int buttonValue;

        SimpleMissionButtonInfo(MissionButtonInfo missionButtonInfo) {
            this.buttonTitle = missionButtonInfo.getButtonTitle();
            this.buttonPicUrl = missionButtonInfo.getButtonPicUrl();
            this.buttonType = missionButtonInfo.getButtonType();
            this.buttonValue = missionButtonInfo.getButtonValue();
        }

        public String toString() {
            return "SimpleMissionButtonInfo{buttonTitle='" + this.buttonTitle + '\'' + ", buttonPicUrl='" + this.buttonPicUrl + '\'' + ", buttonType=" + this.buttonType + ", buttonValue=" + this.buttonValue + '}';
        }

        public String getButtonTitle() {
            return this.buttonTitle;
        }

        public String getButtonPicUrl() {
            return this.buttonPicUrl;
        }

        public int getButtonType() {
            return this.buttonType;
        }

        public int getButtonValue() {
            return this.buttonValue;
        }
    }
}
