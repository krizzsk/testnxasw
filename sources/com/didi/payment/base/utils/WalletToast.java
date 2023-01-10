package com.didi.payment.base.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class WalletToast {

    /* renamed from: a */
    private static Toast f32488a;

    /* renamed from: b */
    private static TextView f32489b;

    /* renamed from: c */
    private static ImageView f32490c;

    /* renamed from: a */
    private static void m24631a(Context context) {
        f32488a = new Toast(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.wallet_toast_layout, (ViewGroup) null);
        f32489b = (TextView) inflate.findViewById(R.id.toast_msg_tv);
        f32490c = (ImageView) inflate.findViewById(R.id.toast_icon_iv);
        f32488a.setGravity(87, 0, 0);
        f32488a.setView(inflate);
    }

    /* renamed from: b */
    private static void m24632b(Context context) {
        f32488a = new Toast(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.wallet_toast_layout, (ViewGroup) null);
        f32489b = (TextView) inflate.findViewById(R.id.toast_msg_tv);
        f32490c = (ImageView) inflate.findViewById(R.id.toast_icon_iv);
        f32488a.setGravity(55, 0, 0);
        f32488a.setView(inflate);
    }

    public static void showSuccessMsg(Context context, String str) {
        if (f32488a == null) {
            m24632b(context.getApplicationContext());
        }
        f32489b.setText(str);
        f32490c.setImageResource(R.drawable.wallet_toast_icon_successful);
        f32488a.setDuration(0);
        SystemUtils.showToast(f32488a);
    }

    public static void showFailedMsg(Context context, String str) {
        if (f32488a == null) {
            m24632b(context.getApplicationContext());
        }
        f32489b.setText(str);
        f32490c.setImageResource(R.drawable.wallet_toast_icon_fail);
        f32488a.setDuration(0);
        SystemUtils.showToast(f32488a);
    }

    public static void showMsg(Context context, String str) {
        if (f32488a == null) {
            m24632b(context.getApplicationContext());
        }
        f32489b.setText(str);
        f32490c.setImageBitmap((Bitmap) null);
        f32488a.setDuration(0);
        SystemUtils.showToast(f32488a);
    }

    public static void cancel() {
        Toast toast = f32488a;
        if (toast != null) {
            toast.cancel();
        }
    }
}
