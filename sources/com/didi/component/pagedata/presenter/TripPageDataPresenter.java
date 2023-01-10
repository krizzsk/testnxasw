package com.didi.component.pagedata.presenter;

import android.content.Context;
import android.os.Bundle;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.TripListener;
import com.didi.component.business.data.form.listener.observer.XpanelResponseListener;
import com.didi.component.pagedata.AbsPageDataPresenter;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarGroup;
import java.util.ArrayList;
import java.util.List;

public class TripPageDataPresenter extends AbsPageDataPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<AnyCarEstimateItemModel> f16700a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AnyCarEstimateItemModel f16701b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<XpanelResponseListener> f16702c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public List<AnyCarGroup> f16703d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f16704e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f16705f;

    public TripPageDataPresenter(Context context) {
        super(context);
        PageCompDataTransfer.getInstance().setTripListener(new TripListener() {
            public void setSelectedAnyCarItem(List<AnyCarEstimateItemModel> list) {
                List unused = TripPageDataPresenter.this.f16700a = list;
            }

            public List<AnyCarEstimateItemModel> getSelectedAnyCarItems() {
                return TripPageDataPresenter.this.f16700a;
            }

            public void setSelectedSingleAnyCarItem(AnyCarEstimateItemModel anyCarEstimateItemModel) {
                AnyCarEstimateItemModel unused = TripPageDataPresenter.this.f16701b = anyCarEstimateItemModel;
            }

            public AnyCarEstimateItemModel getSelectedSingleAnyCarItem() {
                return TripPageDataPresenter.this.f16701b;
            }

            public void addXpanelResponseListener(XpanelResponseListener xpanelResponseListener) {
                if (TripPageDataPresenter.this.f16702c == null) {
                    List unused = TripPageDataPresenter.this.f16702c = new ArrayList();
                }
                TripPageDataPresenter.this.f16702c.add(xpanelResponseListener);
            }

            public List<XpanelResponseListener> getXpanelResponseListener() {
                return TripPageDataPresenter.this.f16702c;
            }

            public List<AnyCarGroup> getGroups() {
                return TripPageDataPresenter.this.f16703d;
            }

            public void setGroups(List<AnyCarGroup> list) {
                List unused = TripPageDataPresenter.this.f16703d = list;
            }

            public void setIsAnyCar(boolean z) {
                boolean unused = TripPageDataPresenter.this.f16705f = z;
            }

            public boolean getIsAnyCar() {
                return TripPageDataPresenter.this.f16705f;
            }

            public void setPreference(int i) {
                int unused = TripPageDataPresenter.this.f16704e = i;
            }

            public int getPreference() {
                return TripPageDataPresenter.this.f16704e;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        PageCompDataTransfer.getInstance().setTripListener((TripListener) null);
    }
}
