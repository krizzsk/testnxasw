package com.didichuxing.diface.appeal.toolkit;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.diface.utils.DisplayUtils;

public class ResizeTakePhoto {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final View f49744a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final View f49745b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final View f49746c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final int f49747d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final int f49748e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final int f49749f;

    public ResizeTakePhoto(Context context, View view, View view2, View view3) {
        this.f49744a = view;
        this.f49745b = view2;
        this.f49746c = view3;
        this.f49747d = DisplayUtils.dip2px(context, 245.0f);
        this.f49748e = DisplayUtils.getScreenWidth(context);
        this.f49749f = DisplayUtils.getScreenHeight(context);
    }

    public void resize(final int i, final int i2) {
        this.f49744a.post(new Runnable() {
            public void run() {
                int i;
                int width = ResizeTakePhoto.this.f49744a.getWidth();
                int i2 = (int) (((((float) width) * 1.0f) * ((float) i)) / ((float) i2));
                ResizeTakePhoto resizeTakePhoto = ResizeTakePhoto.this;
                resizeTakePhoto.m37231a(resizeTakePhoto.f49744a, width, i2);
                int b = ResizeTakePhoto.this.f49749f - i2;
                if (b < ResizeTakePhoto.this.f49747d) {
                    b = ResizeTakePhoto.this.f49747d;
                }
                ResizeTakePhoto resizeTakePhoto2 = ResizeTakePhoto.this;
                resizeTakePhoto2.m37231a(resizeTakePhoto2.f49745b, width, b);
                int height = ResizeTakePhoto.this.f49746c.getHeight();
                int b2 = ResizeTakePhoto.this.f49749f - b;
                if (height >= b2) {
                    height = b2;
                    i = 0;
                } else {
                    i = (b2 - height) / 2;
                }
                ResizeTakePhoto resizeTakePhoto3 = ResizeTakePhoto.this;
                resizeTakePhoto3.m37232a(resizeTakePhoto3.f49746c, width, height, i);
                LogUtils.m37051d("run: screen w * h " + ResizeTakePhoto.this.f49748e + " * " + ResizeTakePhoto.this.f49749f);
                LogUtils.m37051d("run: preview w * h " + i + " * " + i2);
                LogUtils.m37051d("run: flTop w * h " + width + " * " + i2);
                LogUtils.m37051d("run: flBottom w * h " + width + " * " + b);
                LogUtils.m37051d("run: vImg w * h " + height + " * " + width + "  marginTop  : " + i);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37231a(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37232a(View view, int i, int i2, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.width = i;
        marginLayoutParams.height = i2;
        marginLayoutParams.topMargin = i3;
        view.setLayoutParams(marginLayoutParams);
    }
}
