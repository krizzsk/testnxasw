package com.didi.nova.kyc.jumio.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.didi.nova.kyc.jumio.util.JumioOmegaUtil;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J0\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo148868d2 = {"Lcom/didi/nova/kyc/jumio/widget/BackDialogWindow;", "", "()V", "cancelBtn", "Landroid/widget/TextView;", "closeView", "Landroid/view/View;", "confirmBtn", "context", "Landroid/content/Context;", "rootView", "subTitleView", "titleView", "windowView", "Landroid/widget/PopupWindow;", "closeWindow", "", "init", "exitDetail", "Lcom/didi/payment/commonsdk/spi/DDCustomViewData$ExitDetail;", "confirmListener", "Landroid/view/View$OnClickListener;", "cancelListener", "closeListener", "showWindow", "parent", "kyc-jumios_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BackDialogWindow.kt */
public final class BackDialogWindow {

    /* renamed from: a */
    private PopupWindow f31845a;

    /* renamed from: b */
    private View f31846b;

    /* renamed from: c */
    private View f31847c;

    /* renamed from: d */
    private TextView f31848d;

    /* renamed from: e */
    private TextView f31849e;

    /* renamed from: f */
    private TextView f31850f;

    /* renamed from: g */
    private TextView f31851g;

    /* renamed from: h */
    private Context f31852h;

    /* JADX WARNING: type inference failed for: r4v18, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void init(android.content.Context r4, com.didi.payment.commonsdk.spi.DDCustomViewData.ExitDetail r5, android.view.View.OnClickListener r6, android.view.View.OnClickListener r7, android.view.View.OnClickListener r8) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "confirmListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "cancelListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "closeListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r3.f31852h = r4
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0 = 2131625638(0x7f0e06a6, float:1.887849E38)
            r1 = 0
            r2 = 0
            android.view.View r4 = r4.inflate(r0, r1, r2)
            r3.f31846b = r4
            if (r4 != 0) goto L_0x0029
            r4 = r1
            goto L_0x0030
        L_0x0029:
            r0 = 2131428236(0x7f0b038c, float:1.847811E38)
            android.view.View r4 = r4.findViewById(r0)
        L_0x0030:
            r3.f31847c = r4
            android.view.View r4 = r3.f31846b
            if (r4 != 0) goto L_0x0038
            r4 = r1
            goto L_0x0041
        L_0x0038:
            r0 = 2131427700(0x7f0b0174, float:1.8477024E38)
            android.view.View r4 = r4.findViewById(r0)
            android.widget.TextView r4 = (android.widget.TextView) r4
        L_0x0041:
            r3.f31848d = r4
            android.view.View r4 = r3.f31846b
            if (r4 != 0) goto L_0x0049
            r4 = r1
            goto L_0x0052
        L_0x0049:
            r0 = 2131427699(0x7f0b0173, float:1.8477022E38)
            android.view.View r4 = r4.findViewById(r0)
            android.widget.TextView r4 = (android.widget.TextView) r4
        L_0x0052:
            r3.f31849e = r4
            android.view.View r4 = r3.f31846b
            if (r4 != 0) goto L_0x005a
            r4 = r1
            goto L_0x0063
        L_0x005a:
            r0 = 2131427696(0x7f0b0170, float:1.8477016E38)
            android.view.View r4 = r4.findViewById(r0)
            android.widget.TextView r4 = (android.widget.TextView) r4
        L_0x0063:
            r3.f31850f = r4
            android.view.View r4 = r3.f31846b
            if (r4 != 0) goto L_0x006a
            goto L_0x0074
        L_0x006a:
            r0 = 2131427695(0x7f0b016f, float:1.8477014E38)
            android.view.View r4 = r4.findViewById(r0)
            r1 = r4
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x0074:
            r3.f31851g = r1
            if (r5 != 0) goto L_0x0079
            goto L_0x00b1
        L_0x0079:
            android.widget.TextView r4 = r3.f31848d
            if (r4 != 0) goto L_0x007e
            goto L_0x0087
        L_0x007e:
            java.lang.String r0 = r5.getTitle()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
        L_0x0087:
            android.widget.TextView r4 = r3.f31849e
            if (r4 != 0) goto L_0x008c
            goto L_0x0095
        L_0x008c:
            java.lang.String r0 = r5.getSubTitle()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
        L_0x0095:
            android.widget.TextView r4 = r3.f31850f
            if (r4 != 0) goto L_0x009a
            goto L_0x00a3
        L_0x009a:
            java.lang.String r0 = r5.getFirstBtn()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
        L_0x00a3:
            android.widget.TextView r4 = r3.f31851g
            if (r4 != 0) goto L_0x00a8
            goto L_0x00b1
        L_0x00a8:
            java.lang.String r5 = r5.getSecondBtn()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r4.setText(r5)
        L_0x00b1:
            android.widget.TextView r4 = r3.f31850f
            if (r4 != 0) goto L_0x00b6
            goto L_0x00b9
        L_0x00b6:
            r4.setOnClickListener(r6)
        L_0x00b9:
            android.widget.TextView r4 = r3.f31851g
            if (r4 != 0) goto L_0x00be
            goto L_0x00c1
        L_0x00be:
            r4.setOnClickListener(r7)
        L_0x00c1:
            android.view.View r4 = r3.f31847c
            if (r4 != 0) goto L_0x00c6
            goto L_0x00c9
        L_0x00c6:
            r4.setOnClickListener(r8)
        L_0x00c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.nova.kyc.jumio.widget.BackDialogWindow.init(android.content.Context, com.didi.payment.commonsdk.spi.DDCustomViewData$ExitDetail, android.view.View$OnClickListener, android.view.View$OnClickListener, android.view.View$OnClickListener):void");
    }

    public final void showWindow(View view) {
        Resources resources;
        Intrinsics.checkNotNullParameter(view, "parent");
        if (this.f31845a == null) {
            this.f31845a = new PopupWindow(this.f31846b, -1, -1);
        }
        PopupWindow popupWindow = this.f31845a;
        if (popupWindow != null) {
            popupWindow.setOutsideTouchable(true);
        }
        PopupWindow popupWindow2 = this.f31845a;
        if (popupWindow2 != null) {
            popupWindow2.setTouchable(true);
        }
        PopupWindow popupWindow3 = this.f31845a;
        if (popupWindow3 != null) {
            popupWindow3.setFocusable(true);
        }
        PopupWindow popupWindow4 = this.f31845a;
        if (popupWindow4 != null) {
            popupWindow4.setClippingEnabled(false);
        }
        PopupWindow popupWindow5 = this.f31845a;
        if (popupWindow5 != null) {
            Context context = this.f31852h;
            Drawable drawable = null;
            if (!(context == null || (resources = context.getResources()) == null)) {
                drawable = resources.getDrawable(R.drawable.pop_back_trans);
            }
            popupWindow5.setBackgroundDrawable(drawable);
        }
        JumioOmegaUtil.Companion.fin_jumiodocument_tip_sw();
        PopupWindow popupWindow6 = this.f31845a;
        if (popupWindow6 != null) {
            popupWindow6.showAtLocation(view, 80, 0, 0);
        }
    }

    public final void closeWindow() {
        PopupWindow popupWindow = this.f31845a;
        if (popupWindow != null) {
            boolean z = false;
            if (popupWindow != null && popupWindow.isShowing()) {
                z = true;
            }
            if (z) {
                PopupWindow popupWindow2 = this.f31845a;
                if (popupWindow2 != null) {
                    popupWindow2.dismiss();
                }
                this.f31845a = null;
            }
        }
    }
}
