package com.didi.payment.base.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class PayHomelandCityErrorView {

    /* renamed from: a */
    private View f32496a;

    /* renamed from: b */
    private LinkedList<ViewVisibilityRecord> f32497b = new LinkedList<>();

    private static class ViewVisibilityRecord {
        /* access modifiers changed from: private */
        public int originVisibility;
        /* access modifiers changed from: private */
        public WeakReference<View> viewHolder;

        private ViewVisibilityRecord() {
        }
    }

    private PayHomelandCityErrorView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.pay_homeland_city_error_view, (ViewGroup) null);
        this.f32496a = inflate;
        inflate.setTag(this);
    }

    /* renamed from: a */
    private void m24635a(ViewGroup viewGroup) {
        if (viewGroup != null && this.f32496a != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    m24634a(childAt);
                    childAt.setVisibility(8);
                }
            }
            viewGroup.addView(this.f32496a);
        }
    }

    /* renamed from: a */
    private void m24634a(View view) {
        if (view != null) {
            ViewVisibilityRecord viewVisibilityRecord = new ViewVisibilityRecord();
            int unused = viewVisibilityRecord.originVisibility = view.getVisibility();
            WeakReference unused2 = viewVisibilityRecord.viewHolder = new WeakReference(view);
        }
    }

    /* renamed from: a */
    private void m24633a() {
        View view;
        ViewParent parent = this.f32496a.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.f32496a);
            if (!CollectionUtil.isEmpty((Collection) this.f32497b)) {
                Iterator it = this.f32497b.iterator();
                while (it.hasNext()) {
                    ViewVisibilityRecord viewVisibilityRecord = (ViewVisibilityRecord) it.next();
                    if (!(viewVisibilityRecord.viewHolder == null || (view = (View) viewVisibilityRecord.viewHolder.get()) == null)) {
                        view.setVisibility(viewVisibilityRecord.originVisibility);
                    }
                }
            }
        }
    }

    public static void show(ViewGroup viewGroup) {
        Context context;
        if (viewGroup != null && (context = viewGroup.getContext()) != null) {
            new PayHomelandCityErrorView(context).m24635a(viewGroup);
        }
    }

    public static void hide(ViewGroup viewGroup) {
        View findViewById;
        Object tag;
        if (viewGroup != null && (findViewById = viewGroup.findViewById(R.id.ll_wallet_common_intercept_content)) != null && (tag = findViewById.getTag()) != null && (tag instanceof PayHomelandCityErrorView)) {
            ((PayHomelandCityErrorView) tag).m24633a();
            findViewById.setTag((Object) null);
        }
    }

    public static boolean isShown(ViewGroup viewGroup) {
        View findViewById;
        if (viewGroup == null || (findViewById = viewGroup.findViewById(R.id.ll_wallet_common_intercept_content)) == null || findViewById.getVisibility() != 0) {
            return false;
        }
        return true;
    }
}
