package com.didi.addressold.delegate;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.didi.address.FromType;
import com.didi.addressold.util.ApolloUtil;
import com.sdk.poibase.model.AddressParam;

public class SoftKeyboardDelegate {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f9586a;

    /* renamed from: b */
    private AddressParam f9587b;

    /* renamed from: c */
    private FromType f9588c;

    /* renamed from: d */
    private Handler f9589d = new Handler(Looper.myLooper());
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f9590e = ApolloUtil.isHideInputMethod();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f9591f;

    /* renamed from: g */
    private Runnable f9592g;

    public SoftKeyboardDelegate(Context context, AddressParam addressParam, FromType fromType) {
        this.f9586a = context;
        this.f9587b = addressParam;
        this.f9588c = fromType;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        if (r4.f9587b.addressType == 2) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0084, code lost:
        if (com.didi.addressold.util.CommonUtils.isFromRouteEditor(r4.f9588c) == false) goto L_0x0087;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void hideOrShowSoftKeyboard(com.didi.addressold.view.SugSearchView r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x009a
            android.content.Context r0 = r4.f9586a
            boolean r0 = com.didi.addressold.util.ViewUtils.isBigScreen(r0)
            if (r0 == 0) goto L_0x009a
            com.didi.address.FromType r0 = r4.f9588c
            boolean r0 = com.didi.addressold.util.CommonUtils.isFromRouteEditor(r0)
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L_0x0019
            com.didi.addressold.widget.EditTextErasable r5 = r5.getCommonEditText()
            goto L_0x004b
        L_0x0019:
            com.sdk.poibase.model.AddressParam r0 = r4.f9587b
            int r0 = r0.addressType
            if (r0 != r2) goto L_0x0024
            com.didi.addressold.widget.EditTextErasable r5 = r5.getStartEditText()
            goto L_0x004b
        L_0x0024:
            com.sdk.poibase.model.AddressParam r0 = r4.f9587b
            int r0 = r0.addressType
            if (r0 != r1) goto L_0x002f
            com.didi.addressold.widget.EditTextErasable r5 = r5.getEndEditText()
            goto L_0x004b
        L_0x002f:
            com.sdk.poibase.model.AddressParam r0 = r4.f9587b
            int r0 = r0.addressType
            r3 = 3
            if (r0 == r3) goto L_0x0047
            com.sdk.poibase.model.AddressParam r0 = r4.f9587b
            int r0 = r0.addressType
            r3 = 4
            if (r0 == r3) goto L_0x0047
            com.sdk.poibase.model.AddressParam r0 = r4.f9587b
            int r0 = r0.addressType
            r3 = 5
            if (r0 != r3) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r5 = 0
            goto L_0x004b
        L_0x0047:
            com.didi.addressold.widget.EditTextErasable r5 = r5.getCommonEditText()
        L_0x004b:
            com.didi.address.FromType r0 = r4.f9588c
            boolean r0 = com.didi.addressold.util.CommonUtils.isFromHomePage(r0)
            r3 = 0
            if (r0 == 0) goto L_0x005b
            com.sdk.poibase.model.AddressParam r0 = r4.f9587b
            int r0 = r0.addressType
            if (r0 != r1) goto L_0x0087
            goto L_0x0088
        L_0x005b:
            com.didi.address.FromType r0 = r4.f9588c
            boolean r0 = com.didi.addressold.util.CommonUtils.isFromConfirmPage(r0)
            if (r0 == 0) goto L_0x006c
            com.sdk.poibase.model.AddressParam r0 = r4.f9587b
            int r0 = r0.addressType
            if (r0 != r2) goto L_0x0087
            r2 = 0
            r3 = 1
            goto L_0x0088
        L_0x006c:
            com.didi.address.FromType r0 = r4.f9588c
            boolean r0 = com.didi.addressold.util.CommonUtils.isFromGetOnPage(r0)
            if (r0 == 0) goto L_0x0075
            goto L_0x0087
        L_0x0075:
            com.didi.address.FromType r0 = r4.f9588c
            boolean r0 = com.didi.addressold.util.CommonUtils.isFromSetting(r0)
            if (r0 == 0) goto L_0x007e
            goto L_0x0087
        L_0x007e:
            com.didi.address.FromType r0 = r4.f9588c
            boolean r0 = com.didi.addressold.util.CommonUtils.isFromRouteEditor(r0)
            if (r0 == 0) goto L_0x0087
            goto L_0x0088
        L_0x0087:
            r2 = 0
        L_0x0088:
            if (r5 == 0) goto L_0x009a
            com.didi.addressold.delegate.SoftKeyboardDelegate$1 r0 = new com.didi.addressold.delegate.SoftKeyboardDelegate$1
            r0.<init>(r2, r3, r5)
            r4.f9592g = r0
            android.os.Handler r5 = r4.f9589d
            if (r5 == 0) goto L_0x009a
            r1 = 400(0x190, double:1.976E-321)
            r5.postDelayed(r0, r1)
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.addressold.delegate.SoftKeyboardDelegate.hideOrShowSoftKeyboard(com.didi.addressold.view.SugSearchView):void");
    }

    public void onCreateView() {
        this.f9591f = false;
    }

    public void onDestroyView() {
        Runnable runnable;
        Handler handler = this.f9589d;
        if (!(handler == null || (runnable = this.f9592g) == null)) {
            handler.removeCallbacks(runnable);
        }
        this.f9591f = true;
    }
}
