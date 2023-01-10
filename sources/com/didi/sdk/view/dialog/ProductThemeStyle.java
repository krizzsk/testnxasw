package com.didi.sdk.view.dialog;

import com.didi.sdk.util.DataEntity;
import com.didi.sdk.view.TimePickerMode;

public class ProductThemeStyle {

    /* renamed from: a */
    private int f40700a = 0;

    /* renamed from: b */
    private int f40701b = 0;

    /* renamed from: c */
    private int f40702c = 0;

    /* renamed from: d */
    private int f40703d = 0;

    /* renamed from: e */
    private int f40704e = 0;

    /* renamed from: f */
    private int f40705f = 0;

    /* renamed from: g */
    private TitleBarStyle f40706g = new TitleBarStyle();

    /* renamed from: h */
    private int f40707h = 2;

    /* renamed from: i */
    private int f40708i = 0;

    /* renamed from: j */
    private TimePickerMode f40709j = TimePickerMode.Normal;

    /* renamed from: k */
    private ToastStyle f40710k;

    public void setTimePickerMode(TimePickerMode timePickerMode) {
        this.f40709j = timePickerMode;
    }

    public void setToastStyle(ToastStyle toastStyle) {
        this.f40710k = toastStyle;
    }

    public ToastStyle getToastStyle() {
        return this.f40710k;
    }

    public TimePickerMode getTimePickerMode() {
        return this.f40709j;
    }

    public void setCommonDialogBg(int i) {
        this.f40708i = i;
    }

    public int getCommonDialogBg() {
        return this.f40708i;
    }

    public TitleBarStyle getTitleBarStyle() {
        return this.f40706g;
    }

    public void setTitleBarStyle(TitleBarStyle titleBarStyle) {
        this.f40706g = titleBarStyle;
    }

    public int getDefaultButtonTextColor() {
        return this.f40701b;
    }

    public void setDefaultButtonTextColor(int i) {
        this.f40701b = i;
    }

    public int getIndeterminateDrawable() {
        return this.f40702c;
    }

    public void setIndeterminateDrawable(int i) {
        this.f40702c = i;
    }

    public int getCommonSwitchSelector() {
        return this.f40703d;
    }

    public void setCommonSwitchSelector(int i) {
        this.f40703d = i;
    }

    public int getCommonCheckboxSelector() {
        return this.f40704e;
    }

    public void setCommonCheckboxSelector(int i) {
        this.f40704e = i;
    }

    public int getCommonButtonBackground() {
        return this.f40705f;
    }

    public void setCommonButtonBackground(int i) {
        this.f40705f = i;
    }

    public int getProductBasicColor() {
        return this.f40700a;
    }

    public void setProductBasicColor(int i) {
        this.f40700a = i;
    }

    public int getMaxToastContentLines() {
        return this.f40707h;
    }

    public void setMaxToastContentLines(int i) {
        this.f40707h = i;
    }

    public class TitleBarStyle {
        private int mCommonTitleBarTextSelecter;
        private int mCommonTittleBackground = 0;
        private int mTitleColor = 0;

        public TitleBarStyle() {
        }

        public int getCommonTitleBarTextSelecter() {
            return this.mCommonTitleBarTextSelecter;
        }

        public void setCommonTitleBarTextSelecter(int i) {
            this.mCommonTitleBarTextSelecter = i;
        }

        public int getCommonTittleBackground() {
            return this.mCommonTittleBackground;
        }

        public void setCommonTittleBackground(int i) {
            this.mCommonTittleBackground = i;
        }

        public void setTitleColor(int i) {
            this.mTitleColor = i;
        }

        public int getTitleColor() {
            return this.mTitleColor;
        }
    }

    public static class ToastStyle {
        public DataEntity dataEntity;
        public int toastBackground;
        public int toastYoffset = -1;

        public int getToastBackground() {
            return this.toastBackground;
        }

        public void setToastBackground(int i) {
            this.toastBackground = i;
        }

        public int getToastYoffset() {
            return this.toastYoffset;
        }

        public void setToastYoffset(int i) {
            this.toastYoffset = i;
        }

        public DataEntity getDataEntity() {
            return this.dataEntity;
        }

        public void setDataEntity(DataEntity dataEntity2) {
            this.dataEntity = dataEntity2;
        }
    }
}
