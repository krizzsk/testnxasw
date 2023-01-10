package com.jumio.commons.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.view.WindowManager;
import com.jumio.commons.enums.Rotation;
import com.jumio.commons.enums.ScreenAngle;

public class DeviceRotationManager {

    /* renamed from: a */
    public final Rotation f57415a;

    /* renamed from: b */
    public ScreenAngle f57416b = getScreenOrientation();

    /* renamed from: c */
    public Context f57417c;

    /* renamed from: d */
    public final int f57418d;

    /* renamed from: e */
    public final boolean f57419e;

    public DeviceRotationManager(Context context, Rotation rotation) {
        this.f57417c = context;
        this.f57415a = rotation;
        this.f57419e = isTabletDevice(context);
        this.f57418d = mo171845a(context);
        setAngleFromScreen();
    }

    public static boolean isTabletDevice(Context context) {
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || context.getResources().getConfiguration().smallestScreenWidthDp < 600) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public final int mo171845a(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (((rotation == 0 || rotation == 2) && configuration.orientation == 2) || ((rotation == 1 || rotation == 3) && configuration.orientation == 1)) {
            return 2;
        }
        return 1;
    }

    public void destroy() {
        this.f57417c = null;
    }

    public ScreenAngle getAngle() {
        return this.f57416b;
    }

    public int getDisplayRotation() {
        Context context = this.f57417c;
        if (context == null) {
            return 0;
        }
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    public Rotation getRotation() {
        return this.f57415a;
    }

    public ScreenAngle getScreenOrientation() {
        ScreenAngle screenAngle = ScreenAngle.PORTRAIT;
        Context context = this.f57417c;
        if (context == null) {
            return screenAngle;
        }
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 0) {
            return (!this.f57419e || this.f57418d != 2) ? screenAngle : ScreenAngle.LANDSCAPE;
        }
        if (rotation == 1) {
            return (!this.f57419e || this.f57418d != 2) ? ScreenAngle.LANDSCAPE : ScreenAngle.INVERTED_PORTRAIT;
        }
        if (rotation == 2) {
            return (!this.f57419e || this.f57418d != 2) ? ScreenAngle.INVERTED_PORTRAIT : ScreenAngle.INVERTED_LANDSCAPE;
        }
        if (rotation != 3) {
            return screenAngle;
        }
        if (!this.f57419e || this.f57418d != 2) {
            return ScreenAngle.INVERTED_LANDSCAPE;
        }
        return screenAngle;
    }

    public boolean isAngle(ScreenAngle screenAngle) {
        return this.f57416b.equals(screenAngle);
    }

    public boolean isInverted() {
        ScreenAngle screenAngle = this.f57416b;
        return screenAngle == ScreenAngle.INVERTED_PORTRAIT || screenAngle == ScreenAngle.INVERTED_LANDSCAPE;
    }

    public boolean isLandscape() {
        ScreenAngle screenAngle = this.f57416b;
        return screenAngle == ScreenAngle.LANDSCAPE || screenAngle == ScreenAngle.INVERTED_LANDSCAPE;
    }

    public boolean isPortrait() {
        ScreenAngle screenAngle = this.f57416b;
        return screenAngle == ScreenAngle.PORTRAIT || screenAngle == ScreenAngle.INVERTED_PORTRAIT;
    }

    public boolean isRotation(Rotation rotation) {
        return this.f57415a.equals(rotation);
    }

    public boolean isScreenLandscape() {
        ScreenAngle screenOrientation = getScreenOrientation();
        return screenOrientation == ScreenAngle.LANDSCAPE || screenOrientation == ScreenAngle.INVERTED_LANDSCAPE;
    }

    public boolean isScreenPortrait() {
        ScreenAngle screenOrientation = getScreenOrientation();
        return screenOrientation == ScreenAngle.PORTRAIT || screenOrientation == ScreenAngle.INVERTED_PORTRAIT;
    }

    public void setAngleFromScreen() {
        this.f57416b = getScreenOrientation();
    }
}
