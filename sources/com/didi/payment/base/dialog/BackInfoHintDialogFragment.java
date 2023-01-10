package com.didi.payment.base.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;

public class BackInfoHintDialogFragment extends SimplePopupBase {

    /* renamed from: a */
    private String f32320a;

    /* renamed from: b */
    private String f32321b;

    /* renamed from: c */
    private String f32322c;

    /* renamed from: d */
    private String f32323d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View.OnClickListener f32324e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View.OnClickListener f32325f;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.pay_base_drawer_dialog;
    }

    public static void show(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        BackInfoHintDialogFragment backInfoHintDialogFragment = new BackInfoHintDialogFragment();
        backInfoHintDialogFragment.f32320a = str;
        backInfoHintDialogFragment.f32321b = str2;
        backInfoHintDialogFragment.f32322c = str3;
        backInfoHintDialogFragment.f32323d = str4;
        backInfoHintDialogFragment.f32324e = onClickListener;
        backInfoHintDialogFragment.f32325f = onClickListener2;
        backInfoHintDialogFragment.show(fragmentActivity.getSupportFragmentManager(), "back_info_dialog");
    }

    /* access modifiers changed from: protected */
    public void initView() {
        TextView textView = (TextView) this.mRootView.findViewById(R.id.drawer_dialog_left_btn);
        TextView textView2 = (TextView) this.mRootView.findViewById(R.id.drawer_dialog_right_btn);
        ((TextView) this.mRootView.findViewById(R.id.drawer_dialog_title_tv)).setText(this.f32320a);
        ((TextView) this.mRootView.findViewById(R.id.drawer_dialog_content_tv)).setText(this.f32321b);
        textView.setText(this.f32322c);
        textView2.setText(this.f32323d);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BackInfoHintDialogFragment.this.dismiss();
                if (BackInfoHintDialogFragment.this.f32324e != null) {
                    BackInfoHintDialogFragment.this.f32324e.onClick(view);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BackInfoHintDialogFragment.this.dismiss();
                if (BackInfoHintDialogFragment.this.f32325f != null) {
                    BackInfoHintDialogFragment.this.f32325f.onClick(view);
                }
            }
        });
    }
}
