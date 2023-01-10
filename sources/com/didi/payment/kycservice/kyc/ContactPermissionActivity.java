package com.didi.payment.kycservice.kyc;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.didi.commoninterfacelib.permission.PermissionCallback;
import com.didi.commoninterfacelib.permission.PermissionContext;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.payment.commonsdk.p130ui.WBaseActivity;
import com.didi.payment.commonsdk.p130ui.WBaseViewModel;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/ContactPermissionActivity;", "Lcom/didi/payment/commonsdk/ui/WBaseActivity;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "()V", "btnAllow", "Landroid/widget/TextView;", "btnCancel", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ContactPermissionActivity.kt */
public final class ContactPermissionActivity extends WBaseActivity<WBaseViewModel> {

    /* renamed from: a */
    private TextView f33192a;

    /* renamed from: b */
    private TextView f33193b;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_contact_permission_new);
        View findViewById = findViewById(R.id.pix_contact_allow_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.pix_contact_allow_btn)");
        this.f33192a = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.pix_contact_cancel_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.pix_contact_cancel_btn)");
        this.f33193b = (TextView) findViewById2;
        TextView textView = this.f33192a;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnAllow");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ContactPermissionActivity.m25206a(ContactPermissionActivity.this, view);
            }
        });
        TextView textView3 = this.f33193b;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
        } else {
            textView2 = textView3;
        }
        textView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ContactPermissionActivity.m25207b(ContactPermissionActivity.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25206a(ContactPermissionActivity contactPermissionActivity, View view) {
        Intrinsics.checkNotNullParameter(contactPermissionActivity, "this$0");
        PermissionUtil.checkAndRequestPermissions((PermissionContext) contactPermissionActivity, (PermissionCallback) new ContactPermissionActivity$onCreate$1$1(contactPermissionActivity), new String[]{Permission.READ_CONTACTS}, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m25207b(ContactPermissionActivity contactPermissionActivity, View view) {
        Intrinsics.checkNotNullParameter(contactPermissionActivity, "this$0");
        contactPermissionActivity.finish();
    }
}
