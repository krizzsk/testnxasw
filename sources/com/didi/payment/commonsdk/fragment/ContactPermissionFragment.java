package com.didi.payment.commonsdk.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.view.BaseDialogFragment;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;

public class ContactPermissionFragment extends BaseDialogFragment {

    /* renamed from: a */
    private View f32609a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public OnClickListener f32610b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f32611c;

    /* renamed from: d */
    private TextView f32612d;

    /* renamed from: e */
    private CommonTitleBar f32613e;

    /* renamed from: f */
    private TextView f32614f;

    public interface OnClickListener {
        void onClick(ContactPermissionFragment contactPermissionFragment);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f32609a = layoutInflater.inflate(R.layout.contacts_permission_request_notice, viewGroup, true);
        m24728a();
        return this.f32609a;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_contact_access_sw");
    }

    /* renamed from: a */
    private void m24728a() {
        this.f32613e = (CommonTitleBar) this.f32609a.findViewById(R.id.page_titlebar);
        this.f32612d = (TextView) this.f32609a.findViewById(R.id.contacts_permission_req_btn_tv);
        TextView textView = (TextView) this.f32609a.findViewById(R.id.contacts_permission_req_notice_desc);
        this.f32614f = textView;
        textView.setText(Html.fromHtml(ResourcesHelper.getString(requireContext(), R.string.CS_payment_99pay_will_UuPo)));
        this.f32613e.setLeftImage((int) R.drawable.common_title_back_arrow, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ContactPermissionFragment.this.dismiss();
            }
        });
        if (!TextUtils.isEmpty(this.f32611c)) {
            this.f32612d.setText(this.f32611c);
        }
        this.f32612d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (ContactPermissionFragment.this.f32610b != null) {
                    ContactPermissionFragment.this.f32610b.onClick(ContactPermissionFragment.this);
                }
            }
        });
    }

    public void onStart() {
        super.onStart();
        setStyle(1, 2132017976);
        Window window = getDialog().getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = GravityCompat.END;
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }

    public static class Builder {
        ContactPermissionFragment fragment = new ContactPermissionFragment();

        public Builder setClickListener(String str, OnClickListener onClickListener) {
            String unused = this.fragment.f32611c = str;
            OnClickListener unused2 = this.fragment.f32610b = onClickListener;
            return this;
        }

        public ContactPermissionFragment create() {
            return this.fragment;
        }
    }
}
