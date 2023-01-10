package com.didi.soda.business.component.notice;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class BusinessDynamicNoticeView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BusinessDynamicNoticeView f42273a;

    public BusinessDynamicNoticeView_ViewBinding(BusinessDynamicNoticeView businessDynamicNoticeView, View view) {
        this.f42273a = businessDynamicNoticeView;
        businessDynamicNoticeView.mNoticeContentTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_dynamic_notice_text, "field 'mNoticeContentTv'", TextView.class);
        businessDynamicNoticeView.mContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_container, "field 'mContainer'", FrameLayout.class);
    }

    public void unbind() {
        BusinessDynamicNoticeView businessDynamicNoticeView = this.f42273a;
        if (businessDynamicNoticeView != null) {
            this.f42273a = null;
            businessDynamicNoticeView.mNoticeContentTv = null;
            businessDynamicNoticeView.mContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
