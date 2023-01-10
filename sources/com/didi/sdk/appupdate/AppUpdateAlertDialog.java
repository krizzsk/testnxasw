package com.didi.sdk.appupdate;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.taxis99.R;

public class AppUpdateAlertDialog extends DialogFragment {

    /* renamed from: a */
    private Builder f38009a;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static AppUpdateAlertDialog m28681b(Builder builder) {
        AppUpdateAlertDialog appUpdateAlertDialog = new AppUpdateAlertDialog();
        appUpdateAlertDialog.m28682c(builder);
        return appUpdateAlertDialog;
    }

    /* renamed from: c */
    private void m28682c(Builder builder) {
        this.f38009a = builder;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 0);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.common_dialog_anim_style;
        }
        View inflate = layoutInflater.inflate(R.layout.v_app_update_check_dialog, viewGroup, false);
        m28680a(inflate);
        return inflate;
    }

    /* renamed from: a */
    private void m28680a(View view) {
        TextView textView = (TextView) view.findViewById(R.id.text_title);
        TextView textView2 = (TextView) view.findViewById(R.id.text_message);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_btn_area_vertical_2);
        Button button = (Button) view.findViewById(R.id.button_top_bottom_1);
        Button button2 = (Button) view.findViewById(R.id.button_top_bottom_2);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_btn_area_vertical_1);
        Button button3 = (Button) view.findViewById(R.id.button_one);
        Builder builder = this.f38009a;
        if (builder != null) {
            if (!TextUtils.isEmpty(builder.mTitle)) {
                textView.setVisibility(0);
                textView.setText(this.f38009a.mTitle);
            }
            if (!TextUtils.isEmpty(this.f38009a.mMessage)) {
                textView2.setVisibility(0);
                textView2.setText(this.f38009a.mMessage);
            }
            if (this.f38009a.mPositiveClickListener != null && this.f38009a.mNegativeClickListener != null) {
                linearLayout.setVisibility(0);
                linearLayout2.setVisibility(8);
                button.setText(this.f38009a.mPositiveBtn);
                button2.setText(this.f38009a.mNegativeBtn);
                button.setOnClickListener(this.f38009a.mPositiveClickListener);
                button2.setOnClickListener(this.f38009a.mNegativeClickListener);
            } else if (this.f38009a.mPositiveClickListener == null && this.f38009a.mNegativeClickListener == null) {
                linearLayout.setVisibility(8);
                linearLayout2.setVisibility(8);
            } else {
                linearLayout.setVisibility(8);
                linearLayout2.setVisibility(0);
                button3.setText(this.f38009a.mPositiveClickListener != null ? this.f38009a.mPositiveBtn : this.f38009a.mNegativeBtn);
                button3.setOnClickListener(this.f38009a.mPositiveClickListener != null ? this.f38009a.mPositiveClickListener : this.f38009a.mNegativeClickListener);
            }
        }
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            Window window = dialog.getWindow();
            window.setLayout((int) (((double) displayMetrics.widthPixels) * 0.712d), -2);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.4f;
            attributes.flags |= 2;
            window.setAttributes(attributes);
        }
    }

    public void show(FragmentManager fragmentManager, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "app_update_alert_dialog_tag";
        }
        super.show(fragmentManager, str);
    }

    public static class Builder {
        public boolean mCancelable = true;
        public final Context mContext;
        public CharSequence mMessage;
        public CharSequence mNegativeBtn;
        public View.OnClickListener mNegativeClickListener;
        public CharSequence mPositiveBtn;
        public View.OnClickListener mPositiveClickListener;
        public CharSequence mTitle;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.mTitle = charSequence;
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.mMessage = charSequence;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, View.OnClickListener onClickListener) {
            this.mPositiveBtn = charSequence;
            this.mPositiveClickListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, View.OnClickListener onClickListener) {
            this.mNegativeBtn = charSequence;
            this.mNegativeClickListener = onClickListener;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.mCancelable = z;
            return this;
        }

        public AppUpdateAlertDialog create() {
            AppUpdateAlertDialog a = AppUpdateAlertDialog.m28681b(this);
            a.setCancelable(this.mCancelable);
            return a;
        }
    }
}
