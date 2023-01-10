package com.didi.app.nova.support.view.recyclerview.view.layoutmanager;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.app.nova.support.view.recyclerview.mark.StickyHeader;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.ViewRetriever;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.app.nova.support.view.recyclerview.view.layoutmanager.a */
/* compiled from: NovaLayoutManagerDelegate */
class C4346a {

    /* renamed from: a */
    private List<Integer> f10479a = new ArrayList();

    /* renamed from: b */
    private ViewRetriever.RecyclerViewRetriever f10480b;

    /* renamed from: c */
    private C4347b f10481c;

    /* renamed from: d */
    private INovaLayoutManager f10482d;

    /* renamed from: e */
    private NovaRecyclerAdapter f10483e;

    /* renamed from: f */
    private int f10484f = -1;

    C4346a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo46297a(INovaLayoutManager iNovaLayoutManager, NovaRecyclerAdapter novaRecyclerAdapter) {
        this.f10482d = iNovaLayoutManager;
        this.f10483e = novaRecyclerAdapter;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo46293a() {
        C4347b bVar = this.f10481c;
        if (bVar != null) {
            bVar.mo46307b(1);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo46298a(boolean z) {
        int i = z ? 5 : -1;
        this.f10484f = i;
        mo46294a(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo46294a(int i) {
        this.f10484f = i;
        C4347b bVar = this.f10481c;
        if (bVar != null) {
            bVar.mo46302a(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo46295a(RecyclerView.Recycler recycler, RecyclerView.State state) {
        m9145f();
        if (this.f10481c != null) {
            m9143d();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo46299b() {
        C4347b bVar = this.f10481c;
        if (bVar != null) {
            bVar.mo46303a(this.f10482d.findFirstVisibleItemPosition(), m9144e(), this.f10480b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo46300c() {
        C4347b bVar = this.f10481c;
        if (bVar != null) {
            bVar.mo46301a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo46296a(RecyclerView recyclerView) {
        if (this.f10480b == null) {
            this.f10480b = new ViewRetriever.RecyclerViewRetriever(recyclerView);
        }
        if (this.f10481c == null) {
            this.f10481c = new C4347b(recyclerView);
        }
        this.f10481c.mo46302a(this.f10484f);
        if (this.f10479a.size() > 0) {
            this.f10481c.mo46305a(this.f10479a);
            m9143d();
        }
    }

    /* renamed from: d */
    private void m9143d() {
        this.f10481c.mo46307b(this.f10482d.getOrientation());
        this.f10481c.mo46303a(this.f10482d.findFirstVisibleItemPosition(), m9144e(), this.f10480b);
    }

    /* renamed from: e */
    private Map<Integer, View> m9144e() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < this.f10482d.getChildCount(); i++) {
            View childAt = this.f10482d.getChildAt(i);
            int position = this.f10482d.getPosition(childAt);
            if (this.f10479a.contains(Integer.valueOf(position))) {
                linkedHashMap.put(Integer.valueOf(position), childAt);
            }
        }
        return linkedHashMap;
    }

    /* renamed from: f */
    private void m9145f() {
        this.f10479a.clear();
        for (int i = 0; i < this.f10483e.getItemCount(); i++) {
            if (i < this.f10483e.getItemCount() + 0 && (this.f10483e.getItem(i + 0) instanceof StickyHeader)) {
                this.f10479a.add(Integer.valueOf(i));
            }
        }
        C4347b bVar = this.f10481c;
        if (bVar != null) {
            bVar.mo46305a(this.f10479a);
        }
    }
}
