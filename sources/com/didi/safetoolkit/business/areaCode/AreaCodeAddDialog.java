package com.didi.safetoolkit.business.areaCode;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.android.didi.safetoolkit.fragment.BaseDialogFragment;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class AreaCodeAddDialog extends BaseDialogFragment {

    /* renamed from: a */
    private TextView f36977a;

    /* renamed from: b */
    private TextView f36978b;

    /* renamed from: c */
    private TextView f36979c;

    /* renamed from: d */
    private LinearLayout f36980d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Builder f36981e;

    /* access modifiers changed from: protected */
    public int getLayoutRes() {
        return R.layout.sf_area_code_add_dialog;
    }

    /* access modifiers changed from: protected */
    public void initData() {
    }

    /* access modifiers changed from: protected */
    public void initObjects() {
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void setListener() {
    }

    public static AreaCodeAddDialog newInstance(Builder builder) {
        AreaCodeAddDialog areaCodeAddDialog = new AreaCodeAddDialog();
        areaCodeAddDialog.f36981e = builder;
        return areaCodeAddDialog;
    }

    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        window.setAttributes(attributes);
    }

    public View getLoadingView() {
        return findViewById(R.id.sf_loading);
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.dialog_layout);
        this.f36980d = linearLayout;
        if (linearLayout != null) {
            linearLayout.startAnimation(AnimationUtils.loadAnimation(this.f36981e.mContext, R.anim.footer_slide_in));
        }
        this.f36977a = (TextView) findViewById(R.id.guide_text);
        this.f36978b = (TextView) findViewById(R.id.sf_dialog_cancel);
        this.f36979c = (TextView) findViewById(R.id.sf_dialog_confirm);
        if (!TextUtils.isEmpty(this.f36981e.content)) {
            this.f36977a.setText(this.f36981e.content);
        }
        if (!TextUtils.isEmpty(this.f36981e.posText)) {
            this.f36979c.setText(this.f36981e.posText);
        }
        if (!TextUtils.isEmpty(this.f36981e.negText)) {
            this.f36978b.setText(this.f36981e.negText);
        }
        this.f36979c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (AreaCodeAddDialog.this.f36981e.listener != null) {
                    AreaCodeAddDialog.this.f36981e.listener.onPositiveClick(AreaCodeAddDialog.this);
                }
            }
        });
        this.f36978b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (AreaCodeAddDialog.this.f36981e.listener != null) {
                    AreaCodeAddDialog.this.f36981e.listener.onNegativeClick(AreaCodeAddDialog.this);
                }
            }
        });
        setCancelable(this.f36981e.cancelable);
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public boolean cancelable = true;
        /* access modifiers changed from: private */
        public String content;
        private AreaCodeAddDialog dialog;
        /* access modifiers changed from: private */
        public DialogListener listener;
        /* access modifiers changed from: private */
        public FragmentActivity mContext;
        /* access modifiers changed from: private */
        public String negText;
        /* access modifiers changed from: private */
        public String posText;

        public interface DialogListener {
            void onNegativeClick(BaseDialogFragment baseDialogFragment);

            void onPositiveClick(BaseDialogFragment baseDialogFragment);
        }

        public Builder(FragmentActivity fragmentActivity) {
            this.mContext = fragmentActivity;
        }

        public Builder setListener(DialogListener dialogListener) {
            this.listener = dialogListener;
            return this;
        }

        public Builder setContent(String str) {
            this.content = str;
            return this;
        }

        public Builder setPositiveText(String str) {
            this.posText = str;
            return this;
        }

        public Builder setNegativeText(String str) {
            this.negText = str;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.cancelable = z;
            return this;
        }

        public AreaCodeAddDialog create() {
            AreaCodeAddDialog newInstance = AreaCodeAddDialog.newInstance(this);
            this.dialog = newInstance;
            return newInstance;
        }
    }
}
