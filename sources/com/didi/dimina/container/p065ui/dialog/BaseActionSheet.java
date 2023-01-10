package com.didi.dimina.container.p065ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.dimina.container.p065ui.dialog.ActionSheetItemView;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.dimina.container.ui.dialog.BaseActionSheet */
public class BaseActionSheet extends Dialog {

    /* renamed from: a */
    private final Context f19423a;

    /* renamed from: b */
    private final OnDismissListener f19424b;

    /* renamed from: c */
    private View f19425c;

    /* renamed from: d */
    private String f19426d;

    /* renamed from: e */
    private int f19427e = -1;
    protected LinearLayout mContentContainer;

    /* renamed from: com.didi.dimina.container.ui.dialog.BaseActionSheet$OnDismissListener */
    public interface OnDismissListener {
        void onDismiss(int i);
    }

    public BaseActionSheet(Context context, OnDismissListener onDismissListener) {
        super(context, R.style.BottomDialog);
        this.f19423a = context;
        this.f19424b = onDismissListener;
        m16494a();
    }

    /* renamed from: a */
    private void m16494a() {
        View inflate = LayoutInflater.from(this.f19423a).inflate(R.layout.dimina_action_sheet, (ViewGroup) null);
        this.f19425c = inflate;
        this.mContentContainer = (LinearLayout) inflate.findViewById(R.id.action_sheet_content_container);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.f19425c);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = m16497b();
        attributes.gravity = 80;
        getWindow().setAttributes(attributes);
        getWindow().setWindowAnimations(2132017442);
    }

    /* renamed from: b */
    private int m16497b() {
        DisplayMetrics displayMetrics;
        if (getContext() == null || (displayMetrics = getContext().getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.widthPixels;
    }

    public void refresh(List<String> list) {
        this.mContentContainer.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (!TextUtils.isEmpty(str)) {
                m16496a(i, str, Color.parseColor(this.f19426d));
                m16495a(1);
            }
        }
        m16495a(20);
        m16496a(-1, "取消", Color.parseColor("#000000"));
    }

    /* renamed from: a */
    private void m16495a(int i) {
        View view = new View(this.f19423a);
        view.setBackgroundColor(Color.parseColor("#F5F5F5"));
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
        this.mContentContainer.addView(view);
    }

    /* renamed from: a */
    private void m16496a(int i, String str, int i2) {
        ActionSheetItemView actionSheetItemView = new ActionSheetItemView(this.f19423a);
        actionSheetItemView.setTextValue(str, i2);
        actionSheetItemView.setActionSheetItemClick(new ActionSheetItemView.ActionSheetItemClick(i) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick() {
                BaseActionSheet.this.m16498b(this.f$1);
            }
        });
        this.mContentContainer.addView(actionSheetItemView);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m16498b(int i) {
        this.f19427e = i;
        dismiss();
    }

    public void setTitle(String str) {
        if (this.f19423a != null && !TextUtils.isEmpty(str)) {
            TextView textView = (TextView) LayoutInflater.from(this.f19423a).inflate(R.layout.dimina_action_sheet, (ViewGroup) null).findViewById(R.id.alert_title);
            textView.setVisibility(0);
            textView.setText(str);
        }
    }

    public void setItemColor(String str) {
        this.f19426d = str;
    }

    public void show() {
        super.show();
    }

    public void dismiss() {
        super.dismiss();
        LinearLayout linearLayout = this.mContentContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            OnDismissListener onDismissListener = this.f19424b;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(this.f19427e);
            }
        }
    }
}
