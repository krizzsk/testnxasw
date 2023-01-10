package com.didi.nova.assembly.p128ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.nova.assembly.ui.ToastHelper */
public class ToastHelper {

    /* renamed from: a */
    private static Toast f31679a;

    /* renamed from: a */
    private static Toast m24218a(Context context, String str, int i, int i2) {
        Context applicationContext = context.getApplicationContext();
        View inflate = LayoutInflater.from(applicationContext).inflate(R.layout.nova_assembly_common_toast, (ViewGroup) null);
        if (i != 0) {
            ((ImageView) inflate.findViewById(R.id.iv_icon)).setImageResource(i);
        } else {
            inflate.findViewById(R.id.ll_icon_root).setVisibility(8);
        }
        ((TextView) inflate.findViewById(R.id.tv_msg)).setText(str);
        if (f31679a == null) {
            f31679a = new Toast(applicationContext);
        }
        f31679a.setDuration(i2);
        f31679a.setView(inflate);
        f31679a.setGravity(17, 0, 0);
        return f31679a;
    }

    public static void showShortInfo(Context context, String str, int i) {
        SystemUtils.showToast(m24218a(context, str, i, 0));
    }

    public static void showLongInfo(Context context, String str, int i) {
        SystemUtils.showToast(m24218a(context, str, i, 1));
    }
}
