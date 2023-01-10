package com.didi.map.global.component.markers.view;

import android.graphics.Bitmap;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.map.global.component.collide.ICollideStrategy;

public class MarkerModel {

    /* renamed from: a */
    private String f28284a;

    /* renamed from: b */
    private LatLng f28285b;

    /* renamed from: c */
    private boolean f28286c = true;

    /* renamed from: d */
    private Bitmap f28287d;

    /* renamed from: e */
    private float f28288e;

    /* renamed from: f */
    private float f28289f;

    /* renamed from: g */
    private Padding f28290g;

    /* renamed from: h */
    private int f28291h;

    /* renamed from: i */
    private String f28292i;

    /* renamed from: j */
    private float f28293j;

    /* renamed from: k */
    private String f28294k;

    /* renamed from: l */
    private int f28295l;

    /* renamed from: m */
    private int f28296m;

    /* renamed from: n */
    private boolean f28297n;

    /* renamed from: o */
    private ILabelView f28298o;

    /* renamed from: p */
    private Padding f28299p;

    /* renamed from: q */
    private ICollideStrategy f28300q;

    public void setStrategy(ICollideStrategy iCollideStrategy) {
        this.f28300q = iCollideStrategy;
    }

    public ICollideStrategy getStrategy() {
        return this.f28300q;
    }

    public void setAnchorPadding(Padding padding) {
        this.f28290g = padding;
    }

    public Padding getAnchorPadding() {
        return this.f28290g;
    }

    public String getMarkerUrl() {
        return this.f28292i;
    }

    public void setMarkerUrl(String str) {
        this.f28292i = str;
    }

    public String getId() {
        return this.f28284a;
    }

    public void setId(String str) {
        this.f28284a = str;
    }

    public LatLng getPoint() {
        return this.f28285b;
    }

    public void setPoint(LatLng latLng) {
        this.f28285b = latLng;
    }

    public String getAddressName() {
        return this.f28294k;
    }

    public void setAddressName(String str) {
        this.f28294k = str;
    }

    public Bitmap getMarkerIcon() {
        return this.f28287d;
    }

    public void setMarkerIcon(Bitmap bitmap) {
        this.f28287d = bitmap;
    }

    public float getAnchorU() {
        return this.f28288e;
    }

    public void setAnchorU(float f) {
        this.f28288e = f;
    }

    public float getAnchorV() {
        return this.f28289f;
    }

    public void setAnchorV(float f) {
        this.f28289f = f;
    }

    public int getZOrder() {
        return this.f28291h;
    }

    public void setZOrder(int i) {
        this.f28291h = i;
    }

    public int getLabelZIndex() {
        return this.f28295l;
    }

    public void setLabelZIndex(int i) {
        this.f28295l = i;
    }

    public Padding getLabelAnchorPadding() {
        return this.f28299p;
    }

    public void setLabelAnchorPadding(Padding padding) {
        this.f28299p = padding;
    }

    public boolean isClickable() {
        return this.f28286c;
    }

    public void setClickable(boolean z) {
        this.f28286c = z;
    }

    public float getUrlIconScaleParam() {
        return this.f28293j;
    }

    public void setUrlIconScaleParam(float f) {
        this.f28293j = f;
    }

    public int getLabelDirection() {
        return this.f28296m;
    }

    public void setLabelDirection(int i) {
        this.f28296m = i;
    }

    public ILabelView getLabelView() {
        return this.f28298o;
    }

    public void setLabelView(ILabelView iLabelView) {
        this.f28298o = iLabelView;
    }

    public boolean isLabelSelected() {
        return this.f28297n;
    }

    public void setLabelSelected(boolean z) {
        this.f28297n = z;
    }

    public MarkerModel() {
    }

    public MarkerModel(String str, LatLng latLng, String str2, Bitmap bitmap, float f, float f2) {
        this.f28284a = str;
        this.f28285b = latLng;
        this.f28294k = str2;
        this.f28287d = bitmap;
        this.f28288e = f;
        this.f28289f = f2;
    }

    public MarkerModel(String str, LatLng latLng, String str2, Bitmap bitmap, float f, float f2, int i) {
        this.f28284a = str;
        this.f28285b = latLng;
        this.f28294k = str2;
        this.f28287d = bitmap;
        this.f28288e = f;
        this.f28289f = f2;
        this.f28291h = i;
    }

    public MarkerModel(String str, LatLng latLng, String str2, Bitmap bitmap, float f, float f2, int i, String str3, int i2) {
        this.f28284a = str;
        this.f28285b = latLng;
        this.f28294k = str2;
        this.f28287d = bitmap;
        this.f28288e = f;
        this.f28289f = f2;
        this.f28291h = i;
        this.f28292i = str3;
        this.f28295l = i2;
    }
}
