package com.didi.dimina.container.p065ui.statusbar;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.dimina.container.ui.statusbar.BarParams */
public class BarParams implements Cloneable {

    /* renamed from: a */
    Map<View, Map<Integer, Integer>> f19560a = new HashMap();
    public float autoNavigationBarDarkModeAlpha = 0.0f;
    public boolean autoNavigationBarDarkModeEnable = false;
    public float autoStatusBarDarkModeAlpha = 0.0f;
    public boolean autoStatusBarDarkModeEnable = false;

    /* renamed from: b */
    OnKeyboardListener f19561b;
    public boolean barEnable = true;
    public BarHide barHide = BarHide.FLAG_SHOW_BAR;

    /* renamed from: c */
    OnNavigationBarListener f19562c;
    public float contentAlpha = 0.0f;
    public int contentColor = 0;
    public int contentColorTransform = -16777216;

    /* renamed from: d */
    OnBarListener f19563d;
    public int defaultNavigationBarColor = -16777216;
    public boolean fits = false;
    public boolean fitsLayoutOverlapEnable = true;
    public int flymeOSStatusBarFontColor;
    public int flymeOSStatusBarFontTempColor;
    public boolean fullScreen = false;
    public boolean hideNavigationBar = false;
    public boolean isSupportActionBar = false;
    public boolean keyboardEnable = false;
    public int keyboardMode = 50;
    public float navigationBarAlpha = 0.0f;
    public int navigationBarColor = -16777216;
    public int navigationBarColorTransform = -16777216;
    public boolean navigationBarDarkIcon = false;
    public boolean navigationBarEnable = false;
    public float navigationBarTempAlpha = 0.0f;
    public boolean navigationBarWithEMUI3Enable = true;
    public boolean navigationBarWithKitkatEnable = true;
    public float statusBarAlpha = 0.0f;
    public int statusBarColor = 0;
    public boolean statusBarColorEnabled = true;
    public int statusBarColorTransform = -16777216;
    public boolean statusBarDarkFont = false;
    public float statusBarTempAlpha = 0.0f;
    public View statusBarView;
    public View titleBarView;
    public float viewAlpha = 0.0f;

    /* access modifiers changed from: protected */
    public BarParams clone() {
        try {
            return (BarParams) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
