package com.didi.common.map.model;

import android.graphics.Bitmap;
import com.didi.common.map.internal.IMapElementOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class LineOptions extends IMapElementOptions {
    public static final int LINE_END_TYPE_ROUND = 1;
    public static final int LINE_END_TYPE_STRAIGHT = 0;
    public static final int LINE_JOINT_TYPE_NONE = 0;
    public static final int LINE_JOINT_TYPE_ROUND = 2;
    public static final int LINE_JOINT_TYPE_STRAIGHT = 1;

    /* renamed from: a */
    private List<LatLng> f12670a;

    /* renamed from: b */
    private double f12671b;

    /* renamed from: c */
    private int f12672c;

    /* renamed from: d */
    private Bitmap f12673d;

    /* renamed from: e */
    private int f12674e;

    /* renamed from: f */
    private int f12675f;

    /* renamed from: g */
    private int f12676g;

    /* renamed from: h */
    private List<LatLng> f12677h;

    /* renamed from: i */
    private List<Integer> f12678i;

    /* renamed from: j */
    private long f12679j;

    /* renamed from: k */
    private String f12680k;

    /* renamed from: l */
    private float f12681l;

    /* renamed from: m */
    private int f12682m;

    /* renamed from: n */
    private boolean f12683n;

    /* renamed from: o */
    private boolean f12684o;

    /* renamed from: p */
    private int f12685p;

    /* renamed from: q */
    private List<LatLng> f12686q;

    /* renamed from: r */
    private boolean f12687r;

    /* renamed from: s */
    private boolean f12688s;

    /* renamed from: t */
    private int f12689t;

    /* renamed from: u */
    private String f12690u;

    /* renamed from: v */
    private int f12691v;

    /* renamed from: w */
    private MultiColorLineInfo[] f12692w;

    /* renamed from: x */
    private List<RouteWithName> f12693x;

    /* renamed from: y */
    private boolean f12694y;

    /* renamed from: z */
    private List<Integer> f12695z;

    public static class COLOR {
        public static final int BLACK_262B2E = 11;
        public static final int BLUE_00BEFF = 24;
        public static final int BLUE_33BBFF = 23;
        public static final int BLUE_5DA2ED = 1;
        public static final int BLUE_61ADD3 = 1;
        public static final int BLUE_65D8FF = 25;
        public static final int BLUE_7CB5F3 = 6;
        public static final int BLUE_A6DFFF = 29;
        public static final int BLUE_A7CEFC = 9;
        public static final int BLUE_B4E6FF = 2;
        public static final int BLUE_BDDAF9 = 5;
        public static final int GREEN_4CC186 = 4;
        public static final int GREY_C2C2C2 = 0;
        public static final int RED_B63C47 = 10;
        public static final int RED_E96461 = 2;
        public static final int TRANSPARENT = 0;
        public static final int WHITE_2 = 8;
        public static final int WRITE_1 = 7;
        public static final int YELLOW_F4C286 = 3;
    }

    public static class DottedResType {
        public static final int ARROW_BULE = 1;
        public static final int ARROW_GRAY = 2;
        public static final int DEFAUT = 0;
        public static final int DOT_BLUE = 5;
        public static final int DOT_GRAY = 4;
        public static final int DOT_INNER_DARK = 6;
        public static final int DOT_INNER_LIGHT = 7;
        public static final int USE_CUSTOM_IMAGE = 3;
    }

    public static final class LineType {
        public static final int LINE_TYPE_ANIMATION = 6;
        public static final int LINE_TYPE_ARGB = 4;
        public static final int LINE_TYPE_DOTTED = 2;
        public static final int LINE_TYPE_DOTTED_ANIMATION = 5;
        public static final int LINE_TYPE_IMAGEINARY = 1;
        public static final int LINE_TYPE_MULTICOLOR = 0;
        public static final int LINE_TYPE_MULTICOLOR_2 = 7;
        public static final int LINE_TYPE_MULTICOLOR_BITMAP = 8;
    }

    public static final class MultiColorLineInfo {
        public int colorIndex;
        public int pointIndex;
    }

    public LineOptions() {
        this.f12671b = 36.0d;
        this.f12672c = 0;
        this.f12674e = 0;
        this.f12675f = 2;
        this.f12676g = 1;
        this.f12679j = 0;
        this.f12680k = "";
        this.f12682m = 0;
        this.f12683n = true;
        this.f12684o = false;
        this.f12685p = 0;
        this.f12687r = false;
        this.f12688s = false;
        this.f12689t = 4;
        this.f12691v = 0;
        this.f12694y = true;
        this.f12671b = 36.0d;
        this.mZIndex = 0;
        this.f12681l = 200.0f;
        this.mVisible = true;
        this.f12694y = true;
        this.f12676g = 0;
        this.f12682m = 0;
        this.f12670a = new ArrayList();
        this.f12685p = 0;
        this.f12686q = new ArrayList();
        this.f12687r = false;
    }

    public List<LatLng> getGetTrafficInsertPoint() {
        return this.f12677h;
    }

    public void setGetTrafficInsertPoint(List<LatLng> list) {
        this.f12677h = list;
    }

    public void setCusTextureBitmapColors(List<Integer> list) {
        this.f12695z = list;
    }

    public List<Integer> getCusTextureBitmapColors() {
        return this.f12695z;
    }

    public List<Integer> getGetRouteTrafficIndex() {
        return this.f12678i;
    }

    public void setGetRouteTrafficIndex(List<Integer> list) {
        this.f12678i = list;
    }

    public List<LatLng> getPoints() {
        return this.f12670a;
    }

    public LineOptions setPoints(List<LatLng> list) {
        this.f12670a = list;
        return this;
    }

    public LineOptions customImageNameInAssets(String str) {
        this.f12680k = str;
        return this;
    }

    public String getCustomImageNameInAssets() {
        return this.f12680k;
    }

    public LineOptions add(LatLng latLng) {
        this.f12670a.add(latLng);
        return this;
    }

    public LineOptions add(LatLng... latLngArr) {
        this.f12670a.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public LineOptions add(List<LatLng> list) {
        this.f12670a.addAll(list);
        return this;
    }

    public LineOptions addAll(Iterable<LatLng> iterable) {
        if (iterable == null) {
            return this;
        }
        for (LatLng next : iterable) {
            if (next != null) {
                this.f12670a.add(next);
            }
        }
        return this;
    }

    public LineOptions road(boolean z) {
        this.f12694y = z;
        return this;
    }

    public boolean isRoad() {
        return this.f12694y;
    }

    public LineOptions spacing(float f) {
        this.f12681l = f;
        return this;
    }

    public LineOptions routeId(long j) {
        this.f12679j = j;
        return this;
    }

    public long getRouteId() {
        return this.f12679j;
    }

    public float getSpacing() {
        return this.f12681l;
    }

    public double getWidth() {
        return this.f12671b;
    }

    public LineOptions width(double d) {
        this.f12671b = d;
        return this;
    }

    public int getColor() {
        return this.f12672c;
    }

    public LineOptions color(int i) {
        this.f12672c = i;
        return this;
    }

    public LineOptions dottedResType(int i) {
        this.f12682m = i;
        return this;
    }

    public int getDottedResType() {
        return this.f12682m;
    }

    public Bitmap getBitmap() {
        return this.f12673d;
    }

    public LineOptions bitmap(Bitmap bitmap) {
        this.f12673d = bitmap;
        return this;
    }

    public int getStretchFactor() {
        return this.f12674e;
    }

    public LineOptions stretchFactor(int i) {
        this.f12674e = i;
        return this;
    }

    public int getLineJoinType() {
        return this.f12675f;
    }

    public LineOptions lineJoinType(int i) {
        this.f12675f = i;
        return this;
    }

    public int getLineEndType() {
        return this.f12676g;
    }

    public LineOptions lineEndType(int i) {
        this.f12676g = i;
        return this;
    }

    public LineOptions directionArrow(boolean z) {
        this.f12683n = z;
        return this;
    }

    public boolean hasDirectionArrow() {
        return this.f12683n;
    }

    public LineOptions turnArrow(boolean z) {
        this.f12684o = z;
        return this;
    }

    public boolean hasTurnArrow() {
        return this.f12684o;
    }

    public LineOptions bezierInfo(int i, List<LatLng> list, boolean z) {
        this.f12685p = i;
        this.f12687r = z;
        if (this.f12686q == null) {
            this.f12686q = new ArrayList();
        }
        this.f12686q.clear();
        this.f12686q.addAll(list);
        return this;
    }

    public int getBezierOrder() {
        return this.f12685p;
    }

    public List<LatLng> getBezierControlPoints() {
        return this.f12686q;
    }

    public LineOptions aboveBuilding(boolean z) {
        this.f12688s = z;
        return this;
    }

    public boolean isAboveBuilding() {
        return this.f12688s;
    }

    public LineOptions type(int i) {
        this.f12689t = i;
        return this;
    }

    public int getType() {
        return this.f12689t;
    }

    public LineOptions routeNamesInfo(List<RouteWithName> list) {
        this.f12693x = list;
        return this;
    }

    public List<RouteWithName> getRouteNamesInfo() {
        return this.f12693x;
    }

    public LineOptions multiColorLineInfo(MultiColorLineInfo[] multiColorLineInfoArr) {
        this.f12692w = multiColorLineInfoArr;
        return this;
    }

    public MultiColorLineInfo[] getMultiColorLineInfo() {
        return this.f12692w;
    }

    public void setBezierInfo(int i, List<LatLng> list, boolean z) {
        this.f12685p = i;
        this.f12686q.clear();
        this.f12687r = z;
        if (z) {
            if (list == null || (list != null && list.size() < 2)) {
                throw new IllegalArgumentException("bezier曲线使用默认控制点需要先设置起终点");
            }
            LatLng latLng = list.get(0);
            LatLng latLng2 = list.get(1);
            new LatLng((latLng.latitude + latLng2.latitude) / 2.0d, (latLng.longitude + latLng2.longitude) / 2.0d);
            if (i != 1) {
                if (i == 2) {
                    this.f12686q.add(new LatLng((((latLng.latitude + latLng2.latitude) + latLng2.longitude) - latLng.longitude) / 2.0d, (((latLng.longitude + latLng2.longitude) + latLng.latitude) - latLng2.latitude) / 2.0d));
                } else if (i == 3) {
                    LatLng latLng3 = new LatLng((((latLng.latitude + latLng2.latitude) + latLng2.longitude) - latLng.longitude) / 2.0d, (((latLng.longitude + latLng2.longitude) + latLng.latitude) - latLng2.latitude) / 2.0d);
                    LatLng latLng4 = new LatLng((latLng3.latitude + latLng.latitude) / 2.0d, (latLng3.longitude + latLng.longitude) / 2.0d);
                    LatLng latLng5 = new LatLng((latLng3.latitude + latLng2.latitude) / 2.0d, (latLng3.longitude + latLng2.longitude) / 2.0d);
                    this.f12686q.add(latLng4);
                    this.f12686q.add(latLng5);
                } else {
                    throw new IllegalArgumentException("bezier曲线阶数为1，2，3");
                }
            }
        } else if (list != null) {
            this.f12686q.addAll(list);
        }
    }

    public List<LatLng> getListBezierControlPoints() {
        return this.f12686q;
    }

    public boolean isBezierUseDefaultControl() {
        return this.f12687r;
    }

    public static class RouteWithName {
        public static final int ROUTE_NAME_TYPE_MAIN = 0;
        public static final int ROUTE_NAME_TYPE_MUITL = 1;
        private int color;
        private int endNum;
        private String roadName;
        private int startNum;
        private int type;

        public int getType() {
            return this.type;
        }

        public void setType(int i) {
            this.type = i;
        }

        public int getStartNum() {
            return this.startNum;
        }

        public void setStartNum(int i) {
            this.startNum = i;
        }

        public int getEndNum() {
            return this.endNum;
        }

        public void setEndNum(int i) {
            this.endNum = i;
        }

        public int getColor() {
            return this.color;
        }

        public void setColor(int i) {
            this.color = i;
        }

        public String getRoadName() {
            return this.roadName;
        }

        public void setRoadName(String str) {
            this.roadName = str;
        }
    }
}
