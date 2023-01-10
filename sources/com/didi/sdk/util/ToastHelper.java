package com.didi.sdk.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.log.TraceLogUtil;
import com.didi.sdk.view.dialog.ProductControllerStyleManager;
import com.didi.sdk.view.dialog.ProductThemeStyle;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.taxis99.R;

public class ToastHelper {

    /* renamed from: a */
    private static Toast f40405a;

    @Deprecated
    public enum IconType {
        INFO,
        COMPLETE,
        ERROR
    }

    @Deprecated
    public static void show(Context context, int i, int i2, int i3) {
    }

    @Deprecated
    public static void show(Context context, int i, String str, int i2) {
    }

    /* renamed from: a */
    private static Toast m30390a(Context context, String str, int i, int i2) {
        return m30391a(context, str, i, i2, (DataEntity) null);
    }

    /* renamed from: a */
    private static Toast m30391a(Context context, String str, int i, int i2, DataEntity dataEntity) {
        ProductThemeStyle.ToastStyle toastStyle;
        int i3;
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        View inflate = LayoutInflater.from(applicationContext).inflate(R.layout.common_toast, (ViewGroup) null);
        if (f40405a == null) {
            f40405a = Toast.makeText(applicationContext, (CharSequence) null, i2);
        }
        f40405a.setDuration(i2);
        if (!(dataEntity != null || ProductControllerStyleManager.getInstance().getProductThemeStyle() == null || ProductControllerStyleManager.getInstance().getProductThemeStyle().getToastStyle() == null || ProductControllerStyleManager.getInstance().getProductThemeStyle().getToastStyle().getDataEntity() == null)) {
            dataEntity = ProductControllerStyleManager.getInstance().getProductThemeStyle().getToastStyle().getDataEntity();
            if (ProductControllerStyleManager.getInstance().getProductThemeStyle().getToastStyle().getDataEntity().getDataEntityChangeListener() != null) {
                ProductControllerStyleManager.getInstance().getProductThemeStyle().getToastStyle().getDataEntity().getDataEntityChangeListener().onChange(str, i);
            }
        }
        int i4 = 1;
        int i5 = 0;
        if (dataEntity == null || dataEntity.getView() == null) {
            if (!(ProductControllerStyleManager.getInstance().getProductThemeStyle() == null || (toastStyle = ProductControllerStyleManager.getInstance().getProductThemeStyle().getToastStyle()) == null)) {
                inflate.setBackgroundColor(toastStyle.toastBackground);
            }
            if (i > -1) {
                ((ImageView) inflate.findViewById(R.id.iv_icon)).setImageResource(i);
            } else {
                inflate.findViewById(R.id.ll_icon_root).setVisibility(8);
            }
            if (!(dataEntity == null || dataEntity.getAlign() == null)) {
                i4 = dataEntity.getAlign().align;
            }
            f40405a.setGravity(i4, 0, 0);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_msg);
            textView.setText(str);
            textView.setMaxLines(ProductControllerStyleManager.getInstance().getProductThemeStyle().getMaxToastContentLines());
            textView.setContentDescription(str);
            f40405a.setView(inflate);
        } else {
            f40405a.setView(dataEntity.getView());
            if (dataEntity.getAlign() != null) {
                i4 = dataEntity.getAlign().align;
            }
            if (dataEntity.getOffset() != null) {
                i5 = dataEntity.getOffset().f40297x;
                i3 = dataEntity.getOffset().f40298y;
            } else {
                i3 = 0;
            }
            f40405a.getView().startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.footer_slide_in));
            f40405a.setGravity(i4, i5, i3);
        }
        return f40405a;
    }

    /* renamed from: a */
    private static void m30392a(String str, String str2) {
        TraceLogUtil.addLogWithTab("toast_stat", "[mode" + str + "][msg=" + str2 + Const.jaRight);
    }

    public static void showShortInfo(Context context, int i) {
        showShortInfo(context, context.getResources().getString(i));
        m30392a("showShortInfo", context.getResources().getString(i));
    }

    public static void showShortInfo(Context context, int i, DataEntity dataEntity) {
        showShortInfo(context, context.getResources().getString(i), dataEntity);
        m30392a("showShortInfo", context.getResources().getString(i));
    }

    public static void showLongInfo(Context context, int i) {
        showLongInfo(context, context.getResources().getString(i));
        m30392a("showLongInfo", context.getResources().getString(i));
    }

    public static void showLongInfo(Context context, int i, DataEntity dataEntity) {
        showLongInfo(context, context.getResources().getString(i), dataEntity);
        m30392a("showLongInfo", context.getResources().getString(i));
    }

    public static void showShortInfo(Context context, String str) {
        SystemUtils.showToast(m30390a(context, str, R.drawable.toast_icon_warning, 0));
        m30392a("showShortInfo", str);
    }

    public static void showShortInfo(Context context, String str, DataEntity dataEntity) {
        SystemUtils.showToast(m30391a(context, str, R.drawable.toast_icon_warning, 0, dataEntity));
        m30392a("showShortInfo", str);
    }

    public static void showLongInfo(Context context, String str) {
        SystemUtils.showToast(m30390a(context, str, R.drawable.toast_icon_warning, 1));
        m30392a("showLongInfo", str);
    }

    public static void showLongInfo(Context context, String str, DataEntity dataEntity) {
        SystemUtils.showToast(m30391a(context, str, R.drawable.toast_icon_warning, 1, dataEntity));
        m30392a("showLongInfo", str);
    }

    public static void showShortWait(Context context, String str) {
        SystemUtils.showToast(m30390a(context, str, R.drawable.toast_icon_time, 0));
        m30392a("showShortWait", str);
    }

    public static void showShortWait(Context context, String str, DataEntity dataEntity) {
        SystemUtils.showToast(m30391a(context, str, R.drawable.toast_icon_time, 0, dataEntity));
        m30392a("showShortWait", str);
    }

    public static void showLongWait(Context context, String str) {
        SystemUtils.showToast(m30390a(context, str, R.drawable.toast_icon_time, 1));
        m30392a("showLongWait", str);
    }

    public static void showLongWait(Context context, String str, DataEntity dataEntity) {
        SystemUtils.showToast(m30391a(context, str, R.drawable.toast_icon_time, 1, dataEntity));
        m30392a("showLongWait", str);
    }

    public static void showShortInfo(Context context, String str, int i) {
        SystemUtils.showToast(m30390a(context, str, i, 0));
    }

    public static void showShortInfo(Context context, String str, int i, DataEntity dataEntity) {
        SystemUtils.showToast(m30391a(context, str, i, 0, dataEntity));
    }

    public static void showLongInfo(Context context, String str, int i) {
        SystemUtils.showToast(m30390a(context, str, i, 1));
    }

    public static void showLongInfo(Context context, String str, int i, DataEntity dataEntity) {
        SystemUtils.showToast(m30391a(context, str, i, 1, dataEntity));
    }

    public static void showWait(Context context, String str, int i) {
        SystemUtils.showToast(m30390a(context, str, R.drawable.toast_icon_time, i));
        m30392a("showWait", str);
    }

    public static void showWait(Context context, String str, int i, DataEntity dataEntity) {
        SystemUtils.showToast(m30391a(context, str, R.drawable.toast_icon_time, i, dataEntity));
        m30392a("showWait", str);
    }

    public static void showShortInfoText(Context context, String str) {
        SystemUtils.showToast(m30390a(context, str, -1, 0));
        m30392a("showShortInfoNoIcon", str);
    }

    public static void showShortInfoText(Context context, String str, DataEntity dataEntity) {
        SystemUtils.showToast(m30391a(context, str, -1, 0, dataEntity));
        m30392a("showShortInfoNoIcon", str);
    }

    public static void showLongInfoText(Context context, String str) {
        SystemUtils.showToast(m30390a(context, str, -1, 1));
        m30392a("showShortInfoNoIcon", str);
    }

    public static void showLongInfoText(Context context, String str, DataEntity dataEntity) {
        SystemUtils.showToast(m30391a(context, str, -1, 1, dataEntity));
        m30392a("showShortInfoNoIcon", str);
    }

    @Deprecated
    public static void showShortInfo(Context context, String str, String str2) {
        showShortInfo(context, str);
        m30392a("showShortInfo", str);
    }

    @Deprecated
    public static void showShortInfo(Context context, String str, String str2, DataEntity dataEntity) {
        showShortInfo(context, str, dataEntity);
        m30392a("showShortInfo", str);
    }

    @Deprecated
    public static void showShortError(Context context, int i) {
        showShortInfo(context, context.getResources().getString(i));
    }

    @Deprecated
    public static void showShortError(Context context, int i, DataEntity dataEntity) {
        showShortInfo(context, context.getResources().getString(i), dataEntity);
    }

    @Deprecated
    public static void showLongError(Context context, int i) {
        showLongInfo(context, context.getResources().getString(i));
    }

    @Deprecated
    public static void showLongError(Context context, int i, DataEntity dataEntity) {
        showLongInfo(context, context.getResources().getString(i), dataEntity);
    }

    @Deprecated
    public static void showShortError(Context context, String str) {
        showShortInfo(context, str);
    }

    @Deprecated
    public static void showShortError(Context context, String str, DataEntity dataEntity) {
        showShortInfo(context, str, dataEntity);
    }

    @Deprecated
    public static void showLongError(Context context, String str) {
        showLongInfo(context, str);
    }

    @Deprecated
    public static void showLongError(Context context, String str, DataEntity dataEntity) {
        showLongInfo(context, str, dataEntity);
    }

    public static void showShortCompleted(Context context, int i) {
        showShortCompleted(context, context.getResources().getString(i));
        m30392a("showShortCompleted", context.getResources().getString(i));
    }

    public static void showShortCompleted(Context context, int i, DataEntity dataEntity) {
        showShortCompleted(context, context.getResources().getString(i), dataEntity);
        m30392a("showShortCompleted", context.getResources().getString(i));
    }

    public static void showLongCompleted(Context context, int i) {
        showLongCompleted(context, context.getResources().getString(i));
        m30392a("showLongCompleted", context.getResources().getString(i));
    }

    public static void showLongCompleted(Context context, int i, DataEntity dataEntity) {
        showLongCompleted(context, context.getResources().getString(i), dataEntity);
        m30392a("showLongCompleted", context.getResources().getString(i));
    }

    public static void showShortCompleted(Context context, String str) {
        SystemUtils.showToast(m30390a(context, str, R.drawable.toast_icon_right, 0));
        m30392a("showShortCompleted", str);
    }

    public static void showShortCompleted(Context context, String str, int i) {
        SystemUtils.showToast(m30390a(context, str, i, 0));
        m30392a("showShortCompleted", str);
    }

    public static void showShortCompleted(Context context, String str, DataEntity dataEntity) {
        SystemUtils.showToast(m30391a(context, str, R.drawable.toast_icon_right, 0, dataEntity));
        m30392a("showShortCompleted", str);
    }

    public static void showLongCompleted(Context context, String str) {
        SystemUtils.showToast(m30390a(context, str, R.drawable.toast_icon_right, 1));
        m30392a("showLongCompleted", str);
    }

    public static void showLongCompleted(Context context, String str, int i) {
        SystemUtils.showToast(m30390a(context, str, i, 1));
        m30392a("showLongCompleted", str);
    }

    public static void showLongCompleted(Context context, String str, DataEntity dataEntity) {
        SystemUtils.showToast(m30391a(context, str, R.drawable.toast_icon_right, 1, dataEntity));
        m30392a("showLongCompleted", str);
    }

    @Deprecated
    public static void showLongCompleteMessage(Context context, int i) {
        showLongCompleted(context, context.getResources().getString(i));
        m30392a("showLongCompleteMessage", context.getResources().getString(i));
    }

    @Deprecated
    public static void showLongCompleteMessage(Context context, int i, DataEntity dataEntity) {
        showLongCompleted(context, context.getResources().getString(i), dataEntity);
        m30392a("showLongCompleteMessage", context.getResources().getString(i));
    }

    @Deprecated
    public static void showLongCompleteMessage(Context context, String str) {
        showLongCompleted(context, str);
        m30392a("showLongCompleteMessage", str);
    }

    @Deprecated
    public static void showLongCompleteMessage(Context context, String str, DataEntity dataEntity) {
        showLongCompleted(context, str, dataEntity);
        m30392a("showLongCompleteMessage", str);
    }
}
