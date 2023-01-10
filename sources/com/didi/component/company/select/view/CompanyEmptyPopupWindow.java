package com.didi.component.company.select.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class CompanyEmptyPopupWindow extends PopupWindow {

    /* renamed from: a */
    private View f14407a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f14408b;

    public CompanyEmptyPopupWindow(Context context) {
        super(-1, -1);
        this.f14408b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.company_empty_layout, (ViewGroup) null, false);
        this.f14407a = inflate;
        setContentView(inflate);
    }

    public void show() {
        Context context = this.f14408b;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && !activity.isFinishing() && !isShowing()) {
            setBackgroundDrawable(new ColorDrawable(1076176429));
            setClippingEnabled(false);
            setOutsideTouchable(true);
            this.f14407a.setAnimation(AnimationUtils.loadAnimation(this.f14408b, R.anim.ggk_drawer_bottom_in));
            showAtLocation(this.f14407a, 80, 0, 0);
            ((TextView) this.f14407a.findViewById(R.id.abnormal_btn)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (CompanyEmptyPopupWindow.this.f14408b instanceof ComponentActivity) {
                        ((ComponentActivity) CompanyEmptyPopupWindow.this.f14408b).onBackPressed();
                    }
                }
            });
        }
    }
}
