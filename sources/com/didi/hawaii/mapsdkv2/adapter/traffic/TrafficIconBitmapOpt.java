package com.didi.hawaii.mapsdkv2.adapter.traffic;

import com.didi.hawaii.utils.BitmapUtil;
import com.didi.map.base.bubble.BaseBubbleBitmapOpt;

public class TrafficIconBitmapOpt extends BaseBubbleBitmapOpt {

    /* renamed from: a */
    private static final String f26022a = "map/";

    /* renamed from: b */
    private static final String f26023b = "map/night";

    /* renamed from: c */
    private final int f26024c;

    /* renamed from: d */
    private float f26025d = 50.0f;

    /* renamed from: e */
    private boolean f26026e = false;

    public TrafficIconBitmapOpt(long j, String str, int i) {
        super(str, j);
        this.f26024c = i;
        this.f26025d = 50.0f / BitmapUtil.fDensityXH;
    }

    public int getTrafficIconType() {
        return this.f26024c;
    }

    public TrafficIconBitmapOpt setIconSize(int i) {
        this.f26025d = ((float) i) / BitmapUtil.fDensityXH;
        return this;
    }

    public TrafficIconBitmapOpt setIsHintIcon(boolean z) {
        this.f26026e = z;
        return this;
    }

    public boolean isHint() {
        return this.f26026e;
    }

    public float getRealIconSize() {
        return this.f26025d;
    }

    public String getTrafficIconTypeFileName() {
        switch (this.f26024c / 100) {
            case 0:
                return "map/" + "traffic_yongdu_3x.png";
            case 1:
                return "map/" + "traffic_shigu_3x.png";
            case 2:
                return "map/" + "traffic_shigong_3x.png";
            case 3:
                return "map/" + "traffic_guanzhi_3x.png";
            case 4:
                return "map/" + "traffic_fenglu_3x.png";
            case 5:
                return "map/" + "traffic_jishui_3x.png";
            case 6:
                return "map/" + "traffic_jingcha_3x.png";
            case 7:
                return "map/" + "traffic_gonggao_3x.png";
            default:
                return "map/" + "traffic_default_3x.png";
        }
    }

    public String getResourcePaths() {
        return super.toString() + "traffic_icon" + isNight() + this.f26025d + "|";
    }
}
