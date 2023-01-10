package com.didiglobal.p205sa.biz.component.bizcard;

import android.view.View;
import android.view.ViewGroup;
import com.didi.component.never.core.IView;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.p205sa.biz.component.bizcard.model.BizCardModel;
import com.didiglobal.p205sa.biz.util.UiUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\rH\u0016J2\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00122\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\tJ\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo148868d2 = {"Lcom/didiglobal/sa/biz/component/bizcard/BizCardView;", "Lcom/didi/component/never/core/IView;", "Lcom/didiglobal/sa/biz/component/bizcard/BizCardPresenter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "child", "Ljava/util/ArrayList;", "Lcom/didiglobal/enginecore/component/XEComponent;", "Lkotlin/collections/ArrayList;", "container", "Landroid/view/ViewGroup;", "rootView", "Landroid/view/View;", "getView", "refreshData", "", "list", "", "bizCardModelList", "Lcom/didiglobal/sa/biz/component/bizcard/model/BizCardModel;", "setPresenter", "p0", "visibilityView", "visibility", "", "biz-library_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.bizcard.BizCardView */
/* compiled from: BizCardView.kt */
public final class BizCardView implements IView<BizCardPresenter> {

    /* renamed from: a */
    private View f53330a;

    /* renamed from: b */
    private ViewGroup f53331b;

    /* renamed from: c */
    private final ArrayList<XEComponent> f53332c = new ArrayList<>();

    public void setPresenter(BizCardPresenter bizCardPresenter) {
    }

    /* JADX WARNING: type inference failed for: r3v5, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BizCardView(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r2.<init>()
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            r0 = 2131624277(0x7f0e0155, float:1.887573E38)
            r1 = 0
            android.view.View r3 = r3.inflate(r0, r1)
            java.lang.String r0 = "from(context).inflate(R.…component_biz_card, null)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r2.f53330a = r3
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r2.f53332c = r3
            android.view.View r3 = r2.f53330a
            if (r3 != 0) goto L_0x0027
            goto L_0x0031
        L_0x0027:
            r0 = 2131428337(0x7f0b03f1, float:1.8478316E38)
            android.view.View r3 = r3.findViewById(r0)
            r1 = r3
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
        L_0x0031:
            r2.f53331b = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.component.bizcard.BizCardView.<init>(android.content.Context):void");
    }

    public View getView() {
        return this.f53330a;
    }

    public final void refreshData(List<? extends XEComponent> list, ArrayList<BizCardModel> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.isEmpty()) {
            m39887a(0);
            return;
        }
        ViewGroup viewGroup = this.f53331b;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        this.f53332c.clear();
        if (list != null) {
            this.f53332c.addAll(list);
        }
        if (!this.f53332c.isEmpty()) {
            int size = this.f53332c.size();
            if (size > 0) {
                int i = 0;
                z = false;
                while (true) {
                    int i2 = i + 1;
                    XEComponent xEComponent = this.f53332c.get(i);
                    Intrinsics.checkNotNullExpressionValue(xEComponent, "child[i]");
                    View view = xEComponent.getView();
                    if (view != null) {
                        if (i != 0) {
                            View view2 = new View(view.getContext());
                            ViewGroup viewGroup2 = this.f53331b;
                            if (viewGroup2 != null) {
                                viewGroup2.addView(view2, new ViewGroup.LayoutParams(-1, UiUtils.INSTANCE.dip2px(view.getContext(), 20.0f)));
                            }
                        }
                        ViewGroup viewGroup3 = this.f53331b;
                        if (viewGroup3 != null) {
                            viewGroup3.addView(view);
                        }
                        z = true;
                    }
                    if (i2 >= size) {
                        break;
                    }
                    i = i2;
                }
            } else {
                z = false;
            }
            if (z) {
                m39887a(0);
            } else {
                m39887a(8);
            }
        } else {
            m39887a(8);
        }
    }

    /* renamed from: a */
    private final void m39887a(int i) {
        ViewGroup viewGroup = this.f53331b;
        if (viewGroup != null) {
            viewGroup.setVisibility(i);
        }
        View view = this.f53330a;
        if (view != null) {
            view.setVisibility(i);
        }
    }
}
