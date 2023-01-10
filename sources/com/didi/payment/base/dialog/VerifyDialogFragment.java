package com.didi.payment.base.dialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;

public class VerifyDialogFragment extends SimplePopupBase {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f32343a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f32344b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f32345c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f32346d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f32347e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f32348f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public OnClickListener f32349g;

    public interface OnClickListener {
        void onNegativeClick(VerifyDialogFragment verifyDialogFragment);

        void onPositiveClick(VerifyDialogFragment verifyDialogFragment);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.fragment_verify_dialog;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }

    public static class Builder {
        VerifyDialogFragment dialog = new VerifyDialogFragment();

        public Builder showCloseBtn(boolean z) {
            boolean unused = this.dialog.f32343a = z;
            return this;
        }

        public Builder setImageRes(int i) {
            int unused = this.dialog.f32344b = i;
            return this;
        }

        public Builder setTitle(String str) {
            String unused = this.dialog.f32345c = str;
            return this;
        }

        public Builder setContent(String str) {
            String unused = this.dialog.f32346d = str;
            return this;
        }

        public Builder setClickListener(String str, String str2, OnClickListener onClickListener) {
            String unused = this.dialog.f32347e = str;
            String unused2 = this.dialog.f32348f = str2;
            OnClickListener unused3 = this.dialog.f32349g = onClickListener;
            return this;
        }

        public VerifyDialogFragment create() {
            return this.dialog;
        }
    }

    /* access modifiers changed from: protected */
    public void initView() {
        ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.vd_btn_close);
        ImageView imageView2 = (ImageView) this.mRootView.findViewById(R.id.vd_header_iv);
        TextView textView = (TextView) this.mRootView.findViewById(R.id.vd_title_tv);
        TextView textView2 = (TextView) this.mRootView.findViewById(R.id.vd_content_tv);
        TextView textView3 = (TextView) this.mRootView.findViewById(R.id.vd_btn_pos);
        TextView textView4 = (TextView) this.mRootView.findViewById(R.id.vd_btn_neg);
        imageView.setVisibility(this.f32343a ? 0 : 4);
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                VerifyDialogFragment.this.dismiss();
            }
        });
        if (this.f32344b != 0) {
            imageView2.setVisibility(0);
            imageView2.setImageResource(this.f32344b);
        } else {
            imageView2.setVisibility(8);
        }
        textView.setText(this.f32345c);
        textView2.setText(this.f32346d);
        textView3.setText(this.f32347e);
        textView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (VerifyDialogFragment.this.f32349g != null) {
                    VerifyDialogFragment.this.f32349g.onPositiveClick(VerifyDialogFragment.this);
                }
            }
        });
        textView4.setText(this.f32348f);
        textView4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (VerifyDialogFragment.this.f32349g != null) {
                    VerifyDialogFragment.this.f32349g.onNegativeClick(VerifyDialogFragment.this);
                }
            }
        });
        setCancelable(false);
    }
}
