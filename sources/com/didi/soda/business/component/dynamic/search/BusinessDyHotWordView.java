package com.didi.soda.business.component.dynamic.search;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.nova.assembly.p128ui.flowlayout.NovaFlowLayout;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.widget.text.IconRichTextView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class BusinessDyHotWordView extends IView<BusinessDyHotWordPresent> {

    /* renamed from: a */
    private View f42187a;

    /* renamed from: b */
    private NovaFlowLayout f42188b;

    /* renamed from: c */
    private TextView f42189c;

    BusinessDyHotWordView() {
    }

    public void setHotWords(List<String> list) {
        this.f42188b.removeAllViews();
        if (CollectionsUtil.isEmpty(list)) {
            this.f42189c.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (!TextUtils.isEmpty(next)) {
                arrayList.add(m31677a(next));
            }
        }
        if (CollectionsUtil.isEmpty(arrayList)) {
            this.f42189c.setVisibility(8);
        } else {
            this.f42189c.setVisibility(0);
            this.f42188b.addView(arrayList);
        }
        this.f42188b.setClickListener(new NovaFlowLayout.NovaFlowLayoutClickListener() {
            public final void onClick(int i, Object obj, Object obj2) {
                BusinessDyHotWordView.this.m31678a(i, obj, obj2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31678a(int i, Object obj, Object obj2) {
        ((BusinessDyHotWordPresent) getPresenter()).clickWord(i);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.customer_component_business_dy_words_layout, viewGroup, true);
        this.f42187a = inflate;
        this.f42188b = (NovaFlowLayout) inflate.findViewById(R.id.customer_search_recommend_flow_layout);
        this.f42189c = (TextView) this.f42187a.findViewById(R.id.customer_tv_search_recommend_title);
        return this.f42187a;
    }

    /* renamed from: a */
    private View m31677a(String str) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_dy_hot_word_tag, (ViewGroup) null);
        ((IconRichTextView) inflate.findViewById(R.id.customer_tv_business_hot_word_tag)).setText(str);
        return inflate;
    }
}
