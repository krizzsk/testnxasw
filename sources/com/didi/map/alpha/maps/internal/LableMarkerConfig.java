package com.didi.map.alpha.maps.internal;

public class LableMarkerConfig {

    /* renamed from: a */
    private int f26768a;

    /* renamed from: b */
    private int f26769b;

    /* renamed from: c */
    private String f26770c;

    /* renamed from: d */
    private String f26771d;

    /* renamed from: e */
    private String f26772e;

    /* renamed from: f */
    private String f26773f;

    /* renamed from: g */
    private String f26774g;

    /* renamed from: h */
    private String f26775h;

    /* renamed from: i */
    private int f26776i;

    /* renamed from: j */
    private String f26777j;

    /* renamed from: k */
    private String f26778k;

    /* renamed from: l */
    private String f26779l;

    /* renamed from: m */
    private String f26780m;

    /* renamed from: n */
    private String f26781n;

    /* renamed from: o */
    private String f26782o;

    /* renamed from: p */
    private String f26783p;

    /* renamed from: q */
    private String f26784q;

    /* renamed from: r */
    private String f26785r;

    /* renamed from: s */
    private String f26786s;

    private LableMarkerConfig() {
    }

    public static LableMarkerConfig createMainRouteConfig() {
        LableMarkerConfig lableMarkerConfig = new LableMarkerConfig();
        lableMarkerConfig.f26768a = 18;
        lableMarkerConfig.f26769b = -591112;
        lableMarkerConfig.f26776i = -591112;
        lableMarkerConfig.f26770c = "map/lable_marker.9.png";
        lableMarkerConfig.f26771d = "map/lable_marker3.9.png";
        lableMarkerConfig.f26772e = "map/lable_marker_left.9.png";
        lableMarkerConfig.f26773f = "map/lable_marker_left3.9.png";
        lableMarkerConfig.f26774g = "map/lable_marker_right.9.png";
        lableMarkerConfig.f26775h = "map/lable_marker_right3.9.png";
        lableMarkerConfig.f26777j = "map/lable_marker_night.9.png";
        lableMarkerConfig.f26778k = "map/lable_marker_night3.9.png";
        lableMarkerConfig.f26779l = "map/lable_marker_left_night.9.png";
        lableMarkerConfig.f26780m = "map/lable_marker_left3_night.9.png";
        lableMarkerConfig.f26781n = "map/lable_marker_right_night.9.png";
        lableMarkerConfig.f26782o = "map/lable_marker_right3_night.9.png";
        return lableMarkerConfig;
    }

    public static LableMarkerConfig createOtherRouteConfig() {
        LableMarkerConfig lableMarkerConfig = new LableMarkerConfig();
        lableMarkerConfig.f26768a = 18;
        lableMarkerConfig.f26769b = -8618353;
        lableMarkerConfig.f26776i = -3222558;
        lableMarkerConfig.f26770c = "map/lable_marker_other_day.9.png";
        lableMarkerConfig.f26771d = "map/lable_marker_other_day3.9.png";
        lableMarkerConfig.f26772e = "map/lable_marker_other_left_day.9.png";
        lableMarkerConfig.f26773f = "map/lable_marker_other_left3_day.9.png";
        lableMarkerConfig.f26774g = "map/lable_marker_other_right_day.9.png";
        lableMarkerConfig.f26775h = "map/lable_marker_other_right3_day.9.png";
        lableMarkerConfig.f26777j = "map/lable_marker_other_night.9.png";
        lableMarkerConfig.f26778k = "map/lable_marker_other_night3.9.png";
        lableMarkerConfig.f26779l = "map/lable_marker_other_left_night.9.png";
        lableMarkerConfig.f26780m = "map/lable_marker_other_left3_night.9.png";
        lableMarkerConfig.f26781n = "map/lable_marker_other_right_night.9.png";
        lableMarkerConfig.f26782o = "map/lable_marker_other_right3_night.9.png";
        return lableMarkerConfig;
    }

    public static LableMarkerConfig createDynamicrRouteConfig() {
        LableMarkerConfig lableMarkerConfig = new LableMarkerConfig();
        lableMarkerConfig.f26768a = 18;
        lableMarkerConfig.f26769b = -8618353;
        lableMarkerConfig.f26776i = -3222558;
        lableMarkerConfig.f26770c = "map/lable_marker_other_day.9.png";
        lableMarkerConfig.f26771d = "map/lable_marker_other_day3.9.png";
        lableMarkerConfig.f26772e = "dynamic/multi_lable_marker_other_left_day.9.png";
        lableMarkerConfig.f26773f = "dynamic/multi_lable_marker_other_left3_day.9.png";
        lableMarkerConfig.f26774g = "dynamic/multi_lable_marker_other_right_day.9.png";
        lableMarkerConfig.f26775h = "dynamic/multi_lable_marker_other_right3_day.9.png";
        lableMarkerConfig.f26777j = "map/lable_marker_other_night.9.png";
        lableMarkerConfig.f26778k = "map/lable_marker_other_night3.9.png";
        lableMarkerConfig.f26779l = "dynamic/multi_lable_marker_left_night.9.png";
        lableMarkerConfig.f26780m = "dynamic/multi_lable_marker_left3_night.9.png";
        lableMarkerConfig.f26781n = "dynamic/multi_lable_marker_right_night.9.png";
        lableMarkerConfig.f26782o = "dynamic/multi_lable_marker_right3_night.9.png";
        return lableMarkerConfig;
    }

    public static LableMarkerConfig createIllegalParkConfig() {
        LableMarkerConfig lableMarkerConfig = new LableMarkerConfig();
        lableMarkerConfig.f26768a = 18;
        lableMarkerConfig.f26769b = -8618353;
        lableMarkerConfig.f26776i = -3222558;
        lableMarkerConfig.f26774g = "map/bubble_illegalpark_right.png";
        lableMarkerConfig.f26775h = "map/bubble_illegalpark_right3.png";
        lableMarkerConfig.f26781n = "map/bubble_illegalpark_right.png";
        lableMarkerConfig.f26782o = "map/bubble_illegalpark_right3.png";
        return lableMarkerConfig;
    }

    public int getFontSize() {
        return this.f26768a;
    }

    public int getFontColor() {
        return this.f26769b;
    }

    public String getFileName() {
        return this.f26770c;
    }

    public String getFileName2() {
        return this.f26771d;
    }

    public String getFileNameLeft() {
        return this.f26772e;
    }

    public String getFileNameLeft2() {
        return this.f26773f;
    }

    public String getFileNameRight() {
        return this.f26774g;
    }

    public String getFileNameRight2() {
        return this.f26775h;
    }

    public int getFontColorNight() {
        return this.f26776i;
    }

    public String getFileNameNight() {
        return this.f26777j;
    }

    public String getFileNameNight2() {
        return this.f26778k;
    }

    public String getFileNameLeftNight() {
        return this.f26779l;
    }

    public String getFileNameLeftNight2() {
        return this.f26780m;
    }

    public String getFileNameRightNight() {
        return this.f26781n;
    }

    public String getFileNameRightNight2() {
        return this.f26782o;
    }

    public String getFileNameLt() {
        return this.f26783p;
    }

    public String getFileNameLb() {
        return this.f26784q;
    }

    public String getFileNameRt() {
        return this.f26785r;
    }

    public String getFileNameRb() {
        return this.f26786s;
    }
}
