package com.didi.hawaii.p120ar.view;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.hawaii.p120ar.core.ThemeManager;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.hawaii.ar.view.GuideView */
public class GuideView {

    /* renamed from: a */
    PopupWindow f25662a;

    /* renamed from: b */
    Context f25663b;

    /* renamed from: c */
    OnGuideViewDissMissListener f25664c;

    /* renamed from: d */
    ViewGroup f25665d;

    /* renamed from: e */
    ImageView f25666e;

    /* renamed from: f */
    ImageView f25667f;

    /* renamed from: g */
    Button f25668g;

    /* renamed from: h */
    ObjectAnimator f25669h;

    /* renamed from: i */
    int[] f25670i = new int[2];

    /* renamed from: j */
    int[] f25671j = new int[2];
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Dialog f25672k;

    /* renamed from: com.didi.hawaii.ar.view.GuideView$OnGuideViewDissMissListener */
    public interface OnGuideViewDissMissListener {
        void onDisMiss();
    }

    public GuideView(Context context, ViewGroup viewGroup) {
        this.f25663b = context;
        this.f25665d = viewGroup;
    }

    public GuideView builder() {
        View inflate = LayoutInflater.from(this.f25663b).inflate(R.layout.view_guide, (ViewGroup) null);
        this.f25667f = (ImageView) inflate.findViewById(R.id.phone_bg);
        this.f25668g = (Button) inflate.findViewById(R.id.guide_cancle);
        Dialog dialog = this.f25672k;
        if (dialog != null && dialog.isShowing()) {
            this.f25672k.dismiss();
        }
        if (this.f25672k == null) {
            this.f25672k = new Dialog(this.f25663b, R.style.AlertDialogStyle);
        }
        this.f25672k.setContentView(inflate);
        this.f25672k.setCancelable(false);
        Button button = this.f25668g;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GuideView.this.f25672k.dismiss();
                    if (GuideView.this.f25664c != null) {
                        GuideView.this.f25664c.onDisMiss();
                    }
                }
            });
        }
        m20408a(inflate);
        return this;
    }

    /* renamed from: a */
    private void m20408a(View view) {
        ThemeManager.getInstance().changeViewTheme((TextView) view.findViewById(R.id.guide_title_tv), R.id.guide_title_tv);
        ThemeManager.getInstance().changeViewTheme((TextView) view.findViewById(R.id.guide_2_tv), R.id.guide_2_tv);
    }

    public GuideView setCanclebleOutside(boolean z) {
        PopupWindow popupWindow = this.f25662a;
        if (popupWindow != null) {
            popupWindow.setOutsideTouchable(z);
        }
        return this;
    }

    public GuideView setDisMissListener(OnGuideViewDissMissListener onGuideViewDissMissListener) {
        this.f25664c = onGuideViewDissMissListener;
        return this;
    }

    public void show() {
        Dialog dialog = this.f25672k;
        if (dialog != null) {
            SystemUtils.showDialog(dialog);
        }
    }
}
