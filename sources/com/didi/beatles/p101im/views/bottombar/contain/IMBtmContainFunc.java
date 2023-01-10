package com.didi.beatles.p101im.views.bottombar.contain;

import android.view.View;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.beatles.p101im.access.action.IMActionItem;
import com.didi.beatles.p101im.adapter.IMFuncAdapter;
import java.util.Collections;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.bottombar.contain.IMBtmContainFunc */
class IMBtmContainFunc extends C4858a {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Callback f11862c;

    /* renamed from: d */
    private RecyclerView f11863d;

    /* renamed from: e */
    private IMFuncAdapter f11864e;

    /* renamed from: com.didi.beatles.im.views.bottombar.contain.IMBtmContainFunc$Callback */
    interface Callback {
        void invokeAction(IMActionItem iMActionItem, boolean z);
    }

    IMBtmContainFunc(View view) {
        super(view);
        m10198a(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo48956a(Callback callback) {
        this.f11862c = callback;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public List<IMActionItem> mo48958b() {
        IMFuncAdapter iMFuncAdapter = this.f11864e;
        if (iMFuncAdapter == null) {
            return Collections.emptyList();
        }
        return iMFuncAdapter.getTotalList();
    }

    /* renamed from: a */
    private void m10198a(View view) {
        RecyclerView recyclerView = (RecyclerView) view;
        this.f11863d = recyclerView;
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo48957a(List<IMActionItem> list) {
        IMFuncAdapter iMFuncAdapter = this.f11864e;
        if (iMFuncAdapter != null) {
            iMFuncAdapter.changeSystemList(list);
        } else {
            m10199c(list);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo48959b(List<IMActionItem> list) {
        if (this.f11864e == null) {
            m10199c(Collections.emptyList());
        }
        this.f11864e.changeMoreList(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo48955a(IMActionItem iMActionItem) {
        IMFuncAdapter iMFuncAdapter = this.f11864e;
        if (iMFuncAdapter != null) {
            iMFuncAdapter.refreshItem(iMActionItem);
        }
    }

    /* renamed from: c */
    private void m10199c(List<IMActionItem> list) {
        this.f11863d.setLayoutManager(new GridLayoutManager(this.f11895a, 4, 1, false));
        IMFuncAdapter iMFuncAdapter = new IMFuncAdapter(this.f11895a, list, new IMFuncAdapter.IMFuncOnClickListener() {
            public void onClick(IMActionItem iMActionItem) {
                if (IMBtmContainFunc.this.f11862c != null) {
                    IMBtmContainFunc.this.f11862c.invokeAction(iMActionItem, true);
                }
            }
        });
        this.f11864e = iMFuncAdapter;
        this.f11863d.setAdapter(iMFuncAdapter);
    }
}
